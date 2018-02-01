package sample.wechat.kotlin.view.login

import allnewapp.kotlinmvp.bean.MainModel
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.presenter.BasePresenter

/**
 * Created by heping on 2018/1/31.
 */
open class LoginPresenter<T : LoginView<MainModel>> constructor(mView: T) : BasePresenter<BaseView>(mView) {
        val mvpView = mView
        fun getWeather(cityId: String) {
            mvpView.showDialog()
            val observable: Observable<MainModel>? = BasePresenter.apiStoreInstance()?.
                    loadDataByRetrofitRxjava(cityId)
            val onSuccess: Consumer<MainModel> = Consumer { modle -> if (modle != null) mvpView.onSuccess(modle) }
            val onThrowable: Consumer<Throwable> = Consumer {
                e -> Log.e("wing", "error android Presenter" + e.message)
                mvpView.onFaild(e.message.toString())
            }
            if (observable != null) {
                addDisposable(observable,onSuccess, onThrowable)
            }

    }

}
