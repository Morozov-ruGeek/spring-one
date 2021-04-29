package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/find")
    public String showProductFinder(){
        return "find_product_form";
    }

    @PostMapping("/products/find")
    public String showProduct(@RequestParam Long id, Model model) {
        productService.findOneById(id).ifPresent(p -> model.addAttribute("product", p));
        return "product_info";
    }

    /*
     После проверки ДЗ добавить пагинацию
     */
    @GetMapping("/")
    public String showAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @PostMapping("/products/price-between")
    public String filterProductsByPrice(@RequestParam(name = "minprice", required = false) Integer minPrice,
                                        @RequestParam(name = "maxprice", required = false) Integer maxPrice,
                                        Model model) {
        List<Product> products = productService.findProductsByPrice(minPrice, maxPrice);
        if (products.size() > 0) {
            model.addAttribute("products", products);
        }
        return "index";
    }

    @PostMapping("/products/title-like")
    public String filterProductsByPrice(@RequestParam(name = "title", required = false) String title, Model model) {
        List<Product> products = productService.findAllByTitle(title);
        if (products.size() > 0) {
            model.addAttribute("products", products);
        }
        return "index";
    }

    @PostMapping("/products/filter")
    public String filterProductsByFilter(@RequestParam(name = "minprice", required = false) Integer minPrice,
                                         @RequestParam(name = "maxprice", required = false) Integer maxPrice,
                                         @RequestParam(name = "title", required = false) String title,
                                         Model model) {
        List<Product> products = productService.findProductsByFilter(minPrice, maxPrice, title);
        if (products.size() > 0) {
            model.addAttribute("products", products);
        }
        return "index";
    }

    @GetMapping("/products/add")
    public String showAddProduct(Model model) {
        model.addAttribute("message", "");
        model.addAttribute("title", "");
        model.addAttribute("price", "0");
        return "create_product_form";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String title, @RequestParam int price, @RequestParam Long category_id) {
        productService.saveWithCategory(title, price, category_id);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

}
