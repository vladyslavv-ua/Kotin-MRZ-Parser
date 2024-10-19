import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("jvm")
}

group = "io.vladyslavv_ua"
version = "0.1-SNAPSHOT"

val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/vladyslavv-ua/*")

    }
}

dependencies {
    implementation("io.vladyslavv_ua:mrz_parser:0.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}