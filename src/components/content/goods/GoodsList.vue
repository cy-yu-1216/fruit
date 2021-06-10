<template>
  <div class="goods">
    <good-list-item v-for="item,index in goods" :key="index" :item = "item"></good-list-item>
  </div>
</template>

<script>
import GoodListItem from "./GoodListItem.vue"
export default {
  name: "GoodList",
  components:{ GoodListItem},
  props: {
    goods: {
      type: Array,
      default() {
        return []
      }
    }
  }
}
</script>
<style scoped>
  .goods{
    margin-top: 15px;
    display: flex;
    padding: 5px;
    flex-wrap: wrap;
     /* 均等分 中间空隙距离相等  最两边空袭加起来等于中间空隙*/
    justify-content: space-around;
  }
</style>