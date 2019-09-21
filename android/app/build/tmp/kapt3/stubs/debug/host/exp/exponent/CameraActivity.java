package host.exp.exponent;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020#J\"\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J-\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00042\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150.2\u0006\u0010/\u001a\u000200H\u0016\u00a2\u0006\u0002\u00101J\u0006\u00102\u001a\u00020#J\b\u00103\u001a\u00020#H\u0002J\u001e\u00104\u001a\u00020#2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u000209J\u0018\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006@"}, d2 = {"Lhost/exp/exponent/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "PERMISSION_REQUEST_CODE", "", "REQUEST_IMAGE_CAPTURE", "getREQUEST_IMAGE_CAPTURE", "()I", "captureButton", "Landroid/widget/Button;", "getCaptureButton", "()Landroid/widget/Button;", "setCaptureButton", "(Landroid/widget/Button;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "mCurrentPhotoPath", "", "realm", "Lio/realm/Realm;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "checkPersmission", "", "createFile", "Ljava/io/File;", "getFirstExpense", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "randomQuery", "requestPermission", "sendEvent", "context", "Lcom/facebook/react/bridge/ReactContext;", "eventName", "params", "Lcom/facebook/react/bridge/WritableMap;", "storeReciept", "expense", "Lhost/exp/exponent/models/Expense;", "byteArray", "", "takePicture", "app_debug"})
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView imageView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button captureButton;
    private io.realm.Realm realm;
    private final int REQUEST_IMAGE_CAPTURE = 1;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri uri;
    private final int PERMISSION_REQUEST_CODE = 101;
    private java.lang.String mCurrentPhotoPath;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getImageView() {
        return null;
    }
    
    public final void setImageView(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getCaptureButton() {
        return null;
    }
    
    public final void setCaptureButton(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    public final int getREQUEST_IMAGE_CAPTURE() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void takePicture() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void randomQuery() {
    }
    
    public final void getFirstExpense() {
    }
    
    private final void storeReciept(host.exp.exponent.models.Expense expense, byte[] byteArray) {
    }
    
    public final void sendEvent(@org.jetbrains.annotations.NotNull()
    com.facebook.react.bridge.ReactContext context, @org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.NotNull()
    com.facebook.react.bridge.WritableMap params) {
    }
    
    private final boolean checkPersmission() {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    private final java.io.File createFile() throws java.io.IOException {
        return null;
    }
    
    public CameraActivity() {
        super();
    }
}