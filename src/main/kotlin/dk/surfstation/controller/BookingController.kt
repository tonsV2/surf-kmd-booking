package dk.surfstation.controller

import dk.surfstation.client.BookingClient
import dk.surfstation.configuration.BookingConfiguration
import dk.surfstation.domain.Bookings
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
class BookingController(private val bookingClient: BookingClient, private val bookingConfiguration: BookingConfiguration) {
    @Get("/bookings")
    fun bookings(): Bookings {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val now = LocalDateTime.now().format(formatter)
        val bookings = bookingClient.fetchBookings(now, now, bookingConfiguration.authenticationCode)
        bookings.accessControlRecords.occasionRecords.forEach {
            println(it.facilityName)
            println("${it.fomKlo} - ${it.tomKlo}")
            println(it.objectName)
            println("-----------------------------------------")
        }
        return bookings
    }
}
