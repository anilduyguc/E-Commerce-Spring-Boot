<template>
  <Navbar :cartCount="cartCount" @resetCartCount="resetCartCount" />
  <router-view v-if="products && categories"
               :baseUrl="baseUrl"
               :categories="categories"
               :products="products"
               @fetchData="fetchData" style="min-height: 60vh">
  </router-view>
  <footer-view></footer-view>
</template>

<script>
import Navbar from "@/components/Navbar";
import axios from "axios";
import FooterView from "@/components/Footer";
export default {
  components: {FooterView, Navbar },
  data(){
    return {
      baseUrl: "http://localhost:8080/api/v1",
      products: null,
      categories: null,
      cartCount: 0
    }
  },
  methods: {
    async fetchData() {
      await axios.get(`${this.baseUrl}/category/list`)
          .then((res) => {
            this.categories = res.data;
          }).catch((err) => {
            console.log(err);
          });

      await axios.get(`${this.baseUrl}/product/list`)
          .then((res) => {
            this.products = res.data;
          }).catch((err) => {
            console.log(err);
          });
      if(this.token){
        axios.get(`${this.baseUrl}/cart/list?token=${this.token}`)
            .then(res => {

              const result = res.data;
              this.cartCount = result.cartItems.length;
            }).catch(err => console.log(err));
      }
    },
    resetCartCount(){
      this.cartCount = 0;
    }
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.fetchData();
  }
};
</script>

<style>
html {
  overflow-y: scroll;
}
</style>
