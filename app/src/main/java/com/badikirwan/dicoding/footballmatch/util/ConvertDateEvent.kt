package com.badikirwan.dicoding.footballmatch.util

import java.text.SimpleDateFormat
import java.util.*

object ConvertDateEvent {

    fun getFormatDate(date: String): String? {
        val input = "yyyy-MM-dd"
        val output = "EEE, dd MMM yyy"

        val inputFormat = SimpleDateFormat(input, Locale.ENGLISH)
        val outputFormat = SimpleDateFormat(output, Locale.ENGLISH)

        val dat = inputFormat.parse(date)
        val str = outputFormat.format(dat)

        return str
    }
}