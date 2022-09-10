package net.java.springboot.service;

import net.java.springboot.client.DogAPIClient;
import net.java.springboot.client.DogOtherAPIClient;
import net.java.springboot.dto.response.DogAPIBaseResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogExternalServiceTest {

    @Mock
    private DogAPIClient dogAPIClient;

    @Mock
    private DogOtherAPIClient dogOtherAPIClient;

    @InjectMocks
    private DogExternalService service;

    @Test
    void getImagesByBreed_Test() {
        List<String> imagesUrlList = List.of(
                "https://url/shiba-1.jpg",
                "https://url/shiba-2.jpg",
                "https://url/shiba-3.jpg",
                "https://url/shiba-4.jpg"
        );

        List<String> oddImagesUrlList = List.of(
                "https://url/shiba-1.jpg",
                "https://url/shiba-3.jpg"
        );

        when(dogOtherAPIClient.getImagesByBreed(any())).thenReturn(new DogAPIBaseResponse(imagesUrlList, "success"));

        var result = service.getImagesByBreed("shiba");

        assertEquals(oddImagesUrlList, result);
    }

}