plugins {
    kotlin("jvm") version "2.0.21"

}

group = "io.vladyslavv_ua"
version = "0.1-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}