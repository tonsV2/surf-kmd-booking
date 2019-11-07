package dk.surfstation.service.impl

import dk.surfstation.client.BookingClient
import dk.surfstation.configuration.BookingConfiguration
import dk.surfstation.domain.Bookings
import dk.surfstation.service.BookingService
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Singleton

@Singleton
class BookingServiceImpl(private val bookingClient: BookingClient, private val bookingConfiguration: BookingConfiguration) : BookingService {
    override fun fetchBookings(fromDate: LocalDate, toDate: LocalDate): Bookings {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val fromDateString = fromDate.format(formatter)
        val toDateString = toDate.format(formatter)
        val authenticationCode = bookingConfiguration.authenticationCode
        val bookings = bookingClient.fetchBookings(fromDateString, toDateString, authenticationCode)
        removeRecordsStartingBeforeNow(bookings)
        sortRecords(bookings)
        return bookings
    }

    private fun removeRecordsStartingBeforeNow(bookings: Bookings) {
        bookings.accessControlRecords.occasionRecords.removeIf {
            val split = it.fomKlo.split(":")
            val hour = split[0].toInt()
            val minute = split[1].toInt()
            val fromTime = LocalTime.of(hour, minute, 0)
            val now = LocalTime.now(ZoneId.of("Europe/Copenhagen"))
            fromTime.isBefore(now)
        }
    }

    private fun sortRecords(bookings: Bookings) {
        bookings.accessControlRecords.occasionRecords.sortBy { it.fomKlo }
    }
}
