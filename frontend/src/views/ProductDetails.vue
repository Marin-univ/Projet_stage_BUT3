<script setup>
import ProductCardDetail from "@/components/productCardDetail.vue"
import { ref, onMounted } from "vue";
import { getById } from "@/services/productService";
import { useRoute } from "vue-router";

const route = useRoute();
const routeId = Number(route.params.id);

const dataProduit = ref();
onMounted(async () => {
  try {
    dataProduit.value = await getById(routeId);
  } catch (error) {
    console.error("Erreur API :", error);
  }
});
</script>

<template>
  <div v-if="dataProduit">
    <ProductCardDetail :id="routeId" :data="dataProduit"/>
  </div>
</template>