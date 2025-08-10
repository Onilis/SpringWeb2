package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.service.BasketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final BasketService basketService;

    // Внедрение BasketService через конструктор
    public ShopController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        basketService.addProduct(id);
        return "Продукт успешно добавлен";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }
}
