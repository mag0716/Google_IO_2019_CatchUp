# What's New in ConstraintLayout

https://www.youtube.com/watch?v=29gLA90m6Gk

* ConstraintLayout 2.x
  * Flexibility
    * Virtual Layouts
    * Helpers & Decorators
    * Programming APIs
  * MotionLayout
  * 2.0.0-beta1
  * Architecture
    * Linear Solver
    * Optimizer
    * Constraints Model
    * Helpers
    * Virtual Layouts
    * MotionLayouts

* ConstraintHelper
  * CircularReveal
  * VirtualLayout
    * フラットな階層のまま
    * Flow
      * 水平、垂直に並べる
      * chains
        * Spread
        * Spread Inside
        * Packed
      * Wrap Chains
        * 最大数も設定できる
      * Wrap Align
        * 要素のサイズが異なる場合でも対応可能
  * Programming APIs
    * ConstraintSet
    * ConstraintProperties

* MotionLayout
  * ConstraintSets
    * Transitions
    * Keyframes
    * Coordinate Systems
    * OnSwipe/OnClick
  * Programmatic control
    * TransitionListener
    * transitionTo(R.id.state)
    * setMotionScene(R.xml.ms)
    * getConstraintSet(R.id.state)
    * 途中でアニメーションを変えられる
  * Motion Editor
    * 数ヶ月後に alpha
  * Building Custom Components
    * Like ボタン
    * Indicator
    * FAB メニュー
  * Multistates
    * 複数の ConstraintSet を適用できる
  * Nested MotionLayout
  * RecyclerView example
    * セルを全画面に表示する
  * MotionLayout List
    * start, end ではなく start, previous, next
    * setProgress(0) などのトリックが必要(31:26)
