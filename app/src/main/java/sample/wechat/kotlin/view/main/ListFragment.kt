package sample.wechat.kotlin.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sample.wechat.kotlin.R

class ListFragment : Fragment() {

    private var mRecyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRecyclerView = inflater.inflate(R.layout.list_fragment, container, false) as RecyclerView
        return mRecyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyclerView!!.layoutManager = LinearLayoutManager(mRecyclerView!!.context)
        mRecyclerView!!.adapter = RecyclerViewAdapter(activity!!)
    }
}
