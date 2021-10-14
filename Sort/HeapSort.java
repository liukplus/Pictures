import java.util.Random;
import java.util.Arrays;
public class HeapSort {
    public static void sort(int[] a){
        int len = a.length;
        for(int i=(len-1)/2;i>=0;i--) {
            sink(a, i, len);
        }
        int heapsize = len;
        for(int i=0;i<len;i++){
            swap(a, 0, --heapsize);
            sink(a, 0, heapsize);
        }       
    }
    public static void swim(int[] a,int k){
            while(a[(k-1)/2]<a[k]){
                swap(a, (k-1)/2, k);
                k=(k-1)/2;
            }
    }
    public static void sink(int[] a,int k,int N){
        while(2*k+1<N){
            int larger = 2*k+2<N && a[2*k+2]>a[2*k+1]?2*k+2:2*k+1;
            if(a[k]<a[larger]){
                swap(a, k, larger);
                k=larger;
            }
            else{
                return;
            }
        }
    }
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
class TestHeapSort{
    public static void main(String[] args) {
        int[] test= new int[10];
        Random r = new Random();
        for(int i=0;i<10;i++){
            test[i]=r.nextInt(10);
        }
        System.out.println(Arrays.toString(test));
        HeapSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
