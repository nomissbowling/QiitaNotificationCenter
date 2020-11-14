package jp.com.elm.qiitacenter.model.service.collectarticle

import android.net.Uri
import jp.com.elm.qiitacenter.model.converter.ArticleConverter
import jp.com.elm.qiitacenter.model.http.SupportHttpClient
import java.util.*

class CollectArticles(api:String) {
    val articleTitle : String
    val articleUrl   : Uri
    val articleDate  : Date

    init {
        val response = getResponseMessage(api)
        val converter = ArticleConverter(response ?: "")

        articleTitle = converter.getTitle()
        articleUrl   = converter.extractUri()
        articleDate  = converter.extractDate()
    }

    private fun getResponseMessage(api: String):String?{
        val httpClient = SupportHttpClient(api)
        return httpClient.getAsync()
    }

}