plugins {
  java
  kotlin("jvm") version "1.3.61"
  id("me.champeau.gradle.jmh") version "0.5.0"
}

group = "in.shabhushan"
version = "0.0.1-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://dl.bintray.com/algs4/maven/")
  maven("https://plugins.gradle.org/m2/")
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  testCompile("junit", "junit", "4.12")
  implementation("edu.princeton.cs", "algs4", "1.0.1")

  // Use the Kotlin test library.
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  // Use the Kotlin JUnit integration.
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
  implementation(kotlin("reflect"))

  // Benchmarking
  "1.22".let {
    implementation("org.openjdk.jmh", "jmh-core", it)
    //implementation("me.champeau.gradle", "jmh-gradle-plugin", "0.5.0")
  }

}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.9"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.9"
  }
}

jmh {
  //jvmArgs = ["-Djmh.separateClasspathJAR=true"]
  iterations = 10 // Number of measurement iterations to do.
  //benchmarkMode = ["thrpt"] // Benchmark mode. Available modes are: [Throughput/thrpt, AverageTime/avgt, SampleTime/sample, SingleShotTime/ss, All/all]
  batchSize = 1
  // Batch size: number of benchmark method calls per operation. (some benchmark modes can ignore this setting)
  fork = 1 // How many times to forks a single benchmark. Use 0 to disable forking altogether
  //operationsPerInvocation = 1 // Operations per invocation.
  timeOnIteration = "1s" // Time to spend at each measurement iteration.
  threads = 4 // Number of worker threads to run with.
  timeout = "10s" // Timeout for benchmark iteration.
  //timeUnit = "ns" // Output time unit. Available time units are: [m, s, ms, us, ns].
  verbosity = "NORMAL" // Verbosity mode. Available modes are: [SILENT, NORMAL, EXTRA]
  warmup = "1s" // Time to spend at each warmup iteration.
  warmupBatchSize = 1 // Warmup batch size: number of benchmark method calls per operation.
  //warmupForks = 0 // How many warmup forks to make for a single benchmark. 0 to disable warmup forks.
  warmupIterations = 10 // Number of warmup iterations to do.
  isZip64 = false // Use ZIP64 format for bigger archives
  jmhVersion = "1.22" // Specifies JMH version

  include = listOf("in.shabhushan.algo_trials.benchmark.string.StringConcat")
}
