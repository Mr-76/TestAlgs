package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if ((!isFull()) && element != null) {
			if (this.head == -1) {
				head++;
			}
			this.tail++;
			if (this.tail == this.array.length) {
				this.tail -= this.array.length;
				this.array[this.tail] = element;
			} else {
				this.array[this.tail] = element;
			}
			this.elements++;

		} else if (element == null) {
			;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!this.isEmpty()) {
			T element = this.array[this.head];
			this.head++;
			this.elements--;

			if (this.head == this.array.length) {
				this.head -= this.array.length;

			} else {
				;
			}
			return element;
		} else
			throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		if (!this.isEmpty()) {
			return this.array[this.head];
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		if (this.elements > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isFull() {
		if (this.elements == this.array.length) {
			return true;
		} else {
			return false;
		}
	}
}
