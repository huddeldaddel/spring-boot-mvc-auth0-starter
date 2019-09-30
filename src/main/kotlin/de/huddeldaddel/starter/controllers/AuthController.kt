package de.huddeldaddel.starter.controllers

import com.auth0.IdentityVerificationException
import com.auth0.Tokens
import de.huddeldaddel.starter.configuration.Auth0Config
import org.springframework.stereotype.Component

import javax.servlet.http.HttpServletRequest
import com.auth0.AuthenticationController.newBuilder as buildController

@Component
class AuthController constructor(config: Auth0Config) {

    private val controller = buildController(config.domain, config.clientId, config.clientSecret).build()
    private val userInfoAudience = String.format("https://%s/userinfo", config.domain)

    @Throws(IdentityVerificationException::class)
    fun handle(request: HttpServletRequest): Tokens {
        return controller.handle(request)
    }

    fun buildAuthorizeUrl(request: HttpServletRequest, redirectUri: String): String {
        return controller
                .buildAuthorizeUrl(request, redirectUri)
                .withAudience(userInfoAudience)
                .build()
    }

}
