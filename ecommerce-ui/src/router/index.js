import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from "@/views/Category/AddCategory";
import Category from "@/views/Category/Category";
import Admin from "@/views/Admin";
import ProductView from "@/views/Product/ProductView";
import AddProduct from "@/views/Product/AddProduct";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/admin/category/add',
    name: 'AddCategory',
    component: AddCategory
  },
  {
    path: '/admin/category',
    name: 'Category',
    component: Category
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin
  },
  {
    path: '/admin/product',
    name: 'AdminProduct',
    component: ProductView
  },
  {
    path: '/admin/product/add',
    name: 'AddProduct',
    component: AddProduct
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
