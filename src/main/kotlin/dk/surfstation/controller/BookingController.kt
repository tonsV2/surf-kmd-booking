package dk.surfstation.controller

import dk.surfstation.domain.OccasionRecords
import dk.surfstation.service.BookingService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.ModelAndView
import java.time.LocalDate

@Controller
class BookingController(private val bookingService: BookingService) {
    @Get("/bookings")
    fun bookings(): ModelAndView<Map<String, List<OccasionRecords>>> {
        val now = LocalDate.now()
        val bookings = bookingService.fetchBookings(now, now)
        return ModelAndView("bookings", mapOf("records" to bookings.accessControlRecords.occasionRecords))
    }
}
