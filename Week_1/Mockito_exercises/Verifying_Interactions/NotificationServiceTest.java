package Week_1.Mockito_exercises.Verifying_Interactions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {

    @Test
    void testVerifyInteraction() {

        ExternalApi mockApi =
                Mockito.mock(
                        ExternalApi.class
                );

        NotificationService service =
                new NotificationService(
                        mockApi
                );

        service.notifyUser();

        Mockito.verify(mockApi)
                .sendData(
                        "Notification Sent"
                );
    }
}
