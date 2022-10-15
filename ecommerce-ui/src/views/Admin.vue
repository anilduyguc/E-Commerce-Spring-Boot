<template>
  <div class="container py-4">
    <router-link :to="{name: 'Category'}">
      <button class="btn btn-primary btn-large">Admin Category</button>
    </router-link>
    <br />
    <router-link :to="{name: 'AdminProduct'}">
      <button class="btn btn-primary btn-large">Admin Products</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "AdminView"
}
</script>

<style scoped>
  .btn {
    margin-bottom: 20px;
  }
</style>