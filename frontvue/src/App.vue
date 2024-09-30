<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"/> -->
    <commHeader/>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <commLeft/>
    <commFooter/>
  </div>

</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

import commHeader from './components/common/commHeader.vue'
import commLeft from './components/common/commLeft.vue'
import commFooter from './components/common/commFooter.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld,

    commHeader,
    commLeft,
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
  margin-top: 60px;
}
</style>
