package android.montreal.devfest.stuff.policies;

import dagger.Component;

@Component(modules = PoliciesModule.class)
public interface SuffPoliciesComponent {
    RandomStuffVerifier verifier();
}
