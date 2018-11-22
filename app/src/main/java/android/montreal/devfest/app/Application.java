package android.montreal.devfest.app;

import android.montreal.devfest.DaggerDomainComponent;
import android.montreal.devfest.app.modules.app.DaggerApplicationComponent;

import javax.inject.Named;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class Application extends DaggerApplication {
    @Named("dependency")
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .with(this)
                .with(DaggerDomainComponent.create())
                .build();
    }
}