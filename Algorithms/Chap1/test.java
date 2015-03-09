
public class test 
{

    public static void main(String[] args)
    {
         int   a = Integer.parseInt(args[0]);
           int b = Integer.parseInt(args[1]);
           int c = Integer.parseInt(args[2]);
           
            if (a == b && b==c) {
                StdOut.println(a);
            }
            else
            {
                System.out.println("No");
            }

    }
}