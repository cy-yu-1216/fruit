
<template>
   <div id="app">
     <keep-alive>
      <router-view/>
    </keep-alive>
    <main-tab-bar/>

  </div>
</template>

<script>
const MainTabBar=()=>import("components/content/mainTabBar/MainTabBar.vue")
export default {
  name: "App",
  components: {
    MainTabBar
  }
}
</script>


<style>
 @import 'assets/css/base.css';
</style>
