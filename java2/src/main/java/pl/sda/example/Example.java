package pl.sda.example;

import lombok.Data;
import pl.sda.annotation.ImHere;

import java.math.BigDecimal;

@Data
@ImHere
public class Example {

    private String field1;

    protected Double field2;

    public BigDecimal fields3;

    public void hello(){
        System.out.println("Hello world!");
    }

}
