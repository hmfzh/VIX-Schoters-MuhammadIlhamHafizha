package com.example.vix_schoters_muhammadilhamhafizha.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    fun dateFormat(date: String?) : String {
        return if (date.isNullOrEmpty()) ""
        else {
            val currentFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale("in", "ID"))
            val dateParse = currentFormat.parse( date )
            val toFormat = SimpleDateFormat("dd MMMM yyyy", Locale("in", "ID"))
            toFormat.format(dateParse!!)
        }
    }
}