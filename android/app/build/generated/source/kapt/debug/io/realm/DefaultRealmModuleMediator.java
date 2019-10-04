package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(6);
        modelClasses.add(host.exp.exponent.models.Expense.class);
        modelClasses.add(host.exp.exponent.models.Amount.class);
        modelClasses.add(host.exp.exponent.models.User.class);
        modelClasses.add(host.exp.exponent.custom.data.models.Expense.class);
        modelClasses.add(host.exp.exponent.custom.data.models.Amount.class);
        modelClasses.add(host.exp.exponent.custom.data.models.User.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(6);
        infoMap.put(host.exp.exponent.models.Expense.class, io.realm.host_exp_exponent_models_ExpenseRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(host.exp.exponent.models.Amount.class, io.realm.host_exp_exponent_models_AmountRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(host.exp.exponent.models.User.class, io.realm.host_exp_exponent_models_UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(host.exp.exponent.custom.data.models.Expense.class, io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(host.exp.exponent.custom.data.models.Amount.class, io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(host.exp.exponent.custom.data.models.User.class, io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            return io.realm.host_exp_exponent_models_ExpenseRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            return io.realm.host_exp_exponent_models_AmountRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            return io.realm.host_exp_exponent_models_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            return io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            return io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            return io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            return "Expense";
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            return "Amount";
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            return "User";
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            return "expense";
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            return "amount";
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            return "user";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(host.exp.exponent.models.Expense.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_models_ExpenseRealmProxy());
            }
            if (clazz.equals(host.exp.exponent.models.Amount.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_models_AmountRealmProxy());
            }
            if (clazz.equals(host.exp.exponent.models.User.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_models_UserRealmProxy());
            }
            if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy());
            }
            if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy());
            }
            if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
                return clazz.cast(new io.realm.host_exp_exponent_custom_data_models_UserRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            host_exp_exponent_models_ExpenseRealmProxy.ExpenseColumnInfo columnInfo = (host_exp_exponent_models_ExpenseRealmProxy.ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Expense.class);
            return clazz.cast(io.realm.host_exp_exponent_models_ExpenseRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.models.Expense) obj, update, cache, flags));
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            host_exp_exponent_models_AmountRealmProxy.AmountColumnInfo columnInfo = (host_exp_exponent_models_AmountRealmProxy.AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.Amount.class);
            return clazz.cast(io.realm.host_exp_exponent_models_AmountRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.models.Amount) obj, update, cache, flags));
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            host_exp_exponent_models_UserRealmProxy.UserColumnInfo columnInfo = (host_exp_exponent_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.models.User.class);
            return clazz.cast(io.realm.host_exp_exponent_models_UserRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.models.User) obj, update, cache, flags));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            host_exp_exponent_custom_data_models_ExpenseRealmProxy.ExpenseColumnInfo columnInfo = (host_exp_exponent_custom_data_models_ExpenseRealmProxy.ExpenseColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.Expense.class);
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.custom.data.models.Expense) obj, update, cache, flags));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            host_exp_exponent_custom_data_models_AmountRealmProxy.AmountColumnInfo columnInfo = (host_exp_exponent_custom_data_models_AmountRealmProxy.AmountColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.Amount.class);
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.custom.data.models.Amount) obj, update, cache, flags));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            host_exp_exponent_custom_data_models_UserRealmProxy.UserColumnInfo columnInfo = (host_exp_exponent_custom_data_models_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(host.exp.exponent.custom.data.models.User.class);
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.copyOrUpdate(realm, columnInfo, (host.exp.exponent.custom.data.models.User) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            io.realm.host_exp_exponent_models_ExpenseRealmProxy.insert(realm, (host.exp.exponent.models.Expense) object, cache);
        } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            io.realm.host_exp_exponent_models_AmountRealmProxy.insert(realm, (host.exp.exponent.models.Amount) object, cache);
        } else if (clazz.equals(host.exp.exponent.models.User.class)) {
            io.realm.host_exp_exponent_models_UserRealmProxy.insert(realm, (host.exp.exponent.models.User) object, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.Expense) object, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.Amount) object, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.User) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(host.exp.exponent.models.Expense.class)) {
                io.realm.host_exp_exponent_models_ExpenseRealmProxy.insert(realm, (host.exp.exponent.models.Expense) object, cache);
            } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
                io.realm.host_exp_exponent_models_AmountRealmProxy.insert(realm, (host.exp.exponent.models.Amount) object, cache);
            } else if (clazz.equals(host.exp.exponent.models.User.class)) {
                io.realm.host_exp_exponent_models_UserRealmProxy.insert(realm, (host.exp.exponent.models.User) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
                io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.Expense) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
                io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.Amount) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
                io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insert(realm, (host.exp.exponent.custom.data.models.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(host.exp.exponent.models.Expense.class)) {
                    io.realm.host_exp_exponent_models_ExpenseRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
                    io.realm.host_exp_exponent_models_AmountRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.models.User.class)) {
                    io.realm.host_exp_exponent_models_UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
                    io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
                    io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
                    io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            io.realm.host_exp_exponent_models_ExpenseRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.Expense) obj, cache);
        } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            io.realm.host_exp_exponent_models_AmountRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.Amount) obj, cache);
        } else if (clazz.equals(host.exp.exponent.models.User.class)) {
            io.realm.host_exp_exponent_models_UserRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.User) obj, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.Expense) obj, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.Amount) obj, cache);
        } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.User) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(host.exp.exponent.models.Expense.class)) {
                io.realm.host_exp_exponent_models_ExpenseRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.Expense) object, cache);
            } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
                io.realm.host_exp_exponent_models_AmountRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.Amount) object, cache);
            } else if (clazz.equals(host.exp.exponent.models.User.class)) {
                io.realm.host_exp_exponent_models_UserRealmProxy.insertOrUpdate(realm, (host.exp.exponent.models.User) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
                io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.Expense) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
                io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.Amount) object, cache);
            } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
                io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insertOrUpdate(realm, (host.exp.exponent.custom.data.models.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(host.exp.exponent.models.Expense.class)) {
                    io.realm.host_exp_exponent_models_ExpenseRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.models.Amount.class)) {
                    io.realm.host_exp_exponent_models_AmountRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.models.User.class)) {
                    io.realm.host_exp_exponent_models_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
                    io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
                    io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
                    io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_ExpenseRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_AmountRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_ExpenseRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_AmountRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(host.exp.exponent.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_ExpenseRealmProxy.createDetachedCopy((host.exp.exponent.models.Expense) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(host.exp.exponent.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_AmountRealmProxy.createDetachedCopy((host.exp.exponent.models.Amount) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(host.exp.exponent.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_models_UserRealmProxy.createDetachedCopy((host.exp.exponent.models.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Expense.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_ExpenseRealmProxy.createDetachedCopy((host.exp.exponent.custom.data.models.Expense) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.Amount.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_AmountRealmProxy.createDetachedCopy((host.exp.exponent.custom.data.models.Amount) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(host.exp.exponent.custom.data.models.User.class)) {
            return clazz.cast(io.realm.host_exp_exponent_custom_data_models_UserRealmProxy.createDetachedCopy((host.exp.exponent.custom.data.models.User) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
