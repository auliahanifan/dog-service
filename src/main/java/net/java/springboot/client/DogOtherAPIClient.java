package net.java.springboot.client;

import net.java.springboot.dto.response.DogAPIBaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "dogotherapiclient", url = "https://dog.ceo/api")
public interface DogOtherAPIClient {

    @RequestMapping(method = RequestMethod.GET, value = "/breed/{breed}/list")
    DogAPIBaseResponse<List<String>> getSubbreedsByBreed(@PathVariable(name = "breed") String breed);

    @RequestMapping(method = RequestMethod.GET, value = "/breed/{breed}/images")
    DogAPIBaseResponse<List<String>> getImagesByBreed(@PathVariable(name = "breed") String breed);

    @RequestMapping(method = RequestMethod.GET, value = "/breed/{breed}/{subbreed}/images")
    DogAPIBaseResponse<List<String>> getImagesBySubbreed(@PathVariable(name = "breed") String breed,
                                                         @PathVariable(name = "subbreed") String subbreed);

}
