package com.amuzil.lwst

import dev.minn.jda.ktx.jdabuilder.default
import dev.minn.jda.ktx.jdabuilder.intents
import net.dv8tion.jda.api.exceptions.InvalidTokenException
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.requests.GatewayIntent

fun main() {
	val configuration = Configuration.parse()

	val jda = try {
		default(configuration.jda.token, enableCoroutines = true) {
			intents += GatewayIntent.GUILD_MEMBERS
		}
	} catch (exception: InvalidTokenException) {
		error("Invalid token! Please check your configuration.")
	}

	jda.addEventListener(ExampleListener())
	jda.addEventListener(ExampleCommandListener())

	jda.updateCommands().addCommands(
		Commands.slash("ping", "Pong!")
			.addOption(OptionType.BOOLEAN, "response-time", "Whether to include the response time in the response.", false)
			.addOption(OptionType.ATTACHMENT, "attachment", "An attachment to send with the response.", false)
			.addOptions(OptionData(OptionType.STRING, "message", "A message to send with the response.", false)
				.addChoice("Pong!", "Pong!")
				.addChoice("Echo!", "Echo!")
			)
	).queue()

	jda.awaitReady()

	println("Successfully connected the ${jda.selfUser.name} to Discord!")
}