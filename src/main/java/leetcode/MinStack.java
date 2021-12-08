package leetcode;

import java.util.Stack;

/**
 * @Author: hongji
 * @Date: 2021-04-15 18:20
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 */
public class MinStack {

    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> dataStack = new Stack<Integer>();
    public void push(int node){
        dataStack.push(node);
        minStack.push(minStack.isEmpty()?node:Math.min(node,minStack.peek()));
    }
    public void pop(){
        dataStack.pop();
        minStack.pop();
    }
    public int top(){
        return dataStack.peek();
    }
    public int min(){
        return minStack.peek();

    }


}
