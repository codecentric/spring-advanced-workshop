package de.codecentric.orderservice.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FieldClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
       if(response.status() == HttpStatus.NOT_FOUND.value()) {
           return new FieldNotFoundException("Field not found");
       }
       return new Default().decode(methodKey, response);
    }
}
