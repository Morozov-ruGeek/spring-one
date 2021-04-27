package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAllProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/products/finder")
    public String showProductFinder(){
        return "find_product_form";
    }

    @PostMapping("/products/finder")
    public String showProductInfo(@RequestParam Long id, Model model) {
        Optional<Product> product = productService.findOneByIdFroData(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }

    @GetMapping("/products/create")
    public String showCreator() {
        return "create_product_form";
    }

    @PostMapping("/products/create")
    public String createNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/products/score/increment/{id}")
    public String incrementScoreById(@PathVariable Long id){
        productService.changeScoreById(id, 1);
        return "redirect:/";
    }

    @GetMapping("/products/decrement/{id}")
    public String decrementScoreById(@PathVariable Long id){
        productService.changeScoreById(id, -1);
        return "redirect:/";
    }
}
