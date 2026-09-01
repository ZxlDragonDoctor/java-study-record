// src/api/userApi.js
import request from '@/request.js'

export const userApi = {
    // 用户注册
    register(data) {
        return request.post('/user/register', data)
    },

    // 用户登录
    login(data) {
        return request.post('/user/login', data)
    },

    // 获取用户信息
    getInfo(data) {
        return request.get('/user/info',data)
    },

    // 更新用户信息
    updateInfo(data) {
        return request.post('/user/update', data)
    }
}