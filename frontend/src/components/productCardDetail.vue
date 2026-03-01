<script setup>
const props = defineProps({
  id: Number,
  data: Object
})

import { ref } from "vue";
import { updateProduct, deleteProduct } from "@/services/productService";

const items = ["Type A", "Type B", "Type C"];
const isEditing = ref(false);
const dataModif = ref({});

function startEdit() {
  Object.assign(dataModif.value, props.data);
  isEditing.value = true;
}

function cancelEdit() {
  isEditing.value = false;
}

function save() {
  updateProduct(props.id, dataModif.value).then(() => {
    Object.assign(props.data, dataModif.value);
    isEditing.value = false;
  });
}

function deleteP() {
  confirm("Êtes-vous sûr de vouloir supprimer ce produit ?") &&
  deleteProduct(props.id).then(() => {
    alert("Produit supprimé avec succès");
    window.location.href = `/`;
  });
}

</script>

<template>
  <v-card class="product-card" max-width="520">
    <v-card-title>{{ data.nom }}</v-card-title>
    <v-divider></v-divider>

    <v-card-text class="text-body-1" v-if="!isEditing">
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

    <v-card-text class="text-body-1" v-else>
      <v-text-field
      v-model="dataModif.nom"
      label="Nom"
      ></v-text-field>

      <v-text-field
      v-model="dataModif.description"
      label="Description"
      ></v-text-field>

      <v-text-field
      v-model="dataModif.prix"
      label="Prix"
      ></v-text-field>

      <v-select
      v-model="dataModif.type"
      :items="items"
      label="Type"
      ></v-select>

      <v-text-field
      v-model="dataModif.quantite"
      label="Quantité"
      ></v-text-field>

    </v-card-text>

    <v-divider></v-divider>

    <v-card-actions>
        <div v-if="!isEditing">
          <v-btn color="primary" @click="startEdit">
            Modifier
          </v-btn>
          <v-btn color="red" @click="deleteP">
            Supprimer
          </v-btn>
        </div>

        <div v-else>
            <v-btn color="red" @click="cancelEdit">
                Annuler
            </v-btn>

            <v-btn color="green" @click="save">
                Sauvegarder
            </v-btn>
        </div>
    </v-card-actions>
  </v-card>
  <v-btn color="secondary" @click="$router.go(-1)" class="mt-4">
    Retour
  </v-btn>
</template>



<style scoped>
.product-card {
  border-radius: 8px;
}

.right {
  text-align: right;
}

</style>