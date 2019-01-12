package pl.sda.reflection;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.example.Example;

import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {

    private static int EXAMPLE_FIELD_SIZE = 3;
    private static int EXAMPLE_METHOD_SIZE = 1;
    private static int EXAMPLE_ANNOTATIONS_SIZE = 0;

    @Test
    public void printFields() {
        //given
        Reflection reflection = new Reflection();
        //when
        int result = reflection.getFields(new Example());
        //then
        Assert.assertEquals(EXAMPLE_FIELD_SIZE, result);
    }

    @Test
    public void printMethods() throws InvocationTargetException, IllegalAccessException {
        //given
        Reflection reflection = new Reflection();
        //when
        int result = reflection.getMethods(new Example());
        //then
        Assert.assertEquals(EXAMPLE_METHOD_SIZE, result);
    }

    @Test
    public void printAnnotations() {
        //given
        Reflection reflection = new Reflection();
        //when
        int result = reflection.getAnnotations(new Example());
        //then
        Assert.assertEquals(EXAMPLE_ANNOTATIONS_SIZE, result);

    }
}