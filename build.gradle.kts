plugins {
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("kapt") version "1.9.22"
}

kotlin {
    jvmToolchain(17) // Ustaw na 17
}

// Dodaj konfigurację dla Java Toolchain
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Ustaw na 17
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Spring Boot
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.boot:spring-boot-starter-actuator")

    // Kotlin
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
    api("org.jetbrains.kotlin:kotlin-reflect:1.9.22")

    // Baza danych
    api("org.postgresql:postgresql:42.7.2")
    api("org.flywaydb:flyway-core:9.22.3")

    // MapStruct
    api("org.mapstruct:mapstruct:1.6.0.Beta2")
    kapt("org.mapstruct:mapstruct-processor:1.6.0.Beta2")

    // Testy
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.9.22")
    testImplementation("org.springframework.security:spring-security-test")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.22")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-resource-server")
    implementation("org.springframework.security:spring-security-oauth2-jose")
}

kapt {
    javacOptions {
        option("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
        option("--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED")
        option("--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED")
        option("--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED")
        option("--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17" // Ustaw na 17
        freeCompilerArgs = listOf(
            "-Xjvm-default=all",
            "-Xadd-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED"
        )
    }
}
// Reszta konfiguracji pozostaje bez zmian