// src/utils/http.js
import axios from 'axios'
import { message } from 'ant-design-vue'
import router from "@/router/index.js";

// 创建axios实例
const http = axios.create({
    baseURL: 'http://localhost:9090', // API基础地址
    timeout: 10000, // 请求超时时间
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    }
})

// 请求拦截器
http.interceptors.request.use(
    config => {
        // // 在发送请求之前做些什么（例如添加token）
        return config
    },
    error => {
        // 对请求错误做些什么
        return Promise.reject(error)
    }
)

// 响应拦截器
http.interceptors.response.use(
    response => {
        // 对响应数据做点什么
        return response.data
    },
    error => {
        // 对响应错误做点什么
        return Promise.reject(error)
    }
)

// 封装通用请求方法
const request = {
    get(url, params, config = {}) {
        return http.get(url, { params, ...config })
    },

    post(url, data, config = {}) {
        return http.post(url, data, config)
    },

    put(url, data, config = {}) {
        return http.put(url, data, config)
    },

    delete(url, params, config = {}) {
        return http.delete(url, { params, ...config })
    },

    // 文件上传
    upload(url, file, config = {}) {
        const formData = new FormData()
        formData.append('file', file)
        return http.post(url, formData, {
            headers: { 'Content-Type': 'multipart/form-data' },
            ...config
        })
    }
}

export default request