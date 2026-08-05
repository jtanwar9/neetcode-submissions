class MinStack {
    Stack<Record> stack;
    record Record(int val, int min) {}

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = val;
        if(!stack.isEmpty()) {
            min = Math.min(stack.peek().min(), val);
        }
        stack.push(new Record(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val();
    }

    public int getMin() {
        return stack.peek().min();
    }
}
