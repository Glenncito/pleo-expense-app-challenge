package host.exp.exponent.custom.data.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006-"}, d2 = {"Lhost/exp/exponent/custom/data/models/Expense;", "Lio/realm/RealmObject;", "id", "", "date", "merchant", "amount", "Lhost/exp/exponent/custom/data/models/Amount;", "category", "comment", "user", "Lhost/exp/exponent/custom/data/models/User;", "receipt", "", "index", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lhost/exp/exponent/custom/data/models/Amount;Ljava/lang/String;Ljava/lang/String;Lhost/exp/exponent/custom/data/models/User;[BI)V", "getAmount", "()Lhost/exp/exponent/custom/data/models/Amount;", "setAmount", "(Lhost/exp/exponent/custom/data/models/Amount;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getComment", "setComment", "getDate", "setDate", "getId", "setId", "getIndex", "()I", "setIndex", "(I)V", "getMerchant", "setMerchant", "getReceipt", "()[B", "setReceipt", "([B)V", "getUser", "()Lhost/exp/exponent/custom/data/models/User;", "setUser", "(Lhost/exp/exponent/custom/data/models/User;)V", "app_debug"})
@io.realm.annotations.RealmClass(name = "expense")
public class Expense extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.PrimaryKey()
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String date;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String merchant;
    @org.jetbrains.annotations.Nullable()
    private host.exp.exponent.custom.data.models.Amount amount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String category;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String comment;
    @org.jetbrains.annotations.Nullable()
    private host.exp.exponent.custom.data.models.User user;
    @org.jetbrains.annotations.Nullable()
    private byte[] receipt;
    private int index;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMerchant() {
        return null;
    }
    
    public final void setMerchant(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final host.exp.exponent.custom.data.models.Amount getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.Nullable()
    host.exp.exponent.custom.data.models.Amount p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final void setComment(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final host.exp.exponent.custom.data.models.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    host.exp.exponent.custom.data.models.User p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final byte[] getReceipt() {
        return null;
    }
    
    public final void setReceipt(@org.jetbrains.annotations.Nullable()
    byte[] p0) {
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    public Expense(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String merchant, @org.jetbrains.annotations.Nullable()
    host.exp.exponent.custom.data.models.Amount amount, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    host.exp.exponent.custom.data.models.User user, @org.jetbrains.annotations.Nullable()
    byte[] receipt, int index) {
        super();
    }
    
    public Expense() {
        super();
    }
}