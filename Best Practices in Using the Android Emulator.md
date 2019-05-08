# Best Practices in Using the Android Emulator

https://www.youtube.com/watch?v=Up3hyBSDAMA

* アプリのインストール速度
  * 端末にアプリをインストールする際は adb Client と adb Server が TCP で通信している
    * 端末では adbd が動いている
  * シンプルなアプリであればエミュレータの方が速い

* AR Macros
  * AR のテストができる

* Emulate Physical Devices
  * テストできるアプリが増える
  * YUV フォーマット
    * 2019 August

* Snapshots
  * テストで再インストールするなどの手順が不要になる

* Multiple instances
  * 複数の端末設定でテストすることができる
  * 複数OSバージョンでテストすることができる
  * `-read-only` オプションをつけて起動

* Headless
  * `emulator-headless`

* ANRs & Crash testing
  * Google Play Console の結果をもとに emulator を使ってアプリを改善する
