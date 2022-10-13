<template>
<div class="container">
  <div class="row">
    <div class="col-12 text-center">
    <h4>Our Products</h4>
    <router-link :to="{name: 'AddProduct'}" style="float: right">
      <button class="btn btn-primary btn-large">Add Product</button>
    </router-link>
    </div>
  </div>
  <div class="row">
    <div v-for="product of products" :key="product.id" class="col-md-6 col-xl-4 col-12 pt-3 d-flex">
      <ProductBox :product="product"></ProductBox>
    </div>
  </div>
</div>
</template>

<script>
import ProductBox from "@/components/ProductBox";
export default {
  name: "ProductView",
  components: {ProductBox},
  props: ["products"]
}
</script>

<style scoped>

</style>