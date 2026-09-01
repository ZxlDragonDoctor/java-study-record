<template>
  <div class="login-container">
    <h2>用户登录</h2>
    <form @submit.prevent="handleLogin">
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
      <button type="submit" class="login-btn">登录</button>
      <p class="register-link" style="color: blue;">
        还没有账号？
        <a href="#" @click="doChange" >立即注册</a>
      </p>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import {userApi} from "@/api/userApi.js";
import {message} from "ant-design-vue";
import { useRouter} from "vue-router";

const username = ref('')
const password = ref('')

const router = useRouter()

const handleLogin = async () => {
  // 这里添加登录逻辑
  const res = await userApi.login({
    username: username.value,
    password: password.value,
  })
  if (res.code === 0 && res.data) {
    message.success('登录成功')
    router.push({
      path: `/user/details/${username.value}`
    })
  } else {
    message.error('登录失败，' + res.message)
  }
}

const doChange = () =>{
   router.push({
      path: '/user/register',
   })
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 8px;
  background: rgba(255, 255, 255, 0.8);/* 半透明背景 */
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

.login-btn {
  width: 100%;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
}

.login-btn:hover {
  background-color: #45a049;
}

.register-link {
  text-align: center;
  margin-top: 15px;
}

.register-link a {
  color: #4CAF50;
  text-decoration: none;
}

.register-link a:hover {
  text-decoration: underline;
}
</style> 