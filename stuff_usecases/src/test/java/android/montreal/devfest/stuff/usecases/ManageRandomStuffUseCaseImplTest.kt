package android.montreal.devfest.stuff.usecases

import android.montreal.devfest.stuff.entities.RandomStuffEntity
import android.montreal.devfest.stuff.policies.RandomStuffVerifier
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ManageRandomStuffUseCaseImplTest {
    @Mock
    private lateinit var verifier: RandomStuffVerifier

    @Mock
    private lateinit var setter: RandomStuffSetter

    @Mock
    private lateinit var getter: RandomStuffGetter

    private lateinit var useCase: ManageRandomStuffUseCaseImpl

    @Before
    fun setup() {
        useCase = ManageRandomStuffUseCaseImpl(verifier, setter, getter)
    }

    @Test
    fun setRandomStuff_whenStuffNotVerified_shouldThrowAnException() {
        // Given
        val data = RandomStuffData(
                UUID.randomUUID().toString(),
                UUID.randomUUID().hashCode()
        )

        doReturn(false)
                .`when`(verifier)
                .isValid(any(RandomStuffEntity::class.java))

        // Then When
        assertThatExceptionOfType(SetRandomStuffException::class.java)
                .isThrownBy { useCase.setRandomStuff(data) }

        verify(verifier).isValid(any(RandomStuffEntity::class.java))
    }

    @Test
    @Throws(Exception::class)
    fun setRandomStuff_whenStuffVerified_shouldProcessWithoutError() {
        // Given
        val data = RandomStuffData(
                UUID.randomUUID().toString(),
                UUID.randomUUID().hashCode()
        )

        doReturn(true)
                .`when`(verifier)
                .isValid(any(RandomStuffEntity::class.java))
        doNothing()
                .`when`(setter)
                .setRandomStuff(data)

        // When
        useCase.setRandomStuff(data)

        // Then
        verify(verifier).isValid(any(RandomStuffEntity::class.java))
        verify(setter).setRandomStuff(data)
    }
}
