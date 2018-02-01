@file:Suppress("DEPRECATION")

package sample.wechat.kotlin.view.main
import allnewapp.kotlinmvp.bean.MainModel
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tab_layout.*
import sample.wechat.kotlin.R
import sample.wechat.kotlin.base.view.BaseActivity

class MainActivity : BaseActivity<MainPresenter<MainView<MainModel>>>(),MainView<MainModel> {
    override fun showDialog() {
    }

    override fun hintDialog() {
    }

    override fun getLayoutId(): Int = R.layout.activity_tab_layout

    override fun createPresenter(): MainPresenter<MainView<MainModel>>  = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun initViews() {

        toolbar.title = ""
        title_tb.text = "Kotlin-Mvp"
        setSupportActionBar(toolbar)
        var ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { this.finish() }
        initViewPaper()
    }
    fun initViewPaper(){

        val list = listOf("精选","体育","图文")
        val fragments = arrayListOf<ListFragment>()
        for ((i,e) in list.withIndex()){
            val tab = tabs.newTab()
            tab.text = e
            tabs.addTab(tab,i)
            fragments.add(ListFragment())
        }
        val mFragmentAdapteradapter = FragmentAdapter(supportFragmentManager, fragments, list)
        //给ViewPager设置适配器
        viewpager.setAdapter(mFragmentAdapteradapter)
        //将TabLayout和ViewPager关联起来。
        tabs.setupWithViewPager(viewpager)
        //给TabLayout设置适配器
        tabs.setTabsFromPagerAdapter(mFragmentAdapteradapter)

    }


}
