package android.montreal.devfest.stuff.policies

import dagger.Component

@Component(modules = [PoliciesModule::class])
interface SuffPoliciesComponent {
    fun verifier(): RandomStuffVerifier
}
