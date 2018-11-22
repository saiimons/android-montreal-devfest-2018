package android.montreal.devfest.stuff.presentation.presenters;

import android.montreal.devfest.stuff.presentation.navigation.Navigator;
import android.montreal.devfest.stuff.usecases.ManageRandomStuffUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainPresenterModule {
    @Provides
    static MainPresenter presenter(
            MainPresenter.MainView view,
            ManageRandomStuffUseCase randomStuffUseCase,
            Navigator.ViewMore viewMore
    ) {
        return new MainPresenterImpl(view, randomStuffUseCase, viewMore);
    }
}
