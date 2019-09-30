package de.huddeldaddel.starter.controllers

import de.huddeldaddel.starter.configuration.Auth0Config
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest

@Controller
class LogoutController(config: Auth0Config) {

    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val domain = config.domain
    private val clientId = config.clientId

    @RequestMapping(value = ["/logout"], method = [RequestMethod.GET])
    protected fun logout(req: HttpServletRequest): String {
        logger.debug("Performing logout")
        req.session?.invalidate()
        val returnTo = req.scheme + "://" + req.serverName + ":" + req.serverPort
        val logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s", domain, clientId, returnTo)
        return "redirect:$logoutUrl"
    }

}
