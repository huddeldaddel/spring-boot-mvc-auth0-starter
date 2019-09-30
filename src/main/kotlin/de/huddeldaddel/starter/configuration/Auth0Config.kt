package de.huddeldaddel.starter.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
@Configuration
class Auth0Config(
        @Value(value = "\${com.auth0.domain}")
        val domain: String,

        @Value(value = "\${com.auth0.clientId}")
        val clientId: String,

        @Value(value = "\${com.auth0.clientSecret}")
        val clientSecret: String
) {

    @Bean
    fun filterRegistration(): FilterRegistrationBean<*> {
        val registration: FilterRegistrationBean<Auth0Filter> = FilterRegistrationBean()
        registration.filter = Auth0Filter()
        registration.addUrlPatterns("/protected/*")
        registration.setName(Auth0Filter::class.java.simpleName)
        return registration
    }

}
