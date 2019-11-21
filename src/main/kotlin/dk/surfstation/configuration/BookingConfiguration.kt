package dk.surfstation.configuration

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class BookingConfiguration(@Value("\${booking.authenticationCode}") val authenticationCode: String)
