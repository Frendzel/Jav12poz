package pl.sda.reflection;

import pl.sda.annotation.ImHere;
import pl.sda.example.Example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    Example example = new Example();

    public int getFields(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field df : declaredFields) {
            System.out.println(df.getName());
        }
        return declaredFields.length;
    }

    public int getMethods(Object object) throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
            method.invoke(object);
        }
        return declaredMethods.length;
    }

    public int getAnnotations(Object object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        int annotationsCounter = 0;
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
                annotationsCounter++;
            }
        }
        return annotationsCounter;
    }

    //znajdzmy adnotacje na klasie korzystajac z refleksji
    public boolean findImHereAnnotation(Object object) {
        ImHere[] annotationsByType = object.getClass().getDeclaredAnnotationsByType(ImHere.class);
        return annotationsByType.toString() != null;
    }


}
