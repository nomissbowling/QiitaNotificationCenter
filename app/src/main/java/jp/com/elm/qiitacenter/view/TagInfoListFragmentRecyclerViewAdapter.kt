package jp.com.elm.qiitacenter.view

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.com.elm.qiitacenter.model.sqlite.TagInfoDTO

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyaddTagFragmentRecyclerViewAdapter(
        private val context:Context, private val values: List<TagInfoDTO>)
    : RecyclerView.Adapter<MyaddTagFragmentRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.tag_info_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        setTagIcon(item.iconUrl, holder)
        holder.tagId.text = item.tagId
        holder.followersCount.text = item.followersCount.toString()
        holder.itemsCount.text  = item.itemsCount.toString()
    }
    private fun setTagIcon(uri: Uri?,holder: ViewHolder){
        if (uri === null) holder.icon.setImageResource(R.mipmap.deffault_tag_icon)
        else              holder.icon.setImageURI(uri)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon : ImageView = view.findViewById(R.id.tag_icon)
        val tagId : TextView = view.findViewById(R.id.tag_id)
        val followersCount : TextView = view.findViewById(R.id.followers_count)
        val itemsCount:TextView = view.findViewById(R.id.items_count)

        override fun toString(): String {
            return super.toString() + " '" + tagId.text + "'"
        }
    }
}