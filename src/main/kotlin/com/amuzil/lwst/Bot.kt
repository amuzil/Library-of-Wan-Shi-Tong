package com.amuzil.lwst

import com.amuzil.lwst.command.HelpCommand
import dev.minn.jda.ktx.jdabuilder.default
import dev.minn.jda.ktx.jdabuilder.intents
import dev.minn.jda.ktx.messages.Embed
import dev.minn.jda.ktx.messages.MessageCreate
import net.dv8tion.jda.api.exceptions.InvalidTokenException
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.requests.GatewayIntent
import java.time.Instant
import java.util.*

fun main() {
	val configuration = Configuration.parse()

	val jda = try {
		default(configuration.jda.token, enableCoroutines = true) {
			intents += EnumSet.allOf(GatewayIntent::class.java)
		}
	} catch (exception: InvalidTokenException) {
		error("Invalid token! Please check your configuration.")
	}

	jda.addEventListener(ExampleListener())
	jda.addEventListener(ExampleCommandListener())

	jda.updateCommands().addCommands(
		Commands.slash("ping", "Pong!").apply {
			addOption(
				OptionType.BOOLEAN,
				"response-time",
				"Whether to include the response time in the response.",
				false
			)

			addOption(
				OptionType.ATTACHMENT,
				"attachment",
				"An attachment to send with the response.",
				false
			)

			addOptions(OptionData(
				OptionType.STRING,
				"message",
				"A message to send with the response.",
				false
			).apply {
				addChoice("Pong!", "Pong!")
				addChoice("Echo!", "Echo!")
			})
		}
	).queue()

	HelpCommand.setup(jda)

	jda.awaitReady()

	println("Successfully connected the ${jda.selfUser.name} to Discord!")

	val embed = Embed {
		title = "Hello friends!"
		description = "I have returned from the sands"
		url = "https://github.com/amuzil/lwst"
		color = 0xFF0000
		footer {
			name = "This is a footer"
			iconUrl = "https://raw.githubusercontent.com/amuzil/lwst/main/src/main/resources/logo.png"
		}
		author {
			name = "This person"
			iconUrl = "https://avatars.githubusercontent.com/u/22727323?v=4"
			url = "https://mahtaran.amuzil.com"
		}
		timestamp = Instant.now().minusSeconds(10)
		image = "https://raw.githubusercontent.com/amuzil/lwst/main/src/main/resources/logo.png"
		thumbnail = "https://raw.githubusercontent.com/amuzil/lwst/main/src/main/resources/banner.png"
		field {
			name = "Rate your experience"
			value = "5 :star:"
			inline = false
		}
		field {
			name = "Want to try it out?"
			value = "Use </help:1035677432579096686> to get started!"
		}
	}

	val message = MessageCreate {
		embeds += embed
	}

	jda.getTextChannelById(1035343392256823328)
		?.sendMessage(message)
		?.queue()
}