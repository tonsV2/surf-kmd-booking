package dk.surfstation.controller

import dk.surfstation.client.BookingClient
import dk.surfstation.configuration.BookingConfiguration
import dk.surfstation.domain.OccasionRecords
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.ModelAndView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
class BookingController(private val bookingClient: BookingClient, private val bookingConfiguration: BookingConfiguration) {
    @Get("/bookings")
    fun bookings(): ModelAndView<Map<String, List<OccasionRecords>>> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val now = LocalDateTime.now().format(formatter)
        val bookings = bookingClient.fetchBookings(now, now, bookingConfiguration.authenticationCode)
        return ModelAndView("bookings", mapOf("records" to bookings.accessControlRecords.occasionRecords))
    }
}
