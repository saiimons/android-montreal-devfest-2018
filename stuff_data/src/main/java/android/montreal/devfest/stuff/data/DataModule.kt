package android.montreal.devfest.stuff.data

import android.content.Context
import android.montreal.devfest.dagger.ApplicationContext
import android.montreal.devfest.stuff.data.gateway.StuffStorage

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {

    @Binds
    internal abstract fun keyValueStore(keyValueStore: FileKeyValueStore): StuffStorage

    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun fileKeyValueStore(@ApplicationContext context: Context): FileKeyValueStore {
            return FileKeyValueStore(context)
        }

        @Provides
        @JvmStatic
        internal fun sharedPrefsKeyValueStore(@ApplicationContext context: Context): SharedPrefsKeyValueStore {
            return SharedPrefsKeyValueStore(context)
        }
    }
}
