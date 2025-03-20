package soniya.stockcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soniya.stockcontrol.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByDescriptionContainingIgnoreCase(String description);
}
