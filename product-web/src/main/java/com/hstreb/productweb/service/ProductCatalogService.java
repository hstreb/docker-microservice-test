package com.hstreb.productweb.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "product-catalog")
public interface ProductCatalogService {
    @RequestMapping(value = "/product")
    String list();
}
