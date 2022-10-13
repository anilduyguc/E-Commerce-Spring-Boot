<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Product</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form action="" v-if="product">
          <div class="form-group">
            <label>Category</label>
            <select class="form-control" v-model="product.categoryId" required>
              <option v-for="category of categories" :key="category.id" :value="category.id">{{category.categoryName}}</option>
            </select>
          </div>
          <div class="form-group">
            <label>Name</label>
            <input type="text" v-model="product.name" required class="form-control">
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" v-model="product.description" required class="form-control">
          </div>
          <div class="form-group">
            <label>Image URL</label>
            <input type="text" v-model="product.imageUrl" required class="form-control">
          </div>
          <div class="form-group">
            <label>Price</label>
            <input type="number" v-model="product.price" required class="form-control">
          </div>
          <button type="button" class="btn btn-primary" @click="editProduct">Submit Changes</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from "sweetalert";
export default {
  name: "EditProduct",
  data(){
    return {
      product: null,
      id: null
    }
  },
  props: ["baseUrl", "categories", "products"],
  mounted() {
    this.id=this.$route.params.id;
    this.product=this.products.find(product => product.id == this.id);
  },
  methods: {
    async editProduct(){
      await axios.post(`${this.baseUrl}/product/edit/${this.id}`, this.product)
          .then(() => {
            this.$emit("fetchData");
            this.$router.push({name: 'AdminProduct'});
            swal({
              text: "Product has been updated",
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