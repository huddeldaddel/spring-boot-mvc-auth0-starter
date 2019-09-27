package de.huddeldaddel.mjournal

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["de.huddeldaddel.mjounal"])
@EnableAutoConfiguration
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
