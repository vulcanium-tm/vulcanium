plugins {
    kotlin("jvm") version "1.6.10"
    java
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    mavenCentral()
}

group = "org.vulcanium"
version = "1.0-SNAPSHOT"
description = "Vulcanium"

dependencies {
    implementation("com.google.guava:guava:32.1.2-jre")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.googlecode.json-simple:json-simple:1.1")
    implementation("org.avaje:ebean:2.7.3")
    implementation("org.joml:joml:1.10.5")
    implementation("org.yaml:snakeyaml:2.2")
    implementation("org.yaml:snakeyaml:1.9")
    implementation("commons-lang:commons-lang:2.3")
    implementation(enforcedPlatform("com.intellectualsites.bom:bom-newest:1.40"))
    compileOnly("org.apache.maven:maven-resolver-provider:3.9.6")
    compileOnly("org.apache.maven.resolver:maven-resolver-connector-basic:1.9.18")
    compileOnly("org.apache.maven.resolver:maven-resolver-transport-http:1.9.18")
    compileOnly("org.jetbrains:annotations-java5:24.0.1")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    testImplementation("junit:junit:4.11")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-core:5.5.0")
    testImplementation("org.ow2.asm:asm-tree:9.5")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
