package org.vulcanium.compatibility.bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BukkitCompatibilityLayer {

    private Properties mapping;

    public static void main(String[] args) {
        BukkitCompatibilityLayer compatibilityLayer = new BukkitCompatibilityLayer();
        compatibilityLayer.callMappedMethod("org.bukkit.ExampleClass.exampleMethod");
    }

    public BukkitCompatibilityLayer() {
        // Load the mapping from the properties file
        mapping = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("compatibility-mapping.properties")) {
            mapping.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callMappedMethod(String originalMethodName) {
        // Check if there is a mapping for the specified method
        if (mapping.containsKey(originalMethodName)) {
            String mappedMethodName = mapping.getProperty(originalMethodName);
            // Delegate the call to the mapped method in your Vulcanium class
            invokeVulcaniumMethod(mappedMethodName);
        } else {
            // Log or handle the case where there is no mapping
            System.out.println("No mapping found for " + originalMethodName);
        }
    }

    private void invokeVulcaniumMethod(String methodName) {
        System.out.println("Invoking Vulcanium method: " + methodName);
        org.vulcanium.ExampleClass.exampleMethod();
    }
}