package boutique.service;

import java.util.List;
import org.springframework.stereotype.Service;

import boutique.entity.Produit;
import boutique.repository.ProduitRepository;

@Service
public class ProduitService {

    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> getAll() {
        return repository.findAll();
    }
}