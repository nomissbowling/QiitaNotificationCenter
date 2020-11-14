package jp.com.elm.qiitacenter.model.converter

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import java.util.*

class DateAnalyzer(val date:String) {

    fun analyzeDate() : Date{
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.JAPANESE)
        formatter.timeZone = TimeZone.getFrozenTimeZone("Asia/Tokyo")
        return formatter.parse(date)
    }

}