import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("jvm")
    id("java-library")
    id("maven-publish")
}

group = "io.vladyslavv_ua"
version = "0.3.1"


tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}



repositories {
    mavenCentral()
}

val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))

publishing {
    repositories {
        maven {
            name = "Kotin-MRZ-Parser"
            url = uri("https://maven.pkg.github.com/vladyslavv-ua/Kotin-MRZ-Parser")
            credentials {
                username = githubProperties["gpr.usr"] as String? ?: System.getenv("GPR_USER")
                password =
                    githubProperties["gpr.key"] as String? ?: System.getenv("GPR_API_KEY")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}