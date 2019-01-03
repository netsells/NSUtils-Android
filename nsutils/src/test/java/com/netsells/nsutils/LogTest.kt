package com.netsells.nsutils

import org.junit.Assert.*
import org.junit.Test

/**
 * Unit test related to Log.kt
 */
class LogTest {

    /**
     * Test that the [TAG] value for the current class is correct
     */
    @Test
    fun thisTag() {
        assertEquals("LogTest", TAG)
    }

    /**
     * Test that the [TAG] value for the [String] class is correct
     */
    @Test
    fun stringTag() {
        assertEquals("String", "".TAG)
    }

    /**
     * Test that the [TAG] value for the [Integer] class is correct
     */
    @Test
    fun intTag() {
        assertEquals("Integer", 2.TAG)
    }

}