package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.article.Article;
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
        // Продукт 1: Ноутбук
        UUID laptopId = UUID.randomUUID();
        products.put(laptopId, new Product(laptopId, "Ноутбук") {
            @Override
            public double getPrice() {
                return 89999.99;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        });

        // Продукт 2: Йогурт
        UUID yogurtId = UUID.randomUUID();
        products.put(yogurtId, new Product(yogurtId, "Йогурт") {
            @Override
            public double getPrice() {
                return 89.50;
            }

            @Override
            public boolean isSpecial() {
                return true;
            }
        });

        // Продукт 3: Книга
        UUID bookId = UUID.randomUUID();
        products.put(bookId, new Product(bookId, "Книга 'Java для начинающих'") {
            @Override
            public double getPrice() {
                return 1200.00;
            }

            @Override
            public boolean isSpecial() {
                return false;
            }
        });

        // Статья
        UUID articleId = UUID.randomUUID();
        articles.put(articleId, new Article(articleId, "Новости технологий", "ИИ научился писать код..."));
    }
}