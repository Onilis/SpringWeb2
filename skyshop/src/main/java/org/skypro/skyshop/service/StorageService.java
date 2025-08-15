package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        initTestData();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> all = new ArrayList<>();
        all.addAll(products.values());
        all.addAll(articles.values());
        return all;
    }

    private void initTestData() {
        // ======== Продукты (анонимные классы) ========
        Product phone = new Product(UUID.randomUUID(), "Телефон") {
            @Override
            public boolean isSpecial() {
                return false; // обычный товар
            }

            @Override
            public double getPrice() {
                return 15000; // цена в руб.
            }
        };

        Product laptop = new Product(UUID.randomUUID(), "Ноутбук") {
            @Override
            public boolean isSpecial() {
                return true; // допустим, специальное предложение
            }

            @Override
            public double getPrice() {
                return 65000;
            }
        };

        Product yogurt = new Product(UUID.randomUUID(), "Йогурт") {
            @Override
            public boolean isSpecial() {
                return false;
            }

            @Override
            public double getPrice() {
                return 80;
            }
        };

        // ======== Статьи ========
        Article article1 = new Article(UUID.randomUUID(), "Гаджеты 2025", "electronics");
        Article article2 = new Article(UUID.randomUUID(), "Питание и здоровье", "food");

        // ======== Добавляем в коллекции ========
        products.put(phone.getId(), phone);
        products.put(laptop.getId(), laptop);
        products.put(yogurt.getId(), yogurt);

        articles.put(article1.getId(), article1);
        articles.put(article2.getId(), article2);
    }
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }


}
