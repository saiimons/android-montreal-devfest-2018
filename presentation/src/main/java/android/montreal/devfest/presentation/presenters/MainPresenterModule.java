package android.montreal.devfest.presentation.presenters;

import android.montreal.devfest.presentation.navigation.Navigator;
import android.montreal.devfest.stuff.usescases.ManageRandomStuffUseCase;

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
