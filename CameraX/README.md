# CameraX

## 概要

https://developer.android.com/training/camerax

* Android 5.0(21) までの後方互換性がある
* Camera2 の機能を活用され、lifecycle-aware
* デバイス仕様に関連するコードをアプリに実装する必要がなくなる
* デバイスがサポートされていれば CameraX Extensions で利用できる
  * ポートレイト、HDR、夜景モード
* Note：まだ alpha で API はフィックスされていない

### Primary benefits

#### Ease of use

* 必要なタスクを use case として扱う
  * Preview
  * Image analysis
  * Image capture

#### Consistency across devices

* aspect ratio, orientation, rotation, preview size, high-resolution image size などをどんな端末でも一貫して動作する
  * Test lab で自動テストしている

#### New camera experiences

* Extensions と呼ばれるアドオンがある
  * いまのところ Portrait, HDR, Night, Beauty が有効

## Codelab

* preview, capture などを UseCase として扱われる

### 注意点

* `CameraX.bindToLifecycle` で `LifecycleOwner` を渡す必要がある
  * `this` を使う場合はappcompat-1.1.0 以上にする必要がある

### 疑問点

* permission 許可直後に preview が表示されない
