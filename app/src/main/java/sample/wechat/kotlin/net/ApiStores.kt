package sample.wechat.kotlin.net
import allnewapp.kotlinmvp.bean.MainModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
interface ApiStores {

    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadDataByRetrofit(@Path("cityId") cityId: String): Call<MainModel>

    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadDataByRetrofitRxjava(@Path("cityId") cityId: String): Observable<MainModel>

    companion object {
        //baseUrl
        val API_SERVER_URL = "http://www.weather.com.cn/"
    }

}
