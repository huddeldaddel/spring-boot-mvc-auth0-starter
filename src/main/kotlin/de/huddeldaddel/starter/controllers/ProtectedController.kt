package de.huddeldaddel.starter.controllers

import com.auth0.SessionUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping(value = ["/protected"])
class ProtectedController {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(value = ["/home"], method = [RequestMethod.GET])
    protected fun home(model: MutableMap<String, Any>, req: HttpServletRequest): String {
        val accessToken = SessionUtils.get(req, "accessToken") as String?
        val idToken = SessionUtils.get(req, "idToken") as String?
        if (accessToken != null) {
            model["userId"] = accessToken
        } else if (idToken != null) {
            model["userId"] = idToken
        }
        return "protected/home"
    }

}
