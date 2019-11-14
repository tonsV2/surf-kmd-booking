package dk.surfstation.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Bookings(@JsonProperty("AccessControlRecords") val accessControlRecords: AccessControlRecords, val resultCode: Int, val resultText: String?)

data class AccessControlRecords(@JsonProperty("OccasionRecords") val occasionRecords: MutableList<OccasionRecords>)

data class OccasionRecords(
        @JsonProperty("Type") val type: String,
        @JsonProperty("BookingNr") val bookingNr: Int,
        @JsonProperty("BookingRow") val bookingRow: Int,
        @JsonProperty("FacilityID") val facilityID: String,
        @JsonProperty("ObjectID") val objectID: String,
        @JsonProperty("PartOfObjectId") val partOfObjectId: String,
        @JsonProperty("PartOfObjectName") val partOfObjectName: String,
        @JsonProperty("FacilityName") val facilityName: String,
        @JsonProperty("BookFromDate") val bookFromDate: String,
        @JsonProperty("BookToDate") val bookToDate: String,
        @JsonProperty("OccasionDate") val occasionDate: String,
        @JsonProperty("OccasionToDate") val occasionToDate: String,
        @JsonProperty("FomKlo") val fomKlo: String,
        @JsonProperty("TomKlo") val tomKlo: String,
        @JsonProperty("TimeBefore") val timeBefore: Int,
        @JsonProperty("TimeAfter") val timeAfter: Int,
        @JsonProperty("Weekday") val weekday: Int,
        @JsonProperty("BookStatus") val bookStatus: String,
        @JsonProperty("KortReg") val kortReg: String,
        @JsonProperty("CustomerID") val customerID: String,
        @JsonProperty("CustomerName") val customerName: String,
        @JsonProperty("TypeOfBooking") val typeOfBooking: String,
        @JsonProperty("CreatedBy") val createdBy: String,
        @JsonProperty("Cards") val cards: String?,
        @JsonProperty("FunctionCode1") val functionCode1: Int,
        @JsonProperty("FunctionCode2") val functionCode2: Int,
        @JsonProperty("FunctionCode3") val functionCode3: Int,
        @JsonProperty("FunctionCode4") val functionCode4: String,
        @JsonProperty("Text1") val text1: String,
        @JsonProperty("Text2") val text2: String,
        @JsonProperty("Text3") val text3: String,
        @JsonProperty("Text4") val text4: String,
        @JsonProperty("EndUser") val endUser: String,
        @JsonProperty("Activity") val activity: String
) {
    @JsonProperty("ObjectName")
    val objectName: String = ""
        get() = field.replace("LYIB - ", "")
}
