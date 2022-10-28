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
			// Calculate response time
			val responseTime = Instant.now().plusMillis(500).toEpochMilli() - event.message.timeCreated.toInstant().toEpochMilli()

			// Send response
			event.channel.sendMessage("Pong! Response time: $responseTime ms").queue()
		}
	}
}