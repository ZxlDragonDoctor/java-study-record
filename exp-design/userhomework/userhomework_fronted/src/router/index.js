import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/components/Login.vue";
import Register from "@/components/Register.vue";
import UserDetails from "@/components/UserDetails.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/user/login'
        },
        {
            path: '/user/login',
            name: '用户登录',
            component: Login,
        },
        {
            path: '/user/register',
            name: '用户注册',
            component: Register,
        },
        {
            path: '/user/details/:username',
            name: '用户详情',
            props: true,
            component: UserDetails,
        }
    ],
})

export default router