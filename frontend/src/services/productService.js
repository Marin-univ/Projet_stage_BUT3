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

export async function createProduct(data) {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/produits`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

    if (!response.ok) {
        throw new Error("Erreur lors de l'ajout du produit");
    }

    return await response.json();
}

export async function updateProduct(id, data) {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/produits/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });

    if (!response.ok) {
        throw new Error("Erreur lors de la mise à jour");
    }

    return await response.json();
}

export async function deleteProduct(id) {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/produits/${id}`, {
        method: "DELETE"
    });

    if (!response.ok) {
        throw new Error("Erreur lors de la suppression du produit");
    }
}