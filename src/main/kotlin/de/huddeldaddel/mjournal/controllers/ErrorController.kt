package de.huddeldaddel.mjournal.controllers

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import java.io.IOException

@Controller
class ErrorController : org.springframework.boot.web.servlet.error.ErrorController {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun getErrorPath(): String = PATH

    @RequestMapping("/error")
    @Throws(IOException::class)
    protected fun error(redirectAttributes: RedirectAttributes): String {
        logger.error("Handling error")
        redirectAttributes.addFlashAttribute("error", true)
        return "redirect:/login"
    }

    companion object {

        private const val PATH = "/error"

    }

}