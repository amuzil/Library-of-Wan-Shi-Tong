package com.amuzil.lwst

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.Path

data class JDAConfiguration(
	val token: String
)

data class Configuration(
	val jda: JDAConfiguration
) {
	companion object {
		fun parse(): Configuration {
			val path = getConfigurationPath()

			val mapper = ObjectMapper(YAMLFactory())
			mapper.registerModule(KotlinModule.Builder().build())

			if (path.toFile().length() == 0L) {
				val configuration = defaultConfiguration()
				mapper.writeValue(path.toFile(), configuration)
				return configuration
			}

			return mapper.readValue(path.toFile(), Configuration::class.java)
		}

		private fun getConfigurationPath(): Path {
			val userHome = Path.of(System.getProperty("user.home"))
			val baseDirectory = when (System.getProperty("os.name").split(" ")[0]) {
				"Linux" -> Path.of(System.getenv("XDG_CONFIG_HOME"))
				"Windows" -> Path.of(System.getenv("APPDATA"))
				"Mac" -> Path.of(System.getenv("HOME"), "Library", "Application Support")
				else -> null
			} ?: userHome.resolve(".config")
			val path = baseDirectory.resolve("LWST").resolve("configuration.yml")

			if (!path.toFile().exists()) {
				path.toFile().parentFile.mkdirs()
				path.toFile().createNewFile()
			}

			return path
		}

		private fun defaultConfiguration() = Configuration(
			jda = JDAConfiguration(
				token = "enter_your_token_here"
			)
		)
	}
}