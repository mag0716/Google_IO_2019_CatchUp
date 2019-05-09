# What's New in Shared Storage

https://www.youtube.com/watch?v=3EtBw5s9iRY

* Android 9
  * internal storage は他のアプリからのアクセスはできない
  * READ/WRITE_EXTERNAL_STORAGE が必要
  * MediaStore でアクセスができる
  * アプリ用のディレクトリのアクセスには permission は不要

* Principle
  * Better attribution
  * Protect app datas
  * Protect user data

* Android Q
  * MediaStore でも permission は不要になったが他のアプリのコンテンツへのアクセスには permission が不要
  * システム picker によってアクセスが可能
    * Downloads へのアクセスはシステム picker 経由のみ
  * Context.getDataDir などの internal storage はそのまま

* MediaStore
  * Audio, Video, Images

* Downloads
  * MediaStore.Downloads

* Contributing
  * IS_PENDING に 1 を渡している(9:49)
  * 0 にするときは update で
  * MediaColumn.RELATIVE_PATH
    * ファイルの場所
    * 変更することで移動も可能
  * volume の指定(14:26)
    * MediaStore.Audio.Media.getContentUri(volumeName)
    * ファイルパスは RELATIVE_PATH で相対パスを指定する

* Discover
  * discover：ContentResolver.query
  * read/write：ContentResolver.openFIleDescriptor
  * PENDING されているコンテンツはデフォルトでは見えない
    * MediaStore.setIncludePending

* Editing
  * update, delete, openFileDescriptor
    * permission が必要

* Metadata
  * 位置情報の取得には permission が必要
    * ACCESS_MEDIA_LOCATION
  * ExifInterface
    * MediaStore の LATITUDE, LONGITUDE は deprecated

* Scoped mode
  * targetSdkVersion Q+ では /sdcard/ などでのアクセスはできなくなる
    * FileNotFoundExeption
  * パッケージ名が指定されたディレクトリへのアクセスは可能
  * MediaStore, Storage Access Framework とも動作する

* Beyond local
  * ACTION_OPEN_DOCUMENT, ACTION_CREATE_DOCUMENT はユーザにファイルアクセスさせることができる
    * アプリでメンテナンスが必要なコードが減る
    * どんなアプリでもファイルアクセスの UI, UX が同じになる

* Temporarily opt-out
  * requestLegacyExternalStorage
  * Environment.isExternalStorageLegacy
