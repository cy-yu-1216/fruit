import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
const Home =()=>import("views/home/Home.vue")
const Profile =()=>import("views/profile/Profile.vue")
const Cart =()=>import("views/cart/Cart.vue")
const Category =()=>import("views/category/Category.vue")
Vue.use(VueRouter)

const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',

    component: Home
  },
  {
    path: '/category',

    component: Category
  },
  {
    path: '/cart',

    component: Cart
  },
  {
    path: '/profile',

    component: Profile
  }
]
// //获取原型对象上的push函数
// const originalPush = VueRouter.prototype.replace
// //修改原型对象中的push方法
// VueRouter.prototype.replace = function replace(location) {
//   return originalPush.call(this, location).catch(err => err)
// }
const router = new VueRouter({
  mode: 'history',

  routes
})

export default router
