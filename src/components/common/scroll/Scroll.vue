<template>
  <div class="wrapper" ref="wrapper">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import BScroll from "better-scroll"
export default {
  name: "Scroll",
  data() {
    return {
      scroll: null
    }
  },
  props: {
    probeType:{
      type: Number,
      default: 0
    },
    pullUpLoad:{
      type:Boolean,
      default:true
    }
  },
  mounted() {
    this.scroll=new BScroll(document.querySelector('.wrapper'), {
      observeDOM: true,
      // mouseWheel:true,
      //控制div元素是不是可以点击
      click: true,
      //设置为3时，实时监听，不断去调用this.scroll.on,让别人自己去选择，会影响性能
      probeType: this.probeType,
      //上拉加载更多为true
      pullUpLoad: this.pullUpLoad
    }),
    //监听滚动位置
    this.scroll.on("scroll",(position)=>{
        // console.log(position);
        this.$emit("scrollPositon",position);
    })
    //当底部下拉距离超过阈值
    this.scroll.on("pullingUp",() => {
      this.$emit("pullingup");
    })

  },
  methods: {
    scrollMy(x, y, time = 800) {
      //scroll构造函数中有一个scrollTo方法，
      // x，y坐标 time是到这个坐标的时间，
      // (x, y, time = 800) es6语法 time = 800 表示是默认时间，在调用这个函数的时候可传可不传
        this.scroll.scrollTo(x,y,time)
    },
    finishPullingUp() {
      this.scroll.finishPullUp();
    },
    refresh(){
      // console.log(111);
      this.scroll.refresh()
    },
    getScrollY(){
      return this.scroll.y;
    }
  }
}
</script>

<style>

</style>