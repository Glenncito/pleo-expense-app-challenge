package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class host_exp_exponent_custom_data_models_UserRealmProxy extends host.exp.exponent.custom.data.models.User
    implements RealmObjectProxy, host_exp_exponent_custom_data_models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long firstIndex;
        long lastIndex;
        long emailIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("user");
            this.firstIndex = addColumnDetails("first", "first", objectSchemaInfo);
            this.lastIndex = addColumnDetails("last", "last", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.firstIndex = src.firstIndex;
            dst.lastIndex = src.lastIndex;
            dst.emailIndex = src.emailIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<host.exp.exponent.custom.data.models.User> proxyState;

    host_exp_exponent_custom_data_models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<host.exp.exponent.custom.data.models.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$first() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstIndex);
    }

    @Override
    public void realmSet$first(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'first' to null.");
            }
            row.getTable().setString(columnInfo.firstIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'first' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.firstIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$last() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastIndex);
    }

    @Override
    public void realmSet$last(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'last' to null.");
            }
            row.getTable().setString(columnInfo.lastIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'last' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.lastIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'email' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("user", 3, 0);
        builder.addPersistedProperty("first", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("last", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "user";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "user";
    }

    @SuppressWarnings("cast")
    public static host.exp.exponent.custom.data.models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        host.exp.exponent.custom.data.models.User obj = realm.createObjectInternal(host.exp.exponent.custom.data.models.User.class, true, excludeFields);

        final host_exp_exponent_custom_data_models_UserRealmProxyInterface objProxy = (host_exp_exponent_custom_data_models_UserRealmProxyInterface) obj;
        if (json.has("first")) {
            if (json.isNull("first")) {
                objProxy.realmSet$first(null);
            } else {
                objProxy.realmSet$first((String) json.getString("first"));
            }
        }
        if (json.has("last")) {
            if (json.isNull("last")) {
                objProxy.realmSet$last(null);
            } else {
                objProxy.realmSet$last((String) json.getString("last"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static host.exp.exponent.custom.data.models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final host.exp.exponent.custom.data.models.User obj = new host.exp.exponent.custom.data.models.User();
        final host_exp_exponent_custom_data_models_UserRealmProxyInterface objProxy = (host_exp_exponent_custom_data_models_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("first")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$first((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$first(null);
                }
            } else if (name.equals("last")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$last((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$last(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static host_exp_exponent_custom_data_models_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class), false, Collections.<String>emptyList());
        io.realm.host_exp_exponent_custom_data_models_UserRealmProxy obj = new io.realm.host_exp_exponent_custom_data_models_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static host.exp.exponent.custom.data.models.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, host.exp.exponent.custom.data.models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (host.exp.exponent.custom.data.models.User) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static host.exp.exponent.custom.data.models.User copy(Realm realm, UserColumnInfo columnInfo, host.exp.exponent.custom.data.models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (host.exp.exponent.custom.data.models.User) cachedRealmObject;
        }

        host_exp_exponent_custom_data_models_UserRealmProxyInterface realmObjectSource = (host_exp_exponent_custom_data_models_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(host.exp.exponent.custom.data.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.firstIndex, realmObjectSource.realmGet$first());
        builder.addString(columnInfo.lastIndex, realmObjectSource.realmGet$last());
        builder.addString(columnInfo.emailIndex, realmObjectSource.realmGet$email());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.host_exp_exponent_custom_data_models_UserRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, host.exp.exponent.custom.data.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.custom.data.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$first = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$first();
        if (realmGet$first != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstIndex, rowIndex, realmGet$first, false);
        }
        String realmGet$last = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$last();
        if (realmGet$last != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastIndex, rowIndex, realmGet$last, false);
        }
        String realmGet$email = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.custom.data.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class);
        host.exp.exponent.custom.data.models.User object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.custom.data.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$first = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$first();
            if (realmGet$first != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstIndex, rowIndex, realmGet$first, false);
            }
            String realmGet$last = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$last();
            if (realmGet$last != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastIndex, rowIndex, realmGet$last, false);
            }
            String realmGet$email = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, host.exp.exponent.custom.data.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.custom.data.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$first = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$first();
        if (realmGet$first != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstIndex, rowIndex, realmGet$first, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstIndex, rowIndex, false);
        }
        String realmGet$last = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$last();
        if (realmGet$last != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastIndex, rowIndex, realmGet$last, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastIndex, rowIndex, false);
        }
        String realmGet$email = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.custom.data.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class);
        host.exp.exponent.custom.data.models.User object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.custom.data.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$first = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$first();
            if (realmGet$first != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstIndex, rowIndex, realmGet$first, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.firstIndex, rowIndex, false);
            }
            String realmGet$last = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$last();
            if (realmGet$last != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastIndex, rowIndex, realmGet$last, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastIndex, rowIndex, false);
            }
            String realmGet$email = ((host_exp_exponent_custom_data_models_UserRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
        }
    }

    public static host.exp.exponent.custom.data.models.User createDetachedCopy(host.exp.exponent.custom.data.models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        host.exp.exponent.custom.data.models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new host.exp.exponent.custom.data.models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (host.exp.exponent.custom.data.models.User) cachedObject.object;
            }
            unmanagedObject = (host.exp.exponent.custom.data.models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        host_exp_exponent_custom_data_models_UserRealmProxyInterface unmanagedCopy = (host_exp_exponent_custom_data_models_UserRealmProxyInterface) unmanagedObject;
        host_exp_exponent_custom_data_models_UserRealmProxyInterface realmSource = (host_exp_exponent_custom_data_models_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$first(realmSource.realmGet$first());
        unmanagedCopy.realmSet$last(realmSource.realmGet$last());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{first:");
        stringBuilder.append(realmGet$first());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{last:");
        stringBuilder.append(realmGet$last());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        host_exp_exponent_custom_data_models_UserRealmProxy aUser = (host_exp_exponent_custom_data_models_UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
