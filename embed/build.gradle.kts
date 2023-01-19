plugins {
  kotlin("jvm") version "1.3.72"
  application
}

application {
  mainClassName = "com.agiledeveloper.dsl.RunDSLKt"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))        
  implementation(kotlin("reflect"))
  implementation(kotlin("script-runtime"))
  implementation(kotlin("compiler-embeddable"))
  implementation(kotlin("script-util"))
  runtimeOnly(kotlin("scripting-compiler-embeddable"))
  runtimeOnly("net.java.dev.jna:jna:5.5.0")
}

val run: JavaExec by tasks
run.standardInput = System.`in`

defaultTasks("clean", "run")