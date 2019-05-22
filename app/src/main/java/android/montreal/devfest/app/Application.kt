package android.montreal.devfest.app

import android.montreal.devfest.stuff.policies.DaggerSuffPoliciesComponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
                .with(this)
                .with(DaggerSuffPoliciesComponent.create())
                .build()
    }
}
