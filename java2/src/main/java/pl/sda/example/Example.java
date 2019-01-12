package pl.sda.example;

import pl.sda.annotation.ImHere;

import java.math.BigDecimal;

@ImHere
public class Example {

    private String field1;

    protected Double field2;

    public BigDecimal fields3;

    public void hello() {
        System.out.println("Hello world!");
    }

}
