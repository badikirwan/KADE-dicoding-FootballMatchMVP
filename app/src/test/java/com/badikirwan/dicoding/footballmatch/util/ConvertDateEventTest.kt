package com.badikirwan.dicoding.footballmatch.util

import org.junit.Test

import org.junit.Assert.*

class ConvertDateEventTest {

    @Test
    fun getFormatDate() {
        assertEquals("Mon, 10 Dec 2018", ConvertDateEvent.getFormatDate("2018-12-10"))
    }
}