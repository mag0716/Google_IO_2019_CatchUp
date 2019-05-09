# Jetpack Navigation

https://www.youtube.com/watch?v=JFGq0asqSuA

* Goal：in-app navigation

* Libraries
  * navigation-common
  * navigation-runtime
    * NavController
  * navigation-fragment
    * NavHostFragment
    * Fragment Destinations
  * navigation-ui
    * AppBarConfiguration
  * それぞれの ktx

* Tooling
  * Navigation Editor
  * Manifest Merger
    * for Deep Links
  * Safe Args Gradle Plugin

* Dialog Destinations
  * 2.1.0
  * `<dialog>`
  * `show()` の代わりになる

* ViewModels in Navigation
  * 2.1.0
  * navigation graph ごとのスコープ
  * `navViewModels`

* Safe Args
  * analyze navigation file
  * generate code
  * SafeArgs + Kotlin
    * `androidx.navigation.safeargs.kotlin`
    * Named Arguments
    * Default Arguments
    * Immutable Objects
    * Data Classes
  * https://developer.android.com/guide/navigation/navigation-pass-data

* Modularizing
  * navigation graph を分割する
  * `<include>`
    * app モジュールでは各モジュールの navigation graph を include する
  * navigation graph 間の遷移
    * URI を使う
      * 2.1.0
      * `<deepLink>`
  * Navigating dynamically
    * dynamic module への遷移
    * 今年リリース予定
      * Dynamic Feature Navigator

* What's Next
