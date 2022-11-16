package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (!isEmpty()) {
			return array[this.top];
		} else {
			return null;

		}
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (this.top == this.array.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!(this.isFull()) && element != null) {
			this.array[++top] = element;

		} else if (element == null) {
			;
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!(this.isEmpty())) {
			T element = array[this.top];
			this.top -= 1;
			return element;

		} else {
			throw new StackUnderflowException();
		}
	}
}
