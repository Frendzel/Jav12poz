package pl.sda.reflection;

import org.junit.Test;
import pl.sda.example.Example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

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
        assertEquals(EXAMPLE_FIELD_SIZE, result);
    }

    @Test
    public void printMethods() throws InvocationTargetException, IllegalAccessException {
        //given
        Reflection reflection = new Reflection();
        //when
        int result = reflection.getMethods(new Example());
        //then
        assertEquals(EXAMPLE_METHOD_SIZE, result);
    }

    @Test
    public void printAnnotations() {
        //given
        Reflection reflection = new Reflection();
        //when
        int result = reflection.getAnnotations(new Example());
        //then
        assertEquals(EXAMPLE_ANNOTATIONS_SIZE, result);

    }

    @Test
    public void classForNameTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("pl.sda.example.Example");
        Object o = aClass.newInstance();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            m.setAccessible(true);
        }
        Method hello = aClass.getDeclaredMethod("hello");
        hello.invoke(o);
    }

    @Test
    public void findImHereAnnotationTest() {
        //given
        Example example = new Example();
        //when
        boolean imHereAnnotation = Reflection.findImHereAnnotation(example);
        //then
        assertTrue(imHereAnnotation);
    }
}