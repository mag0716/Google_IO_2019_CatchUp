# Customizable Delivery with the App Bundle and Easy Sharing of Test Builds

https://www.youtube.com/watch?v=flhib2krW7U

* Android App Bundle
  * Google のアプリも対応中
  * New features
    * In-app updates
    * Conditional delivery
    * On-demand delivery
    * Asset delivery for games
  * Testing tools
    * Internal app sharing

* In-app updates
  * アプリから更新をトリガーする
  * Immediate
    * 即座に更新させる
    * 機能の利用ができない
    * 更新中の progress はアプリ内で表示される
  * Flexible
    * ex: swiggy
    * 設定メニューに更新ボタンを配置している
    * 更新中も機能が利用可能
    * 更新が完了したら Snackbar が表示される
  * AppUpdateManagerFactory

* Conditional delivery
  * 特定の条件を満たした端末にのみインストールさせる
    * country
    * minSdkVersion
    * Device feature
      * ex:AR
  * モジュールがインストールされているかどうかは SplitInstallManager.getInstalledModules で

* On-demand delivery
  * インストール、アンインストールを特待のタイミングで行える
  * ex:NETFLIX
    * カスタムサポート
  * <install-time>
  * SplitInstallManager.deferredUninstall

* Asset delivery for games
  * CDN を使っていては端末ごとのカスタマイズができない
  * 自動更新もできない
  * EAP
  * 今後柔軟な設定などができるようになる予定

* Modularization
  * ex:Plaid
    * Resources
      * モジュールごとに prefix をつけて管理している
    * as で app モジュールの R を appR にしている
    * 画面遷移はクラス名を直接指定している
      * app モジュールの Helper クラスで定義
    * org.gradle.paralell

* Introducing Internal App Sharing
  * アップロード後に渡される URL を共有する
  * 影響なく使える
    * Play Console の管理者じゃなくてもアップロードできる
      * QA エンジニアでもできる
    * プロダクトのキーでの署名も不要
    * versionCode の更新も不要
    * debuggable=true でもアップロードできるのでステップ実行できる
  * Dynamic Delivery のテストが簡単になる
