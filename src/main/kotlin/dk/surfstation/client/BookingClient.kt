package dk.surfstation.client

import dk.surfstation.configuration.BookingConfiguration
import dk.surfstation.domain.Bookings
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(BookingConfiguration.URL)
interface BookingClient {
    @Get(BookingConfiguration.PATH)
    fun fetchBookings(dateTimeFrom: String, dateTimeTo: String, authenticationCode: String): Bookings
}
