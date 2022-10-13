<template>
  <Navbar />
  <router-view v-if="products && categories"
               :baseUrl="baseUrl"
               :categories="categories"
               :products="products"
               @fetchData="fetchData">

  </router-view>
</template>

<script>
import Navbar from "@/components/Navbar";
import axios from "axios";
export default {
  components: { Navbar },
  data(){
    return {
      baseUrl: "http://localhost:8080/api/v1",
      products: null,
      categories: null
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
    }
  },
  mounted() {
    this.fetchData();
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
