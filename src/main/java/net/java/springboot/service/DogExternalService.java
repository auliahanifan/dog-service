package net.java.springboot.service;

import lombok.extern.slf4j.Slf4j;
import net.java.springboot.client.DogAPIClient;
import net.java.springboot.dto.response.DogAPIBaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class DogExternalService {

    @Autowired
    private DogAPIClient apiClient;

    public Map<String, List<String>> getAllDogs() {
        var response = apiClient.getListAll();
        Map<String, List<String>> result = new HashMap<>();

        response.getMessage().forEach((breed, subbreedList) -> {
            if (breed.equals("sheepdog")) {
                sheepdogAddition(result, breed, subbreedList);
            } else if (breed.equals("terrier")) {
                terrierAddition(result, breed, subbreedList);
            } else {
                result.put(breed, subbreedList);
            }
        });

        return result;
    }

    private void sheepdogAddition(Map<String, List<String>> result, String breed, List<String> subbreedList) {
        subbreedList.stream().forEach((subbreed) -> {
            result.put(breed + "-" + subbreed, new ArrayList<>());
        });
    }

    private void terrierAddition(Map<String, List<String>> result, String breed, List<String> subbreedList) {
        // To Do : Make efficient async call
        subbreedList.stream().forEach((subbreed) -> {
            CompletableFuture<DogAPIBaseResponse<List<String>>> future
                    = CompletableFuture.supplyAsync(() -> apiClient.getImagesBySubbreed(breed, subbreed));
            try {
                result.put(breed + "-" + subbreed, future.get().getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
    }

    public List<String> getImagesByBreed(String breed) {
        var response = apiClient.getImagesByBreed(breed);

        List<String> result = new ArrayList<>();
        response.getMessage().stream().forEach((imageUrl) -> {
            // Make shiba get only odd number
            if (breed.equals("shiba")) {
                shibaOddOnlyAddition(result, breed, imageUrl);
            } else {
                result.add(imageUrl);
            }
        });

        return result;
    }

    private void shibaOddOnlyAddition(List<String> result, String breed, String imageUrl) {
        String numberOnly= imageUrl.replaceAll("[^0-9]", "");
        if (Integer.valueOf(numberOnly) % 2 != 0) {
            result.add(imageUrl);
        }
    }

}
