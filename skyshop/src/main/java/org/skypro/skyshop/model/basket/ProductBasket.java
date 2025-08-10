package org.skypro.skyshop.model.basket;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.*;

@Component
@SessionScope
public class ProductBasket {

    private final Map<UUID, Integer> products = new HashMap<>();
    public void addProduct(UUID id) {
        products.merge(id, 1, Integer::sum); // если уже есть, увеличиваем count
    }
    public Map<UUID, Integer> getAllProducts() {
        return Collections.unmodifiableMap(products);
    }
}
