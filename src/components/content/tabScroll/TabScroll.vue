<template>
  <div class="tabScroll">
    <div v-for="(item,index) in title" :key="index" class="title">
      <span :class="{itemActive:index==cIndex}" @click="getIndex(index)">{{item}}</span>
    </div>
  </div>
</template>
<script>
export default {
  name: "TabScroll",
  data(){
    return {
      cIndex:0
    }
  },
  props: {
    title: {
      type: Array,
      default(){
        return []
      }
    }
  },
  methods: {
    getIndex(index) {
      this.cIndex = index;
      this.$emit("getCurIndex", this.cIndex);
      // console.log(111);

    }
  }
}
</script>

<style>
  .tabScroll{
    display: flex;
  }
  .title{
    flex:1;
    text-align: center;
  }
  .title span{
    padding: 4px;
    
  }
  .itemActive{
    color: var(--color-tint);
    border-bottom: 3px solid var(--color-tint);
  }
</style>