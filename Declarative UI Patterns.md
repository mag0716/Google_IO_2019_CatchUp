# Declarative UI Patterns

https://www.youtube.com/watch?v=VsStyq4Lzxo

* Unbundle the UI toolkit
  * android.widget -> Jetpack

* 別ライブラリになる理由
  * 既存 API が残念
    * View が状態を持っている(ex.Spinner)
  * アプリのアーキテクチャがいろいろある
  * コード量が多すぎる
    * style など定義する場所も複数に存在する

* Goals
  * Unbundle from platform releases
  * Fewer technology stack flowcharts
  * Clarify state ownership and event handling
  * Write less code

* Jetpack Compose
  * React, Litho, Vue.js, Flutter から影響を受けている
  * `@Composable`：UI Widget
  * What is Compose?
    * A new set of Jetpack UI widgets
    * A Kotlin compiler plugin
    * 既存のアプリと互換性がある
  * メソッドとして分割できる
  * RecyclerView -> ScrollingList
  * LiveData などを observe して View を更新することも簡単
  * 画像の読み込みも直感的にかける
    * `asyncLoad`
  * `@Model`
  * Top-down Data Flow
  * `Clickable`
    * lambda を渡す

* Recap
  * Composable functions scale across layers of abstraction
  * View Compatibility
    * `@GenerateView`
      * 既存の xml を利用できる
  * Layout Editor & Preview Tool も提供される
  * Animation, Style, Theme, ConstraintLayout もサポートされる
