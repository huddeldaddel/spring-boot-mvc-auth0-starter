package de.huddeldaddel.mjournal.controllers

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest

@Controller
class LoginController(private val controller: AuthController) {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    protected fun login(req: HttpServletRequest): String {
        logger.debug("Performing login")
        val redirectUri = req.scheme + "://" + req.serverName + ":" + req.serverPort + "/callback"
        val authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri)
        return "redirect:$authorizeUrl"
    }

}
