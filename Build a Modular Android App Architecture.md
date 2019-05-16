# Build a Android Modular App Architecture

https://www.youtube.com/watch?v=PZBg5DIzNww

* scale
  * 各モジュールごとにエンジニアを振り分けることができる
* maintenability
  * 複数の機能のソースやリソースがあると見辛い

* Faster compilation

* Faster CI
  * 変更したモジュール、それを依存するモジュールのみをテストすれば CI が早くなる

* How we do it in AndroidX
  * https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/buildSrc/src/main/kotlin/androidx/build/dependencyTracker/

* Good for business
  * Smaller APKs
  * A/B test で dynamic feature modules を使える

* Module
  * How to modularize?
    * Feature
      * onDemand="true" -> 80:20
      * 1度だけしか使わないような機能は onDemand="false" でインストール時に含めてアンインストールする
      * Plaid
        * 可能な限り onDemand module にしている
        * about, search のような利点がないものについては :app が依存している
    * Layer
  * Isolation via modules
    * api vs implementation
    * api：ModuleB is part of my Publis API
    * implementation：ModuleB is my Implementation Detail
    * Repositories api Database
    * Repositories implementation Web Service
    * Database implementation Room
    * Web Service implementation Retrofit, Json Parser
    * UI で DTO にアクセスできなくなるので、Repositories api Common Value Objects
      * こうすれば、UI は Common Value Objects にアクセスできるようになる
  * How to modularize?
    * Feature
    * Feature & Layer
  * Working with dynamic module
    * Navigation
      * app: クラス名を直接指定する
  * Discovering Dependencies
    * core 側に interface を用意し、依存関係を解決する(Provider)
    * feature module 側は ServiceLoader から必要なクラスを取得する(Inject)
  * Dynamically Loaded Modules
    * SplitInstallManager
  * Databases
    * アプリに対して1つの DB を用意する
    * core の DB と feature 毎の DB
    * Room を使って feature をわかりやすくする
      * Room のmulti module サポート使う
        * Dynamic Feature Modules のデータもマージしてくれる？

* TL;DR
  * 正解はないのでプロジェクト毎にどうすべきかを検討する
  * モジュール化を進めると Cost は上がるが Benefit は上がりにくくなるのでどこまですべきかを考える
