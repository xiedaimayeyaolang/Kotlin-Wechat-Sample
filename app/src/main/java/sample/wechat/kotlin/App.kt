package sample.wechat.kotlin

import android.support.multidex.MultiDexApplication

/**
 * Created by heping on 2018/2/1.
 */
class App: MultiDexApplication(){
//    init {
//        instance = this
//    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    companion object{
        lateinit var instance: App
    }
}
