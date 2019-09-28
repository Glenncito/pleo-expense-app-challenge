package host.exp.exponent.custom.api

import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {
    @Multipart
    @POST("expenses/{id}/receipts")
    fun uploadReceipt (@Path("id") id: String, @Part file: MultipartBody.Part, @Part("name") body: RequestBody): Flowable<ResponseBody>
}