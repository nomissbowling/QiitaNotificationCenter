package jp.com.elm.qiitacenter.model.converter

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.util.*

class DateAnalyzerTest{
    @Test
    fun testConvertDate(){
        val date = DateAnalyzer("2020-11-12T05:19:00")
        val actual = date.analyzeDate().time
        val expect = Date().time
        val sa = expect-actual
        assertTrue(0 <= sa && sa <= 1000 * 60 * 60)
    }
}