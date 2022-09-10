package net.java.springboot.dto.response;

import lombok.Data;

@Data
public class DogAPIBaseResponse<T> {
    private T message;
    private String status;
}
