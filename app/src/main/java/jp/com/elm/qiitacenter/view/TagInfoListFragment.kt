package jp.com.elm.qiitacenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.com.elm.qiitacenter.model.generator.IGenerateTagInfo

/**
 * A fragment representing a list of Items.
 */
class AddTagFragmentFragment<T,D>(private val generator : IGenerateTagInfo<T, D>, private val response : T) : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tag_info_list, container, false)
        val tagInfoList = generator.generateTagInfo(response)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyaddTagFragmentRecyclerViewAdapter(context, tagInfoList)
            }
        }
        return view
    }

    companion object{

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun <T,D> newInstance(generator:IGenerateTagInfo<T,D>, response:T) =
                AddTagFragmentFragment(generator,response).apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}