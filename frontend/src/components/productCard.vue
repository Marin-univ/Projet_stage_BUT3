<template>
    <v-card class="pa-6" max-width="520">
        <v-card-title>{{nom}}</v-card-title>
        <v-card-text>
        {{description}} {{prix}}€
        </v-card-text>
        <v-card-actions>
            <v-btn color="primary" :to="`/product/${id}`"
            >Details</v-btn>
        </v-card-actions>
    </v-card>
</template>

<script setup>
defineProps({
  id: Number,
  nom: String,
  prix: Number,
  description: String
})
</script>