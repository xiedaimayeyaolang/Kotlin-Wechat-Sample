package sample.wechat.kotlin.view.main

import allnewapp.kotlinmvp.bean.MainModel
import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.presenter.BasePresenter

/**
 * Created by heping on 2018/1/31.
 */
open class MainPresenter<T : MainView<MainModel>> constructor(mView: T) : BasePresenter<BaseView>(mView){

}