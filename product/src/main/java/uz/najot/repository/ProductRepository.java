package uz.najot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najot.entity.ProductEntity;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    Optional<ProductEntity> findByNameAndPrice(String name,Double price);
}
