package android.montreal.devfest.stuff.presentation.navigation

import android.content.Context
import android.montreal.devfest.dagger.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

interface NavigationModule {

    @Module
    abstract class ViewMore {
        @Binds
        internal abstract fun viewMore(wrapper: NavigatorWrapper): Navigator.ViewMore
    }

    @Module
    abstract class Website {
        @Binds
        internal abstract fun website(wrapper: NavigatorWrapper): Navigator.Website
    }

    @Module
    object App {
        @Provides
        @Singleton
        @JvmStatic
        internal fun appNavigator(): AppNavigator {
            return AppNavigatorImpl()
        }
    }

    @Module
    object Wrapper {
        @Provides
        @JvmStatic
        internal fun wrapper(
                @ActivityContext context: Context,
                appNavigator: AppNavigator
        ): NavigatorWrapper {
            return NavigatorWrapper(context, appNavigator)
        }
    }
}
