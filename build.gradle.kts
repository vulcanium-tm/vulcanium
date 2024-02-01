plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("jvm") version "1.5.31"
    java
}

repositories {
    mavenCentral()
}

group = "org.vulcanium"
version = "1.0-SNAPSHOT"
description = "Vulcanium"

dependencies {
    implementation("org.yaml:snakeyaml:1.9")
    implementation("com.googlecode.json-simple:json-simple:1.1")
    implementation("org.avaje:ebean:2.7.3")
    implementation("com.google.guava:guava:10.0.1")
    implementation("commons-lang:commons-lang:2.3")
    implementation(platform("com.intellectualsites.bom:bom-newest:1.40"))
    testImplementation("junit:junit:4.11")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    compileOnly 'org.projectlombok:lombok:1.18.26'
    annotationProcessor 'org.projectlombok:lombok:1.18.26'
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.6"
}
