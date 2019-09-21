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
public class host_exp_exponent_models_ExpenseRealmProxy extends host.exp.exponent.models.Expense
    implements RealmObjectProxy, host_exp_exponent_models_ExpenseRealmProxyInterface {

    static final class ExpenseColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long dateIndex;
        long merchantIndex;
        long amountIndex;
        long userIndex;
        long receiptIndex;

        ExpenseColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Expense");
            this.dateIndex = addColumnDetails("date", "date", objectSchemaInfo);
            this.merchantIndex = addColumnDetails("merchant", "merchant", objectSchemaInfo);
            this.amountIndex = addColumnDetails("amount", "amount", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.receiptIndex = addColumnDetails("receipt", "receipt", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ExpenseColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ExpenseColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ExpenseColumnInfo src = (ExpenseColumnInfo) rawSrc;
            final ExpenseColumnInfo dst = (ExpenseColumnInfo) rawDst;
            dst.dateIndex = src.dateIndex;
            dst.merchantIndex = src.merchantIndex;
            dst.amountIndex = src.amountIndex;
            dst.userIndex = src.userIndex;
            dst.receiptIndex = src.receiptIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ExpenseColumnInfo columnInfo;
    private ProxyState<host.exp.exponent.models.Expense> proxyState;

    host_exp_exponent_models_ExpenseRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ExpenseColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<host.exp.exponent.models.Expense>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            }
            row.getTable().setDate(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$merchant() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.merchantIndex);
    }

    @Override
    public void realmSet$merchant(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'merchant' to null.");
            }
            row.getTable().setString(columnInfo.merchantIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'merchant' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.merchantIndex, value);
    }

    @Override
    public host.exp.exponent.models.Amount realmGet$amount() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.amountIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(host.exp.exponent.models.Amount.class, proxyState.getRow$realm().getLink(columnInfo.amountIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$amount(host.exp.exponent.models.Amount value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("amount")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.amountIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.amountIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.amountIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.amountIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public host.exp.exponent.models.User realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(host.exp.exponent.models.User.class, proxyState.getRow$realm().getLink(columnInfo.userIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$user(host.exp.exponent.models.User value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("user")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public byte[] realmGet$receipt() {
        proxyState.getRealm$realm().checkIfValid();
        return (byte[]) proxyState.getRow$realm().getBinaryByteArray(columnInfo.receiptIndex);
    }

    @Override
    public void realmSet$receipt(byte[] value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.receiptIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBinaryByteArray(columnInfo.receiptIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.receiptIndex);
            return;
        }
        proxyState.getRow$realm().setBinaryByteArray(columnInfo.receiptIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Expense", 5, 0);
        builder.addPersistedProperty("date", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("merchant", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("amount", RealmFieldType.OBJECT, "Amount");
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "User");
        builder.addPersistedProperty("receipt", RealmFieldType.BINARY, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ExpenseColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ExpenseColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Expense";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Expense";
    }

    @SuppressWarnings("cast")
    public static host.exp.exponent.models.Expense createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        if (json.has("amount")) {
            excludeFields.add("amount");
        }
        if (json.has("user")) {
            excludeFields.add("user");
        }
        host.exp.exponent.models.Expense obj = realm.createObjectInternal(host.exp.exponent.models.Expense.class, true, excludeFields);

        final host_exp_exponent_models_ExpenseRealmProxyInterface objProxy = (host_exp_exponent_models_ExpenseRealmProxyInterface) obj;
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                Object timestamp = json.get("date");
                if (timestamp instanceof String) {
                    objProxy.realmSet$date(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$date(new Date(json.getLong("date")));
                }
            }
        }
        if (json.has("merchant")) {
            if (json.isNull("merchant")) {
                objProxy.realmSet$merchant(null);
            } else {
                objProxy.realmSet$merchant((String) json.getString("merchant"));
            }
        }
        if (json.has("amount")) {
            if (json.isNull("amount")) {
                objProxy.realmSet$amount(null);
            } else {
                host.exp.exponent.models.Amount amountObj = host_exp_exponent_models_AmountRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("amount"), update);
                objProxy.realmSet$amount(amountObj);
            }
        }
        if (json.has("user")) {
            if (json.isNull("user")) {
                objProxy.realmSet$user(null);
            } else {
                host.exp.exponent.models.User userObj = host_exp_exponent_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("user"), update);
                objProxy.realmSet$user(userObj);
            }
        }
        if (json.has("receipt")) {
            if (json.isNull("receipt")) {
                objProxy.realmSet$receipt(null);
            } else {
                objProxy.realmSet$receipt(JsonUtils.stringToBytes(json.getString("receipt")));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static host.exp.exponent.models.Expense createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final host.exp.exponent.models.Expense obj = new host.exp.exponent.models.Expense();
        final host_exp_exponent_models_ExpenseRealmProxyInterface objProxy = (host_exp_exponent_models_ExpenseRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$date(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$date(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("merchant")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$merchant((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$merchant(null);
                }
            } else if (name.equals("amount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$amount(null);
                } else {
                    host.exp.exponent.models.Amount amountObj = host_exp_exponent_models_AmountRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$amount(amountObj);
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    host.exp.exponent.models.User userObj = host_exp_exponent_models_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("receipt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$receipt(JsonUtils.stringToBytes(reader.nextString()));
                } else {
                    reader.skipValue();
                    objProxy.realmSet$receipt(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static host_exp_exponent_models_ExpenseRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class), false, Collections.<String>emptyList());
        io.realm.host_exp_exponent_models_ExpenseRealmProxy obj = new io.realm.host_exp_exponent_models_ExpenseRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static host.exp.exponent.models.Expense copyOrUpdate(Realm realm, ExpenseColumnInfo columnInfo, host.exp.exponent.models.Expense object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (host.exp.exponent.models.Expense) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static host.exp.exponent.models.Expense copy(Realm realm, ExpenseColumnInfo columnInfo, host.exp.exponent.models.Expense newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (host.exp.exponent.models.Expense) cachedRealmObject;
        }

        host_exp_exponent_models_ExpenseRealmProxyInterface realmObjectSource = (host_exp_exponent_models_ExpenseRealmProxyInterface) newObject;

        Table table = realm.getTable(host.exp.exponent.models.Expense.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addDate(columnInfo.dateIndex, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.merchantIndex, realmObjectSource.realmGet$merchant());
        builder.addByteArray(columnInfo.receiptIndex, realmObjectSource.realmGet$receipt());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.host_exp_exponent_models_ExpenseRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        // Finally add all fields that reference other Realm Objects, either directly or through a list
        host.exp.exponent.models.Amount amountObj = realmObjectSource.realmGet$amount();
        if (amountObj == null) {
            realmObjectCopy.realmSet$amount(null);
        } else {
            host.exp.exponent.models.Amount cacheamount = (host.exp.exponent.models.Amount) cache.get(amountObj);
            if (cacheamount != null) {
                realmObjectCopy.realmSet$amount(cacheamount);
            } else {
                realmObjectCopy.realmSet$amount(host_exp_exponent_models_AmountRealmProxy.copyOrUpdate(realm, (host_exp_exponent_models_AmountRealmProxy.AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class), amountObj, update, cache, flags));
            }
        }

        host.exp.exponent.models.User userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            realmObjectCopy.realmSet$user(null);
        } else {
            host.exp.exponent.models.User cacheuser = (host.exp.exponent.models.User) cache.get(userObj);
            if (cacheuser != null) {
                realmObjectCopy.realmSet$user(cacheuser);
            } else {
                realmObjectCopy.realmSet$user(host_exp_exponent_models_UserRealmProxy.copyOrUpdate(realm, (host_exp_exponent_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.User.class), userObj, update, cache, flags));
            }
        }

        return realmObjectCopy;
    }

    public static long insert(Realm realm, host.exp.exponent.models.Expense object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.models.Expense.class);
        long tableNativePtr = table.getNativePtr();
        ExpenseColumnInfo columnInfo = (ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        java.util.Date realmGet$date = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        }
        String realmGet$merchant = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$merchant();
        if (realmGet$merchant != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.merchantIndex, rowIndex, realmGet$merchant, false);
        }

        host.exp.exponent.models.Amount amountObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$amount();
        if (amountObj != null) {
            Long cacheamount = cache.get(amountObj);
            if (cacheamount == null) {
                cacheamount = host_exp_exponent_models_AmountRealmProxy.insert(realm, amountObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.amountIndex, rowIndex, cacheamount, false);
        }

        host.exp.exponent.models.User userObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = host_exp_exponent_models_UserRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }
        byte[] realmGet$receipt = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$receipt();
        if (realmGet$receipt != null) {
            Table.nativeSetByteArray(tableNativePtr, columnInfo.receiptIndex, rowIndex, realmGet$receipt, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.models.Expense.class);
        long tableNativePtr = table.getNativePtr();
        ExpenseColumnInfo columnInfo = (ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class);
        host.exp.exponent.models.Expense object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.models.Expense) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            java.util.Date realmGet$date = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
            }
            String realmGet$merchant = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$merchant();
            if (realmGet$merchant != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.merchantIndex, rowIndex, realmGet$merchant, false);
            }

            host.exp.exponent.models.Amount amountObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$amount();
            if (amountObj != null) {
                Long cacheamount = cache.get(amountObj);
                if (cacheamount == null) {
                    cacheamount = host_exp_exponent_models_AmountRealmProxy.insert(realm, amountObj, cache);
                }
                table.setLink(columnInfo.amountIndex, rowIndex, cacheamount, false);
            }

            host.exp.exponent.models.User userObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = host_exp_exponent_models_UserRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }
            byte[] realmGet$receipt = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$receipt();
            if (realmGet$receipt != null) {
                Table.nativeSetByteArray(tableNativePtr, columnInfo.receiptIndex, rowIndex, realmGet$receipt, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, host.exp.exponent.models.Expense object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(host.exp.exponent.models.Expense.class);
        long tableNativePtr = table.getNativePtr();
        ExpenseColumnInfo columnInfo = (ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        java.util.Date realmGet$date = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$merchant = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$merchant();
        if (realmGet$merchant != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.merchantIndex, rowIndex, realmGet$merchant, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.merchantIndex, rowIndex, false);
        }

        host.exp.exponent.models.Amount amountObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$amount();
        if (amountObj != null) {
            Long cacheamount = cache.get(amountObj);
            if (cacheamount == null) {
                cacheamount = host_exp_exponent_models_AmountRealmProxy.insertOrUpdate(realm, amountObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.amountIndex, rowIndex, cacheamount, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.amountIndex, rowIndex);
        }

        host.exp.exponent.models.User userObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = host_exp_exponent_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }
        byte[] realmGet$receipt = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$receipt();
        if (realmGet$receipt != null) {
            Table.nativeSetByteArray(tableNativePtr, columnInfo.receiptIndex, rowIndex, realmGet$receipt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.receiptIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(host.exp.exponent.models.Expense.class);
        long tableNativePtr = table.getNativePtr();
        ExpenseColumnInfo columnInfo = (ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class);
        host.exp.exponent.models.Expense object = null;
        while (objects.hasNext()) {
            object = (host.exp.exponent.models.Expense) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            java.util.Date realmGet$date = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
            }
            String realmGet$merchant = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$merchant();
            if (realmGet$merchant != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.merchantIndex, rowIndex, realmGet$merchant, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.merchantIndex, rowIndex, false);
            }

            host.exp.exponent.models.Amount amountObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$amount();
            if (amountObj != null) {
                Long cacheamount = cache.get(amountObj);
                if (cacheamount == null) {
                    cacheamount = host_exp_exponent_models_AmountRealmProxy.insertOrUpdate(realm, amountObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.amountIndex, rowIndex, cacheamount, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.amountIndex, rowIndex);
            }

            host.exp.exponent.models.User userObj = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = host_exp_exponent_models_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }
            byte[] realmGet$receipt = ((host_exp_exponent_models_ExpenseRealmProxyInterface) object).realmGet$receipt();
            if (realmGet$receipt != null) {
                Table.nativeSetByteArray(tableNativePtr, columnInfo.receiptIndex, rowIndex, realmGet$receipt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.receiptIndex, rowIndex, false);
            }
        }
    }

    public static host.exp.exponent.models.Expense createDetachedCopy(host.exp.exponent.models.Expense realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        host.exp.exponent.models.Expense unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new host.exp.exponent.models.Expense();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (host.exp.exponent.models.Expense) cachedObject.object;
            }
            unmanagedObject = (host.exp.exponent.models.Expense) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        host_exp_exponent_models_ExpenseRealmProxyInterface unmanagedCopy = (host_exp_exponent_models_ExpenseRealmProxyInterface) unmanagedObject;
        host_exp_exponent_models_ExpenseRealmProxyInterface realmSource = (host_exp_exponent_models_ExpenseRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$merchant(realmSource.realmGet$merchant());

        // Deep copy of amount
        unmanagedCopy.realmSet$amount(host_exp_exponent_models_AmountRealmProxy.createDetachedCopy(realmSource.realmGet$amount(), currentDepth + 1, maxDepth, cache));

        // Deep copy of user
        unmanagedCopy.realmSet$user(host_exp_exponent_models_UserRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$receipt(realmSource.realmGet$receipt());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Expense = proxy[");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{merchant:");
        stringBuilder.append(realmGet$merchant());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{amount:");
        stringBuilder.append(realmGet$amount() != null ? "Amount" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "User" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{receipt:");
        stringBuilder.append(realmGet$receipt() != null ? realmGet$receipt() : "null");
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
        host_exp_exponent_models_ExpenseRealmProxy aExpense = (host_exp_exponent_models_ExpenseRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aExpense.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aExpense.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aExpense.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
