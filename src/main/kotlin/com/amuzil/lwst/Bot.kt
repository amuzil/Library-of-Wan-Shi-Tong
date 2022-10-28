package com.amuzil.lwst

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.exceptions.InvalidTokenException
import net.dv8tion.jda.api.requests.GatewayIntent

class Bot {
}

fun main() {
	val configuration = Configuration.parse()

	val api: JDA = try {
		JDABuilder.createDefault(configuration.jda.token)
			.enableIntents(GatewayIntent.MESSAGE_CONTENT)
			.addEventListeners(ExampleListener())
			.build()
	} catch (exception: InvalidTokenException) {
		println("Invalid token! Please check your configuration.")
		return
	}

	api.awaitReady()

	println("Successfully connected the ${api.selfUser.name} to Discord!")
}