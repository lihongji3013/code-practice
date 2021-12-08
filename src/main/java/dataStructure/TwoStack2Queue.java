package dataStructure;

import java.util.Stack;

public class TwoStack2Queue {
 
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	//进栈操作
	public void appendTail(int item){
		stack1.push(item);
	}
	
	//出栈操作
	public int deleteHead(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()){
			return -1;
		}else{
			return stack2.pop();
		}
	}
}