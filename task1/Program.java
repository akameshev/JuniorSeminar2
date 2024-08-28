package task1;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("task1.Person");
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Наименование: " + field.getName());
        }
        Constructor[] constructors = personalClass.getConstructors();
        constructors[0].getParameters();
        Object personInstance = constructors[0].newInstance(null);
        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Alice");
        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 22);
        Method displayMethodInfo = personalClass.getDeclaredMethod("displayInfo");
        displayMethodInfo.invoke(personInstance);
    }
}
