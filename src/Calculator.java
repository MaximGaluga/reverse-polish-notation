import java.util.Stack;

public class Calculator {
    public static int calculate(String expression) {
        String[] tokens = expression.split("\\s");
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operations = new Stack<>();
        for (String token : tokens) {
            if (token.matches("\\d+")) {
                numbers.push(Integer.parseInt(token));
            }
            else {
                int number1 = numbers.pop();
                int number2 = numbers.pop();
                switch (token) {
                    case "+" -> numbers.push(number2 + number1);
                    case "-" -> numbers.push(number2 - number1);
                    case "*" -> numbers.push(number2 * number1);
                    case "/" -> numbers.push(number2 / number1);
                }

            }
        }
        return numbers.pop();
    }
}
