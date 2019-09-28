package de.huddeldaddel.mjournal.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest

@Controller
class LoginController(
        private val controller: AuthController,
        @Value(value = "\${com.auth0.callback}") val callbackUrl: String
) {

    @RequestMapping(value = ["/login"], method = [RequestMethod.GET])
    protected fun login(req: HttpServletRequest): String {
        val authorizeUrl = controller.buildAuthorizeUrl(req, callbackUrl)
        return "redirect:$authorizeUrl"
    }

}
