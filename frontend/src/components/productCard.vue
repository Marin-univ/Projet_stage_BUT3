<template>
    <v-card class="pa-6" max-width="520">
        <v-card-title>{{nom}}</v-card-title>
        <v-card-text>
        {{description}} {{prix}}€ - {{categorie}}
        </v-card-text>
    </v-card>
</template>

<script setup>
defineProps({
  nom: String,
  prix: Number,
  description: String,
  categorie: String
})
</script>