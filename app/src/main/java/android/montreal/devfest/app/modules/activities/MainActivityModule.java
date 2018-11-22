package android.montreal.devfest.app.modules.activities;

import android.app.Activity;
import android.montreal.devfest.presentation.activities.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivitySubComponent.class})
public abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> injector(MainActivitySubComponent.Builder builder);
}
