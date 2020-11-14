package jp.com.elm.qiitacenter.model.http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class SupportHttpClient(private val api: String) {

    fun  getAsync():String? {
       return runBlocking { withContext(Dispatchers.IO) {
           runGetAsync(api)
       }

       }
    }

    private  fun runGetAsync(api: String):String? {
        val client = OkHttpClient()
        val request = Request.Builder().url(api).build()

        val response = client.newCall(request).execute()
        val result = response.body?.string()
        return result
    }

}