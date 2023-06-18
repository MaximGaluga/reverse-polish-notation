import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParseString {
    public static String[] getTokens(String expression) {
        return expression.replaceAll("\\s", "").split("(?<=\\D)|(?=\\D)");
    }

    public static String getPolishExpression(String[] tokens) {
        StringBuilder bd = new StringBuilder();
        Stack<String> operationStack = new Stack<>();
        Map<String, Integer> operationsMap = new HashMap<>() {{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("(", 3);
        }};

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                bd.append(token).append(" ");
            }
            else if (operationsMap.containsKey(token)) {
                if (operationStack.isEmpty()) {
                    operationStack.push(token);
                }
                else {
                    while (!operationStack.isEmpty() && (operationsMap.get(operationStack.peek()) >= operationsMap.get(token))) {
                        if (operationStack.peek().equals("(")) break;
                        bd.append(operationStack.pop()).append(" ");
                    }
                    operationStack.push(token);
                }
            }
            else if (token.equals(")")) {
                while (!operationStack.isEmpty() && !operationStack.peek().equals("(")) {
                    bd.append(operationStack.pop()).append(" ");
                }
                operationStack.pop();
            }
        }
        while (!operationStack.isEmpty()) {
            bd.append(operationStack.pop()).append(" ");
        }
        return bd.toString();
    }
}
