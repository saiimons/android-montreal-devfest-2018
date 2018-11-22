package android.montreal.devfest.app.modules.activities;

import android.montreal.devfest.app.scopes.ActivityScope;
import android.montreal.devfest.presentation.MainViewModule;
import android.montreal.devfest.presentation.activities.MainActivity;
import android.montreal.devfest.presentation.navigation.NavigationModule;
import android.montreal.devfest.stuff.usescases.StuffUseCaseModule;

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
