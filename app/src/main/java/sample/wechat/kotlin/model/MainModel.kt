package allnewapp.kotlinmvp.bean

import sample.wechat.kotlin.base.model.BaseModel


class MainModel : BaseModel(){

    var weatherinfo: WeatherinfoBean? = null

    class WeatherinfoBean {
        var city: String? = null
        var cityid: String? = null
        var temp: String? = null
        var wd: String? = null
        var ws: String? = null
        var sd: String? = null
        var wse: String? = null
        var time: String? = null
//        var isRadar: String? = null
//        var radar: String? = null
        var njd: String? = null
        var qy: String? = null
    }
}
