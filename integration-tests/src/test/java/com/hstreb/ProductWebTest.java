package com.hstreb;

import static org.junit.Assert.assertTrue;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProductWebTest {

    private String productService;
    private final PropertiesConfiguration properties = new PropertiesConfiguration();
    private WebDriver driver;

    @Before
    public void setup() {
        String url = properties.getString("product.service.url", "localhost");
        String port = properties.getString("product.service.port", "8383");
        productService = "http://" + url + ":" + port + "/product";
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        String phantomjs = getClass().getClassLoader().getResource("phantomjs").getPath();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs);
        driver = new PhantomJSDriver(capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGetProduct() {
        driver.navigate().to(productService);
        String body = driver.getPageSource();
        assertTrue(body.contains("Memory DDR3 8Gb"));
    }
}
