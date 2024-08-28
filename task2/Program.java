package task2;

import java.lang.reflect.Field;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("BMW", "Green", 2020);
//        task2(car);
        getObjectFields(car);
    }

    private static <T> void task2(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();

        Field [] fields = objClass.getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            System.out.printf("%s %s\n",field.getName(),field.get(obj));
        }
    }
    private static void getObjectFields(Object object) throws IllegalAccessException {
        Field [] fields = object.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            System.out.printf("%s %s\n",field.getName(),field.get(object));
        }
    }
}
