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
  <div>
    <h1>TEST</h1>
    <ProductCard
      v-for="product in products"
      :key="product.id"
      :nom="product.nom"
      :prix="product.prix"
      :description="product.description"
      :categorie="product.categorie"
    />
  </div>
</template>