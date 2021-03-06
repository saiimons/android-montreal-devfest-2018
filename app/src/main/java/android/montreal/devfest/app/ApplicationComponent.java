package android.montreal.devfest.app;

import android.content.Context;
import android.montreal.devfest.dagger.ApplicationContext;
import android.montreal.devfest.stuff.data.DataModule;
import android.montreal.devfest.stuff.data.gateway.DataGatewayModule;
import android.montreal.devfest.stuff.policies.SuffPoliciesComponent;
import android.montreal.devfest.stuff.presentation.activities.MainActivityModule;
import android.montreal.devfest.stuff.presentation.navigation.NavigationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(
        dependencies = {
                SuffPoliciesComponent.class,
        },
        modules = {
                DataModule.class,
                DataGatewayModule.class,
                NavigationModule.App.class,

                AndroidInjectionModule.class,
                AndroidSupportInjectionModule.class,

                MainActivityModule.class,
        }
)
@Singleton
public interface ApplicationComponent extends AndroidInjector<Application> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder with(@ApplicationContext Context context);

        Builder with(SuffPoliciesComponent component);

        ApplicationComponent build();
    }
}
