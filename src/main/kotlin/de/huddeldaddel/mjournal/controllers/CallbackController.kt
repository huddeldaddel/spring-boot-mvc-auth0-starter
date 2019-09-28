package de.huddeldaddel.mjournal.controllers

import com.auth0.IdentityVerificationException
import com.auth0.SessionUtils
import com.auth0.Tokens
import de.huddeldaddel.mjournal.controllers.AuthController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

@Controller
class CallbackController(private val controller: AuthController) {

    private val redirectOnFail: String = "/login"
    private val redirectOnSuccess = "/journal/home"

    @RequestMapping(value = ["/callback"], method = [RequestMethod.GET])
    @Throws(ServletException::class, IOException::class)
    protected fun getCallback(req: HttpServletRequest, res: HttpServletResponse) {
        handle(req, res)
    }

    @RequestMapping(value = ["/callback"], method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    @Throws(ServletException::class, IOException::class)
    protected fun postCallback(req: HttpServletRequest, res: HttpServletResponse) {
        handle(req, res)
    }

    @Throws(IOException::class)
    private fun handle(req: HttpServletRequest, res: HttpServletResponse) {
        try {
            val tokens = controller.handle(req)
            SessionUtils.set(req, "accessToken", tokens.accessToken)
            SessionUtils.set(req, "idToken", tokens.idToken)
            res.sendRedirect(redirectOnSuccess)
        } catch (e: IdentityVerificationException) {
            e.printStackTrace()
            res.sendRedirect(redirectOnFail)
        }

    }

}
