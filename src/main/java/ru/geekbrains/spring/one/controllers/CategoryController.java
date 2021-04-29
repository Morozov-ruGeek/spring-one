package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/filter")
    public String filterByCategory(@RequestParam(name = "category") Long id, Model model) {
        List<Product> products = categoryService.findProductByCategory(id);
        if (products.size()>0) {
            model.addAttribute("products", products);
        }
        return "index";
    }
}
