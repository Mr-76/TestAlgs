package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if ((!this.isFull()) && element != null) {
			try {
				this.stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		} else if (element == null) {
			;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		if (!(this.stack1.isEmpty())) {
			T element = null;
			this.ManipulaStacks(this.stack1, this.stack2);

			try {
				element = this.stack2.pop();

			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}

			this.ManipulaStacks(this.stack2, this.stack1);
			return element;
		} else {
			throw new QueueUnderflowException();
		}

	}

	@Override
	public T head() {
		T element = null;
		if (!this.isEmpty()) {
			this.ManipulaStacks(this.stack1, this.stack2);
			element = this.stack2.top();
			return element;
		} else {
			return element;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	/**
	 *
	 * Metodo move elementos de uma pilha para outra nesse caso move-se os elementos
	 * da pilha1 p1, para a pilha2 p2, de forma que os elementos mais antigos de p1
	 * fique mais perto do topo,agora em p2
	 *
	 * @param p1 pilha 1
	 * @para p2 pilha 2
	 */
	public void ManipulaStacks(Stack<T> p1, Stack<T> p2) {
		while (!p1.isEmpty()) {
			try {
				p2.push(p1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}

	}

}
