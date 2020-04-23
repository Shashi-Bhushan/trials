plugins {
  java
  kotlin("jvm") version "1.3.61"
}

group = "in.shabhushan"
version = "0.0.1-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  testCompile("junit", "junit", "4.12")

  // Use the Kotlin test library.
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  // Use the Kotlin JUnit integration.
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
  implementation(kotlin("reflect"))
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_12
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}
