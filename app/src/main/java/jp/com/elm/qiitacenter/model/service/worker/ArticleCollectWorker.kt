package jp.com.elm.qiitacenter.model.service.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import jp.com.elm.qiitacenter.common.api.QiitaApi
import jp.com.elm.qiitacenter.model.service.collectarticle.CollectArticles
import jp.com.elm.qiitacenter.model.service.judge.JudgePostArticle

class ArticleCollectWorker(context: Context,params:WorkerParameters) : Worker(context,params){

    private val manager = newNotificationManager()

    /* カテゴリー名 */
    private val categoryName      = "新規記事が投稿されました"
    /* システムに登録するchannelのid */
    private val channelId         = "elm_nico"

    companion object{
        var id = 1
    }

    init {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(channelId, categoryName, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "新規記事の通知"
            }
            manager.createNotificationChannel(channel)
        }
    }

    private fun newNotificationManager():NotificationManager
        = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override fun doWork(): Result {
        val collectArticle = CollectArticles(QiitaApi.getTagApi("java"))
        val judgePostedArticle : JudgePostArticle = JudgePostArticle()

        val latestUpdate = collectArticle.articleDate
        if(judgePostedArticle.isLatestArticlePosted(latestUpdateTime = latestUpdate.time)){
            notifyManager(collectArticle.articleUrl,collectArticle.articleTitle)
        }

        TODO("Not yet implemented")

    }

    private fun notifyManager(uri:Uri,title:String){

        val intent = Intent(Intent.ACTION_VIEW, uri)
        val pi = PendingIntent.getActivity(applicationContext,ArticleCollectWorker.id,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(applicationContext,channelId).apply {
            setContentText(title)

            setContentIntent(pi)
            //TODO smaIconを用意する
        }
        with(NotificationManagerCompat.from(applicationContext)){
            notify(ArticleCollectWorker.id++,notification.build())
        }
    }

}