<template>
  <tab-bar>
    <tab-bar-item path="/home" activeColor="pink">
       <img src="~assets/img/tabbar/home.svg" alt=""  slot="item-ico">
       <img src="~assets/img/tabbar/home_active.svg" alt=""  slot="item-active-ico">
       <div slot="item-text">首页</div>
    </tab-bar-item>
    <tab-bar-item path="/category" activeColor="pink"> 
      <img src="~assets/img/tabbar/category.svg" alt=""  slot="item-ico">
      <img src="~assets/img/tabbar/category_active.svg" alt=""  slot="item-active-ico">
      <div slot="item-text">分类</div>
    </tab-bar-item>
    <tab-bar-item path="/cart" activeColor="pink"> 
      <img src="~assets/img/tabbar/shopcart.svg" alt=""  slot="item-ico">
      <img src="~assets/img/tabbar/shopcart_active.svg" alt=""  slot="item-active-ico">
      <div slot="item-text">购物车</div></tab-bar-item>
    <tab-bar-item path="/profile" activeColor="pink"> 
      <img src="~assets/img/tabbar/profile.svg" alt=""  slot="item-ico">
      <img src="~assets/img/tabbar/profile_active.svg" alt=""  slot="item-active-ico">
      <div slot="item-text">我的</div></tab-bar-item>
  </tab-bar>

</template>

<script>
const TabBar=()=> import("components/common/tabbar/TabBar.vue")
const TabBarItem=()=> import("components/common/tabbar/TabBarItem.vue")
export default {
  name: "MainTabBar",
  components: {
    TabBar,
    TabBarItem
  }
}
</script>

<style>

</style>