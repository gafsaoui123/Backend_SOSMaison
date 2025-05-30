package com.app.app.service;


import com.app.app.dao.ProductDao;
import com.app.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product) {
        return productDao.save(product);

    }

    public List<Product> getAllProducts() {

        return (List<Product>) productDao.findAll();
    }

    public void deleteProductDetails(Integer productId) {
        productDao.deleteById(productId);
    }

    public Product getProductDetailsById(Integer productId) {
        return productDao.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId ){
        if (isSingleProductCheckout) {
            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).orElse(null);
            if (product != null) {
                list.add(product);
            }
            return list;
        } else {
            return new ArrayList<>();
        }
    }

}
