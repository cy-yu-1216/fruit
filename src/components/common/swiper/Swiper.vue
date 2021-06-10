<template>
  <div class="swiper">
    <div class="swiper-image">
      <slot></slot>
    </div>
    <div class="indicator">
      <!-- item是从1开始的 -->
        <div class="point" v-for="item of len" :key="item" :class="{active:item==index+1}" @click="pressCy(item)"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Swiper",
  data() {
    return {
      index: 0,    
    }
  },
  props: {
    len:{
      type:Number,
      default:0}
   
  },
  mounted(){
    this.setTime();
  }
  ,
  methods: {
    //小圆点点击
    pressCy(item){
      // console.log(item);
      this.index = item-1;
      this.changeIndex()
      clearInterval(this.interval);
      this.setTime();
    },
    setTime() {
      this.interval = setInterval(() => {
        this.index++;
        this.index = this.index%4;
        // console.log(this.index);
        this.changeIndex()
      }, 3000);
    },
    changeIndex() {
       this.$emit("changeIndex", this.index)
    }
  }
}
</script>

<style scoped>
  .swiper{
    overflow: hidden;
    position: relative;
    width: 100%;
  }
  .indicator{
    display: flex;
    justify-content: center;
    position: absolute; 
    width: 100%;
    bottom: 8px;
  }
  .swiper-image{
    display: flex;
    /* flex-direction: row */
  }
  .point{
     /* 为元素指定的任何内边距和边框都将在已设定的宽度和高度内进行绘制。
通过从已设定的宽度和高度分别减去边框和内边距才能得到内容的宽度和高度。 */
    box-sizing: border-box;
    margin: 0 5px;
    width: 6px;
    height: 6px;
    border-radius: 50%;
    background-color: white;
  }
  .active{
        background-color: rgba(212,62,46,1.0);
  }
</style>