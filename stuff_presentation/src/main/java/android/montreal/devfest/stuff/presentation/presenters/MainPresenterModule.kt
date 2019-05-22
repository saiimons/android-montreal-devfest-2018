package android.montreal.devfest.stuff.presentation.presenters

import android.montreal.devfest.stuff.presentation.navigation.Navigator
import android.montreal.devfest.stuff.usecases.ManageRandomStuffUseCase

import dagger.Module
import dagger.Provides

@Module
abstract class MainPresenterModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun presenter(
                view: MainPresenter.MainView,
                randomStuffUseCase: ManageRandomStuffUseCase
        ): MainPresenter {
            return MainPresenterImpl(view, randomStuffUseCase)
        }
    }
}
