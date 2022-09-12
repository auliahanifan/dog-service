package net.java.springboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DogAPIBaseResponse<T> {
    private T message;
    private String status;
}
