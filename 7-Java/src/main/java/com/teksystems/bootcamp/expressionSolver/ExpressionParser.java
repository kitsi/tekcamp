package com.teksystems.bootcamp.expressionSolver;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParser {
    private static final Map<Character, Operation> operators = new HashMap<>() {{
        put('^', new ExponentOperation());
        put('%', new ModuloOperation());
        put('*', new MultiplicationOperation());
        put('/', new DivisionOperation());
        put('+', new AdditionOperation());
        put('-', new SubtractionOperation());
    }};

    private static final Map<Character, Integer> precedence = new HashMap<>() {{
        put('^', 3);
        put('%', 2);
        put('*', 2);
        put('/', 2);
        put('+', 1);
        put('-', 1);
    }};

    public static Term parseExpression(String input) {
        input = input.replaceAll(" ", "");
        try {
            double number = Double.parseDouble(input);
            return new Constant(number);
        } catch (Exception ignored) {}
        char[] chars = input.toCharArray();
        int operatorPosition = 0;
        char operator = ' ';
        int operatorPrecedence = Integer.MAX_VALUE;
        for(int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if(precedence.containsKey(character)) {
                if(precedence.get(character) <= operatorPrecedence) {
                    operator = character;
                    operatorPosition = i;
                    operatorPrecedence = precedence.get(character);
                }
            }
        }
        String term1 = input.substring(0, operatorPosition);
        String term2 = input.substring(operatorPosition + 1);
        Operation operation = operators.get(operator);
        return new Expression(parseExpression(term1), operation, parseExpression(term2));
    }
}
