# What's New in Architecture Components

https://www.youtube.com/watch?v=Qxj2eBmXLHg

* Kotlin first!
  * ktx だけではなく、Kotlin のみの機能が追加される
  * API 設計も Kotlin ぽくなる

* Data Biding
  * Android Studio 3.5
    * コンパイルが速くなる
    * android.databinding.incremental
    * xml への変更が即コードに反映される
    * リファクタリングのサポート
      * モデルのリネームで xml 側もリネームされる
    * エラーメッセージがわかりやすくなる

* View Binding
  * Android Studio 3.6
  * DataBinding と違ってコンパイル速度が速い
  * gradle plugin
  * コンパイル時安全
  * DataBinding と互換性がある

* Lifecycle

* Saved State
  * Parcelable
  * Data size limit
  * ViewModel はメモリ上にあるのでメモリサイズ制限はない
    * プロセス再起動では復帰しない
  * UI の状態や Navigation を対象とする
  * ViewModels + SaveState
    * SaveStateHandle
  * サイズ制限などはあるので DB として使わない

* ViewModels
  * by viewModels()

* WorkManager
  * On-demand initialization
    * 必要になったら初期化する
    * Configuration.Provider を Application クラスに実装する
    * WorkManager.getInstance で Context を渡す
  * Google Play Services integration
    * M以下の端末のパフォーマンス改善
  * Compatibility improvements
  * Testing
    * Robolectric support
  * Worker unit testing
    * TestWorkerBuilder
    * TestListenableWorkerBuilder
  * Foreground service support
    * Notification が表示される

* Room
  * Coroutines
    * 2.1 から suspend をつけれるようになる
  * Full Text Search
    * @Fts4
  * Database Views
    * @DatabaseView
  * Expanded Rx support
    * Single, Completable
  * Incremental annotatino processor
  * Relationship improvements
  * Migration improvements
    * カラムのリネーム
  * Coroutine Channel & Flow

* Paging
  * エラーハンドリング
  * Headers & footers
  * RxJava & Coroutines
  * 夏に EAP, alpha 公開

* Navigation
  * ViewModels scoped
    * Navigation Graph のスコープで生存する ViewModel が作成される
  * Navigate by URI
  * Dialog
  * Dynamic features サポート
