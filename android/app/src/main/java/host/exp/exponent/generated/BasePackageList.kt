package host.exp.exponent.generated

import java.util.Arrays
import org.unimodules.core.interfaces.Package

class BasePackageList {
    val packageList: List<Package>
        get() = Arrays.asList(
                expo.modules.constants.ConstantsPackage(),
                expo.modules.filesystem.FileSystemPackage(),
                expo.modules.font.FontLoaderPackage(),
                expo.modules.keepawake.KeepAwakePackage(),
                expo.modules.lineargradient.LinearGradientPackage(),
                expo.modules.location.LocationPackage(),
                expo.modules.permissions.PermissionsPackage(),
                expo.modules.sqlite.SQLitePackage(),
                expo.modules.webbrowser.WebBrowserPackage()
        )
}
