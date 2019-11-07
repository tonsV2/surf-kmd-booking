package dk.surfstation.configuration

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class BookingConfiguration {
    companion object {
        const val URL = "https://booking-ltk.kmd.dk"
        const val PATH = "/kmd_webapi/api/Monitor/GetFilteredAccessControlRecords?dateTimeFrom={fromDate}&dateTimeTo={toDate}&facility=&facilityObject=&partObject=&authenticationCode={authenticationCode}&type=json"
    }

    @Value("\${booking.authenticationCode}")
    lateinit var authenticationCode: String
}
