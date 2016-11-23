package com.hstreb.productweb.rest;

import com.hstreb.productweb.service.ProductCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductCatalogService productCatalogService;

    @RequestMapping(value = "/product")
    public String list() {
        String list = productCatalogService.list();
        logger.info("call product {}", list);
        return list;
    }

}
