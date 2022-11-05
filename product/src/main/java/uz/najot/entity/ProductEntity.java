package uz.najot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer categoryId;
    public Double count;
    public Double price;
    public String firma;

    public ProductEntity(String name, Integer categoryId, Double count, Double price, String firma) {
        this.name = name;
        this.categoryId = categoryId;
        this.count = count;
        this.price = price;
        this.firma = firma;
    }
}

