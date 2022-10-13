<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Categories</h3>
        <router-link :to="{name: 'AddCategory'}">
         <button class="btn">Add Category</button>
        </router-link>
      </div>
    </div>
    <div class="row">
      <div v-for="category of categories" :key="category.id" class="col-xl-4 col-md-6 col-12 d-flex pt-3">
        <CategoryBox :category="category" />
      </div>
    </div>
  </div>
</template>

<script>

import CategoryBox from "@/components/Category/CategoryBox";
export default {
  name: "ViewCategory",
  props: ["categories"],
  components: { CategoryBox },
  data() {
    return {
      baseURL:"http://localhost:8080/api/v1",
    };
  },
  methods: {
  },
  mounted() {

  },
};
</script>

<style scoped></style>