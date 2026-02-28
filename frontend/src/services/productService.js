export async function getProducts() {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/produits`);

    if (!response.ok) {
        throw new Error("Erreur lors de la récupération des produits");
    }

    return await response.json();
}

export async function getById(id) {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/produits/${id}`);

    if (!response.ok) {
        throw new Error("Erreur lors de la récupération des produits");
    }

    return await response.json();
}

export async function updateProduct(id, data) {
    return fetch(`${import.meta.env.VITE_API_URL}/produits/${id}`, {
        method: "PUT",
        headers: {
        "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });
}