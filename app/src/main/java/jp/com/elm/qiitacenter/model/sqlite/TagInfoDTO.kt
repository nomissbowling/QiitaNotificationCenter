package jp.com.elm.qiitacenter.model.sqlite

import android.net.Uri

data class TagInfoDTO(
    val followersCount:Int,
    val iconUrl: Uri?,
    val tagId : String,
    val itemsCount : Int
)