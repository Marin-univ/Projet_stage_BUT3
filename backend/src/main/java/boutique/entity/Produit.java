package boutique.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "PRODUIT")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String type;
    private Double prix;
    private Integer quantite;
    
    public Integer getQuantite() {return quantite;}
    public void setQuantite(Integer quantite) {this.quantite = quantite;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public Double getPrix() {return prix;}
    public void setPrix(Double prix) {this.prix = prix;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}