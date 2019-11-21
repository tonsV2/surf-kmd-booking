package dk.surfstation.client

import dk.surfstation.domain.Bookings
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("\${booking.url}")
interface BookingClient {
    @Get("\${booking.path}")
    fun fetchBookings(fromDate: String, toDate: String, authenticationCode: String): Bookings
}
