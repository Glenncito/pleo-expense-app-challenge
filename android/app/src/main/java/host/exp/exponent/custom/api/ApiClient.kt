package host.exp.exponent.custom.api

import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class ApiClient {
    private var apiService: ApiService

    companion object {
        private val BASE_URL = "http://192.168.0.183:3000/"
        private var instance: ApiClient? = null

        fun getInstance():ApiClient {
            if (instance == null)
            {
                instance = ApiClient()
            }
            return instance as ApiClient
        }
    }

    init{
        val okHttpClient: OkHttpClient? = OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(200000, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(CustomInterceptor())
                .addNetworkInterceptor(CustomInterceptor())
                .build()

        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    fun uploadReceipt(expenseId: String, file:MultipartBody.Part, description: RequestBody): Flowable<ResponseBody>{
        return apiService.uploadReceipt(expenseId, file, description)
    }
}

class CustomInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        Log.d ("Responseee", response.toString())
        return response
    }
}