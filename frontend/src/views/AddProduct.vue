<script setup>
import { reactive } from "vue"
import { useVuelidate } from "@vuelidate/core"
import { required, numeric } from "@vuelidate/validators"
import { createProduct } from "@/services/productService"

const items = ["Type A", "Type B", "Type C"]

const initialState = {
  nom: "",
  description: "",
  prix: null,
  type: null,
  quantite: null,
}

const state = reactive({ ...initialState })

const rules = {
  nom: { required },
  description: { required },
  prix: { required, numeric },
  type: { required },
  quantite: { required, numeric },
}

const v$ = useVuelidate(rules, state)

async function submit() {
  const isValid = await v$.value.$validate()
  if (!isValid) return

  await createProduct(state)
  alert("Produit ajouté avec succès")
}
</script>

<template>
  <v-container class="d-flex justify-center mt-10">
    <v-card class="product-card pa-4" min-width="800">

      <v-card-title class="text-h5 font-weight-bold mb-4">
        Ajouter un produit
      </v-card-title>

      <form @submit.prevent="submit">

        <v-text-field
          v-model="state.nom" label="Nom" class="mb-4"
          :error-messages="v$.nom.$errors.map(e => e.$message)"
          required
        />

        <v-text-field
          v-model="state.description" label="Description" class="mb-4"
          :error-messages="v$.description.$errors.map(e => e.$message)"
          required
        />

        <v-text-field
          v-model.number="state.prix"
          label="Prix" type="number" class="mb-4"
          :error-messages="v$.prix.$errors.map(e => e.$message)"
          required
        />

        <v-select
          v-model="state.type"
          :items="items" label="Type" class="mb-4"
          :error-messages="v$.type.$errors.map(e => e.$message)"
          required
        />

        <v-text-field
          v-model.number="state.quantite"
          label="Quantité" type="number" class="mb-6"
          :error-messages="v$.quantite.$errors.map(e => e.$message)"
          required
        />

        <div class="d-flex justify-center">
          <v-btn color="green" type="submit" min-width="50%">
            Ajouter
          </v-btn>
        </div>
      </form>
    </v-card>
  </v-container>
</template>

<style scoped>
.product-card {
  border-radius: 8px;
}
</style>