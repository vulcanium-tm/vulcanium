package org.vulcanium.configuration;

public class MemoryConfigurationTest extends ConfigurationTest {
    @Override
    public Configuration getConfig() {
        return new MemoryConfiguration();
    }
}
