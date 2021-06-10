<template>
  <div class="tab-bar-item">
    <div v-if="isActive" @click="itemclick">
        <slot name="item-ico"></slot>
    </div>
    <div v-else>
       <slot name="item-active-ico"></slot>
    </div>
    <div :style="isText">
      <slot name="item-text"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabBarItem",
  props: {
    path:String
  },
  props: {
    path: String,
    activeColor:{
      type:String,
      default:'red'
    }
  },
  computed: {
    isActive() {
      return this.$route.path.indexOf(this.path) == -1
    },
    isText() {
      return this.isActive ? {} : {color: this.activeColor}
    }
  },
    methods: {
      itemclick() {
        this.$router.replace(this.path);

      }

    }
}
</script>

<style>
.tab-bar-item{
  flex:1;
  text-align: center;
  font-size: 14px;
  height: 49px;

}
.tab-bar-item img{
  width: 24px;
  height: 24px;
  vertical-align: middle;
  margin-top: 2px;
}

</style>