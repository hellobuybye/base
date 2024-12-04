import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

// createApp(App).use(router).mount('#app')

// vue.prototype.$axios = axios;   // global Var : this.$axios

const app = createApp(App);
app.use(router);

// Axios 기본 URL 설정
// axios.defaults.baseURL = 'https://api.example.com'; // API의 기본 URL
// axios.defaults.headers.common['Authorization'] = 'Bearer YOUR_ACCESS_TOKEN'; // 기본 헤더 추가 (선택)
app.config.globalProperties.$axios = axios;

app.mount('#app');


