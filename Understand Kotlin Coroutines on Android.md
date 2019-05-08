# Understand Kotlin Coroutines on Android

* Rx だったら autoDisposable
* LiveData だったら viewLifecycleObserver
* Coroutine はシンプルに実装できるが学習コストがかかる

* suspend, resume
  * Dispatchers
    * Default : CPU
    * IO : Network & Disk
    * Main : Main Thread
  * withContext : Main-safe

* WorkManager
  * Worker
    * doWork でキャンセルされたのかをチェックする必要がある
  * CoroutineWorker
    * doWork でのキャンセルのチェックが不要

* LiveData & Corutines
  * 2.2.0-alpha1
  * `liveData` 内で suspend fun 以外を呼び出す場合は、Dispatchers.IO を指定する
  * リポジトリ層での API, DB の切り替えも簡単
    * `emitSource`

* ViewModel & Coroutines
  * viewModelScope
    * onCleared でキャンセルされる
    * リークを回避できる

* Lifecycle & Coroutines
  * 2.2.0-alpha1
  * lifecycleScope
    * onDestroy でキャンセルされる
    * リポジトリ層の API は呼び出してはいけない
      * 再生成時に再度呼び出されてしまうの
      * ViewModel でviewModelScope を使うのが正しい
        * CompletableDeferred
    * launchWhenStarted を使うことで Fragment の遷移も行えるようになる
      * IllegalStateException を回避できる

* Testing Coroutines
  * kotlinx-coroutines-test
  * いろいろなテストフレームワークで使える
  * TestCoroutineDispatcher
  * TestCoroutineScope
  * setup で Dispatchers.setMain(testDispatcher)
  * tearDown で Dispatchers.resetMain
  * TestCoroutineRule を使えば setup, tearDown での実装は不要

* まとめ
  * あくまで推奨しているだけ
  * まだ WIP
