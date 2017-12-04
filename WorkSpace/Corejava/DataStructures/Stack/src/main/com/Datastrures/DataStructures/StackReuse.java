<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class StackReuse {
	protected LinkedList l;

    public StackReuse(){
        l = new LinkedList();
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
    public void push(Object o){
        l.insert(o);
    }
    public Object pop(){
        return l.remove();
    }
}
=======
package com.Datastrures.DataStructures;

public class StackReuse {
	protected LinkedList l;

    public StackReuse(){
        l = new LinkedList();
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
    public void push(Object o){
        l.insert(o);
    }
    public Object pop(){
        return l.remove();
    }
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
