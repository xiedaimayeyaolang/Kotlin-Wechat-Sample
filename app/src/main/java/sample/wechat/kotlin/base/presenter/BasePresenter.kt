package sample.wechat.kotlin.base.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.model.BaseModel
import sample.wechat.kotlin.net.ApiClient
import sample.wechat.kotlin.net.ApiStores

/**
 * Created by heping on 2018/1/31.
 */
abstract class BasePresenter<T : BaseView> (val mView: T) {
    val disposable: CompositeDisposable = CompositeDisposable()
    companion object{
        fun apiStoreInstance(): ApiStores? = ApiClient.retrofit()?.create(ApiStores::class.java)
    }
    protected  fun <T: BaseModel> addDisposable(observable: Observable<T>,
                                                onSuccess: Consumer<T>,
                                                onThrowable: Consumer<Throwable>) {
        disposable.add(observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess, onThrowable))
    }
    protected  fun <T: BaseModel> addToDisposable(observable: Observable<T>,
                                                  consumer: Consumer<T>,
                                                  onThrowable: Consumer<Throwable>) {
        disposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer, onThrowable))
    }
    fun unDisposed() = { if(disposable.isDisposed) disposable.dispose() }
}
