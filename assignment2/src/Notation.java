/**
 * @author Caitlyn Clifton
 * @date 6/15/2023
 */
public class Notation extends Object
{
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		MyStack<String> stack = new MyStack<String>();
		char[] postfix = postfixExpr.toCharArray();
		double value1 = 0, value2 = 0, result = 0;
		char c;
		try 
		{
			for(int i = 0; i < postfix.length; i++)
			{
				c = postfix[i];
				//If the current character in the postfix expression is a space, ignore it.
				if(c == ' ')
					continue;
				//If the current character is an operator:
				if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
				{
					//Pop the top 2 values from the stack. 
					if(stack.size() < 2) // If there are fewer than 2 values throw an error
					{
						throw new InvalidNotationFormatException();
					}
					value1 = Double.parseDouble(stack.pop());
					value2 = Double.parseDouble(stack.pop());
					
					//Perform the arithmetic calculation of the operator with the first popped value as the right operand and the second popped value as the left operand
					switch(c)
					{
						case '+':
							result = value2 + value1;
							break;
						case '-':
							result = value2 - value1;
							break;
						case '*':
							result = value2 * value1;
							break;
						case '/':
							result = value2 / value1;
							break;
						case '%':
							result = value2 % value1;
					}
					stack.push(Double.toString(result)); //Pushes the resulting value onto the stack
				}
				else //If the current character is an operand or left parenthesis, push on the stack
				{
					if(Character.isDigit(c) || c == '(')
						stack.push(String.valueOf(c));
				}
			}
			if(stack.size() > 1) //If there is only one value in the stack – it is the result of the postfix expression, if more than one value, throw an error
			{
				throw new InvalidNotationFormatException();
			}
		}
		catch(InvalidNotationFormatException | StackOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		return result;
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
	{
		MyStack<String> stack = new MyStack<String>();
		char[] post = postfix.toCharArray();
		String value1, value2, s = "";
		char c;
		try {
			for(int i = 0; i < post.length; i++)
			{
				c = post[i];
				//If the current character in the postfix is a space, ignore it
				if(c == ' ')
					continue;
				//If the current character is an operator:
				if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
				{
					if(stack.size() < 2) //If there are fewer than 2 values throw an error
					{
						throw new InvalidNotationFormatException();
					}
					//Pop the top 2 values from the stack
					value1 = stack.pop();
					value2 = stack.pop();
					
					s = "(" + value2 + c + value1 + ")";
					//Push a string with 1st value and then the operator and then the 2nd value and encapsulate the resulting string within parenthesis
					stack.push(s);
				}
				//If the current character is an operand, push it on the stack
				else
				{
					s = String.valueOf(c);
					stack.push(s);
				}
			}
			if(stack.size() > 1) //If there is only one value in the stack – it is the result of the postfix expression, if more than one value, throw an error
			{
				throw new InvalidNotationFormatException();
			}
		}
		catch(InvalidNotationFormatException | StackOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		return s;
	}
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{			
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> queue = new MyQueue<String>();
		char[] inf = infix.toCharArray();
		char c; 
		String s = "";
		try {
			for(int i = 0; i < inf.length; i++)
			{
				c = inf[i];
				//If the current character in the infix is a space, ignore it.
				if(c == ' ') 
					continue;
				
				//If the current character in the infix is a digit, copy it to the postfix solution queue
				else if(Character.isDigit(c))
					queue.enqueue(String.valueOf(c));
				
				//If the current character in the infix is a left parenthesis, push it onto the stack
				else if(c == '(') 
					stack.push(String.valueOf(c));
				
				//If the current character in the infix is a + or - operator:
				else if(c == '+' || c == '-')
				{
					//Pops all operators at the top of the stack
					if(!stack.isEmpty())
					{
						while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/") || stack.top().equals("%"))
						{
							//inserts the popped operator in the solution queue
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(c));//pushes the current character onto the stack
					
				}
				//If the current character in the infix is a * or / or % operator:
				else if(c == '*' || c == '/' || c == '%')
				{
					//Pops all operators at the top of the stack
					if(!stack.isEmpty())
					{
						while(stack.top().equals("*") || stack.top().equals("/") || stack.top().equals("%"))
						{
							//inserts the popped operator in the solution queue
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(c));//pushes the current character onto the stack
				}
				
				//If the current character in the infix is a right parenthesis:
				else if(c == ')')
				{
					//Pop operators from the top of the stack and insert them in postfix solution queue until a left parenthesis is at the top of the stack
					while(!stack.isEmpty() && !stack.top().equals("("))
					{
						queue.enqueue(stack.pop());
					}
					if(stack.isEmpty() || !stack.top().equals("("))
					{
						throw new InvalidNotationFormatException();
					}
					if(!stack.isEmpty() && stack.top().equals("("))
					{
						stack.pop();
					}
				}
			}
			//When the infix expression has been read, Pop any remaining operators and insert them in postfix solution queue.
			while(!stack.isEmpty() && !stack.top().equals("("))
			{
				queue.enqueue(stack.pop());
			}
		}
		catch(InvalidNotationFormatException | StackOverflowException | QueueOverflowException | StackUnderflowException e)
		{
			e.getMessage();
		}
		s = queue.toString();
		return s;
	}
}