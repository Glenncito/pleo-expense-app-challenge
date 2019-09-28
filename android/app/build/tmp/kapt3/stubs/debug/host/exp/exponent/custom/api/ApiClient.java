package host.exp.exponent.custom.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lhost/exp/exponent/custom/api/ApiClient;", "", "()V", "apiService", "Lhost/exp/exponent/custom/api/ApiService;", "uploadReceipt", "Lio/reactivex/Flowable;", "Lokhttp3/ResponseBody;", "expenseId", "", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "Companion", "app_debug"})
public final class ApiClient {
    private host.exp.exponent.custom.api.ApiService apiService;
    private static final java.lang.String BASE_URL = "http://192.168.0.183:3000/";
    private static host.exp.exponent.custom.api.ApiClient instance;
    public static final host.exp.exponent.custom.api.ApiClient.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<okhttp3.ResponseBody> uploadReceipt(@org.jetbrains.annotations.NotNull()
    java.lang.String expenseId, @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody description) {
        return null;
    }
    
    public ApiClient() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lhost/exp/exponent/custom/api/ApiClient$Companion;", "", "()V", "BASE_URL", "", "instance", "Lhost/exp/exponent/custom/api/ApiClient;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final host.exp.exponent.custom.api.ApiClient getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}