class MyStack {
    Queue<Integer>q1;
    Queue<Integer>q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
      Queue<Integer> temp=q1;
        temp=q2;
        q2=q1;
        q1=temp;;

    }
    
    public int pop() {
        if(q2.isEmpty()){
            return -1;
        }
        return q2.poll();
    }
    
    public int top() {
        if(q2.isEmpty()){
            return -1;
        }
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */