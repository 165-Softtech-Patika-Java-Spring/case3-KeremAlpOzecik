package com.example.demo.cus.enums;


import com.example.demo.gen.enums.BaseErrorMessage;


public enum CusErrorMessage implements BaseErrorMessage {

    CUSTOMER_ERROR_MESSAGE("Customer not found!"),
    ;

    private String message;
    CusErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
