package host.exp.exponent

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.react.ReactPackage
import com.facebook.react.shell.MainReactPackage

import org.unimodules.core.interfaces.Package

import java.util.Arrays

import expo.loaders.provider.interfaces.AppLoaderPackagesProviderInterface
import host.exp.exponent.generated.BasePackageList
import io.realm.react.RealmReactPackage
import okhttp3.OkHttpClient

// Needed for `react-native link`
// import com.facebook.react.ReactApplication;

class MainApplication : ExpoApplication(), AppLoaderPackagesProviderInterface<ReactPackage> {

    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun getPackages(): List<ReactPackage> {
        return Arrays.asList(
                NativeCameraPackage(),
                RealmReactPackage()

                // TODO: add native modules!

                // Needed for `react-native link`
                // new MainReactPackage()
        )
    }

    override fun getExpoPackages(): List<Package> {
        return BasePackageList().packageList
    }

    override fun gcmSenderId(): String {
        return getString(R.string.gcm_defaultSenderId)
    }

    companion object {


        fun okHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
            // Customize/override OkHttp client here
            return builder
        }
    }

}
