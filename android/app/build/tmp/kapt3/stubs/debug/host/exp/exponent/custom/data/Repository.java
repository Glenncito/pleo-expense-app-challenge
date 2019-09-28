package host.exp.exponent.custom.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lhost/exp/exponent/custom/data/Repository;", "", "()V", "database", "Lhost/exp/exponent/custom/data/DatabaseHelper;", "expense", "Lhost/exp/exponent/custom/data/models/Expense;", "insertRecieptDataIntoExpense", "", "recieptByteArray", "", "setSelectedExpenseWithId", "expenseId", "", "uploadReceipt", "Lio/reactivex/Flowable;", "Lokhttp3/ResponseBody;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "app_debug"})
public final class Repository {
    private host.exp.exponent.custom.data.models.Expense expense;
    private host.exp.exponent.custom.data.DatabaseHelper database;
    
    public final void insertRecieptDataIntoExpense(@org.jetbrains.annotations.NotNull()
    byte[] recieptByteArray) {
    }
    
    public final void setSelectedExpenseWithId(@org.jetbrains.annotations.NotNull()
    java.lang.String expenseId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<okhttp3.ResponseBody> uploadReceipt(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody description) {
        return null;
    }
    
    public Repository() {
        super();
    }
}