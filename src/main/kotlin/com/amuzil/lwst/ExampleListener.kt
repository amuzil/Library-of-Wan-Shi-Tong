package com.amuzil.lwst

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Instant

class ExampleListener : ListenerAdapter() {
	override fun onMessageReceived(event: MessageReceivedEvent) {
		if (event.author.isBot) {
			return
		}

		if (event.message.contentRaw == "ping") {
			event.channel.sendMessage("Pong!").queue {
				val responseTime = it.timeCreated.toInstant().toEpochMilli() - event.message.timeCreated.toInstant().toEpochMilli()

				it.editMessage("Pong! Response time: $responseTime ms").queue()
			}
		}
	}
}