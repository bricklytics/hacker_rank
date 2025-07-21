plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.bouncycastle:bcprov-jdk15on:1.70")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}