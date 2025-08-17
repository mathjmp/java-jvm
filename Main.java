import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Main {

    interface MathOperation<T> {
        T calculate(T a, T b);
    }

    static class Error {
        private String description;

        public Error(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    static class Sum implements MathOperation<Integer> {
        
        private Error error;

        @Override
        public Integer calculate(Integer a, Integer b) {
            return a + b;
        }
    }

    static class Product implements MathOperation<Integer> {
        
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a * b;
        }
    }
    
    public static void main(String[] args) {
        
        final var sum = new Sum();
        Class c1 = sum.getClass();
        
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());

        }

        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }
    }
}