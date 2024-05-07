package com.example.standard_mvvm.util

import java.math.BigDecimal
import java.text.DecimalFormat

fun decimal(price: Double): String {
    val decimal = BigDecimal(price)
    return DecimalFormat("\$ #,###.00").format(decimal)
}