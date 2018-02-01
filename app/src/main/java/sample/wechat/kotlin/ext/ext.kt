package sample.wechat.kotlin.ext

import android.app.Activity
import android.widget.Toast
import java.time.Duration

/**
 * Created by heping on 2018/1/31.
 */
fun android.view.View.onClick(l: (v: android.view.View?) -> Unit) {
    setOnClickListener(l)
}
fun Activity.toast(msg: String = "this is a toast",duration: Int = Toast.LENGTH_LONG){
    Toast.makeText(this,msg,duration)
}
