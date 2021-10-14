
import java.util.Arrays;
import java.util.Random;

class QuickSort{
    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }
    public static void sort(int[] nums,int left,int right){
        if(right<=left){return;}
        int partitionpoint = partition(nums,left,right);
        sort(nums, left, partitionpoint-1);
        sort(nums, partitionpoint+1, right);
    }
    public static int partition(int[] nums,int left,int right){
        // Random r = new Random();
        // int i=left+r.nextInt(right-left+1);
        // swap(nums, i, left);
        // i=left;
        int i=left;
        int j=right+1;
        int v=nums[left];
        while(true){
            while(nums[++i]<v){
                if(i==right){break;}
            }
            while(nums[--j]>v){
                // if(j==left){break;}
            }
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums, left, j);
        return j;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
class Test{
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
