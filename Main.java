import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class ref = Reflection.class;

        Method[] methods = ref.getDeclaredMethods();
        // Field[] fields = ref.getDeclaredFields();

        TreeSet<Method> geters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> seters = new TreeSet<>(Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterCount() == 0) {
                    geters.add(method);
                }
            } else if (method.getName().startsWith("set")) {
                if (method.getParameterCount() == 1) {
                    if (void.class.equals(method.getReturnType())) {
                        seters.add(method);
                    }
                }
            }
        }

//        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers()))
//                .sorted(Comparator.comparing(Field::getName))
//                .forEach(f -> System.out.println(String.format("%s must be private!", f.getName())));

        for (Method geter : geters) {
            System.out.println(String.format("%s will return class %s",
                    geter.getName()
                    , geter.getReturnType().getSimpleName()
            ));

        }
        for (Method seter : seters) {

            System.out.println(String.format("%s and will set field of class %s",
                    seter.getName(),
                    seter.getParameterTypes()[0].getSimpleName()));

        }
    }

}
