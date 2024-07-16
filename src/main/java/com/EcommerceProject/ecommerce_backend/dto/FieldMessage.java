package com.EcommerceProject.ecommerce_backend.dto;

public class FieldMessage { //Mensagem para cada campo

    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

}
