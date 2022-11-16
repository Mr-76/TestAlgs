package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;
	public Queue<Integer> queue5;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

		queue4.enqueue(1);
		queue4.enqueue(2);

	}

	private void getImplementations() {
		queue1 = new QueueImpl<Integer>(4);
		queue2 = new QueueUsingStack<Integer>(3);
		queue3 = new QueueImpl<Integer>(1);
		queue4 = new CircularQueue<Integer>(4);
		queue5 = new QueueUsingStack<Integer>(3);
	}

	// MÉTODOS DE TESTE

	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
		assertEquals(null, queue3.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
		try {
			queue3.enqueue(new Integer(5));
			assertTrue(queue3.isFull());
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
			assertEquals(new Integer(2), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5));
		queue2.enqueue(new Integer(5));
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue());
	}

	// Testes Fila com 2 pilhas

	@Test
	public void testHeadQueueStack() {
		try {
			queue2.enqueue(new Integer(5));
			assertTrue(queue2.isFull());
			assertEquals(new Integer(1), queue2.head());

		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testQueueStackVazio() {
		assertTrue(queue5.isEmpty());
	}

	@Test
	public void testQueueStackCheio() {
		try {
			queue5.enqueue(1);
			queue5.enqueue(1);
			queue5.enqueue(1);
			assertTrue(queue5.isFull());
		} catch (QueueOverflowException e) {
			;
		}
	}

	@Test
	public void testElementoInserioQueueStack() {
		try {
			queue2.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueQueueStack() {
		try {
			assertEquals(new Integer(1), queue2.dequeue());
			assertEquals(new Integer(2), queue2.dequeue());
			assertTrue(queue2.isEmpty());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueQueueStackCheio() throws QueueOverflowException {
		queue2.enqueue(3);
		queue2.enqueue(3);

	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueQueueStackVazio() throws QueueUnderflowException {
		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
	}

	// Testes queue circular tamanho 4
	@Test
	public void testHeadCircular() {
		assertEquals(new Integer(1), queue4.head());
	}

	@Test
	public void testIsEmptyQueueCircular() {
		assertFalse(queue4.isEmpty());
	}

	@Test
	public void testIsFullQueueCircular() {
		assertFalse(queue4.isFull());
	}

	@Test
	public void testEnqueueCircular() {
		try {
			queue4.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueCircular() {
		try {
			assertEquals(new Integer(1), queue4.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueCircularComErro() throws QueueOverflowException {
		queue4.enqueue(new Integer(5));
		queue4.enqueue(new Integer(5));
		queue4.enqueue(new Integer(5));

	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComCircularErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue4.dequeue());
		assertEquals(new Integer(2), queue4.dequeue());
		assertEquals(new Integer(1), queue4.dequeue());
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueCircularMeio() throws QueueOverflowException {
		queue4.enqueue(new Integer(5));
		queue4.enqueue(new Integer(6));
		try {

			assertEquals(new Integer(1), queue4.dequeue());
			assertEquals(new Integer(2), queue4.dequeue());

			assertEquals(new Integer(5), queue4.head());

			queue4.enqueue(new Integer(7));
			queue4.enqueue(new Integer(8));
			assertTrue(queue4.isFull());

			assertEquals(new Integer(5), queue4.dequeue());
			assertEquals(new Integer(6), queue4.dequeue());
			assertEquals(new Integer(7), queue4.head());

			assertEquals(new Integer(7), queue4.dequeue());

			assertEquals(new Integer(8), queue4.head());

			queue4.enqueue(new Integer(9));
			queue4.enqueue(new Integer(10));
			queue4.enqueue(new Integer(11));
			queue4.enqueue(new Integer(12));

		} catch (QueueUnderflowException e) {
			;
		}

	}
}
