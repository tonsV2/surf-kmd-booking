package dk.surfstation.configuration

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class BookingConfiguration {
    companion object {
        //const val URL = "https://booking-ltk.kmd.dk"
        const val URL = "https://fritidsportalen-odense.kmd.dk"
        const val PATH = "/kmd_webapi/api/Monitor/GetFilteredAccessControlRecords?dateTimeFrom={dateTimeFrom}&dateTimeTo={dateTimeTo}&facility=&facilityObject=&partObject=&authenticationCode={authenticationCode}&type=json"
    }

    @Value("\${booking.authenticationCode}")
    lateinit var authenticationCode: String
}
