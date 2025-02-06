plugins {
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.9.20" // Zaktualizowana wersja Kotlina
    kotlin("plugin.spring") version "1.9.20" // Zaktualizowana wersja Kotlina
    kotlin("kapt") version "1.9.20"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}
kapt {
    javacOptions {
        option("-J--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED", "")
    }
}

dependencies {
    api(libs.org.springframework.boot.spring.boot.starter.data.jpa)
    api(libs.org.springframework.boot.spring.boot.starter.web)
    api(libs.org.springframework.boot.spring.boot.starter.validation)
    api(libs.com.fasterxml.jackson.module.jackson.module.kotlin)
    api(libs.org.jetbrains.kotlin.kotlin.reflect)
    api(libs.org.jetbrains.kotlin.kotlin.stdlib)
//    api(libs.org.jetbrains.kotlin.kotlin.maven.allopen)
//    api(libs.org.jetbrains.kotlin.kotlin.maven.noarg)
    api(libs.org.postgresql.postgresql)
    api("org.flywaydb:flyway-core:9.16.0")
    api("org.mapstruct:mapstruct:1.5.5.Final")
    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
    testImplementation(libs.org.jetbrains.kotlin.kotlin.test.junit5)
    compileOnly("org.mapstruct:mapstruct-processor:1.5.5.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
}




group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "portfolio-service"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.register<JavaExec>("run") {
    mainClass.set("com.example.PortfolioServiceApplication")
    classpath = sourceSets.main.get().runtimeClasspath
}

kotlin {
    jvmToolchain(17) // Ustawienie targetu JVM na 17
}