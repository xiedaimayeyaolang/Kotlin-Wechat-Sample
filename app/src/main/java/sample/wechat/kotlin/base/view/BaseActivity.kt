package sample.wechat.kotlin.base.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.presenter.BasePresenter

abstract class BaseActivity<P : BasePresenter<BaseView>> : AppCompatActivity(),AnkoLogger {
    lateinit var mPresenter: P
    override val loggerTag: String = "wechat"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initViews()
        mPresenter = createPresenter()
    }
    abstract fun getLayoutId(): Int
    abstract fun createPresenter(): P
    abstract fun initViews()
    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unDisposed()
    }
}
