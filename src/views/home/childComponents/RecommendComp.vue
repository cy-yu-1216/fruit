<template>
  <div class="recommend">
    <div class="image" v-for="(item,index) in recommends" :key="index">
      <a :href="item.link">
        <img :src="item.image" alt="">
        <p>{{item.title}}</p>
      </a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "RecommendComp",
    props: {
      recommends: {
        type:Array,
        default(){
          return []
        }
      }
    }
  }
</script>

<style>
  .recommend{
    display: flex;
    overflow: hidden;
    font-size: 10px;
    padding: 10px 0px 20px 0px;
    width: 100%;
    border-bottom: 6px solid #EEEEEE;
  }
  .image{
    /* 每个人均匀占一份 */
    flex: 1;
    text-align: center;
  }
  .image img{
    margin-bottom: 4px;
    width: 70px;
    height: 70px;
    
  }
</style>