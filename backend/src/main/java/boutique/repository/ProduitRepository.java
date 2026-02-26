package boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import boutique.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}