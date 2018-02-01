package sample.wechat.kotlin.view.login

import sample.wechat.kotlin.base.interfacez.BaseView
import sample.wechat.kotlin.base.model.BaseModel

/**
 * Created by heping on 2018/1/31.
 */
interface LoginView<T : BaseModel>: BaseView {
    fun onSuccess(model: T)
    fun onFaild(error: String)
}
