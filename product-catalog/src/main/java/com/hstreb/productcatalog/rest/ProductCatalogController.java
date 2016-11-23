package com.hstreb.productcatalog.rest;

import com.hstreb.productcatalog.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductCatalogController {
    private static final Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);

    private List<Product> products = Arrays.asList(new Product("1", "Memory DDR3 8Gb"),
            new Product("2", "Keyboard"));

    @RequestMapping(value = "/product")
    public List<Product> list() {
        logger.info("call product: {}", products);
        return products;
    }
}
