package allnewapp.kotlinmvp.base

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.presenter.BasePresenter

/**
 * Created by heping on 2018/2/1.
 */
abstract class BaseFragment<P : BasePresenter<BaseView>>: AnkoLogger,Fragment(){
    override val loggerTag: String = "kotlinmvp"
    lateinit var mPresenter: P
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(getLayoutId(), container, false) as View
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter = createPresenter()
        initViews()

    }
    abstract fun getLayoutId(): Int
    abstract fun createPresenter(): P
    abstract fun initViews()
    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unDisposed()
    }
}
