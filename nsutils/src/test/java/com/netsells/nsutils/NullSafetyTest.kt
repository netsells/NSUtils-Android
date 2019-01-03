package com.netsells.nsutils

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

/**
 * Tests various null safety methods
 */
class NullSafetyTest {

    @Test
    fun `given a random int, int_orZero() returns the number`() {
        val num = Random.nextInt()
        assertNotNull(num)
        assertEquals(num, num.orZero())
    }

    @Test
    fun `given zero, int_orZero() returns zero`() {
        assertEquals(0, 0.orZero())
    }

    @Test
    fun `given null, int_orZero() returns zero`() {
        assertEquals(0, (null as Int?).orZero())
    }

    @Test
    fun `given a random long, long_orZero() returns the number`() {
        val num = Random.nextLong()
        assertNotNull(num)
        assertEquals(num, num.orZero())
    }

    @Test
    fun `given zero, long_orZero() returns zero`() {
        assertEquals(0L, 0L.orZero())
    }

    @Test
    fun `given null, long_orZero() returns zero`() {
        assertEquals(0, (null as Long?).orZero())
    }

    @Test
    fun `given a random float, float_orZero() returns the number`() {
        val num: Float = Random.nextFloat()
        assertNotNull(num)
        assertEquals(num, num.orZero())
    }

    @Test
    fun `given zero, float_orZero() returns zero`() {
        assertEquals(0f, 0f.orZero())
    }

    @Test
    fun `given null, float_orZero() returns zero`() {
        assertEquals(0f, (null as Float?).orZero())
    }

    @Test
    fun `given a random double, double_orZero() returns the number`() {
        val num: Double = Random.nextDouble()
        assertNotNull(num)
        assertEquals(num, num.orZero(), 0.0)
    }

    @Test
    fun `given zero, double_orZero() returns zero`() {
        assertEquals(0.0, 0.0.orZero(), 0.0)
    }

    @Test
    fun `given null, double_orZero() returns zero`() {
        assertEquals(0.0, (null as Double?).orZero(), 0.0)
    }

    @Test
    fun `given true, boolean_orFalse() returns true`() {
        assertTrue(true.orFalse())
    }

    @Test
    fun `given false, boolean_orFalse() returns false`() {
        assertFalse(false.orFalse())
    }

    @Test
    fun `given null, boolean_orFalse() returns false`() {
        assertFalse((null as Boolean?).orFalse())
    }

}