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
public class host_exp_exponent_models_AmountRealmProxy extends host.exp.exponent.models.Amount
    implements RealmObjectProxy, host_exp_exponent_models_AmountRealmProxyInterface {

    static final class AmountColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long valueIndex;
        long currencyIndex;

        AmountColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Amount");
            this.valueIndex = addColumnDetails("value", "value", objectSchemaInfo);
            this.currencyIndex = addColumnDetails("currency", "currency", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        AmountColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AmountColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AmountColumnInfo src = (AmountColumnInfo) rawSrc;
            final AmountColumnInfo dst = (AmountColumnInfo) rawDst;
            dst.valueIndex = src.valueIndex;
            dst.currencyIndex = src.currencyIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AmountColumnInfo columnInfo;
    private ProxyState<host.exp.exponent.models.Amount> proxyState;

    host_exp_exponent_models_AmountRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AmountColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<host.exp.exponent.models.Amount>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.valueIndex);
    }

    @Override
    public void realmSet$value(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
            }
            row.getTable().setString(columnInfo.valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.valueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$currency() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.currencyIndex);
    }

    @Override
    public void realmSet$currency(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'currency' to null.");
            }
            row.getTable().setString(columnInfo.currencyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'currency' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.currencyIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Amount", 2, 0);
        builder.addPersistedProperty("value", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("currency", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AmountColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AmountColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Amount";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Amount";
    }

    @SuppressWarnings("cast")
    public static host.exp.exponent.models.Amount createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        host.exp.exponent.models.Amount obj = realm.createObjectInternal(host.exp.exponent.models.Amount.class, true, excludeFields);

        final host_exp_exponent_models_AmountRealmProxyInterface objProxy = (host_exp_exponent_models_AmountRealmProxyInterface) obj;
        if (json.has("value")) {
            if (json.isNull("value")) {
                objProxy.realmSet$value(null);
            } else {
                objProxy.realmSet$value((String) json.getString("value"));
            }
        }
        if (json.has("currency")) {
            if (json.isNull("currency")) {
                objProxy.realmSet$currency(null);
            } else {
                objProxy.realmSet$currency((String) json.getString("currency"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static host.exp.exponent.models.Amount createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final host.exp.exponent.models.Amount obj = new host.exp.exponent.models.Amount();
        final host_exp_exponent_models_AmountRealmProxyInterface objProxy = (host_exp_exponent_models_AmountRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$value((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$value(null);
                }
            } else if (name.equals("currency")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$currency((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$currency(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static host_exp_exponent_models_AmountRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class), false, Collections.<String>emptyList());
        io.realm.host_exp_exponent_models_AmountRealmProxy obj = new io.realm.host_exp_exponent_models_AmountRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static host.exp.exponent.models.Amount copyOrUpdate(Realm realm, AmountColumnInfo columnInfo, host.exp.exponent.models.Amount object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (host.exp.exponent.models.Amount) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static host.exp.exponent.models.Amount copy(Realm realm, AmountColumnInfo columnInfo, host.exp.exponent.models.Amount newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (host.exp.exponent.models.Amount) cachedRealmObject;
        }

        host_exp_exponent_models_AmountRealmProxyInterface realmObjectSource = (host_exp_exponent_models_AmountRealmProxyInterface) newObject;

        Table table = realm.getTable(host.exp.exponent.models.Amount.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.valueIndex, realmObjectSource.realmGet$value());
        builder.addString(columnInfo.currencyIndex, realmObjectSource.realmGet$currency());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.host_exp_exponent_models_AmountRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, host.exp.exponent.models.Amount object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.models.Amount.class);
        long tableNativePtr = table.getNativePtr();
        AmountColumnInfo columnInfo = (AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$value = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        }
        String realmGet$currency = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$currency();
        if (realmGet$currency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.models.Amount.class);
        long tableNativePtr = table.getNativePtr();
        AmountColumnInfo columnInfo = (AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class);
        host.exp.exponent.models.Amount object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.models.Amount) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$value = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            }
            String realmGet$currency = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$currency();
            if (realmGet$currency != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, host.exp.exponent.models.Amount object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.models.Amount.class);
        long tableNativePtr = table.getNativePtr();
        AmountColumnInfo columnInfo = (AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$value = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
        }
        String realmGet$currency = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$currency();
        if (realmGet$currency != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.currencyIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.models.Amount.class);
        long tableNativePtr = table.getNativePtr();
        AmountColumnInfo columnInfo = (AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class);
        host.exp.exponent.models.Amount object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.models.Amount) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$value = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
            }
            String realmGet$currency = ((host_exp_exponent_models_AmountRealmProxyInterface) object).realmGet$currency();
            if (realmGet$currency != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currencyIndex, rowIndex, realmGet$currency, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.currencyIndex, rowIndex, false);
            }
        }
    }

    public static host.exp.exponent.models.Amount createDetachedCopy(host.exp.exponent.models.Amount realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        host.exp.exponent.models.Amount unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new host.exp.exponent.models.Amount();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (host.exp.exponent.models.Amount) cachedObject.object;
            }
            unmanagedObject = (host.exp.exponent.models.Amount) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        host_exp_exponent_models_AmountRealmProxyInterface unmanagedCopy = (host_exp_exponent_models_AmountRealmProxyInterface) unmanagedObject;
        host_exp_exponent_models_AmountRealmProxyInterface realmSource = (host_exp_exponent_models_AmountRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$value(realmSource.realmGet$value());
        unmanagedCopy.realmSet$currency(realmSource.realmGet$currency());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Amount = proxy[");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currency:");
        stringBuilder.append(realmGet$currency());
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
        host_exp_exponent_models_AmountRealmProxy aAmount = (host_exp_exponent_models_AmountRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAmount.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAmount.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAmount.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
