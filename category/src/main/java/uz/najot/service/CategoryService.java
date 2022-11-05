package uz.najot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najot.entity.CategoryEntity;
import uz.najot.model.CategoryModel;
import uz.najot.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<CategoryEntity> getAll(){
        return categoryRepository.findAll();
    }
    public ResponseEntity saveCategory(CategoryEntity categoryEntity){
        return ResponseEntity.ok(categoryRepository.save(categoryEntity));
    }
}
