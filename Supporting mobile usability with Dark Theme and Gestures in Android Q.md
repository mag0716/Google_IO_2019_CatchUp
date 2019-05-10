# Supporting mobile usability with Dark Theme and Gestures in Android Q

タイトルが Dark Theme & Gesture Navigation になっている

https://www.youtube.com/watch?v=OCHEjeLC_UY

* Dark Theme
  * Why
    * Environment
    * Battery
    * Accessibility
  * 端末の設定で変えられるのでアプリでサポートするのが強く推奨されている
  * Force Dark
    * 自動的に Dark Theme が適用される
    * forceDarkAllowed
  * DayNight
    * -night リソース
    * AppCompatDelegate.setDefaultNightMode
    * getDelegate().setLocalNightMode
    * 永続化はされない
  * Modes
    * バッテリがなくなってきたら Dark Theme になる
  * AppCompat 1.1.0
    * WebView の生成時にリセットされない
    * MODE_NIGHT_AUTO_TIME は deprecated
  * システムの theme 設定を上書きする方法を提供が推奨されている
    * Android Q はシステム設定
      * MODE_NIGHT_FOLLOW_SYSTEM
    * Android P 以前は Battery Saver
      * MODE_NIGHT_AUTO_BATTERY
  * Elevation
    * Dark Theme では影ではなく opacity が変わる
      * MDC 1.1.0
    * ElevationOverlayProvider
  * Theming
    * color リソースでそれぞれ定義するのは大変
    * ?attr を使うほうがいい
      * alpha と組み合わせる
    * AppCompatResources.getThemeColor
    * 画像は tint で帰る
      * verctor に設定するとよい
      * tintDrawable
    * Dark Theme かどうか isDarkTheme
  * Force Dark
    * View に forceDarkAllowed を設定し、色を個別で定義することができる
  * Scenarios
    * WebView + Force isDarkTheme
      * 自動で適用される
      * Custom Tabs
        * 自動では適用されない
        * setColorScheme が追加予定
    * Map
      * mapstyle.withgoogle.com から style をダウンロードする
    * Illustrations
      * 見にくい場合には色を変更する必要がある
      * vector だとカスタマイズ性が高い
    * Notifications
      * template は自動で適用される
      * カスタムレイアウトは自前で適用させる必要がある

* Gesture Navigation
  * アプリ終了
  * Recent Apps
  * back key
  * 将来的には2つのモードをサポートする
    * 3ボタン
    * ジェスチャー
  * ジェスチャーモードはデザインにも関係する
    * 画面恥の配置
    * ジェスチャーのバッティング
  * アプリの準備
    * navigation bar, status bar の下にも描画すべき
      * Android Q 未満はオプション
      * navigation bar のボタンの色はコンテンツの色によって勝手に変わる
    * Insets
      * System window
        * クリック可能な View は移動する
        * mode によって navigation bar のサイズが変わる？
      * System gesture
        * ドラッグ可能な View は移動する
        * 画面下部からのスワイプは上書きできない
    * Overriding system gesture
      * gallery のような UI だとコンフリクトする
      * 上書きしないと2回処理が走ることになるので対応必要
      * View.setSystemGestureExclusingRects
        * onLayout で呼び出す
    * Scrolling Views
      * navigation bar にかぶらないように padding を設定する
        * setOnApplyWindowInsetsListener
          * systemWindowInsetBottom
        * clipToPadding = false
    * Navigation drawers
      * 1.1.0-alpha01 から自動的に対応される
    * Bottom sheets
      * navigation bar の上に配置するように対応必要
      * setOnApplyWindowInsetsListener
      * navigation bar の近くに配置する際は慎重に
    * Carousels
      * 端まで描画して何もしないことを推奨
    * Landscape
      * navigation bar と重ならないようにする(39:44)
