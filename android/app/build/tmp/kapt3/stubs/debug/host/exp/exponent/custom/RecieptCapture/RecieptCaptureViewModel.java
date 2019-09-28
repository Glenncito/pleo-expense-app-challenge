package host.exp.exponent.custom.RecieptCapture;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lhost/exp/exponent/custom/RecieptCapture/RecieptCaptureViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "repository", "Lhost/exp/exponent/custom/data/Repository;", "insertRecieptDataIntoExpense", "", "recieptByteArray", "", "setSelectedExpenseWithId", "expenseId", "", "uploadReceipt", "Lio/reactivex/Flowable;", "Lokhttp3/ResponseBody;", "filePath", "app_debug"})
public final class RecieptCaptureViewModel extends androidx.lifecycle.AndroidViewModel {
    private host.exp.exponent.custom.data.Repository repository;
    
    public final void insertRecieptDataIntoExpense(@org.jetbrains.annotations.NotNull()
    byte[] recieptByteArray) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final io.reactivex.Flowable<okhttp3.ResponseBody> uploadReceipt(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
    
    public final void setSelectedExpenseWithId(@org.jetbrains.annotations.NotNull()
    java.lang.String expenseId) {
    }
    
    public RecieptCaptureViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}