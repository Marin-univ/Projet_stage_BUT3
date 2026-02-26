package boutique.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boutique.entity.Produit;
import boutique.service.ProduitService;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produit> getProduits() {
        return service.getAll();
    }
}