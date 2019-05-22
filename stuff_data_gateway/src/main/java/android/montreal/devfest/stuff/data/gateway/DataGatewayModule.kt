package android.montreal.devfest.stuff.data.gateway

import android.montreal.devfest.stuff.usecases.RandomStuffGetter
import android.montreal.devfest.stuff.usecases.RandomStuffSetter
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DataGatewayModule {
    @Binds
    internal abstract fun randomStuffGetter(stuffDataGateway: StuffDataGateway): RandomStuffGetter

    @Binds
    internal abstract fun randomStuffSetter(stuffDataGateway: StuffDataGateway): RandomStuffSetter

    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        internal fun dataGateway(stuffStorage: StuffStorage): StuffDataGateway {
            return StuffDataGateway(stuffStorage)
        }
    }
}
