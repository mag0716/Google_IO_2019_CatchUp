# Android Studio: Tips and Tricks

https://www.youtube.com/watch?v=ihF-PwDfRZ4

* Profiler
  * Memory
    * Activity 名が表示される
    * GC のタイミングが記録される
    * 拡大しての比較しやすくなる
    * 選択した期間のメモリ消費量が見える
  * Energy
    * バッテリー消費につながった処理が確認できる

* Core IDE Tips
  * Open/Close Tool Window
    * Alt + 数字
    * 数字が記載されてないものは Ctrl + Tab
    * Shift + Escape で閉じる
    * F12 で最後に表示した Window を表示
  * Moving around Editor Tabs
    * Ctrl + Tab
    * Layout Editor は Shift + 矢印
  * Find Anything
    * Shift を2回
  * CamelHump text navigation
    * Shift + Ctrl + Right
  * Go to Method Above/Below
    * Alt + Down or Up
  * Go to Last Edit Location
    * Shift + Command + Backspace
  * Method Info / Parameter Info
    * F1 で JavaDoc
  * Code Completion basics
    * Control + Space
  * Smart Code Completion
    * Shift + Control + Space
    * 複数パラメータも一気に入力できる
  * Editing commands
  * Refactoring tools
    * 似た処理を簡単にメソッド化できる
  * Coding with Intentions
  * Postfix Completion
  * Live Templates
    * logd
    * .if

* Design Tools
  * Navigation Editor
    * 指定した destination に飛べる
    * 整列させることができる
    * Nested Graph に分けることができる
  * Layout Editor
    * listitem
    * サンプルデータ
      * json
    * Component Tree の View の移動で表示順を簡単に変えられる
    * Component Tree でのレイアウトファイルの行き来ができる
    * Pick a Resource で色を選択できる
    * 画面サイズいろいろ変えて確認できる
  * Resource Manager
    * Drawable, Color, Layout, Mip Map
    * ライブラリのリソースを含めるかどうかを切り替えられる
    * Layout からのドラッグで include として配置できる
    * Drawable からのドラッグで ImageView を追加 or ImageView の画像を変えられる

* Building
  * モジュールを移動するだけで、gradle ファイルの変更してくれる
  * gradle でのモジュール名変更で実際のモジュール名も変更してくれる
  * ライブラリは library_versiosn.gradle にまとめとく(33:43)
  * Date などビルドごとに毎回変わるとビルド時間に影響するので注意(37:18)
  * Apply Code Changes ボタン
    * コードが変わった時に利用する
    * リソースが変わった時は Activity が再生成させる必要がある
