package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (!this.isEmpty()) {
			return array[0];
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return (tail == array.length - 1);
	}

	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++) {
			this.array[i] = this.array[i + 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if ((!isFull()) && element != null) {
			this.array[++tail] = element;
		} else if (element == null) {
			;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!this.isEmpty()) {
			T element = this.array[0];
			this.shiftLeft();
			this.tail--;
			return element;
		} else
			throw new QueueUnderflowException();
	}
}
