package android.montreal.devfest.stuff.policies

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal abstract class PoliciesModule {
    @Binds
    internal abstract fun randomStuffVerifier(impl: RandomStuffVerifierImpl): RandomStuffVerifier

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun randomStuffVerifierImpl(): RandomStuffVerifierImpl {
            return RandomStuffVerifierImpl()
        }
    }
}
