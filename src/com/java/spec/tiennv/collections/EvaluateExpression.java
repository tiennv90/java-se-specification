package com.java.spec.tiennv.collections;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		String expression = "(1 + 2) * 4 - 3";
		System.out.println(evaluate(expression));
	}
	
	private static int evaluate(String expression) {
		
		Stack<Character> operatorStack = new Stack<Character>();
		Stack<Integer> operandStack = new Stack<Integer>();
		
		String tokens[] = expression.split(" ");
		
		for (String token : tokens) {
			char item = token.charAt(0);
			if (item == '+' || item =='-') {
				processAllOperator(operatorStack, operandStack);
			} else if (item == '*' || item == '/') {
				processMultiplyAndBreaksOperators(operatorStack, operandStack);
			} else if (item == '(') {
				operatorStack.push(item);
			} else if (item == ')') {
				processAllOperator(operatorStack, operandStack, item);
			} else {
				operandStack.push(new Integer(item));
			}
		}
		return 0;
	}

	private static void processAllOperator(Stack<Character> operatorStack,
			Stack<Integer> operandStack, Character stopCondition) {
		if (stopCondition != null) {
			
		} else {
			int result;
			int firstNumber = operandStack.pop();
			char operator = operatorStack.pop();
			int secondNumber = operandStack.pop();
			switch (operator) {
			case '+':
				result = firstNumber + secondNumber;
			case '-':
				result = firstNumber - secondNumber;
			case '*':
				result = firstNumber * secondNumber;
			case '/':
				result = firstNumber / secondNumber;
			}
		}
	}

	private static void processMultiplyAndBreaksOperators(
			Stack<Character> operatorStack, Stack<Integer> operandStack) {
		
	}

	private static void processAllOperator(Stack<Character> operatorStack,
			Stack<Integer> operandStack) {
		processAllOperator(operatorStack, operandStack, null);
	}

	private static int isInteger(char value) {
		return 0;
	}
}
