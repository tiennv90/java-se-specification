package com.java.spec.tiennv.collections;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		String expression = " ( 1 + 2 ) * 4 - 3";
		System.out.println("Result: " + evaluate(expression));
	}
	
	private static int evaluate(String expression) {
		
		Stack<Character> operatorStack = new Stack<Character>();
		Stack<Integer> operandStack = new Stack<Integer>();
		
		String tokens[] = expression.split(" ");
		
		//phase 1: scan tokens
		for (String token : tokens) {
			
			if (token.length() == 0) {
				continue;
			}
			
			char item = token.trim().charAt(0);
			if (item == '+' || item =='-') {
				//process +, - *, / in the top of operator stack
				while (!operatorStack.isEmpty() && 
						(operatorStack.peek() == '+'||
						operatorStack.peek() == '-' ||
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				
				//put -, + into operator stack
				operatorStack.push(item);
			} else if (item == '*' || item == '/') {
				//process *,/ in the top of operator stack
				while (!operatorStack.isEmpty() && 
						(operatorStack.peek() == '*'||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				//push * or / into operator stack
				operatorStack.push(item);
			} else if (item == '(') {
				operatorStack.push('(');
			} else if (item == ')') {
				//process all operator in stack until seeing '('
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				//pop '(' from operator stack
				operatorStack.pop(); 
			} else {
				operandStack.push(new Integer(token));
			}
		}
		
		//phase 2 process all remaining operator in the stack
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		
		return operandStack.pop();
	}

	private static void processAnOperator(Stack<Integer> operandStack,
			Stack<Character> operatorStack) {
		
		char operator = operatorStack.pop();
		int firstNumber = operandStack.pop();
		int secondNumber = operandStack.pop();
		//System.out.println(secondNumber + " " + operator + " " + firstNumber);
		
		if (operator == '+')
			operandStack.push(secondNumber + firstNumber);
		else if (operator == '-')
			operandStack.push(secondNumber - firstNumber);
		else if (operator == '*')
			operandStack.push(secondNumber * firstNumber);
		else if (operator == '/')
			operandStack.push(secondNumber / firstNumber);
		
		System.out.println();
	}
	
	
}
