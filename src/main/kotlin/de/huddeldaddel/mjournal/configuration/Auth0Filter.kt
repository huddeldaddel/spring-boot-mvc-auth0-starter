package de.huddeldaddel.mjournal.configuration

import com.auth0.SessionUtils

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class Auth0Filter : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig?) {
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, next: FilterChain) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse
        val accessToken = SessionUtils.get(req, "accessToken") as String?
        val idToken = SessionUtils.get(req, "idToken") as String?
        if (accessToken == null && idToken == null) {
            res.sendRedirect("/login")
            return
        }
        next.doFilter(request, response)
    }

    override fun destroy() { }

}
