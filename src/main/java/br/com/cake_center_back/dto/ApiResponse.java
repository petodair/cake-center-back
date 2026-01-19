package br.com.cake_center_back.dto;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

public record ApiResponse<D> (
        String status,
        int code,
        D data,
        String message
) {
    ApiResponse(ResponseStatusType status, HttpStatusCode code, D data, String message){
        this(status.getStatus(),code.value(),data,message);
    }

    @Getter
    enum ResponseStatusType{
        SUCCESS("success"),
        ERROR("error");
        final private String status;
        ResponseStatusType(String status){
            this.status = status;
        }
    }
}
