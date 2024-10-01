import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import axios from 'axios'

createApp(App).use(router).mount('#app')

// vue.prototype.$axios = axios;   // global Var : this.$axios
