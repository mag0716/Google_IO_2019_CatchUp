# Overview of Privacy Changes in Android Q

https://www.youtube.com/watch?v=bFp2n5OxYEE
18:04 しかなく途中から始まった？

* Permissions
  * permission が不要な API に代替できないかを検討する
    * Read SMS permission -> Play SMS retriever API
    * READ_PHONE_STATE -> Audio focus to see call state
    * READ_EXTERNAL_STORAGE -> Use your app's dedicated directory or system picker
  * permission の scope とどうしてそれが必要なのかを伝える
    * scope：storage の領域(Download, 写真など)
  * ユーザのデータを使うときは慎重に

* Device Identifier
  * READ_PHONE_STATE
  * MAC アドレスはランダムな値が返されるようになった

* App launching and notifications
  * 着信やアラームの場合は high priority, 適切なカテゴリーをセットする
  * full screen Intent

* Foreground services
  * forgroundServiceType の指定が必要になった
