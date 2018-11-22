package android.montreal.devfest.stuff.policies;

import android.montreal.devfest.stuff.policies.PoliciesModule;
import android.montreal.devfest.stuff.policies.RandomStuffVerifier;

import dagger.Component;

@Component(modules = PoliciesModule.class)
public interface SuffPoliciesComponent {
    RandomStuffVerifier verifier();
}
