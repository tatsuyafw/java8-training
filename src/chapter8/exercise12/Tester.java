package chapter8.exercise12;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * \@TestCase を付与したメソッドをテストする
 * WARN: static メソッド限定
 */
public class Tester {
    private static final String TEST_TARGET = "chapter8.exercise12.MyMath";

    public static void main(String[] main) {
        Class<?> targetClass = null;
        try {
            targetClass = Class.forName(TEST_TARGET);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Map<Method, TestCase[]> testCases = testCases(targetClass);

        runTest(testCases);
    }

    private static Map<Method, TestCase[]> testCases(Class<?> klass) {
        Map<Method, TestCase[]> cases = new HashMap<>();
        for (Method m : klass.getDeclaredMethods()) {
            if ( ! Modifier.isStatic(m.getModifiers()) ) continue;
            cases.put(m, m.getAnnotationsByType(TestCase.class));
        }

        return cases;
    }

    private static void runTest(Map<Method, TestCase[]> testCases) {
        for (Map.Entry<Method, TestCase[]> testCase : testCases.entrySet()) {
            Method method = testCase.getKey();
            if ( ! Modifier.isStatic(method.getModifiers() ) ) {
                continue;
            }

            TestCase[] tests = testCase.getValue();
            int successCount = 0, failureCount = 0;
            for (TestCase t : tests) {
                long param = t.param();
                long expected = t.expected();
                long actual;
                try {
                    String paramType = method.getParameters()[0].getType().getName();
                    boolean isPassed = false;
                    switch(paramType) {
                    case "long":
                        actual = (long)method.invoke(null, param);
                        isPassed = test(expected, actual);
                        break;
                    case "int":
                        actual = (long)method.invoke(null, param);
                        isPassed = test( expected, (long)method.invoke(null, (int)param) );
                        break;
                    default:
                        // Nothing to do...
                        break;
                    }
                    if ( isPassed ) {
                        successCount++;
                    } else {
                        // TODO: show the failure message.
                        failureCount++;
                    }
                } catch (ReflectiveOperationException ex) {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }

            System.out.println("Success: " + successCount);
            System.out.println("Failure: " + failureCount);
        }
    }

    // long に限定した test メソッド
    private static boolean test(long expected, long actual) {
        return expected == actual;
    }
}
