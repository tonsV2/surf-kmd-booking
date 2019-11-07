package dk.surfstation.service.impl

import dk.surfstation.client.BookingClient
import dk.surfstation.configuration.BookingConfiguration
import dk.surfstation.domain.Bookings
import dk.surfstation.service.BookingService
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Singleton

@Singleton
class BookingServiceImpl(private val bookingClient: BookingClient, private val bookingConfiguration: BookingConfiguration) : BookingService {
    override fun fetchBookings(fromDate: LocalDate, toDate: LocalDate): Bookings {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fromDateString = fromDate.format(formatter)
        val toDateString = toDate.format(formatter)
        val bookings = bookingClient.fetchBookings(fromDateString, toDateString, bookingConfiguration.authenticationCode)
        bookings.accessControlRecords.occasionRecords.sortBy { it.fomKlo }
        return bookings
    }
}
