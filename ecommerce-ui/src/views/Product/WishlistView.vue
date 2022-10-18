<template>
<div class="container">
  <div class="row">
    <div class="col-12 text-center">
      <h4 class="pt-3">Your Wishlist Items</h4>
    </div>
  </div>
  <div class="row">
    <div v-for="product of products" :key="product.id" class="col-md-6 col-xl-4 col-12 pt-3  justify-content-around d-flex">
      <ProductBox :product="product">
      </ProductBox>
    </div>
  </div>
</div>
</template>

<script>
import axios from "axios";
import ProductBox from "@/components/ProductBox";

export default {
  name: "WishlistView",
  components: {ProductBox},
  props: ["baseUrl"],
  methods: {
    fetchWishlist(){
      axios.get(`${this.baseUrl}/wish-list/${this.token}`)
          .then(res => {
            this.products=res.data;
          }).catch(err => console.log(err));
    }
  },
  mounted() {
    this.token = localStorage.getItem('token');
    this.fetchWishlist();
  },
  data(){
    return{
      token: null,
      products: null
    }
  }
}
</script>

<style scoped>

</style>