package net.java.springboot.client;

import net.java.springboot.dto.response.DogAPIBaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "dogapiclient", url = "https://dog.ceo/api")
public interface DogAPIClient {

    @RequestMapping(method = RequestMethod.GET, value = "/breeds/list/all", produces = "application/json")
    DogAPIBaseResponse<Map<String, List<String>>> getListAll();

}
