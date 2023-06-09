package com.nd705.suppointspb.controllers;

import com.nd705.suppointspb.dto.ProductDTO;
import com.nd705.suppointspb.service.ProductService;
import com.nd705.suppointspb.service.SessionObjectHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
private final SessionObjectHolder sessionObjectHolder;
    public ProductController(ProductService productService, SessionObjectHolder sessionObjectHolder) {
        this.productService = productService;
        this.sessionObjectHolder = sessionObjectHolder;
    }

    ;

    @GetMapping
    public String list(Model model){
    sessionObjectHolder.addClick();
    List<ProductDTO> list = productService.getAll();
    model.addAttribute("products",list);
    return"products";
    }
@GetMapping("/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        sessionObjectHolder.addClick();
        if (principal == null) {
            return "redirect:/products";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products";
}

}
