<template>
  <div class="home">
    <nav-bar class="nav">
      <div slot="center">cy购物街</div>
    </nav-bar>
    <scroll class="content" ref="myScroll" :probe-type="3"  
    @scrollPositon="sPositon" 
    :pull-up-load="true" @pullingup="pullingUp"><!-- 不加：相当于传了一个字符串-->
      <div >
        <home-swiper :banners="banners"/>
        <recommend-comp :recommends="recommends"/>
        <feature/>
        <tab-scroll :title = "title" @getCurIndex="getCurIndex"/>
        <goods-list :goods = "showType"/>
        
      </div>    
    </scroll>
    <back-top @click.native="backTop" v-show="backShow"/>
  
  </div>
</template> 

<script>
import NavBar from 'components/common/navbar/NavBar.vue'

import HomeSwiper from './childComponents/HomeSwiper'
import RecommendComp from './childComponents/RecommendComp.vue'
import Feature from './childComponents/Feature.vue'

import TabScroll from 'components/content/tabScroll/TabScroll.vue'
import GoodsList from 'components/content/goods/GoodsList.vue'

import {getHomeMultidata,getProductData} from 'network/home'
import Scroll from 'components/common/scroll/Scroll.vue'
import BackTop from 'components/content/backTop/BackTop.vue'

import {debounce} from "common/until.js"

export default {
  components: { 
    NavBar,
    RecommendComp,
    HomeSwiper,
    Feature,
    TabScroll,
    GoodsList,
    Scroll,
    BackTop
  },
  name: 'Home',
  data() {
    return {
      banners: [],
      recommends: [],
      title:['流行','新款','精选'],
      goods:{
        "pop":{list:[],page:0},
        "new":{list:[],page:0},
        "sell":{list:[],page:0}
      },
      type: "pop",
      backShow:false,
      saveY:0
    }
  },
  computed: {
    showType() {
      return this.goods[this.type].list;
    }
  },
  created() {
    this.getHomeMultidata();
    this.getProductData("pop");
    this.getProductData("sell");
    this.getProductData("new");
   
  },
  mounted() {
    // this.$refs.myScroll.scroll.scrollTo(0,0,800)
    // this.$refs.myScroll.scroll.backTop  @click.native="backTop"
    // this.$refs.myScroll.refresh;
    const rr=debounce(this.$refs.myScroll.refresh,200);
    this.$bus.$on("itemImageLoad",() => {
      //为什么一定要写在外面？？？？？？？写外面是没有防抖
      rr();
      // console.log(11);
    })
  },
  methods:{
    getHomeMultidata() {
      getHomeMultidata().then(res => {
        this.banners=res.data.banner.list;
        this.recommends=res.data.recommend.list;
        //  console.log(this.recommends);
      })
    },
    getProductData(key) {
      const page1 = this.goods[key].page+1; 
      getProductData(key,page1).then(res => {
        this.goods[key].list.push(...res.data.list);
        this.goods[key].page = page1;
        //console.log(res);
        // 结束上拉加载更多才会进行下一次的上拉加载
        this.$refs.myScroll.finishPullingUp();
      })
      
     },
     //获得一个index从而获取是哪个goods列表
    getCurIndex(data) {
      //  console.log(111);
       this.type = Object.keys(this.goods)[data];
    },
     //回到顶部
    backTop() {
       //第一个scroll是ref的名字 第二个是Scroll中的data  第三个scrollTo是一个方法 500表示时间  00表示坐标
      //  this.$refs.myScroll.scroll.scrollTo(0,0,800)
      //$refs可以直接取到这个scroll组件元素，可以直接访问其中的元素和方法
       this.$refs.myScroll.scrollMy(0,0,800)
    },
    sPositon(position){
      //  console.log(position);
      this.backShow = (-position.y)>1000
    },
    pullingUp(){
      // console.log("上拉加载");
      this.getProductData(this.type)
    },
    // refresh() {
    //   // console.log(111);
    //   this.$refs.myScroll.refresh();
    // }

  },
  destroyed() {
    console.log("dddd");
  },
  deactivated() {
    // console.log(11);
    //保存滚动的位置
    this.saveY = this.$refs.myScroll.getScrollY()
  },
  activated() {
    // console.log("创建");
    this.$refs.myScroll.scrollMy(0, this.saveY, 0)
    this.$refs.myScroll.refresh();
  }
  
}
</script>

<style scoped>
  .home{
    position: relative;
    height: 100vh;
  }
  .nav{
    position: fixed;
    top: 0px;
    left: 0;
    right: 0;
    text-align: center;
    color: white;
    background-color: var(--color-tint);
  }
  .content{
    overflow: hidden;
    /* height: 300px; */
    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right: 0;
  }
</style>