package jp.com.elm.qiitacenter.model.sqlite

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import jp.com.elm.qiitacenter.common.strings.FOLLOWERS_COUNT
import jp.com.elm.qiitacenter.common.strings.ID
import jp.com.elm.qiitacenter.common.strings.ITEMS_COUNT

class TagInfoDAO(private val dbHelper: TagInfoDBHelper){

    fun insertTagInfo(followersCount:Int,
                      iconUrl:String?,
                      tagId  :String,
                      itemsCount:Int
    ){
        val db = dbHelper.writableDatabase
        val columns = createColumn(followersCount,iconUrl,tagId,itemsCount)
            //TODO NULL調査
        db.insertOrThrow("tagInfoTable", "null", columns)
    }

    private fun createColumn(followersCount:Int,
                             iconUrl:String?,
                             tagId  :String,
                             itemsCount:Int) : ContentValues {
        return ContentValues().apply {
            put("followers_count",followersCount)
            put("icon_url",iconUrl)
            put("id",tagId)
            put("items_count",itemsCount)
        }
    }

    fun selectRegisteredTagInfo() : Cursor{
        val read  = dbHelper.readableDatabase
        return createQuery(read)
    }

    fun selectRegisteredTag() : Cursor{
        val read = dbHelper.readableDatabase
        return createQueryFilterBYTag(read)
    }

    private fun createQueryFilterBYTag(read: SQLiteDatabase) : Cursor{
        return read.query(
            "tagInfoTable",
                  arrayOf(ID),
            null,
            null,
              null,
                null,
                null
            )
    }

    private fun createQuery(read : SQLiteDatabase) : Cursor{
        return  read.query("tagInfoTable",
                arrayOf(ITEMS_COUNT, FOLLOWERS_COUNT, FOLLOWERS_COUNT, ID),
                null,
                null,
                null,
                null,
                null
        )
    }


    fun deleteTagInfo(tagId: String):Boolean{
        //TODO 指定されたタグをローカルから消す
        TODO()
    }

}