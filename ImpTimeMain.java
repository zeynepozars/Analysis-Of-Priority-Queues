import java.util.PriorityQueue;
import java.util.Random;

public class ImpTimeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Zeynep Özarslan, 041802044, 5 December 2020 */
		/* This program calculates the time complexity of 3 different priority queue implementations */
		
		// loop that increases array size with an increment of 5.000
		for (int n = 10000; n < 100001; n = n + 5000) {
			Random random = new Random();
			int i = 0;
			int[] values = new int[n];
			// insert random values into an array
			while (i < n) {
				values[i] = random.nextInt(100000000 + 1);
				i++;
			}

			// Java's priority queue implementation
			PriorityQueue<Integer> implementation1 = new PriorityQueue<>();

			// calculates enqueue and dequeue operations total implementation time
			long startTime = System.nanoTime();
			for (int value : values) {
				implementation1.add(value);
			}
			for (int j = 0; j < n; j++) {
				implementation1.poll();
			}
			long finishTime = System.nanoTime();

			System.out.println("N= " + n);
			long impTime = finishTime - startTime;
			// 1 second = 1,000,000,000 nano seconds
			double impTimeSec = (double) impTime / 1000000000;
			System.out.println("Total implementation time for Java's PriorityQueue: " + impTimeSec + " seconds");

			// heap based priority queue implementation 
			MyPriorityQueue<Integer> implementation2 = new MyPriorityQueue<>();

			// calculates enqueue and dequeue operations total implementation time
			long startTime2 = System.nanoTime();
			for (int value : values) {
				implementation2.enqueue(value);
			}
			for (int j = 0; j < n; j++) {
				implementation2.dequeue();
			}
			long finishTime2 = System.nanoTime();

			long impTime2 = finishTime2 - startTime2;
			// 1 second = 1,000,000,000 nano seconds
			double impTimeSec2 = (double) impTime2 / 1000000000;
			System.out.println("Total implementation time for MyPriorityQueue: " + impTimeSec2 + " seconds");

			// 3rd priority queue implementation based on sorted array list
			PriorityQueueArrayList<Integer> implementation3 = new PriorityQueueArrayList<>();

			// calculates enqueue and dequeue operations total implementation time
			long startTime3 = System.nanoTime();
			for (int value : values) {
				implementation3.enqueue(value);
			}
			for (int j = 0; j < n; j++) {
				implementation3.dequeue();
			}
			long finishTime3 = System.nanoTime();

			long impTime3 = finishTime3 - startTime3;
			// 1 second = 1,000,000,000 nano seconds
			double impTimeSec3 = (double) impTime3 / 1000000000;
			System.out.println("Total implementation time for PriorityQueueArrayList: " + impTimeSec3 + " seconds");
			
			System.out.println("Relative timings for MyPriorityQueue and PriorityQueueArrayList:");
			System.out.println("MyPriorityQueue: " + (double)impTime2/impTime);
			System.out.println("PriorityQueueArrayList: " + (double)impTime3/impTime);

		}

	}

}
