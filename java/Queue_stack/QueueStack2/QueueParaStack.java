package QueueStack2;

import java.util.Stack;

class QueueStack {

	static class Queue {
		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();

		static void enQueue(int x) {
			}
		}

		static int Dequeue() {
	}

	public static void main(String args[]) {
		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);

		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());

	}

}

