package sample.wechat.kotlin.view.login

import allnewapp.kotlinmvp.bean.MainModel
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import sample.wechat.kotlin.R
import sample.wechat.kotlin.base.view.BaseActivity
import sample.wechat.kotlin.ext.onClick
import sample.wechat.kotlin.ext.toast
import sample.wechat.kotlin.view.main.MainActivity

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity<LoginPresenter<LoginView<MainModel>>>(), LoginView<MainModel> {
    override fun onFaild(error: String)  = toast(error)
    override fun onSuccess(model: MainModel) {
        searchcity.setText(model.weatherinfo?.city)
        searchBtn.text = model.weatherinfo?.city
        result.text =(" ${model.weatherinfo?.temp} \n")
        result.append("${model.weatherinfo?.wse} \n")
        result.append("${model.weatherinfo?.ws} \n")
        result.append("${model.weatherinfo?.njd} \n")
        result.append("${model.weatherinfo?.qy} \n")
        result.append("${model.weatherinfo?.sd} \n")
        hintDialog()
    }
    override fun showDialog() = login_progress.setVisibility(View.VISIBLE)
    override fun hintDialog() = login_progress.setVisibility(View.GONE)
    override fun getLayoutId() = R.layout.activity_login
    override fun createPresenter(): LoginPresenter<LoginView<MainModel>> = LoginPresenter(this)
    override fun initViews() {
        searchBtn.onClick { mPresenter.getWeather("101010100") }
        mainBtn.onClick { startActivity<MainActivity>() }
    }


}

