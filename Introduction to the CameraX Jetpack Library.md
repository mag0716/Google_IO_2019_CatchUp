# Introduction to the CameraX Jetpack Library

streaming

* Intro
  * Android L(21) 以上をサポート
  * Camera2 API を使っている
  * Camera1 API は deprecated になる
  * Lifecycle aware
  * Device HAL について実装は CameraX の内部に含まれることになる
    * アプリでの実装が不要
  * 利点
    * 端末ごとのテストが減らせる
    * コード量が減る
    * アプリサイズが減る

* Deep dive
  * UseCases
    * 何をするのか
    * いつアウトプットを送るのか
    * いつ開始、終了するのか
  * CameraX.bindToLifecycle
  * Preview
    * PreviewConfig
  * Image Analysis
    * easy access buffer
    * ImageAnalysisConfig
  * Image capture
    * ImageCaptureConfig
    * ImageCapture#takePicture
  * カメラ用のスレッドは不要

* CameraX Extensions
  * Portrait, Night, HDR, Beauty
  * HDR Demo
  * Portrait Demo

* StackOverflow
  * android-camerax 
