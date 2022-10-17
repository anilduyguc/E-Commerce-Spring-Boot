<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">
          Shopping Cart
        </h3>
      </div>
      </div>
      <div v-for="cartItem in cartItems" :key="cartItem.id" class="row mt-2 pt-3">
        <div class="col-2"></div>
        <div class="col-md-3 ">
          <img :src="cartItem.product.imageUrl" class="w-100  card-image-top embed-responsive embed-responsive-16by9" style="object-fit: cover" />
        </div>
        <div class="col-md-5 px-3">
          <div class="card-block px-3">
            <h6 class="card-title">{{cartItem.product.name}}</h6>
            <p class="mb-0 font-weight-bold" id="item-price">${{cartItem.product.price}} per unit</p>
            <p class="mb-0">
              Quantity: {{cartItem.quantity}}
            </p>
          </div>
          <p class="mb-0">
            Total: <span class="font-weight-bold">
            ${{cartItem.product.price * cartItem.quantity}}
          </span>
          </p>
        </div>
        <div class="col-2"></div>
        <div class="col-12">
          <hr />
        </div>
      </div>
      <div class="total-cost pt-2 text-end">
        <h5>Total : $ {{ totalCost.toFixed(2) }}</h5>
        <button

            type="button"
            class="btn btn-primary confirm"

        >
          Confirm Order
        </button>
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
            console.log(res.data);
            const result = res.data;
            this.cartItems = result.cartItems;
            this.totalCost = result.totalCost;
          }).catch(err => console.log(err));
    }

  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.listCartItems();
  }
}
</script>

<style scoped>

</style>