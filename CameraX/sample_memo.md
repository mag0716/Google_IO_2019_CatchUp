# サンプルメモ

## https://github.com/android/camera/tree/master/CameraXBasic

### 概要

* 撮影
  * 縦横対応
  * プレビューは自動で画面いっぱいに表示する
    * AutoFitPreviewBuilder
* 表示
  * 全画面表示
  * ノッチ対応
* 共有
  * FileProvider
* unit, instrumented test でのソース共有

### 詳細

* PermissionsFragment
  * permission をリクエスト
  * permission が許可されていたら CameraFragment へ遷移
* CameraFragment
  * カメラ部分
    * 操作用の View は毎回 inflate している
  * カメラの切り替え
    * CameraX.LensFacing
  * retain Fragment
  * GalleryFragment に遷移するボタンにサムネイル画像を表示する処理に Coroutines を使っている
  * 画像保存成功後に MediaScannerConnection で他のアプリに共有
  * bindCameraUseCases
    * usecase の bind は viewFinder.post 内で行なっている
    * ImageAnalyticsConfig はなくてもいい
    * preview には AutoFitPreviewBuilder を使っている
    * preview, imagecapture, imageanalysis に LensFacing をセットしている
  * updateCameraUi
    * 撮影時に渡す Metadata にもどちらのカメラを使っているのかを渡す必要がある
    * カメラ切り替え CameraX.getCameraWithLensFacing
* AutoFitPreviewBuilder
  * TextureView を WeakReference で保持
  * displayId が変化したら TextureView を transform している
    * DisplayManager.DisplayListener
  * TextureView のサイズからアスペクト比を再計算している
  * Preview.OnPreviewOutputUpdateListener で ViewFinder の削除、追加を行なっている
* GalleryFragment
  * retain Fragment
  * 渡されたパスから jpg を取得し、ViewPager で表示
  * Android P 以上は cutout を考慮し画面いっぱいに表示
  * 共有用に FileProvider 経由で Uri を取得
  * ファイルの削除はアプリで撮影したファイルが対象なので File#delete で
* PhotoFragment
  * 渡されたパスの画像を Glide で表示するだけ
* ImageUtils
  * サムネイル取得のための関数
  * exif から撮影方向を取得してサムネイルの表示方向を求めている
* AndroidManifest.xml
  * システムのカメラアプリとして登録するための定義

### 疑問点

* 画像保存成功後にサムネイル画像を表示する処理が 23+ にしている理由は？
* 画像保存成功後に 24+ の場合は `ACTION_NEW_PICTURE` を broadcast している
* Android Q でも画像の共有処理は動作する？
* AutoFitPreviewBuilder は CameraX に含まれないの？
