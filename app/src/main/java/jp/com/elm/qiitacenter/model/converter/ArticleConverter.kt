package jp.com.elm.qiitacenter.model.converter

import android.net.Uri
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class ArticleConverter(responseMessage:String) {

    private val latestArticle : JSONObject

    init {
        latestArticle = createLatestArticleJson(responseMessage)
    }

    private fun createLatestArticleJson(responseMessage: String) : JSONObject{
        val articles = JSONArray(responseMessage)
        return articles.getJSONObject(0)
    }

    fun extractDate() : Date{
        val date = latestArticle.getString("update_at")
        val dateAnalyzer = DateAnalyzer(date)
        return dateAnalyzer.analyzeDate()
    }

    fun extractUri():Uri{
        val uri = latestArticle.getString("uri")
        return Uri.parse(uri)
    }

    fun getTitle():String{
        return latestArticle.getString("title")
    }

}