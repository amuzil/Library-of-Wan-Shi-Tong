<a name="readme-top"></a>


<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<div align="center" style="text-align: center">
	<a href="https://github.com/amuzil/lwst">
		<img src="https://raw.githubusercontent.com/amuzil/lwst/main/src/main/resources/logo.png" alt="Logo" width="80" height="80">
	</a>
	<h3>Library of Wan Shi Tong</h3>
	<p>
        An open source Discord bot for the Avatar Minecraft mod server.
        <br />
        <a href="https://discord.gg/jPVMETb"><strong>Join us on Discord »</strong></a>
        <br />
        <br />
        <a href="https://github.com/amuzil/lwst/issues">Report Bug</a>
        ·
        <a href="https://github.com/amuzil/lwst/issues">Request Feature</a>
	</p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
	<summary>Table of Contents</summary>
	<ol>
		<li>
			<a href="#about-the-project">About The Project</a>
			<ul>
				<li><a href="#why-make-our-own-bot">Why make our own bot?</a></li>
				<li><a href="#built-with">Built with</a></li>
			</ul>
		</li>
		<li>
			<a href="#getting-started">Getting Started</a>
			<ul>
				<li><a href="#prerequisites">Prerequisites</a></li>
				<li><a href="#installation">Installation</a></li>
			</ul>
		</li>
		<li><a href="#contributing">Contributing</a></li>
		<li><a href="#license">License</a></li>
		<li><a href="#contact">Contact</a></li>
		<li><a href="#acknowledgments">Acknowledgments</a></li>
	</ol>
</details>


<!-- ABOUT THE PROJECT -->

## About The Project

[![Banner][banner]][discord-url]

[![GitHub repo file count][github-repo-file-count]][github-repo-url]
[![GitHub repo size][github-repo-size]][github-repo-url]
[![GitHub repo last commit][github-repo-last-commit]][github-repo-url]
[![GitHub repo languages][github-repo-languages]][github-repo-url]

[![GitHub open milestones][github-open-milestones]][github-open-milestones-url]
[![GitHub closed milestones][github-closed-milestones]][github-closed-milestones-url]

[![GitHub open pull requests][github-open-pull-requests]][github-open-pull-requests-url]
[![GitHub closed requests][github-closed-pull-requests]][github-closed-pull-requests-url]

[![GitHub open issues][github-open-issues]][github-open-issues-url]
[![GitHub closed issues][github-closed-issues]][github-closed-issues-url]

The Library of Wan Shi Tong is a Discord bot for the Avatar Minecraft mod server. It is a work in progress and is currently in the alpha stage of development.
The bot is written in Kotlin using the JDA library.
The purpose of the bot is to provide a variety of useful features for the server, such as an easy ticket system, and more features yet to be decided.

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>

### Why make our own bot?

While there are a variety of bots that provide the same features as the Library of Wan Shi Tong, we decided to make our own bot for a few reasons:

- [ ] **Customization**: We wanted to be able to customize the bot to our needs, and not be limited by the features of other bots.
- [ ] **Learning**: We wanted to learn how to use Kotlin, and this seemed like a good opportunity to do so.
- [ ] **Fun**: We wanted to make a bot that we could use on our own server, and that we could share with others.
- [ ] **Open Source**: We wanted to make the bot open source since that is one of our core values, so that others can contribute to it, and learn from it.
- [ ] **Community**: We wanted to make a bot that would be useful for our community, and that would help us grow as a community.

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>

### Built with

[![JDA][jda-shield]][jda-url]
[![Gradle][gradle-shield]][gradle-url]
[![Kotlin][kotlin-shield]][kotlin-url]

[![IntelliJ IDEA][intellij-idea-shield]][intellij-idea-url]
[![Visual Studio Code][vscode-shield]][vscode-url]
[![Git][git-shield]][git-url]
[![GitHub][github-shield]][github-url]

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED -->

## Getting started

This guide is not yet finalised and may not be complete. It is also not yet tested.

### Prerequisites

Before you begin, ensure you have met the following requirements:

