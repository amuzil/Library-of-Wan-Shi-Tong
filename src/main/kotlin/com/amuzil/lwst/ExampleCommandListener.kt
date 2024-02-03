package com.amuzil.lwst

import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.utils.FileUpload
import java.nio.file.StandardOpenOption
import java.time.Instant

class ExampleCommandListener : ListenerAdapter() {
	private val messages = arrayOf("Pong!", "Echo!")

	override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
		if (event.name == "ping") {
			event.deferReply().queue()

			val includeResponseTime = event.getOption("response-time")?.asBoolean ?: false
			val attachment = event.getOption("attachment")?.asAttachment
			val message = event.getOption("message")?.asString ?: "Pong!"

			event.hook.sendMessage(message).apply {
				setEphemeral(true)


				if (attachment != null) {
					attachment.proxy.downloadToPath().thenAccept {
						addFiles(FileUpload.fromData(it, StandardOpenOption.READ, StandardOpenOption.DELETE_ON_CLOSE))
					}.get()
				}
			}.queue {
				if (includeResponseTime) {
					val responseTime = it.timeCreated.toInstant().toEpochMilli() - event.timeCreated.toInstant().toEpochMilli()

					it.editMessage("$message Response time: $responseTime ms").queue()
				}
			}
		}
	}

	override fun onCommandAutoCompleteInteraction(event: CommandAutoCompleteInteractionEvent) {
		if (event.name == "ping" && event.focusedOption.name == "message") {
			event.replyChoiceStrings(messages.filter {
				it.startsWith(event.focusedOption.value)
			}).queue()
		}
	}
}