package host.exp.exponent.custom.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lhost/exp/exponent/custom/api/ApiService;", "", "uploadReceipt", "Lio/reactivex/Flowable;", "Lokhttp3/ResponseBody;", "id", "", "file", "Lokhttp3/MultipartBody$Part;", "body", "Lokhttp3/RequestBody;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "expenses/{id}/receipts")
    @retrofit2.http.Multipart()
    public abstract io.reactivex.Flowable<okhttp3.ResponseBody> uploadReceipt(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "name")
    okhttp3.RequestBody body);
}