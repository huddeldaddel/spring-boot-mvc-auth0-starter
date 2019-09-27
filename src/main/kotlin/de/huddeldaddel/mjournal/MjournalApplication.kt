package de.huddeldaddel.mjournal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MjournalApplication

fun main(args: Array<String>) {
	runApplication<MjournalApplication>(*args)
}
