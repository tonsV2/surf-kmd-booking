package dk.surfstation.service

import dk.surfstation.domain.Bookings
import java.time.LocalDate

interface BookingService {
    fun fetchBookings(fromDate: LocalDate, toDate: LocalDate): Bookings
}
