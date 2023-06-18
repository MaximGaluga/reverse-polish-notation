import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String[] tokens = ParseString.getTokens(expression);
        String polishStatement = ParseString.getPolishExpression(tokens);
        int result = Calculator.calculate(polishStatement);
        System.out.printf("The result is %d", result);
    }
}