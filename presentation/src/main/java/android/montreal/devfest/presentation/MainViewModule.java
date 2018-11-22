package android.montreal.devfest.presentation;

import android.content.Context;
import android.montreal.devfest.dagger.ActivityContext;
import android.montreal.devfest.presentation.activities.MainActivity;
import android.montreal.devfest.presentation.navigation.Navigator;
import android.montreal.devfest.presentation.presenters.MainPresenter;
import android.montreal.devfest.presentation.presenters.MainPresenterModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {MainPresenterModule.class/*, NavigationModule.ViewMore.class*/})
public interface MainViewModule {

    @Binds
    @ActivityContext
    Context context(MainActivity activity);

    @Binds
    MainPresenter.MainView view(MainActivity activity);

    @Binds
    Navigator.ViewMore viewMore(MainActivity activity);
}