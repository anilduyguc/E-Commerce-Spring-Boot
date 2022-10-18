import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from "@/views/Category/AddCategory";
import Category from "@/views/Category/Category";
import Admin from "@/views/Admin";
import ProductView from "@/views/Product/ProductView";
import AddProduct from "@/views/Product/AddProduct";
import EditCategory from "@/views/Category/EditCategory";
import EditProduct from "@/views/Product/EditProduct";
import ShowDetails from "@/views/Product/ShowDetails";
import ListProducts from "@/views/Category/ListProducts";
import SignupView from "@/views/SignupView";
import SigninView from "@/views/SigninView";
import WishlistView from "@/views/Product/WishlistView";
import CartView from "@/views/CartView";
import SuccessView from "@/views/Payment/SuccessView";
import FailedView from "@/views/Payment/FailedView";
import CheckoutView from "@/views/Checkout/CheckoutView";

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/category/view/:id',
    name: 'ListProducts',
    component: ListProducts
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
    path: '/admin/category/edit/:id',
    name: 'EditCategory',
    component: EditCategory
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
  {
    path: '/admin/product/edit/:id',
    name: 'EditProduct',
    component: EditProduct
  },
  {
    path: '/product/view/:id',
    name: 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/signup',
    name: 'SignupView',
    component: SignupView
  },
  {
    path: '/signin',
    name: 'SigninView',
    component: SigninView
  },
  {
    path: '/wishlist',
    name: 'WishlistView',
    component: WishlistView
  },
  {
    path: '/cart',
    name: 'CartView',
    component: CartView
  },
  {
    path: '/payment/success',
    name: 'SuccessView',
    component: SuccessView
  },
  {
    path: '/payment/failed',
    name: 'FailedView',
    component: FailedView
  },
  {
    path: '/checkout',
    name: 'CheckoutView',
    component: CheckoutView
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