* [Java 18](https://jdk.java.net/18/)
    * To check if you have Java installed, run the following command:
    
      ```sh
      java -version
      ```

      It should return a version number, such as 18.0.1. Ensure that the version number is 18 or higher.

### Installation

1. Clone the repo

   ```sh
   git clone https://github.com/amuzil/lwst.git
   ```

2. Install the dependencies

   ```sh
   ./gradlew build
   ```

2. Run the bot to generate the config file

   ```sh
   ./gradlew run
   ```

3. Add your bot token to the config file
    1. Follow the [JDA getting started guide](https://jda.wiki/using-jda/getting-started/) up to step 1 of "Connecting to Discord with a Bot Account".
    2. Open the `config.json` file
        * On Linux, it will be located in `XDG_CONFIG_HOME/LWST/configuration.yml`
            * If `XDG_CONFIG_HOME` is not set, it will be located in `~/.config/LWST/configuration.yml`
        * On Windows, it will be located in `%APPDATA%\LWST\configuration.yml`        
        * On macOS, it will be located in `~/Library/Application Support/LWST/configuration.yml`
        * On other operating systems, it will be located in `~/.config/LWST/configuration.yml`
    3. Replace the value of the `token` key with your bot token
    4. Save the file
4. Run the bot

   ```sh
   ./gradlew run
   ```

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create.
Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request.
You can also simply open an issue.
If you really like the project, consider giving it a star!

> Something we like to use it [Gitmoji](https://gitmoji.dev/), which is an emoji guide for Git commit messages.
> It makes it easier to see what kind of changes have been made at a glance.
> While not required, we heavily recommend using it.
> 
> To make things easier, check out [Gitmoji Plus: Commit Button](https://plugins.jetbrains.com/plugin/12383-gitmoji-plus-commit-button),
> a plugin for JetBrains IDEs that adds a button to the commit dialog that allows you to easily add a Gitmoji to your commit message.

While the below guide details specific `git` commands, you also can (and probably should) use a GUI for Git.
Options include any [JetBrains IDE](https://www.jetbrains.com/products.html) (such as [IntelliJ IDEA](https://www.jetbrains.com/idea/)), [GitHub Desktop](https://desktop.github.com/), or [GitKraken](https://www.gitkraken.com/).

1. Fork the Project
2. Create your Feature Branch

   ```sh
   git checkout -b feature/AmazingFeature
   ```

3. Commit your Changes

   ```sh
   git commit -m ":sparkles: Add some AmazingFeature"
   ```

4. Push to the Branch

   ```sh
   git push origin feature/AmazingFeature
   ```

5. Open a Pull Request

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->

## License

Distributed under the Unlicense. See [`license.md`](license.md) for more information.

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->

## Contact

[![Connect on Discord][discord-shield]][discord-url]
[![Book a meeting][cal-shield]][cal-url]

Main contact: **Luka "Mahtaran" Leer**

[![LinkedIn][luka-linkedin-shield]][luka-linkedin-url]
[![Mail][luka-mail-shield]][luka-mail-url]
[![Website][luka-website-shield]][luka-website-url]

[![Follow on GitHub][luka-github-followers-shield]][luka-github-followers-url]
[![Follow on Reddit][luka-reddit-shield]][luka-reddit-url]
[![Follow on Twitter][luka-twitter-shield]][luka-twitter-url]

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

* [Readme template by Othneil Drew](https://github.com/othneildrew/Best-README-Template)

<p align="right" style="text-align: right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors/amuzil/lwst.svg?style=for-the-badge
[contributors-url]: https://github.com/amuzil/lwst/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/amuzil/lwst.svg?style=for-the-badge
[forks-url]: https://github.com/amuzil/lwst/network/members
[stars-shield]: https://img.shields.io/github/stars/amuzil/lwst.svg?style=for-the-badge
[stars-url]: https://github.com/amuzil/lwst/stargazers
[hacktoberfest-shield]: https://img.shields.io/github/hacktoberfest/2022/amuzil/lwst?style=for-the-badge
[hacktoberfest-url]: https://hacktoberfest.com/
[license-shield]: https://img.shields.io/github/license/amuzil/lwst.svg?style=for-the-badge
[license-url]: https://github.com/amuzil/lwst/blob/main/license.md

[banner]: https://raw.githubusercontent.com/amuzil/lwst/main/src/main/resources/banner.png

[github-repo-url]: https://github.com/amuzil/lwst/
[github-repo-file-count]: https://img.shields.io/github/directory-file-count/amuzil/lwst?style=for-the-badge
[github-repo-size]: https://img.shields.io/github/repo-size/amuzil/lwst?style=for-the-badge
[github-repo-last-commit]: https://img.shields.io/github/last-commit/amuzil/lwst?style=for-the-badge
[github-repo-languages]: https://img.shields.io/github/languages/count/amuzil/lwst?style=for-the-badge
[github-open-issues]: https://img.shields.io/github/issues/amuzil/lwst?style=for-the-badge
[github-open-issues-url]: https://github.com/amuzil/lwst/issues
[github-closed-issues]: https://img.shields.io/github/issues-closed/amuzil/lwst?style=for-the-badge
[github-closed-issues-url]: https://github.com/amuzil/lwst/issues?q=is%3Aissue+is%3Aclosed
[github-open-pull-requests]: https://img.shields.io/github/issues-pr/amuzil/lwst?style=for-the-badge
[github-open-pull-requests-url]: https://github.com/amuzil/lwst/pulls
[github-closed-pull-requests]: https://img.shields.io/github/issues-pr-closed/amuzil/lwst?style=for-the-badge
[github-closed-pull-requests-url]: https://github.com/amuzil/lwst/pulls?q=is%3Apr+is%3Aclosed
[github-open-milestones]: https://img.shields.io/github/milestones/open/amuzil/lwst?style=for-the-badge
[github-open-milestones-url]: https://github.com/amuzil/lwst/milestones
[github-closed-milestones]: https://img.shields.io/github/milestones/closed/amuzil/lwst?style=for-the-badge
[github-closed-milestones-url]: https://github.com/amuzil/lwst/milestones?q=is%3Aclosed

[jda-shield]: https://img.shields.io/badge/JDA-DE4B4B?style=for-the-badge&logo=discord&logoColor=white
[jda-url]: https://jda.wiki/
[gradle-shield]: https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white
[gradle-url]: https://gradle.org/
[kotlin-shield]: https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white
[kotlin-url]: https://kotlinlang.org/
[intellij-idea-shield]: https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white
[intellij-idea-url]: https://www.jetbrains.com/idea/
[vscode-shield]: https://img.shields.io/badge/Visual_Studio_Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white
[vscode-url]: https://code.visualstudio.com/
[git-shield]: https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white
[git-url]: https://git-scm.com/
[github-shield]: https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white
[github-url]: https://github.com/

[discord-shield]: https://img.shields.io/discord/328518857310339076?style=for-the-badge&logo=discord&logoColor=white&label=Connect+on+Discord
[discord-url]: https://discord.gg/jPVMETb
[cal-shield]: https://img.shields.io/badge/Cal.com-1DA1F2?style=for-the-badge&logo=google-calendar&logoColor=white&label=Book+a+meeting
[cal-url]: https://app.cal.com/team/amuzil

[luka-linkedin-shield]: https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
[luka-linkedin-url]: https://linkedin.com/in/luka-leer
[luka-mail-shield]: https://img.shields.io/badge/Mail-D14836?style=for-the-badge&logo=gmail&logoColor=white
[luka-mail-url]: mailto:mahtaran@amuzil.com
[luka-website-shield]: https://img.shields.io/badge/Website-FF7139?style=for-the-badge&logo=firefox&logoColor=white
[luka-website-url]: https://mahtaran.amuzil.com/
[luka-github-followers-shield]: https://img.shields.io/github/followers/Mahtaran?style=for-the-badge&logo=github&logoColor=white&label=Follow+on+GitHub
[luka-github-followers-url]: https://github.com/Mahtaran
[luka-reddit-shield]: https://img.shields.io/reddit/user-karma/link/Mahtaran?style=for-the-badge&logo=reddit&logoColor=white&label=Follow+on+Reddit
[luka-reddit-url]: https://reddit.com/user/Mahtaran
[luka-twitter-shield]: https://img.shields.io/twitter/follow/mahtaransocial?style=for-the-badge&logo=twitter&logoColor=white&label=Follow+on+Twitter
[luka-twitter-url]: https://twitter.com/mahtaransocial
