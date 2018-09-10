public class FibTest {

    public static void main(String args[])
    {
        System.out.println("3rd value is: " + fibIterative(3));
        System.out.println("4rd value is: " + fibIterative(4));
        System.out.println("5rd value is: " + fibIterative(5));
        System.out.println("6rd value is: " + fibIterative(6));
        System.out.println();

        System.out.println("3rd value is: " + fibRecursive(3));
        System.out.println("4rd value is: " + fibRecursive(4));
        System.out.println("5rd value is: " + fibRecursive(5));
        System.out.println("6rd value is: " + fibRecursive(6));

        System.out.println();
        System.out.println("3rd value is: " + fibApprox(2));
        System.out.println("4rd value is: " + fibApprox(3));
        System.out.println("5rd value is: " + fibApprox(4));
        System.out.println("6rd value is: " + fibApprox(5));
    }

    private static int fibIterative(int indexToCalc)
    {
        int a = 0;
        int b = 1;

        int temp = 0;
        for (int index = 0; index < indexToCalc; index++)
        {
            temp = a;
            a = b;
            b = temp + b;
        }
        return temp;
    }

    private static int fibRecursive(int value)
    {
        if (value == 1)
            return 0;
        else if (value == 2)
            return 1;

        return fibRecursive(value -1) + fibRecursive(value -2);
    }

    private static long fibApprox(int index)
    {
        double numerator = Math.pow((1 + Math.sqrt(5)), index) - Math.pow((1 - Math.sqrt(5)), index);
        double denom = Math.pow(2, index) * Math.sqrt(5);
        return Math.round(numerator / denom);
    }
}
