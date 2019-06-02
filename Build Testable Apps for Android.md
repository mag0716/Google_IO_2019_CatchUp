# Build Testable Apps for Android

https://www.youtube.com/watch?v=VJi2vmaQe6w

* Testing Pyramid
  * E2E tests
    * アプリ全体のテスト
    * Black box
  * Integration tests
    * Grey box
    * テスト対象の画面だけを利用する
    * Test Doubles
      * Dummy
      * Stub
        * Mockito
      * Fake
    * API 経由する処理はモックする
  * Unit tests
    * Black box
* Testing Codelab
  * Layered Architecture
    * Data
    * Business Logic
    * Presentation
  * Modular Application
    * モジュールごとに Integration tests を行う
  * Architecture Components
  * Coroutines
    * ViewModel の scope で動作させている
      * viewModelScope
    * `runBlocking` を利用する
      * よりシンプルになる `runBlockingTest`
  * TDD
  * Room
    * inMemoryDatabaseBuilder を使う
  * Instrumentation も Local も同じソースを共有している
    * src/sharedTest に配置して、test, androidTest とも sharedTest を指定する
* Local Tests
* Instrumentation Tests
* Nitrogen
  * Jenkins でも利用できる

## 疑問

* Unit tests は Black box？
  * Black box の意味を履き違えているかも
* Nitrogen の概要を確認が必要
  * Unified API で書かれたテストを色んな環境で実行できる Platform
* Dummy, Stub, Fake の違いを再確認しておく

## TODO

* Codelab をやる
* Nitrogen EAP を触ってみる
