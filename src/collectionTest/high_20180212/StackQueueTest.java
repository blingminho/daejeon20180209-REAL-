package collectionTest.high_20180212;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 스택과 큐 이론<br>
 * Stack ==> 후입선출(LIFO)의 자료구조 : 예) callStack<br>
 * Queue ==> 선입선출(FIFO)의 자료구조 : 예) 인쇄대기열<br>
 * Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다<br>
 * @author SangJun
 */
public class StackQueueTest {
	public static void main(String[] args) {
		/*
		 * Stack의 명령
		 * 1. 자료 입력
		 * 		push(입력할 값);
		 * 2. 자료 출력
		 * 		pop(); ==> 자료를 꺼내온 후 Stack에서 꺼내온 자료를 삭제한다
		 * 		peek(); ==> 자료를 꺼내오는데 삭제는 하지 않는다
		 */
		LinkedList<String> stack = new LinkedList<String>();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		System.out.println("현재 stack값들 : " + stack);
		
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 stack값들 : " + stack);
		
		stack.push("5");
		System.out.println("현재 stack값들 : " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("===============================================");		
		
		/*
		 * Queue명령
		 * 1. 자료 입력
		 * 		offer(입력할 자료);
		 * 2. 자료 출력
		 * 		poll(); ==> 자료를 Queue에서 꺼내온 후 꺼내온 자료를 Queue에서 삭제한다
		 * 		peek(); ==> 자료를 꺼내오지만 삭제는 하지 않는다
		 */	
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		System.out.println("현재 queue값들 : " + queue);
		String value = queue.poll();
		System.out.println("꺼내온 자료 : " + value);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue값들 : " + queue);
		queue.offer("5");
		System.out.println("현재 queue값들 : " + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue값들 : " + queue);
		
	}
}
