CREATE TABLE IF NOT EXISTS PRODUIT (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    type VARCHAR(255) NOT NULL,
    prix DECIMAL(10, 2) NOT NULL,
    quantite INT NOT NULL
);

CREATE TABLE IF NOT EXISTS CLIENT (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS PANIER (
    id SERIAL PRIMARY KEY,
    produit_id INT NOT NULL,
    client_id INT NOT NULL,
    quantite INT NOT NULL,
    FOREIGN KEY (produit_id) REFERENCES PRODUIT(id),
    FOREIGN KEY (client_id) REFERENCES CLIENT(id)
);

INSERT INTO PRODUIT (nom, description, type, prix, quantite) VALUES
('Produit 1', 'Description du produit 1', 'Type A', 19.99, 100),
('Produit 2', 'Description du produit 2', 'Type B', 29.99, 50),
('Produit 3', 'Description du produit 3', 'Type A', 9.99, 200);

INSERT INTO CLIENT (nom, email, mot_de_passe) VALUES
('Admin', 'admin@admin.com', 'admin');