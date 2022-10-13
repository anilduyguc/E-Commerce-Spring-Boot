<template>
<div class="container">
  <div class="row">
    <div class="col-12 text-center">
      <h4>Add new Product</h4>
    </div>
  </div>
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6">
      <form action="">
        <div class="form-group">
          <label>Category</label>
          <select class="form-control" v-model="categoryId" required>
            <option v-for="category of categories" :key="category.id" :value="category.id">{{category.categoryName}}</option>
          </select>
        </div>
        <div class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name">
        </div>
        <div class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description">
        </div>
        <div class="form-group">
          <label>URL of the Image</label>
          <input type="text" class="form-control" v-model="imageUrl">
        </div>
        <div class="form-group">
          <label>Price</label>
          <input type="number" class="form-control" v-model="price">
        </div>
        <button type="button" class="btn btn-primary" @click="addProduct">Add Product</button>
      </form>
    </div>
    <div class="col-3"></div>
  </div>
</div>
</template>

<script>
import axios from "axios";
import swal from 'sweetalert';
export default {
  name: "AddProduct",
  props: ["baseUrl","categories"],
  data(){
    return {
      id: null,
      categoryId: null,
      description: null,
      imageUrl: null,
      price: null,

    }
  },
  methods: {
    addProduct(){
      const newProduct = {
        description: this.description,
        categoryId: this.categoryId,
        imageUrl: this.imageUrl,
        price: this.price,
        name: this.name
      };
      axios.post(`${this.baseUrl}/product/create`, newProduct)
          .then(() => {
            this.$router.push({
              name: 'AdminProduct'
            });
            swal({
              text:"Product added",
              icon: "success"
            });
          }).catch((err) => {
            console.log(err);
      })
    }
  }
}
</script>

<style scoped>

</style>