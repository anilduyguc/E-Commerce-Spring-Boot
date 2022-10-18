<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Add Category</h3>
      </div>
    </div>
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <form action="">
          <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" v-model="categoryName">
          </div>
          <div class="form-group">
            <label>Description</label>
            <textarea type="text" class="form-control" v-model="description" />
          </div>
          <div class="form-group">
            <label>Image</label>
            <input type="text" class="form-control" v-model="imageUrl">
          </div>
          <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>

import axios from 'axios';
const sweetalert = require("sweetalert");
export default {
  data(){
    return {
      categoryName:"",
      description:"",
      imageUrl:"",
    };
  },
  methods: {
    addCategory(){
      const newCategory = {
         categoryName: this.categoryName,
         description: this.description,
         imageUrl: this.imageUrl,
      }
       const baseUrl = "http://localhost:8080/api/v1";
      axios.post(`${baseUrl}/category/create`, newCategory)
          .then(() => {
            sweetalert({
              text: "Category added successfully",
              icon: 'success'
            });
          }).catch((error) => {
          console.log(error);
      })

    }
  },
  name: "AddCategory"
}
</script>

<style scoped></style>