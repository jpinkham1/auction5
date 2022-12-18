package com.togetherauction.controllers

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.View

@CompileStatic
@Controller
class HomeController {
    @Secured(SecurityRule.IS_ANONYMOUS)
    @View('home')
    @Get
    Map<String, Object> index() {
        [:]
    }
}
