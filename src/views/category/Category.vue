<template>
  <scroll class="wrapper" ref="aaa">
      <ul>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
        <li>1</li>
      </ul>
    
  </scroll>
</template>

<script>
import Scroll from 'components/common/scroll/Scroll.vue'
  export default {
  components: { Scroll },
    name: "Category",
    data() {
      return {
        scroll: null
      }
    },
    mounted() {

    }
  }
</script>

<style scoped>
.wrapper{
  height: 200px;
  background-color: aqua;
  overflow: hidden;
  /* overflow-y: scroll; */

}

  
</style>