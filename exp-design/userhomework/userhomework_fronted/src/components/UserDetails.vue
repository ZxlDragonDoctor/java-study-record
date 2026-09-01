<template>
  <div class="user-details-container">
    <h2>用户详情</h2>
    <div v-if="user && !isEditing" class="user-info view-mode">
      <!-- 查看模式 -->
      <div class="info-item">
        <label>用户名:</label>
        <span>{{ user.username }}</span>
      </div>
      <div class="info-item">
        <label>邮箱:</label>
        <span>{{ user.email }}</span>
      </div>
      <div class="info-item">
        <label>全名:</label>
        <span>{{ user.fullName }}</span>
      </div>
      <div class="info-item">
        <label>手机号:</label>
        <span>{{ user.phoneNumber }}</span>
      </div>
      <div class="info-item">
        <label>状态:</label>
        <span :class="['status', user.isActive ? 'active' : 'inactive']">
          {{ user.isActive ? '活跃' : '不活跃' }}
        </span>
      </div>
      <div class="info-item">
        <label>上次登录:</label>
        <span>{{ formatDateTime(user.lastLogin) }}</span>
      </div>
      <button @click="startEditing" class="edit-btn">编辑资料</button>
    </div>

    <form v-if="user && isEditing" @submit.prevent="saveChanges" class="user-info edit-mode">
      <!-- 编辑模式 -->
       <div class="info-item">
        <label>用户名:</label>
        <input type="text" id="username" v-model="editableUser.username" required>
      </div>
      <div class="info-item">
        <label for="email">邮箱:</label>
        <input type="email" id="email" v-model="editableUser.email" required />
      </div>
      <div class="info-item">
        <label for="fullName">全名:</label>
        <input type="text" id="fullName" v-model="editableUser.fullName" required />
      </div>
      <div class="info-item">
        <label for="phoneNumber">手机号:</label>
        <input type="tel" id="phoneNumber" v-model="editableUser.phoneNumber" />
      </div>
       <div class="info-item">
        <label>状态:</label>
         <span>{{ editableUser.isActive ? '活跃' : '不活跃' }}</span> <!-- 状态通常由系统管理 -->
      </div>
       <div class="info-item">
        <label>上次登录:</label>
        <span>{{ formatDateTime(editableUser.lastLogin) }}</span> <!-- 上次登录时间通常不可编辑 -->
      </div>
      <div class="edit-actions">
        <button type="submit" class="save-btn">保存</button>
        <button type="button" @click="cancelEditing" class="cancel-btn">取消</button>
      </div>
    </form>

    <div v-if="!user">
      正在加载用户信息...
    </div>
  </div>
</template>

<script setup>
import {ref, onMounted, reactive, computed} from 'vue';
import router from "@/router/index.js";
import {useRoute} from "vue-router";
import {userApi} from "@/api/userApi.js";
import {message} from "ant-design-vue";

const user = ref(null);
const isEditing = ref(false);
// 使用 reactive 创建可编辑的用户数据副本
const editableUser = reactive({});

const route = useRoute()

const username = route.params.username;

// 获取用户信息
const fetchUserDetails = async () => {
  console.log(username)
  const res = await userApi.getInfo({
    username: username
  })
  if (res.code === 0 && res.data) {
    message.success('获取用户信息成功')
    user.value = {
      ...res.data
    }
  } else {
    message.error('获取用户信息失败,' + res.message)
  }
}

// 格式化日期时间
const formatDateTime = (date) => {
  if (!date) return 'N/A';
  return new Date(date).toLocaleString('zh-CN');
};

// 进入编辑模式
const startEditing = () => {
  // 将当前用户数据复制到可编辑对象
  Object.assign(editableUser, user.value);
  isEditing.value = true;
};

// 取消编辑
const cancelEditing = () => {
  isEditing.value = false;
  // 不需要恢复 editableUser，因为下次编辑会重新复制
};

// 保存更改
const saveChanges = async () => {
  const res = await userApi.updateInfo({
    oldUsername: user.value.username,
    ...editableUser
  })
  if (res.code === 0 && res.data) {
    message.success('更新用户信息成功')
    Object.assign(user.value,editableUser)
    cancelEditing()
  } else {
    message.error('更新用户信息失败,' + res.message)
  }
};

// 组件挂载后获取数据
onMounted(() => {
  fetchUserDetails();
});

</script>

<style scoped>
.user-details-container {
  max-width: 600px;
  margin: 20px auto;
  padding: 30px;
  background-color: rgba(255, 255, 255, 0.8); /* 半透明背景 */
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 25px;
}

.user-info {
  display: grid;
  gap: 15px;
}

.info-item {
  display: flex;
  align-items: center;
  padding-bottom: 10px;
  border-bottom: 1px solid #eee;
  min-height: 38px; /* 保持查看和编辑模式下高度一致 */
}

.info-item label {
  font-weight: bold;
  color: #555;
  min-width: 80px;
  margin-right: 15px;
}

.info-item span,
.info-item input {
  color: #333;
  flex-grow: 1; /* 让输入框或文本填充剩余空间 */
}

/* 编辑模式下的输入框样式 */
.edit-mode input[type="text"],
.edit-mode input[type="email"],
.edit-mode input[type="tel"] {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 1em;
}

.status {
  padding: 3px 8px;
  border-radius: 4px;
  font-size: 0.9em;
  color: white;
}

.status.active {
  background-color: #4CAF50;
}

.status.inactive {
  background-color: #f44336;
}

/* 按钮通用样式调整 */
button {
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1em;
  transition: background-color 0.3s ease;
  margin-top: 10px; /* 为按钮添加上边距 */
}

/* 编辑按钮特定样式 */
.edit-btn {
  background-color: #ffc107; /* 黄色 */
  color: #333;
  display: block; /* 让编辑按钮独占一行 */
  width: auto; /* 宽度自适应内容 */
  margin-left: auto; /* 尝试右对齐 */
  margin-right: 0;
}

.edit-btn:hover {
  background-color: #e0a800;
}

/* 编辑操作按钮容器 */
.edit-actions {
  display: flex;
  justify-content: flex-end; /* 按钮右对齐 */
  gap: 10px; /* 按钮间距 */
  margin-top: 20px;
}

/* 保存按钮 */
.save-btn {
  background-color: #2196F3; /* 蓝色 */
  color: white;
}

.save-btn:hover {
  background-color: #0b7dda;
}

/* 取消按钮 */
.cancel-btn {
  background-color: #ccc;
  color: #333;
}

.cancel-btn:hover {
  background-color: #bbb;
}

</style> 