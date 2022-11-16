package Queue_stack;

import java.util.Stack;

class QueueStack {

	static class Queue {
		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();

		static void enQueue(int x) {
			// movendo tudo de s1 para s2
			while (!s1.isEmpty()) {

				Integer b = s1.pop();
				s2.push(b);
				System.out.printf("adicionando %d", b);

			}

			s1.push(x); // colocando em s1 o ulimo adicionando x
					//
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}

		}

		static int Dequeue() {
			if (s1.isEmpty()) {
				;
				//
				// 3
				// 2
				// 1
				// fila 1,2,3
				//
				// pop na pilha sai 3 mas devia sair 1
				// 2 array que boto os elementos de array1
				//
				// 1
				// 2
				// 3 -- array2
				//
				// agora se der pop sai 1
				//
				// 3
				// 2
				// 1
				// 5
				//
				//
				//
				//
			}
			int x = s1.peek();
			s1.pop();
			return x;
		}
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
