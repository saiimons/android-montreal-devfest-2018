package android.montreal.devfest.data;

import android.content.Context;
import android.montreal.devfest.dagger.ApplicationContext;
import android.montreal.devfest.stuff.data.gateway.StuffStorage;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DataModule {

    @Provides
    static FileKeyValueStore fileKeyValueStore(@ApplicationContext Context context) {
        return new FileKeyValueStore(context);
    }

    @Provides
    static SharedPrefsKeyValueStore sharedPrefsKeyValueStore(@ApplicationContext Context context) {
        return new SharedPrefsKeyValueStore(context);
    }

    @Binds
    abstract StuffStorage keyValueStore(FileKeyValueStore keyValueStore);
}
