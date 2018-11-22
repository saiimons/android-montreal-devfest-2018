package android.montreal.devfest;

import android.montreal.devfest.policies.PoliciesModule;
import android.montreal.devfest.policies.RandomStuffVerifier;

import dagger.Component;

@Component(modules = PoliciesModule.class)
public interface DomainComponent {
    RandomStuffVerifier verifier();
}
