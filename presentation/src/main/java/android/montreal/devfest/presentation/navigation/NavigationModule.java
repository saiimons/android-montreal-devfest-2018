package android.montreal.devfest.presentation.navigation;

import android.content.Context;
import android.montreal.devfest.dagger.ActivityContext;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

public interface NavigationModule {

    @Module
    interface ViewMore {
        @Binds
        Navigator.ViewMore viewMore(NavigatorWrapper wrapper);
    }

    @Module
    interface Website {
        @Binds
        Navigator.Website website(NavigatorWrapper wrapper);
    }

    @Module
    abstract class App {
        @Provides
        @Singleton
        static AppNavigator appNavigator() {
            return new AppNavigatorImpl();
        }
    }

    @Module
    abstract class Wrapper {
        @Provides
        static NavigatorWrapper wrapper(
                @ActivityContext Context context,
                AppNavigator appNavigator
        ) {
            return new NavigatorWrapper(context, appNavigator);
        }
    }
}
