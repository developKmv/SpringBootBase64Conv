package ru.base64utils;

import org.springframework.stereotype.Component;

@Component
public class Test {

    private String string_field;

    public Test() {
        System.out.println("Test created");
    }


    public String getString_field(){
        return string_field;
    }

    public void setString_field(String string_field) {
        this.string_field = string_field;
    }

    public void testFunc(){
        System.out.println("string_field : " + string_field);
    };
}
