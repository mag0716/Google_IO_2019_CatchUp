#  How to Design a Dark Theme Using Material

https://www.youtube.com/watch?v=9NDLR3COU7

* Principle
  * バッテリー消費を減らす
  * アクセシビリティの強化
  * 色はアクセントとして利用する

 * Elevation
  * light:shadow
  * dark:背景色が変わる(透過オーバレイ)

* Color
  * light
    * 600
  * dark
    * 50% - 200 推奨
      * 彩度を低くする
  * ボタンの背景とテキストのコントラスト
    * light:8.13:1
    * dark:7.68:1
  * States
  * Text
    * high emphasis:14.6:1
    * medium emphasis:7.9:1
    * elevation の違いでも色を変える必要がある？

* 例
  * Owl
    * 彩度を下げる
    * メインとして使っていた色をアクセントとして使う
  * Google Photo
  * Google Drive
    * 画像内の色も変えている
  * Google Calendar

* Android Auto

* Samples
  * material.io/resources
  * https://codelabs.developers.google.com/codelabs/design-material-darktheme/index.html?index=..%2F..index#0
  * material.io/tools/build-a-material-theme
