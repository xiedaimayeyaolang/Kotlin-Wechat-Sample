package sample.wechat.kotlin.view.wechart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import kotlinx.android.synthetic.main.activity_wechat_main.*
import sample.wechat.kotlin.R
import sample.wechat.kotlin.ext.BottomNavigationViewHelper
import sample.wechat.kotlin.view.main.ListFragment

class WechatActivity : AppCompatActivity() {
    lateinit var mFragments: MutableList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("hp","WechatActivity")
        setContentView(R.layout.activity_wechat_main)
        initView()
    }
    fun initView() {
        var ab = supportActionBar

        BottomNavigationViewHelper.disableShiftMode(navigationView)
        initFragments()
//        getMainComponent().plus(RandomModule(this)).inject(this)
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = mFragments[position]
            override fun getCount() = mFragments.size
        }

        viewPager.offscreenPageLimit = 4

        navigationView.setOnNavigationItemSelectedListener { item ->
            var tab = 0
            ab?.title = item.title
            item.setChecked(true)
            when (item.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            viewPager.currentItem = tab
            false
        }
    }

    private fun initFragments() {
        mFragments = arrayListOf()
//        mFragments.add(AndroidFragment.newInstance())
//        mFragments.add(IOSFragment.newInstance())
//        mFragments.add(GirlFragment.newInstance())
//        mFragments.add(FragmentHolder())
        mFragments.add(ListFragment())
        mFragments.add(ListFragment())
        mFragments.add(ListFragment())
        mFragments.add(ListFragment())
    }
}
