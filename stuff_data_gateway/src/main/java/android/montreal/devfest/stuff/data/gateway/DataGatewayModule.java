package android.montreal.devfest.stuff.data.gateway;

import android.montreal.devfest.stuff.usescases.RandomStuffGetter;
import android.montreal.devfest.stuff.usescases.RandomStuffSetter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DataGatewayModule {

    @Provides
    @Singleton
    static DataGateway dataGateway(StuffStorage stuffStorage) {
        return new DataGateway(stuffStorage);
    }

    @Binds
    abstract RandomStuffGetter randomStuffGetter(DataGateway dataGateway);

    @Binds
    abstract RandomStuffSetter randomStuffSetter(DataGateway dataGateway);
}
