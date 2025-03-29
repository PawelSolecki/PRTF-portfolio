package com.example.portfolioservice.portfolios.infrastructure.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtDecoders
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
//                authorize("/public/**", permitAll)
                authorize(anyRequest, permitAll)
//                authorize(anyRequest, authenticated)
            }
//            oauth2ResourceServer {
//                jwt {
//                    jwtAuthenticationConverter = jwtAuthenticationConverter()
//                }
//            }
            cors { disable() }
            csrf { disable() }
            httpBasic { disable() }
            formLogin { disable() }
            logout { disable() }
        }
        return http.build()
    }

    @Bean
    fun jwtDecoder(): JwtDecoder {
        return JwtDecoders.fromOidcIssuerLocation("http://localhost:8080/realms/portfolios")
    }

    @Bean
    fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val converter = JwtAuthenticationConverter()
        // Możesz tu dodać niestandardową logikę konwersji JWT na autoryzację użytkownika
        return converter
    }
}