package android.montreal.devfest.app

import android.content.Context
import android.montreal.devfest.dagger.ApplicationContext
import android.montreal.devfest.stuff.data.DataModule
import android.montreal.devfest.stuff.data.gateway.DataGatewayModule
import android.montreal.devfest.stuff.policies.SuffPoliciesComponent
import android.montreal.devfest.stuff.presentation.activities.MainActivityModule
import android.montreal.devfest.stuff.presentation.navigation.NavigationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
        dependencies = [
            SuffPoliciesComponent::class
        ],
        modules = [
            DataModule::class,
            DataGatewayModule::class,
            NavigationModule.App::class,
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class,
            MainActivityModule::class
        ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun with(@ApplicationContext context: Context): Builder

        fun with(component: SuffPoliciesComponent): Builder

        fun build(): ApplicationComponent
    }
}
