package android.montreal.devfest.stuff.usecases

import android.montreal.devfest.stuff.policies.RandomStuffVerifier
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
                .isValid(any())

        // Then When
        assertThatExceptionOfType(SetRandomStuffException::class.java)
                .isThrownBy { useCase.setRandomStuff(data) }

        verify(verifier).isValid(any())
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
                .isValid(any())
        doNothing()
                .`when`(setter)
                .setRandomStuff(data)

        // When
        useCase.setRandomStuff(data)

        // Then
        verify(verifier).isValid(any())
        verify(setter).setRandomStuff(data)
    }

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
}
