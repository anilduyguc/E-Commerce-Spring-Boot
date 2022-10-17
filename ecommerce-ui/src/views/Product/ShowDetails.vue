<template>
  <div class="container">
    <div class="row pt-5">
      <div class="col-md-1">

      </div>
      <div class="col-md-4 col-12">
        <img :src="product.imageUrl" class="img-fluid">
      </div>
      <div class="col-md-6 col-12 pt-3 pt-md-0">
        <h4>{{product.name}}</h4>
        <h6 class="category font-italic">{{category.categoryName}}</h6>
        <h6 class="font-weight-bold">$ {{product.price}}</h6>
        <p>
          {{product.description}}
        </p>
        <div class="d-flex flex-row justify-content-between">
          <div class="input-group col-md-3 col-4 p-0">
            <div class="input-group-prepend">
              <span class="input-group-text">Quantity</span>
            </div>
            <input class="form-control" type="number" v-model="quantity">
          </div>
          <div class="input-group col-md-3 col-4 p-0">
            <button id="add-to-cart-button" class="btn" @click="addToCart">Add to Cart</button>
          </div>
        </div>
        <div class="features pt-3">
          <h5><strong>Features</strong></h5>
          <ul>
            <li>LOREM</li>
            <li>IPSUM</li>
            <li>ASDasd</li>
            <li>ASDAS</li>
            <li>ASDASD</li>
            <li>ASDS</li>
          </ul>
        </div>
        <button id="wishlist-button" class="btn me-3 p-1 py-0" @click="addToWishlist">{{this.wishListString}}</button>
      </div>
    </div>
  </div>
</template>

<script>
import swal from "sweetalert";
import axios from "axios";
export default {
  name: "ShowDetails",
  props: ["baseUrl", "products", "categories"],
  data(){
    return {
      product: {},
      category: {},
      quantity: 1,
      wishListString: "Add to Wishlist"
    }
  },
  mounted() {
    this.id = this.$route.params.id;
    this.product = this.products.find((product) => product.id == this.id);
    this.category = this.categories.find((category) => category.id == this.product.categoryId);
    this.token = localStorage.getItem("token");
  },
  methods: {
    addToWishlist(){
      if(!this.token){
        swal({
          text: "Please login to add an item to wishlist",
          icon: "error"
        });
        return;
      }
      axios.post(`${this.baseUrl}/wish-list/add?token=${this.token}`, {
        id: this.product.id,
      }).then((res) => {
        if(res.status === 201){
          this.wishListString = "Added to Wishlist";
          swal({
            text: "Added to Wishlist",
            icon: "success"
          });
        }
      }).catch((err) => console.log(err));
    },
    addToCart(){
      if(!this.token){
        swal({
          text: "Please login to add an item to cart",
          icon: "error"
        });
        return;
      }
      axios.post(`${this.baseUrl}/cart/add?token=${this.token}`, {
        productId: this.id,
        quantity: this.quantity
      }).then(res => {
        if(res.status === 201){
          swal({
            text: "Product added to cart",
            icon: "success"
          });
          this.$emit("fetchData");
        }
      }).catch((err) => console.log(err));
    }
  }
}
</script>

<style scoped>
  .category{
    font-weight: 400;
  }
  #wishlist-button{
    background-color: #b9b9b9;
  }
  #add-to-cart-button {
    background-color: #febd69;
  }
</style>