<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class ArrayStack2 {
	
	    protected int head[];
	    protected int pointer;

	    public ArrayStack2(int capacity){
	        head = new int[capacity];
	        pointer = -1;
	    }
	    public boolean isEmpty(){
	        return pointer == -1;
	    }
	    public void push(int i){
	        if(pointer+1 < head.length)
	            head[++pointer] = i;
	    }
	    public int pop(){
	        if(isEmpty())
	            return 0;
	        return head[pointer--];
	    }
	
}
=======
package com.Datastrures.DataStructures;

public class ArrayStack2 {
	
	    protected int head[];
	    protected int pointer;

	    public ArrayStack2(int capacity){
	        head = new int[capacity];
	        pointer = -1;
	    }
	    public boolean isEmpty(){
	        return pointer == -1;
	    }
	    public void push(int i){
	        if(pointer+1 < head.length)
	            head[++pointer] = i;
	    }
	    public int pop(){
	        if(isEmpty())
	            return 0;
	        return head[pointer--];
	    }
	
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
