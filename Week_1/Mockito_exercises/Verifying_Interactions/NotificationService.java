package Week_1.Mockito_exercises.Verifying_Interactions;

public class NotificationService {

    private ExternalApi api;

    public NotificationService(
            ExternalApi api) {

        this.api = api;
    }

    public void notifyUser() {

        api.sendData(
                "Notification Sent"
        );
    }
}
