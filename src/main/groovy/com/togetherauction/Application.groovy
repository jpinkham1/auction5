package com.togetherauction

import io.micronaut.core.annotation.NonNull
import io.micronaut.context.ApplicationContextBuilder
import io.micronaut.context.ApplicationContextConfigurer
import io.micronaut.context.annotation.ContextConfigurer
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
class Application {
    @ContextConfigurer
    static class DefaultEnvironmentConfigurer implements ApplicationContextConfigurer {
        @Override
        void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments("dev")
        }
    }
    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
