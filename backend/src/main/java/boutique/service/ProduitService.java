package boutique.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Produit getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé"));
    }
}