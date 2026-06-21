package Week_1.Mockito_exercises.Mockito_exercises;

public class DataService {

    private ExternalApi api;

    public DataService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}