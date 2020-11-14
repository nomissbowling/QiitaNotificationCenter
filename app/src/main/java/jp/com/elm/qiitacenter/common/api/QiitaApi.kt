package jp.com.elm.qiitacenter.common.api

const val TAG = "tag:"
const val OR  = " OR "

class QiitaApi private constructor(){

    companion object{
        fun getArticlesFilterByTag(tag:String, vararg addTag:String) : String{
            val apiEndPoint = StringBuilder("https://qiita.com/api/v2/items/query=tag:${tag}")
            addTag.forEach {
                apiEndPoint.append(TAG).append(it).append(OR)
            }

            return apiEndPoint.toString()
        }

        const val TAG_API = " https://qiita.com/api/v2/tags/"

        fun getTagApi(vararg  tag: String):String = TAG_API+tag

    }
}