<template>
  <v-card class="product-card" max-width="520">
    <v-card-title class="text-h5 font-weight-bold">
      {{ data.nom }}
    </v-card-title>

    <v-divider></v-divider>

    <v-card-text class="text-body-1">
      <div class="mb-3">
        {{ data.description }}
      </div>

      <v-chip class="mr-2" color="primary" variant="tonal"size="small">
        {{ data.type }}
      </v-chip>

      <v-chip color="green" variant="tonal" size="small">
        {{ data.prix }} €
      </v-chip>

      <p class="right">x {{ data.quantite }}</p>
    </v-card-text>

    <v-divider></v-divider>

    <v-card-actions>
        <v-btn color="primary" 
        >modifier</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup>
defineProps({
  id: Number,
  data: Object
})
</script>

<style scoped>
.product-card {
  border-radius: 8px;
}

.right {
  text-align: right;
}
</style>