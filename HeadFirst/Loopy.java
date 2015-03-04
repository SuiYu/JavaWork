public class Loopy{
    public static void main(String[] args) {
        int x=1;
        System.out.println("before the loop");
        while(x <= 10)
        {
            System.out.println("In the loop");
            System.out.println("Value of X is" + x);
            x= x+1;
        }
    }
}