<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Shopping Cart</h3>
      </div>
    </div>
      <div v-for="cartItem in cartItems" :key="cartItem.id" class="row mt-2 pt-3 justify-content-around">
        <div class="col-2"></div>
        <div class="col-md-3 embed-responsive embed-responsive-16by9">
          <img :src="cartItem.product.imageUrl" class="w-100  card-image-top embed-responsive-item" style="object-fit: cover" />
        </div>
        <div class="col-md-5 px-3">
          <div class="card-block px-3">
            <h6 class="card-title">
              <router-link :to="{name:'ShowDetails', params: { id: cartItem.product.id}}">
                {{cartItem.product.name}}
              </router-link>
            </h6>
            <p class="mb-0 font-weight-bold" id="item-price">${{cartItem.product.price}} per unit</p>
            <p class="mb-0" style="float: left">
              Quantity: {{cartItem.quantity}}
            </p>
          </div>
          <p class="mb-0" style="float: right;">
            Total: <span class="font-weight-bold">
            ${{cartItem.product.price * cartItem.quantity}}
          </span>
          </p>
          <br />
          <a href="#" class="text-end" @click="deleteItem(cartItem.id)">Remove from Cart</a>
        </div>
        <div class="col-2"></div>
        <div class="col-12"><hr /></div>
      </div>
      <div class="total-cost pt-2 text-right">
        <h5>Total : $ {{ totalCost.toFixed(2) }}</h5>
        <button type="button" class="btn btn-primary confirm" @click="checkOut">Confirm Order</button>
      </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "CartView",
  props: ["baseUrl"],
  data(){
    return {
      cartItems: [],
      token: null,
      totalCost: 0
    }
  },
  methods: {
    listCartItems(){
      axios.get(`${this.baseUrl}/cart/list?token=${this.token}`)
          .then(res => {
            const result = res.data;
            this.cartItems = result.cartItems;
            this.totalCost = result.totalCost;
          }).catch(err => console.log(err));
    },
    deleteItem(id){
      axios.delete(`${this.baseUrl}/cart/delete/${id}?token=${this.token}`)
          .then(res => {
            if(res.status === 204){
              this.$router.go(0);
            }
          }).catch(err => console.log(err));
    },
    checkOut(){
      this.$router.push({name: 'CheckoutView'})
    }
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.listCartItems();
  }
}
</script>

<style scoped>
h4, h5 {
  color: #484848;
  font-size: 700;
}
</style>