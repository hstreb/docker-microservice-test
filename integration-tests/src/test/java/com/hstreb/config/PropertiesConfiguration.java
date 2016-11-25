package com.hstreb.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;

public class PropertiesConfiguration {
    static {
        System.setProperty("archaius.configurationSource.defaultFileName", "configuration-local.properties");
    }

    public PropertiesConfiguration() {
        ConfigurationManager.getDeploymentContext().setDeploymentEnvironment(getEnvironmentVariable());
        try {
            ConfigurationManager.loadCascadedPropertiesFromResources("configuration");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEnvironmentVariable() {
        if (System.getenv("MY_ENVIRONMENT") != null)
            return System.getenv("MY_ENVIRONMENT");
        return "local";
    }

    public String getString(String value) {
        return this.getString(value, "NOT FOUND");
    }

    public String getString(String value, String defaultValue) {
        return DynamicPropertyFactory.getInstance().getStringProperty(value, defaultValue).getValue();
    }
}

