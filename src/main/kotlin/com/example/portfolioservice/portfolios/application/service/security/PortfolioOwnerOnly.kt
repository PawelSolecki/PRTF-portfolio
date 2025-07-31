package com.example.portfolioservice.portfolios.application.service.security

import org.springframework.security.access.prepost.PreAuthorize


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@PreAuthorize("@portfolioSecurity.isOwner(#id, T(java.util.UUID).fromString(authentication.name))")
annotation class PortfolioOwnerOnly
