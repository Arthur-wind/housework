import axios from 'axios'
import router from '@/router/router-static'
import storage from '@/utils/storage'

// 创建 axios 实例
const http = axios.create({
  timeout: 1000 * 86400,
  withCredentials: true,
  baseURL: '/springbootc90g5',
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  }
})

// 请求拦截器：统一携带 Token
http.interceptors.request.use(config => {
  // 优先从 storage 中获取 Token，否则从 localStorage 获取
  const token = storage.get('Token') || localStorage.getItem('token')
  if (token) {
    config.headers['Token'] = token
  }
  return config
}, error => {
  return Promise.reject(error)
})

// 响应拦截器：统一处理 401、异常提示等
http.interceptors.response.use(response => {
  if (response.data && response.data.code === 401) {
    // 避免重复跳转登录页
    if (router.currentRoute.name !== 'login') {
      // 清除本地 token
      storage.remove('Token')
      localStorage.removeItem('token')
      // 跳转到登录页
      router.push({ name: 'login' })
    }
  }

  return response
}, error => {
  // 可选：处理超时或网络异常提示
  if (error.code === 'ECONNABORTED' || error.message.includes('timeout')) {
    console.warn('请求超时，请稍后重试')
  }

  return Promise.reject(error)
})

export default http
