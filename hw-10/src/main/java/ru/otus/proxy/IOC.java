package ru.otus.proxy;

import ru.otus.annotations.Log;
import ru.otus.domain.Constants;
import ru.otus.utils.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static ru.otus.utils.ReflectionUtils.extractParamsAndNames;

public abstract class IOC {

    private static final Set<String> methodsForLogging = new HashSet<>();

    @SuppressWarnings("logger")
    public static <T> T getInstance(final T obj) {
        final Class<?> clazz = obj.getClass();
        final Method[] methods = clazz.getMethods();
        final Set<Method> annotatedMethods = ReflectionUtils.filterMethodsByAnnotation(methods, Log.class);

        if (annotatedMethods.isEmpty()) {
            throw new IllegalArgumentException("Not found annotation: " + Log.class.getCanonicalName());
        }

        final Set<String> paramsAndNames = new HashSet<>();
        for (Method annotatedMethod : annotatedMethods) {
            Object extractParamsAndNamess = ReflectionUtils.extractParamsAndNamess(annotatedMethod);
            paramsAndNames.add((String) extractParamsAndNamess);
        }

        methodsForLogging.addAll(paramsAndNames);

        return (T) Proxy.newProxyInstance(IOC.class.getClassLoader(), clazz.getInterfaces(), new LogInvocationHandler<>(obj));
    }

    private static <T> void printMethodInfo(final T instance, final Method method, final Object[] args) throws Exception {
        final String methodName = method.getName();

        System.out.println(Constants.LOGGER_START_MSG);
        System.out.println(String.format(Constants.METHOD_INFO_TEMPLATE_MSG, methodName, Arrays.toString(args)));
        System.out.println(String.format(Constants.METHOD_RESULT_MSG, method.invoke(instance, args)));
        System.out.println(Constants.LOGGER_FINISH_MSG);
    }

    private static class LogInvocationHandler<T> implements InvocationHandler {

        private final T instance;

        private LogInvocationHandler(final T instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
            final String paramsAndNames = extractParamsAndNames(method);

            if (methodsForLogging.contains(paramsAndNames)) {
                printMethodInfo(instance, method, args);
            }

            return method.invoke(instance, args);
        }
    }
}

