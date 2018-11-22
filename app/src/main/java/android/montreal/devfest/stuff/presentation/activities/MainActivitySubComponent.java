package android.montreal.devfest.stuff.presentation.activities;

import android.montreal.devfest.scopes.ActivityScope;
import android.montreal.devfest.stuff.presentation.navigation.NavigationModule;
import android.montreal.devfest.stuff.usecases.StuffUseCaseModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(
        modules = {MainViewModule.class, StuffUseCaseModule.class, NavigationModule.Wrapper.class}
)
@ActivityScope
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
