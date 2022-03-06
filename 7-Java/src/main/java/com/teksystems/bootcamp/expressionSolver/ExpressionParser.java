package com.teksystems.bootcamp.expressionSolver;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParser {
    static Map<Character, Operation> operations = new HashMap<>() {{
        put('^', new ExponentOperation());
        put('%', new ModuloOperation());
        put('*', new MultiplicationOperation());
        put('/', new DivisionOperation());
        put('+', new AdditionOperation());
        put('-', new SubtractionOperation());
    }};

    static Map<Character, Integer> precedence = new HashMap<>() {{
        put('^', 3);
        put('%', 2);
        put('*', 2);
        put('/', 2);
        put('+', 1);
        put('-', 1);
    }};

    public static Term parseExpression(String input) {
        Term newTerm;
        input = input.replaceAll(" ", "");
        try {
            Double number = Double.parseDouble(input);
            return new Constant(number);
        } catch (Exception e) {;}
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
        Operation op = operations.get(operator);
        return new Expression(parseExpression(term1), op, parseExpression(term2));
    }
}
