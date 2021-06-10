<template>
  <div class="nav">
    <div class="left">
      <slot name="left"></slot>  
    </div>
    <div class="center">
      <slot name="center"></slot>  
    </div>
    <div class="right">
      <slot name="right"></slot>  
    </div>
 
  </div>  
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style>
  .nav{
    display: flex;
    line-height: 44px;
    box-shadow: 0px 1px 1px rgb(100, 100, 100,.1);
    width: 100%;
  }
  .right,.left{
    width: 60px;
    height: 44px;
 
  }
  .center{
    flex: 1;
    height: 44px;
  }
</style>