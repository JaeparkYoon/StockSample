package com.yjpapp.stockportfolio.util

import android.util.Log
import com.yjpapp.stockportfolio.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    private val sellTex: Double = 0.5

    fun getTodayYYYYMMDD(): String {
        val currentTime: Long = System.currentTimeMillis()
        val todayDate = Date(currentTime)
        val sdformat = SimpleDateFormat("yyyyMMdd")
        return sdformat.format(todayDate)
    }

    fun logcat(msg: String){
        if(BuildConfig.LOG_CAT) Log.d(javaClass.simpleName, msg)
    }

    //5,000,000 => 5000000으로 변환
    fun getNumDeletedComma(num: String): String{
        var result: String = ""
        val split = num.split(",")
        for (i in split.indices) {
            result += split[i]
        }
        return result
    }

    //14% => 14로 변환.
    fun getNumDeletedPercent(num: String): String{
        var result: String = ""
        val split = num.split("%")
        for (i in split.indices) {
            result += split[i]
        }
        return result
    }

    //수익률 계산
    fun calculateGainPercent(purchasePrice: String, sellPrice: String): Double{
        val purchasePriceNum = getNumDeletedComma(purchasePrice)
        val sellPriceNum = getNumDeletedComma(sellPrice)
        return (((sellPriceNum.toDouble() / purchasePriceNum.toDouble()) -1) * 100)
    }

    fun getRoundsPercentNumber(number: Double): String{
        var result = String.format("%.2f", number)
        if(result == "NaN") result = "0"
        result += "%"
        return result
    }
}