package sample.wechat.kotlin.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.startActivity
import sample.wechat.kotlin.R
import sample.wechat.kotlin.ext.onClick
import sample.wechat.kotlin.view.wechart.WechatActivity

class RecyclerViewAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val view = holder.mView
        view.onClick { mContext.startActivity<WechatActivity>() }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
}
