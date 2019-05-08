# What's New in android

* https://www.youtube.com/watch?v=td3Kd7fOROw

* Bubbles
  * 途中からで見れない。。。

* Dark theme
  * 端末の設定アプリから変更できる
  * MODE_NIGHT_AUTO_TIME は deprecated
  * Theme
    * `*.DayNight`
  * forceDarkAllowed
  * -night ディレクトリにリソースを置く
  * Dark theme を無視するのは NG

* Sharing
  * Content preview
  * Shortcut API
  * Clipboard にコピーできる

* Notification
  * gentle?
  * actions

* Gesture navigation
  * クリック可能な View は端には置かない
  * ドラッグ可能な View も端(ジェスチャー領域)には置かない

* WebView/Chrome

* Accessibility

* Text
  * hyphynation がデフォルトでオフになった
  * SystemFonts.getAvailableFonts でシステムフォントを探せる
  * LineBackgroundSpan, LineHeightSpan
  * TextAppearanceSpan
  * Zawgyi support

* Magnifier

* Private APIs
  * 将来的には呼び出すとクラッシュする(grey list)

* Android Runtime(ART)
  * クラウドで一部を処理することで起動が速くなる
  * GC

* Kotlin
  * nullability annotations
  * Android Q ではエラーとして扱うようになる
  * kapt 1.3.30

* Security
  * TLS 1.3 デフォルトで有効に
  * 生体認証ダイアログが改善される
  * Jetpack security library

* New Hotness
  * PowerManager

* Neural Network API

* Preferences
  * android preferences は deprecated になる

* Architecture Components
  * Benchmarking

* CameraX
  * Android L までの後方互換性

* Jetpack Compose
  * Unbundled, Reactive, Kotlin
  * @Composable

* ViewPager2

* ViewBindings
  * findViewById が不要になる
  * Null-safe, type-safe

* Blend Modes
  * PorterDuff.Mode を置き換える

* RenderNode

* HardwareRenderer
  * 影を自前で描画するなど

* Hardware Bitmaps
  * アニメーションなどに利用できる

* SurfaceControl

* Audio Playback Capture
  * AuioPlaybackCaptureConfiguration

* External Storage
  * targetSdk = P では何も変わらない

* Camera
  * getCameraCharacteristics
  * permission が必要

* Connectivity
  * Wifi の切り替えはアプリでは不可になる
  * Wifi の設定は noop
  * ACCESS_FINE_LOCATION が必要になる
  * SettingPanel に移行する
