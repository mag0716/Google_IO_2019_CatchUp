# What's New in Kotlin on Android, 2 Years In

https://www.youtube.com/watch?v=8rYLFD1ZfnM

* when スコープ内のみにアクセスできる変数の定義
* `@Experimental`
  * デフォルトはコンパイルエラー
  * level を変えられる
* Contract
  * `@UseExperimental`
* Serialization
  * `@Serializable`
  * Json.stringify で JSON へ変換
  * Json.parse
* `@Routing`(13:16)
  * Ktor
* mpp
  * IDE で各プラットフォームのコードへジャンプできる
  * actual がないとコンパイルエラーになる

* Demo
  * API, Room からデータを取得する
  * Rx vs Coroutines
    * Coroutines のほうがデバッグが楽

* Android tooling
  * Lint support for Kotlin
  * R8 Kotlin-aware optimizations

* samples
  * Google IO 2018 & 2019
  * Sunflower

* Google's use of Kotlin
  * Drive, Home, nest は Kotlin
  * 昨年の IO から 5倍使われるようになった

* Kotlin first
  * Java との違い
    * ktx はない
    * Online training は best effort
    * サンプルも best effort
    * MPP は対応しない
    * Compose も対応しない
  * Java から Kotlin に移行すべきか(27:08)
