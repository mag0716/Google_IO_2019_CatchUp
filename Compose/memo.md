# リファレンス

## https://developer.android.com/jetpack/compose/

* UI 構築を宣言的に行うためのツールキット
* Kotlin を使う
* Note: まだ pre-alpha

### Core Principles

#### Concise and Idiomatic Kotlin

* Kotlin を使うことで簡潔、安全、Java との互換性を持つ利点がある
* 徹底的にボイラープレートがなく、アプリのコードにフォーカスできるようになる

#### Declarative

* 描画周りやカスタムレイアウトの生成も含めて全て宣言的に実装できる
* フレームワークが最適化し自動的に View 階層を更新する

#### Compatible

* 既存の View と一緒に利用が可能

#### Enable Beautiful Apps

* Material Design のアニメーションも実装できる

#### Accelerate Development

* 不要なコードが減り開発速度が上がる

### A quick look

* 2つのコンポーネントを持っている
  * Compose UI library
    * UI ツールキット
  * Compose compiler
    * カスタム Kotlin コンパイラプラグイン
* composable function を作成するために `@Composable` を利用する

### Compose UI library

* android-text/：text
* android-view/：既存の View の wrapper と adapter
* animation/：アニメーション
* animation-core/：アニメーションシステムの内部定義
* core/：グラフィックや描画などのシステム全体で利用するベースクラス
* framework/：システムによって公開されているベースコンポーネント(Draw, Layout, Text)
* layout/：基本的なレイアウトコンポーネント
* material/：Material 仕様によって生成される UIコンポーネント群
* platform/：ホスト側のテストから Android の実装を分離するためのないブィッそう
* test/：テストフレームワーク
* text/：テキストエンジン
