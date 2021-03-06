# Android Testing Codelab

https://codelabs.developers.google.com/codelabs/android-testing/#0

## Overview

* 学ぶこと
  * 実際のアプリのテストの書き方
  * Unit, Integration, E2E テストのための考え方やツール
  * どのように、いつテストを実行するのか？
  * テストカバレッジの確認
  * Espresso を含む AndroidX Test library の使用方法
  * Coroutines, ViewModel, LiveData, Room, Navigation, Data Binding のテスト

## Get the sample code

`git clone -b codelab2019 --single-branch git@github.com:googlecodelabs/android-testing.git`

## A Brief Introduction to Testing

### The Testing Pyramid

自動テストで考慮すること

* Scope
  * どのくらいの範囲のテストを行うのか？(1つのメソッド、アプリ全体)
* Speed
  * テストにどのくらいの時間がかかるか？
* Fidelity
  * どのくらい実際の状況に近いか？
    * 例：API 経由でデータを取得すれば Fidelity は高い。が、ネットワークがダウンしていることもある

テストのカテゴリ

* Unit tests
  * 通常は 1つのクラス、1つのメソッドにフォーカスしたテスト
  * コードを変更するたびに実行できるくらいの速度にしておくべき
* Integration tests
  * 1機能にフォーカスしたテスト
* End to end tests
  * 機能を組み合わせたテスト

### Testing terminology

* Test Coverage
* Test Driven Development
* Test Doubles
  * Fake, Dummy, Mock, Spy
  * [詳細](https://testing.googleblog.com/2013/07/testing-on-toilet-know-your-test-doubles.html)
* Given, When, Then

## Testing and Architecture

テスタブルにするためには

* クラスごとの目的を明確にする
  * Fragment や Activity は View の描画のみでロジックは持たない
* 他のクラスについての関心ごとを減らす
  * ViewModel は Repository を経由して、データソースを直接触らない
* コンストラクターインジェクションを使う
* ViewModel から Android に関するコードを排除する

## Running your first test

### Local versus Instrumentation

* local tests: `test`
* instrumentation tests: `androidTest`

### Robolectric and AndroidX Test

* Robolectric
  * Android フレームワークや Jetpack のコードを JVM 上での実行を可能にする
* AndroidX Test
  * JUnit4 互換の TestRunner
  * Activity, Fragment のライフサイクル
  * Espresso での View 操作
  * Android Studio やコマンド上からの実行
  * 実機、JVM 上のどちらでも実行が可能なテストになる

### Shared Tests

* `sharedTest` はデフォルトでは自動生成されない
  * 自分で生成し、test, androidTest の srcDir として追加する

## Writing your first unit test

* カバレッジの出力と同時にテストを実行することが可能
  * with Coverage
  * IDE 上でどこがテストされているかも見れる

## Unit Testing with Coroutines

* Coroutines を ViewModel から起動している
  * `viewModelScope`
* Coroutines のテストのために必要なもの
  * `runBocking`
    * 新たに Coroutines を開始し、完了までブロックしてくれる
  * `ViewModelScopeMainDispatcherRule`
    * Main Coroutines dispatcher を single thread に置き換える
    * `TestCoroutineContext`
  * Architecture Components
    * `InstantTaskExecutorRule`
      * それぞれのタスクを同期的に行うための Rule を用意している
      * LiveData の MainLooper を mock している
        * ArchTaskExecutor の置き換え
    * `LiveData`
      * LiveData は observe されないと新しい値を発行しないので、値を取得するための Utils を自前で用意している

## Writing integration tests

Integration tests を明確に定義するのは難しいので、プロジェクト毎に何のためのテストなのかを文書するのがよい。

Unit tests でテストしている項目でも SQLite などデバイスによって動作が変わる可能性があるものについては Integration tests でもテストする
E2E tests との違いは全てのレイヤーを使用してテストする

### UI Testing on Android with Espresso

* `ViewMatcher`：今の View 階層にある View を選択する
  * `withId`：ID 指定で View を取得
  * `withText`：テキスト指定で View を取得
* `ViewAction`：指定した View に対してクリックなどの操作を行う
* `ViewAssertion`：View の状態をチェックする

### Testing navigation

* `NavController` のための Fake は存在しないので、`Mockito` でモックしている
* `Fragment` のテストにフォーカスするなら `launchFragmentInContainer` を使って空の `Activity` に対象の `Fragment` を起動できる
* テストを確実に成功させるために端末の開発者オプションからアニメーションは無効化しておくのがよい

### Testing data interactions

* 同期的に値を取得するために `runBlocking` を使った拡張関数を用意している

## Running Robolectric tests

* コマンドでのテスト実行
  * Unit Tests：`./gradlew test`
  * Android Test：`./gradlew connectedMockDebug`

## Write end-to-end tests

* E2E tests を書く理由
  * 複数の端末、API レベルに対するテストする
  * Proguard を有効にしたバイナリを使ってのテスト
  * 遷移のテスト
  * データレイヤー、ネットワーク接続を使ったテスト
  * スクリーンショット

### Create a navigation test

* E2E tests はブラックボックステストなのでリポジトリなどはテストせず、入力と出力のみをテストする
* Idling Resource
  * アプリがアイドル状態を Espresso に伝え、同期的に処理を実行する手助けをする


## メモ

### わかったこと

* mock, product の flavor ごとに `ServiceLoader` で依存性を解決している
  * mock は API を利用しない

### 気になったこと

* build.gradle
  * useProguard
  * dataBinding.enabledForTests
* Espresso の Idling Resource を使うためにプロダクトコードに Espresso の API を呼び出している
