plugins {
    kotlin("jvm") version "2.0.0-RC2"
    id ("java-library")
    id("maven-publish")
}

group = "io.vladyslavv_ua"
version = "0.1-SNAPSHOT"

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
            "Implementation-Version" to project.version))
    }
}
//publishing {
//    publications {
//        create<MavenPublication>("gpr") {
//            run {
//                groupId = "io.vladyslavv_ua"
//                artifactId = getArtificatId()
//                version = getVersionName()
//                artifact("$buildDir/outputs/aar/${getArtificatId()}-release.aar")
//            }
//        }
//    }
//}

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