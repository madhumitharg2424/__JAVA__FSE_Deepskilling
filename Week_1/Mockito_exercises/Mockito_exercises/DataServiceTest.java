package Week_1.Mockito_exercises.Mockito_exercises;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataServiceTest {

    @Test
    void testFetchData() {

        ExternalApi mockApi =
                Mockito.mock(ExternalApi.class);

        Mockito.when(mockApi.getData())
                .thenReturn("Mock Data");

        DataService service =
                new DataService(mockApi);

        String result =
                service.fetchData();

        assertEquals(
                "Mock Data",
                result
        );
    }
}