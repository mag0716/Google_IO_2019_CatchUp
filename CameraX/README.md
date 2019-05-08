# CameraX

## 概要

## Codelab

* preview, capture などを UseCase として扱われる

### 注意点

* `CameraX.bindToLifecycle` で `LifecycleOwner` を渡す必要がある
  * `this` を使う場合はappcompat-1.1.0 以上にする必要がある

### 疑問点

* permission 許可直後に preview が表示されない
