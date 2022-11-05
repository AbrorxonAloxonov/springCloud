package uz.najot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najot.entity.CategoryEntity;
import uz.najot.model.CategoryModel;
import uz.najot.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public List<CategoryEntity> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.saveCategory(categoryEntity);
    }
}
