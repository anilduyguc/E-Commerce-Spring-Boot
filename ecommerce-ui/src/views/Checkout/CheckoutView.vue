<template>
  <div class="main-class">
    <h3>You will be redirected to payment page.</h3>
    <div class="alert alert-primary">
      While making payment use card number 4242 4242 4242 4242 and enter random date and cvv (3 digit)
    </div>
    <button class="btn checkout-button" @click="goCheckOut">Make Payment</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CheckoutView",
  props: ["baseUrl"],
  methods: {
    getAllItems(){
      axios.get(`${this.baseUrl}/cart/list?token=${this.token}`)
          .then((res) => {
            if(res.status === 200){
              let products = res.data;
              for(let i = 0; i< products.cartItems.length; i++){
                this.checkoutBodyArray.push({
                  price: products.cartItems[i].product.price,
                  quantity: products.cartItems[i].quantity,
                  productId: products.cartItems[i].product.id,
                  productName: products.cartItems[i].product.name
                });
              }
            }
          }).catch(err => console.log(err));
    },
    goCheckOut(){
      axios.post(`${this.baseUrl}/order/create-checkout-session`, this.checkoutBodyArray)
          .then(res => {
            localStorage.setItem("sessionId", res.data.sessionId);
            this.stripe.redirectToCheckout({
              sessionId: res.data.sessionId
            });
          }).catch(err => console.log(err));
    }
  },
  data(){
    return {
      stripeApiToken:"pk_test_51KzLpzFB4AxkeetMmU2FkCm9Re2adwfJBPnUuMNO1XBoBXjAjT4qnZwZIcJX9X8KdTbw4Kx2fQ1c6zxshBfCgTtb00MMFARmqy",
      stripe: "",
      token: null,
      checkoutBodyArray: []
    }
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.stripe = window.Stripe(this.stripeApiToken);
    this.getAllItems();
    //this.goCheckOut();
  }
}
</script>

<style scoped>
.alert {
  width: 50%;
}
.main-class {
  margin-top: 5%;
  margin-left: 30%;
}
.checkout-button {
  background-color: #5d3dec;
  margin: 10px;
  color: white;
}
</style>