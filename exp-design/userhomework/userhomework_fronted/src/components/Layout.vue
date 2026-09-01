<template>
  <div class="auth-layout">
    <div class="auth-container">
      <router-view/>
    </div>
  </div>
</template>

<script setup>


</script>

<style scoped>
.auth-layout {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url('@/assets/images/img.png'); /* 替换为你的图片路径 */
  background-size: cover;
  background-position: center;
  margin: 0;
  padding: 0;
}

.auth-container {
  width: 100%;
  max-width: 500px;
  padding: 20px;
}
</style> 