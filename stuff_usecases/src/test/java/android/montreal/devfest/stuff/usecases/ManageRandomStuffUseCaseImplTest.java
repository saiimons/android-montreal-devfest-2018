package android.montreal.devfest.stuff.usecases;

import android.montreal.devfest.stuff.entities.RandomStuffEntity;
import android.montreal.devfest.stuff.policies.RandomStuffVerifier;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManageRandomStuffUseCaseImplTest {
    @Mock
    private RandomStuffVerifier verifier;

    @Mock
    private RandomStuffSetter setter;

    @Mock
    private RandomStuffGetter getter;

    private ManageRandomStuffUseCaseImpl useCase;

    @Before
    public void setup() {
        useCase = new ManageRandomStuffUseCaseImpl(verifier, setter, getter);
    }

    @Test
    public void setRandomStuff_whenStuffNotVerified_shouldThrowAnException() {
        // Given
        final RandomStuffData data = new RandomStuffData(
                UUID.randomUUID().toString(),
                UUID.randomUUID().hashCode()
        );

        doReturn(false)
                .when(verifier)
                .isValid(any(RandomStuffEntity.class));

        // Then When
        assertThatExceptionOfType(SetRandomStuffException.class)
                .isThrownBy(() -> useCase.setRandomStuff(data));

        verify(verifier)
                .isValid(any(RandomStuffEntity.class));
    }

    @Test
    public void setRandomStuff_whenStuffVerified_shouldProcessWithoutError() throws Exception {
        // Given
        final RandomStuffData data = new RandomStuffData(
                UUID.randomUUID().toString(),
                UUID.randomUUID().hashCode()
        );

        doReturn(true)
                .when(verifier)
                .isValid(any(RandomStuffEntity.class));
        doNothing()
                .when(setter)
                .setRandomStuff(data);

        // When
        useCase.setRandomStuff(data);

        // Then
        verify(verifier)
                .isValid(any(RandomStuffEntity.class));
        verify(setter)
                .setRandomStuff(data);
    }
}
