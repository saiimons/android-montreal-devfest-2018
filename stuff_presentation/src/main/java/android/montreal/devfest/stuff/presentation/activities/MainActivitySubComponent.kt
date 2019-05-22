package android.montreal.devfest.stuff.presentation.activities

import android.montreal.devfest.dagger.ActivityScope
import android.montreal.devfest.stuff.presentation.navigation.NavigationModule
import android.montreal.devfest.stuff.usecases.StuffUseCaseModule

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainViewModule::class, StuffUseCaseModule::class, NavigationModule.Wrapper::class])
@ActivityScope
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
