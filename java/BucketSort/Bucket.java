package BucketSort;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;
import java.lang.Math;

public class Bucket {

	public static void main(String args[]) {
		Integer[] array = { 22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14, 55, 0, 12, 55 };
		System.out.println("Unsorted Array: " + Arrays.toString(array));
		BucketSorting(array,2);
		System.out.println("Sorted Array: " + Arrays.toString(array));
	}

	public static void BucketSorting(Integer[] array, int buckets) {

		List<List<Integer>> bucketsPart = new ArrayList<>(buckets);// bucket matrix;
		ArrayList<Integer> newAL = new ArrayList<Integer>();
		for (int i = 0; i < buckets; i++) {
			bucketsPart.add(newAL);
		} //
			//
		double max = Collections.max(Arrays.asList(array));

		System.out.println(bucketsPart.size());
		int divisor = (int) Math.ceil(((max + 1) / (double) buckets));// seleciona qual bukect colocar os
										// elementos;
		// adiciona 1 pq pode serdo tipo 80 + 1

		for (int i = 0; i < array.length; i++) {
			int pos = (int) Math.floor((double) array[i] / (double) divisor);
			bucketsPart.get(pos).add(array[i]);
		}
		// 80/40.5 = 1.95887 o floor eh 1 e da certo
		for (List<Integer> bucket : bucketsPart) {
			Collections.sort(bucket);
		} // se nao adicionar 1 fica 80/2 = 40
		int index = 0;
		for (List<Integer> bucket : bucketsPart) {

			System.out.println("bukecty: " + index);
			for (Integer num : bucket) {
				if (index == array.length) {
					return;
				} else {

					array[index++] = num;
				}
			}
		} // se nao adicionar 1 fica 80/2 = 40

	}

}
