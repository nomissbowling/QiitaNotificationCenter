package jp.com.elm.qiitacenter.model.service.judge

import java.util.*

class JudgePostArticle() {

    fun isLatestArticlePosted(latestUpdateTime:Long) : Boolean {
        val nowTime = Date().time
        val timeLag = nowTime - (latestUpdateTime ?: 0)
        return 0 <= timeLag && timeLag <= (1000 * 60 * 60)/*1時間*/
    }
}