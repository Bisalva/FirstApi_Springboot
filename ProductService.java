package com.example.demo;

import com.example.demo.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private Map<Long, Product> products = new HashMap<>();
    private long nextId = 1;

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product getById(Long id) {
        return products.get(id);
    }

    public Product save(Product product) {
        product.setId(nextId++);
        products.put(product.getId(), product);
        return product;
    }

    public Product update(Long id, Product product) {
        product.setId(id);
        products.put(id, product);
        return product;
    }

    public Product patch(Long id, Map<String, Object> updates) {
        Product product = products.get(id);
        if (product == null) return null;

        if (updates.containsKey("name")) {
            product.setName((String) updates.get("name"));
        }
        if (updates.containsKey("price")) {
            Object priceObj = updates.get("price");
            if (priceObj instanceof Number) {
                product.setPrice(((Number) priceObj).doubleValue());
            }
        }

        return product;
    }

    public void delete(Long id) {
        products.remove(id);
    }
}
