package android.montreal.devfest.stuff.policies;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PoliciesModule {
    @Provides
    static RandomStuffVerifierImpl randomStuffVerifierImpl() {
        return new RandomStuffVerifierImpl();
    }

    @Binds
    abstract RandomStuffVerifier randomStuffVerifier(RandomStuffVerifierImpl impl);
}
