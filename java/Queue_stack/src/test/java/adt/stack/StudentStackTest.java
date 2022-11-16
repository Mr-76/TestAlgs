package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import adt.stack.StackImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stackVazia;
	public Stack<Integer> stackCheio;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		stackCheio.push(1);
		stackCheio.push(2);
		stackCheio.push(4);
	}

	private void getImplementations() {
		stack1 = new StackImpl<Integer>(4);
		stackVazia = new StackImpl<Integer>(1);
		stackCheio = new StackImpl<Integer>(4);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
		assertEquals(new Integer(4), stackCheio.top());
	}

	@Test
	public void testTopAposPush() {
		try {

			stack1.push(new Integer(6));
			assertEquals(new Integer(6), stack1.top());
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull());
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
			assertTrue(stack1.isFull());
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stackCheio.push(new Integer(5));
		stackCheio.push(new Integer(5));
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
			assertEquals(new Integer(2), stack1.pop());
			assertEquals(new Integer(1), stack1.pop());
			assertTrue(stack1.isEmpty());
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testMultiplosPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stackVazia.pop());
		assertEquals(new Integer(3), stackVazia.pop());
		assertEquals(new Integer(3), stackVazia.pop());
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stackVazia.pop());

	}
}
