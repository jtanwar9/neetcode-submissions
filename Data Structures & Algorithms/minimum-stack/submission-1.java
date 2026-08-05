class Record {
    int val;
    int min;

    Record(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    Stack<Record> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()) {
            min = stack.peek().min < val ? stack.peek().min : val;
        }
        stack.push(new Record(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
