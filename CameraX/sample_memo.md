# サンプルメモ

## https://github.com/android/camera/tree/master/CameraXBasic

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
* ImageUtils
  * サムネイル取得のための関数
  * exif から撮影方向を取得してサムネイルの表示方向を求めている

### 疑問点

* 画像保存成功後にサムネイル画像を表示する処理が 23+ にしている理由は？
* 画像保存成功後に 24+ の場合は `ACTION_NEW_PICTURE` を broadcast している
* Android Q でも画像の共有処理は動作する？
* AutoFitPreviewBuilder は CameraX に含まれないの？
