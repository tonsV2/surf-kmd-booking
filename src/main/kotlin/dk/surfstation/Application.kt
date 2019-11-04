package dk.surfstation

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("dk.surfstation")
                .mainClass(Application.javaClass)
                .start()
    }
}
