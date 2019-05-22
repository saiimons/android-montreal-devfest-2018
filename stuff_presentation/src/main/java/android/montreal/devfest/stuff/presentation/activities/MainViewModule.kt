package android.montreal.devfest.stuff.presentation.activities

import android.content.Context
import android.montreal.devfest.dagger.ActivityContext
import android.montreal.devfest.stuff.presentation.navigation.Navigator
import android.montreal.devfest.stuff.presentation.presenters.MainPresenter
import android.montreal.devfest.stuff.presentation.presenters.MainPresenterModule

import dagger.Binds
import dagger.Module

@Module(includes = [MainPresenterModule::class/*, NavigationModule.ViewMore.class*/])
interface MainViewModule {

    @Binds
    @ActivityContext
    fun context(activity: MainActivity): Context

    @Binds
    fun view(activity: MainActivity): MainPresenter.MainView

    @Binds
    fun viewMore(activity: MainActivity): Navigator.ViewMore
}