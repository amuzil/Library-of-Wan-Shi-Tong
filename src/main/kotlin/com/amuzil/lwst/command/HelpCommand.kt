package com.amuzil.lwst.command

import dev.minn.jda.ktx.events.listener
import dev.minn.jda.ktx.events.onButton
import dev.minn.jda.ktx.events.onCommand
import dev.minn.jda.ktx.events.onCommandAutocomplete
import dev.minn.jda.ktx.interactions.commands.upsertCommand
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.emoji.Emoji
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent
import net.dv8tion.jda.api.interactions.components.buttons.Button
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu
import net.dv8tion.jda.api.interactions.components.text.TextInput
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle
import net.dv8tion.jda.api.interactions.modals.Modal

class HelpCommand {
	companion object {
		const val COMMAND_NAME = "help"

		fun setup(jda: JDA) {
			jda.upsertCommand(COMMAND_NAME, "Starts a new help session.") {

			}.queue()

			jda.onCommandAutocomplete(COMMAND_NAME) { _ ->
				// We don't have any autocomplete options for this command
			}

			jda.onCommand(COMMAND_NAME) { event ->
//				event.deferReply().queue()

				event.reply("Hi, what can I help you with?").apply {
					addActionRow(
						Button.primary(
							"help:installation",
							"I have trouble installing the mod"
						),
						Button.primary(
							"help:crash",
							"The mod is crashing"
						),
						Button.secondary(
							"help:other",
							"Other…"
						)
					).queue()
				}.queue()
			}

			jda.onButton("help:installation") { event ->
				event.reply("What part of the installation are you struggling with?")
					.apply {
						addActionRow(
							StringSelectMenu.create("help:installation:part")
								.apply {
									addOption(
										"Downloading the mod",
										"download",
										"If you don't know where to download the mod, or what version to download",
										Emoji.fromUnicode("📥")
									)
									addOption(
										"Installing MinecraftForge",
										"install-forge",
										"If you don't what version of MinecraftForge you need, or how to install it",
										Emoji.fromUnicode("⚙")
									)
									addOption(
										"Installing the mod",
										"install-mod",
										"If you don't know what to do with the downloaded JAR",
										Emoji.fromUnicode("📦")
									)
									addOption(
										"Launching the game",
										"launch",
										"If you don't know how to launch Minecraft with Forge & the mod",
										Emoji.fromUnicode("🚀")
									)
									setDefaultValues("download")
								}.build()
						).queue()
					}.queue()
			}

			jda.listener<StringSelectInteractionEvent> { event ->
				if (event.componentId == "help:installation:part") {
					var part = event.selectedOptions.first().label
					part = part.substring(0, 1).lowercase() + part.substring(1)
					event.reply("I'll see what I know about $part").queue()
				}
			}

			val crashReportModal = Modal.create(
				"help:crash:report", "Crash Report submission"
			).apply {
				addActionRow(TextInput.create(
					"preconditions",
					"What mods (including versions) are installed?",
					TextInputStyle.SHORT
				).apply {
					setPlaceholder("Only required if you have other mods installed")
					setRequired(false)
				}.build())

				addActionRow(TextInput.create(
					"description",
					"What were you doing when the crash occurred",
					TextInputStyle.PARAGRAPH
				).apply {
					setPlaceholder("Was there anything special you were doing?")
					setMinLength(30)
					setMaxLength(1000)
					setRequired(true)
				}.build())

				addActionRow(TextInput.create(
					"crash-report",
					"Paste the crash report on https://hatebin.com",
					TextInputStyle.SHORT
				).apply {
					val tutorialURL = "https://hatebin.com/wmlklcgdfl"
					setPlaceholder(tutorialURL)
					setMinLength(tutorialURL.length)
					setMaxLength(tutorialURL.length)
					setRequired(true)
				}.build())

			}.build()

			jda.onButton("help:crash") { event ->
				event.replyModal(crashReportModal).queue()
			}

			jda.listener<ModalInteractionEvent> { event ->
				if (event.modalId == "help:crash:report") {
					event.reply("Thank you for your report!").queue()

					event.message?.channel?.sendMessage(
						"**${event.user.name}#${event.user.discriminator}** reported a crash:\n" +
								"*Preconditions:* ${event.getValue("preconditions")?.asString}\n" +
								"*Description:* ${event.getValue("description")?.asString}\n" +
								"*Crash report:* ${event.getValue("crash-report")?.asString}"
					)?.queue()
				}
			}

			jda.onButton("help:other") { event ->
				event.reply(
					"I'll create a support thread for you, please wait…"
				).queue()

				event.message.createThreadChannel(
					"Support for ${event.user.name}"
				).queue {
					it.sendMessage(
						"Hello ${event.user.asMention}, please describe your problem here."
					).queue()
				}
			}
		}
	}
}