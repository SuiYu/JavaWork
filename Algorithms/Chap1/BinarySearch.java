import java.util.Arrays;
import In.*;

public class BinarySearch
{
    public static int rank (int key , int[] a)
    {
        int lo =0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo +(hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid -1;
            }
            else if (key > a[mid]) {
                lo = mid +1;
            }
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args)
     {
       /* int[] a = {0,1,2,3,4,5,6,7,8,9,12,23,45,56,67,78,89};
        int t;
        t = rank(12,a);
        System.out.println(t);*/
        In In = new In();
        int [] whiteList = In.readInts(args[0]);
    }

}