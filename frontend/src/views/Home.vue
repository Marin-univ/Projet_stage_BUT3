<script setup>
import { ref, onMounted } from "vue";
import { getProducts } from "@/services/productService";
import ProductCard from "@/components/productCard.vue"

const products = ref([]);

onMounted(async () => {
  try {
    products.value = await getProducts();
  } catch (error) {
    console.error("Erreur API :", error);
  }
});
</script>

<template>
  <h1>Liste des articles disponibles :</h1>
  <div class="grid">
    <ProductCard
      v-for="product in products"
      :key="product.id"
      :id="product.id"
      :nom="product.nom"
      :prix="product.prix"
      :description="product.description"
    />
  </div>
</template>

<style>
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
  padding: 20px;
}
</style>