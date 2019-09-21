package host.exp.exponent.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0016\b\u0017\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lhost/exp/exponent/models/Expense;", "Lio/realm/RealmObject;", "date", "Ljava/util/Date;", "merchant", "", "amount", "Lhost/exp/exponent/models/Amount;", "user", "Lhost/exp/exponent/models/User;", "receipt", "", "(Ljava/util/Date;Ljava/lang/String;Lhost/exp/exponent/models/Amount;Lhost/exp/exponent/models/User;[B)V", "getAmount", "()Lhost/exp/exponent/models/Amount;", "setAmount", "(Lhost/exp/exponent/models/Amount;)V", "getDate", "()Ljava/util/Date;", "setDate", "(Ljava/util/Date;)V", "getMerchant", "()Ljava/lang/String;", "setMerchant", "(Ljava/lang/String;)V", "getReceipt", "()[B", "setReceipt", "([B)V", "getUser", "()Lhost/exp/exponent/models/User;", "setUser", "(Lhost/exp/exponent/models/User;)V", "app_debug"})
@io.realm.annotations.RealmClass()
public class Expense extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull()
    private java.util.Date date;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String merchant;
    @org.jetbrains.annotations.Nullable()
    private host.exp.exponent.models.Amount amount;
    @org.jetbrains.annotations.Nullable()
    private host.exp.exponent.models.User user;
    @org.jetbrains.annotations.Nullable()
    private byte[] receipt;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchant() {
        return null;
    }
    
    public final void setMerchant(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final host.exp.exponent.models.Amount getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.Nullable()
    host.exp.exponent.models.Amount p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final host.exp.exponent.models.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    host.exp.exponent.models.User p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getReceipt() {
        return null;
    }
    
    public final void setReceipt(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    public Expense(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    java.lang.String merchant, @org.jetbrains.annotations.Nullable()
    host.exp.exponent.models.Amount amount, @org.jetbrains.annotations.Nullable()
    host.exp.exponent.models.User user, @org.jetbrains.annotations.Nullable()
    byte[] receipt) {
        super();
    }
    
    public Expense() {
        super();
    }
}