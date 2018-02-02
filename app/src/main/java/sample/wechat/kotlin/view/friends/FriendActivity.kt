package sample.wechat.kotlin.view.friends

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_app_bar_layout.*
import sample.wechat.kotlin.R


class FriendActivity : AppCompatActivity() {


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)
        Log.e("hp","FriendActivity")
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = ContentAdapter()

        srl_refresh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_samples, menu)
        return true
    }

    private inner class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapter.ContentHolder {
            return ContentHolder(LayoutInflater.from(this@FriendActivity).inflate(R.layout.item_simple_list_1, parent, false))
        }

        override fun onBindViewHolder(holder: ContentAdapter.ContentHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return 50
        }

        internal inner class ContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    }

}
