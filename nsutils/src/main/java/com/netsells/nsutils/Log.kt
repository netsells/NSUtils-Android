package com.netsells.nsutils

/**
 * Returns the class name. Useful for Log tags
 */
val Any.TAG: String
    get() = this::class.java.simpleName