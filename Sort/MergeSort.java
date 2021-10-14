import java.util.Random;
import java.util.Arrays;
public class MergeSort {
    public static void sort(int[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }
        int mid=lo+(hi-lo)>>2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
    public static void merge(int[] a,int lo,int mid,int hi){
        int[] help = new int[hi-lo+1];
        int index=0;
        int less=lo,more=mid+1;
        while(less<=mid && more<=hi){
            help[index++]=a[less]>a[more]?a[more++]:a[less++];
        }
        while(less<=mid){
            help[index++]=a[less++];
        }
        while(more<=hi){
            help[index++]=a[more++];
        }
        for(int i=0;i<help.length;i++){
            a[lo+i]=help[i];
        }
    }
}
class TestMergeSort{
    public static void main(String[] args) {
        int[] test= new int[100];
        Random r = new Random();
        for(int i=0;i<100;i++){
            test[i]=r.nextInt(1000);
        }
        System.out.println(Arrays.toString(test));
        QuickSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
