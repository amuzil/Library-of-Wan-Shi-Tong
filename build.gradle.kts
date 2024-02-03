import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.7.20"
	application
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.amuzil"
version = "0.0.1-alpha"

repositories {
	mavenCentral()
	maven("https://m2.dv8tion,net/releases")
	maven("https://jitpack.io")
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
	implementation("net.dv8tion:JDA:5.0.0-alpha.22")
	implementation("com.github.MinnDevelopment:jda-reactor:1.5.0")
	implementation("com.github.MinnDevelopment:jda-ktx:0.9.5-alpha.19")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "18"
}

application {
	mainClass.set("com.amuzil.lwst.BotKt")
}

tasks.jar {
	archiveBaseName.set("lwst")
}

tasks.shadowJar {
	archiveBaseName.set("lwst")
	// Overwrite the default JAR
	archiveClassifier.set("")
}