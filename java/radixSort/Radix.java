package radixSort;
import java.util.Collections;
import java.util.Arrays;
public class Radix{
		public static void main(String args[]){
	Integer[] array = { 22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14, 55, 0, 12, 55 };

		System.out.println("Unsorted Array: " + Arrays.toString(array));
		radixSort(array);
		System.out.println("Sorted Array: " + Arrays.toString(array));


	}  

		public static void radixSort(Integer[] array){
        int m = Collections.max(Arrays.asList(array)); 
 
		for (int exp = 1; m / exp > 0; exp *= 10){
            bubbleSort(array,exp);
		}

		


}

		public static void bubbleSort(Integer[] array,int exp){
				for (int i = 1 ; i < array.length ;i++){
						for (int j = 0;j < array.length - i;j++){
								if (((array[j]/exp)%10)>(((array[j+1]/exp)%10))){
										int aux = array[j];
										array[j] = array[j+1];
										array[j+1] = aux;
								}
						}
				}
		}

		public static void alternativeSelection(Integer[] array,int exp){
				exp =1;
				for (int i = 0 ; i < array.length -1;i++){
						for (int j = i + 1;j < array.length;j++){
								if (((array[i]/exp)%100)>(((array[j]/exp)%100))){
										int aux = array[i];
										array[i] = array[j];
										array[j] = aux;
								}
						}
				}
		}

}

