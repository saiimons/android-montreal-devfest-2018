package android.montreal.devfest.stuff.data.gateway;

import android.montreal.devfest.stuff.usecases.RandomStuffGetter;
import android.montreal.devfest.stuff.usecases.RandomStuffSetter;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DataGatewayModule {

    @Provides
    @Singleton
    static StuffDataGateway dataGateway(StuffStorage stuffStorage) {
        return new StuffDataGateway(stuffStorage);
    }

    @Binds
    abstract RandomStuffGetter randomStuffGetter(StuffDataGateway stuffDataGateway);

    @Binds
    abstract RandomStuffSetter randomStuffSetter(StuffDataGateway stuffDataGateway);
}
