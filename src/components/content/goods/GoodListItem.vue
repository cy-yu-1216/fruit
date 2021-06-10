<template>
  <div class="goodContent">
    <a :href="item.link"><img :src="item.show.img" alt="" @load="imageLoad"></a>
    <div class="b_describe">
      <p>{{item.title}}</p>
      <span class="price">{{item.price}}</span>
      <span class="store">{{item.cfav}}</span>
    </div>   
  </div>
</template>

<script>
export default {
  name: "GoodListItem",
  props: {
    item: {
      type: Object,
      default() {
        return {}
      }
    }
  },
  methods: {
    imageLoad(){
      this.$bus.$emit("itemImageLoad"); 
    }
  }

}
</script>

<style scoped>
  .goodContent {
    position: relative;
    font-size: 10px;
    padding-bottom: 40px;
    width: 48%;
  }
  img{
    width:100%;
    border-radius: 5px;

  }
  .b_describe{
    position: absolute;
    left: 0;
    right: 0;
    overflow: hidden;
    bottom: 8px;
    text-align: center; 
  }
  p{
    /* //多出部分隐藏 */
    overflow: hidden;
    /* //一行显示 */
    white-space: nowrap;
    /* 隐藏是省略号 */
	  text-overflow: ellipsis;
     margin-bottom: 3px;
   
  }
  
  .price {
    color: var(--color-tint);
  }
  .store{
    position: relative;
    margin-left: 20px;
  }
  .store::before{
    content: '';
    position: absolute;
    bottom: 0px;
    left: -15px;
    right: 0px;
    /* 要加高宽才能显现 */
    width: 14px;
    height: 14px;
    background: url("~assets/img/common/collect.svg") 0 0/14px 14px;
  }

</style>