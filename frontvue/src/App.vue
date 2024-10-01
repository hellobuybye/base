<template>
  <commHeader/>
  <commNav/>
  <!-- <commLeft/> -->
  
  <router-view/>

  <commFooter/>
</template>

<script>

import commHeader from './components/common/commHeader.vue'
import commNav from './components/common/commNav.vue'
// import commLeft from './components/common/commLeft.vue'
import commFooter from './components/common/commFooter.vue'

export default {
  name: 'App',
  components: {    

    commHeader,
    commNav,
    // commLeft,
    commFooter

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

</style>
