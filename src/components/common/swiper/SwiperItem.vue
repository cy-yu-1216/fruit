<template>
  <div class="slide-image">
    <div class="slide">
      <slot></slot>
    </div>
  </div>

</template>

<script>
export default {
  name: "SwiperItem"
}
</script>

<style scoped>
 .slide-image {
    width: 100%;
    flex-shrink:0;
  }
.slide a {
  /* 变成行内快元素 宽高就不适应浏览器大小 */
  /* display: inline-block; */
  padding: 0;
  margin: 0;
}
  .slide img {
    width: 100%;
    overflow: hidden;
  }
</style>