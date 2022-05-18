package reflection;

import executable.IExecutable;
import human.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionDemo {
    /**
     * 1
     *
     * @param list
     * @return
     */
    public static int reflectionFirst(List<Object> list) {
        int count = 0;
        for (Object obj : list) {
            if (obj instanceof Human) {
                count++;
            }
        }
        return count;
    }

    public static List<String> reflectionSecond(Object obj) {
        List<String> result = new ArrayList<>();
        Method[] M = obj.getClass().getDeclaredMethods();
        for (Method m : M) {
            if (m.getModifiers() == Modifier.PUBLIC) {
                result.add(m.getName());
            }
        }
        Collections.sort(result);
        return result;
    }

    public static List<String> reflectionThird(Object obj) {
        List<String> result = new ArrayList<>();
        Class<?> C = obj.getClass().getSuperclass();
        while (C != null) {
            result.add(C.getSimpleName());
            C = C.getSuperclass();
        }
        return result;
    }

    public static int reflectionStarOne(List<Object> list) {
        int result = 0;
        for (Object obj : list) {
            if (obj instanceof IExecutable) {
                ((IExecutable) obj).execute();
                result++;
            }
        }
        return result;
    }

    public static List<String> reflectionStarTwo(Object object){
        List<String> result = new ArrayList<>();
        Method[] methods = object.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(isGetter(method) || isSetter(method)){
                result.add(method.getName());
            }
        }
        Collections.sort(result);
        return result;
    }

    private static boolean isGetter(Method method){
        return method.getName().startsWith("get") &&
                method.getModifiers() != Modifier.STATIC &&
                method.getModifiers() == Modifier.PUBLIC &&
                method.getParameterCount() == 0 &&
                !method.getAnnotatedReturnType().toString().equals("void");

    }

    private static boolean isSetter(Method method){
        return method.getModifiers() != Modifier.STATIC &&
                method.getModifiers() == Modifier.PUBLIC &&
                method.getParameterCount() == 1 &&
                method.getAnnotatedReturnType().toString().equals("void") &&
                method.getName().startsWith("set");
    }
}
