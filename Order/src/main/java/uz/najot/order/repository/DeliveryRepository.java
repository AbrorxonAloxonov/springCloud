package uz.najot.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.najot.order.entity.ProductEntity;

@Repository
public interface DeliveryRepository extends JpaRepository<ProductEntity,Integer>{
}
