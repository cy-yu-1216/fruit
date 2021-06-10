<template>
  <swiper :len="banner.length" @changeIndex="changeItem">
    <!-- <swiper-item v-for="(item,index) in banners" :key="index">
      <a :href="item.link"><img :src="item.image" alt=""></a>
    </swiper-item> -->
    
    <swiper-item>
      <a :href="link[index]"><img :src="image[index]" alt="" ></a>
    </swiper-item>
  </swiper>  
</template>

<script>
import {Swiper,SwiperItem} from 'components/common/swiper'
export default {
  name: "HomeSwiper",
  data(){
    return {
      index: 0,
      banner: [],
      link: [],
      image: []
    }
  },
  props:{
    banners:{
      type:Array,
      default(){
        return []
      }
    },
  },
  methods:{
    changeItem(index) {
      this.index = index;
    }
  },
  watch: {
    // immediate:true,
    banners(banners,old){
      this.banner = banners;
      let a =[],b = [];
      for(var i=0;i<banners.length;i++){
        a[i]  = banners[i].link;
        b[i]  = banners[i].image;
      }
      this.link = a;
      this.image = b;
    }
  },
  coumputed: {
 
  },
  components: {
     Swiper,
     SwiperItem }

}
</script>

<style>
 
</style>