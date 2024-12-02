<template>
  <commHeader/>
  <commNav/>
  

  <div class="main-layout">
    <commLeft/>

    <!-- <div class="main-content">
      <router-view/>
    </div>   -->
    <main>
      <router-view/>
    </main>  

    <!-- <commRight/> -->
  </div>  
  
  

  <commFooter/>
</template>

<script>

import commHeader from './components/common/commHeader.vue'
import commNav from './components/common/commNav.vue'
import commLeft from './components/common/commLeft.vue'
// import commRight from './components/common/commRight.vue'
import commFooter from './components/common/commFooter.vue'

export default {
  name: 'App',
  components: {    

    commHeader,
    commNav,
    commLeft,
    // commRight,
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

  display: flex; /* flexContainer화 한다. */
  flex-direction: column;
  min-height: calc(100vh - 16px);
}

.main-layout {
  display: flex; /* flexContainer화 한다. */
  flex: 1; /* 남은 공간을 채움 */
  
}

main {
 
  width: calc(100% - 100px);  
  justify-content: center;  /* 중앙 정렬 */
  
  padding-left: 100px;
  padding-right: 100px;
  padding-bottom: 50px;

  flex: 1; 
  /* 나머지 공간 차지 */
}

</style>
