# CameraX references

## CameraX architecture

https://developer.android.com/training/camerax/architecture

### CameraX structure

開発者は use case を通してデバイスのカメラを扱う
現状有効な use case は

* Preview
* Image analysis：解析のために CPU-accessible buffers を提供する
* Image capture

use case は同時に組み合わせることができる。

### API model

動作させるために以下を指定する

* use case の設定
* output 操作するために listener の attach
* Lifecycle と use case を binding する

use case の設定は `set()` で行い、`build()` で生成する
use case ごとに `takePicture` のような API が提供される

アプリでの開始、終了処理の代わりに、`CameraX.bindToLifecycle()` で Lifecycle と関連づける。

### API model example

preview use case は表示のために `SurfaceTexture` を提供する

`Preciew#setOnPreviewOutputUpdateListener` で `SurfaceTexture` を View にセットする

### CameraX Lifecycles

CameraX は Lifecycle を監視し、カメラの開始や終了などのタイミングを決定する。
use case API は進捗を確認できる API を提供している。

1つの Lifecycle に 複数の use case を bind させる。
組み合わせることができない use case を利用する場合は

* 複数の Fragment を切り替えて利用する
* カメラのライフサイクルを手動で扱うためにカスタム Lifecycle を生成する

カスタム Lifecycle や retain fragment の場合にView とカメラの use case の Lifecycle owners を分離させる場合、`CameraX.unbindAll` を呼び出す必要がある

`AppCompatActivity` や `AppCompat` Fragment のような lifecycle-aware と使う場合は、カメラは lifecycle-aware になり安全に処分されリソースを無駄に消費することはない。

### Custom LifecycleOwners

明示的にカメラのライフサイクルを定義する場合は、`LifecycleOwner` をカスタマイズする。

リファレンスの例だと、どこからからでも状態遷移を切り替えることができる

### Combine use cases

use case は同時に動作させることが可能。
`CameraX.bindToLifecycle()` 1度で複数の use case を指定することができる。

Note：不正な組み合わせの use case の場合は、`createCaptureSession()` 時にエラーが throw される
実行中のセッションに use case を追加する場合は再構成が必要になる可能性がある

### Permissions

`CAMERA` permission が必要
Android Q 以外では、保存する場合は `WRITE_EXTERNAL_STORAGE` permission が必要

### Requirements

* Android API level 21
* Android Architecture Components 1.1.1
  * lifecycle-aware な Activity を利用するため

### Declare dependencies

`CameraView` を利用する場合は `androidx.camera.core:view`
extensions は `androidx.camera.core:camera2`
