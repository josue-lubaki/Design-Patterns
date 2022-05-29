package ca.josue.strategy.operator_exemple;

import ca.josue.strategy.operator_exemple.operators.StrategyAdd;
import ca.josue.strategy.operator_exemple.operators.StrategyMultiply;
import ca.josue.strategy.operator_exemple.operators.StrategySubstract;

import java.util.Scanner;

/**
 * @author Josue Lubaki
 * @version 1.0
 * @since 2022-05-29
 */
public class OperatorMain {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ContextApp contextApp;
        double a;
        double b;

        // ask user two numbers and the operator
        System.out.println("Enter the first number: ");
        a = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        b = scanner.nextDouble();
        System.out.println("Enter the operator: (choose between +, - and *)");
        String operator = scanner.next();

        // init the context depends on the operator
        if (operator.equals("+")) {
            contextApp = new ContextApp(new StrategyAdd());
        } else if (operator.equals("-")) {
            contextApp = new ContextApp(new StrategySubstract());
        } else {
            contextApp = new ContextApp(new StrategyMultiply());
        }

        // execute the context
        double result = contextApp.executeStrategy(a, b);

        // print the result
        System.out.println("Result: " + result);
    }
}
