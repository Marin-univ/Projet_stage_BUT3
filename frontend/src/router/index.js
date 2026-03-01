import { createRouter, createWebHistory } from "vue-router";
import Home from "@/views/Home.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/product/:id",
    name: "ProductDetails",
    component: () => import("@/views/ProductDetails.vue")
  },
  {
    path: "/add",
    name: "AddProduct",
    component: () => import("@/views/AddProduct.vue")
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;