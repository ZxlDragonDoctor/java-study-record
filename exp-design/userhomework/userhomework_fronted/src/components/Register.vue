<template>
  <div class="register-container">
    <h2>用户注册</h2>
    <form @submit.prevent="handleRegister">
      <div class="form-group">
        <label for="username">用户名</label>
        <input
          type="text"
          id="username"
          v-model="username"
          required
          placeholder="请输入用户名"
        />
      </div>
      <div class="form-group">
        <label for="password">密码</label>
        <input
          type="password"
          id="password"
          v-model="password"
          required
          placeholder="请输入密码"
        />
      </div>
      <div class="form-group">
        <label for="confirmPassword">确认密码</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="confirmPassword"
          required
          placeholder="请再次输入密码"
        />
      </div>
      <button type="submit" class="register-btn">注册</button>
      <p class="login-link" style="color: blue;">
        已有账号？
        <a href="#" @click="doChange">立即登录</a>
      </p>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { message } from 'ant-design-vue'
import {userApi} from "@/api/userApi.js";
import { useRouter } from 'vue-router'

const username = ref('')
const password = ref('')
const confirmPassword = ref('')

const router = useRouter()

const handleRegister = async () => {
  if (password.value !== confirmPassword.value) {
    alert('两次输入的密码不一致！')
    return
  }
  // 这里添加注册逻辑
  const res = await userApi.register({
     username: username.value,
     password: password.value,
     checkPassword: confirmPassword.value
  })
  console.log(res)
  if (res.code === 0 && res.data) {
    message.success('注册成功')
    router.push({
      path: '/user/login',
      replace: true,
    })
  } else {
    message.error('注册失败，' + res.message)
  }
}
const doChange = ()=>{
    router.push({
      path:'/user/login',
    })
}
</script>

<style scoped>
.register-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 8px;
  background: rgba(255, 255, 255, 0.8); /* 半透明背景 */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  color: #666;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
}

.register-btn {
  width: 100%;
  padding: 10px;
  background-color: #2196F3;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
}

.register-btn:hover {
  background-color: #0b7dda;
}

.login-link {
  text-align: center;
  margin-top: 15px;
}

.login-link a:hover {
  text-decoration: underline;
}
</style> 