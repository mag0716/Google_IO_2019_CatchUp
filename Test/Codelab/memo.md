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

## メモ

### わかったこと

* mock, product の flavor ごとに `ServiceLoader` で依存性を解決している
  * mock は API を利用しない

### 気になったこと

* build.gradle
  * useProguard
  * dataBinding.enabledForTests
