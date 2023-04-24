package com.lzq.demo;

import java.util.*;

/**
 * @author: lzq
 * @since: 2023-04-23
 **/
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入算式：");
            String expression = scanner.nextLine();

            double result = calculate(expression);

            System.out.println("结果为：" + result);
        }
    }

    // 计算表达式的值
    public static double calculate(String expression) {
        // 删除空格
        expression = expression.replaceAll("\\s+", "");

        // 将 - 符号转化为负数标记
        expression = expression.replaceAll("-", "@");

        // 将表达式分解为多个数字和运算符
        List<String> tokens = tokenize(expression);

        // 将中缀表达式转化为后缀表达式
        List<String> postfix = toPostfix(tokens);

        // 计算后缀表达式的值
        return evaluatePostfix(postfix);
    }

    // 将表达式分解为多个数字和运算符
    public static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();

        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);

            // 处理数字
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            }
            // 处理运算符
            else if (isOperator(c)) {
                tokens.add(Character.toString(c));
                i++;
            }
            // 处理左括号
            else if (c == '(') {
                tokens.add("(");
                i++;
            }
            // 处理右括号
            else if (c == ')') {
                tokens.add(")");
                i++;
            }
            // 处理负数标记
            else if (c == '@') {
                StringBuilder sb = new StringBuilder();
                sb.append('-');
                i++;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            }
            // 处理非法字符
            else {
                System.out.println("非法字符：" + c);
                return null;
            }
        }

        return tokens;
    }

    // 判断字符是否为运算符
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    // 判断运算符的优先级
    public static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            case "^":
            case "√":
                return 3;
            default:
                return -1;
        }
    }

    // 将中缀表达式转化为后缀表达式
    public static List<String> toPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            // 处理数字
            if (isNumber(token)) {
                postfix.add(token);
            }
            // 处理左括号
            else if (token.equals("(")) {
                stack.push(token);
            }
            // 处理右括号
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            }
            // 处理运算符
            else if (isOperator(token.charAt(0))) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && getPrecedence(token) <= getPrecedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
            // 处理开方运算符
            else if (token.equals("√")) {
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    // 判断字符串是否为数字
    public static boolean isNumber(String s) {
        return s.matches("\\d+(\\.\\d+)?");
    }

    // 计算后缀表达式的值
    public static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            // 处理数字
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            }
            // 处理运算符
            else if (isOperator(token.charAt(0))) {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    case "^":
                        stack.push(Math.pow(num1, num2));
                        break;
                    case "%":
                        stack.push(num1 % num2);
                        break;
                }
            }
            // 处理开方运算符
            else if (token.equals("√")) {
                double num = stack.pop();
                stack.push(Math.sqrt(num));
            }
        }

        return stack.pop();
    }
}