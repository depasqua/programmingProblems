import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.exit;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Deque<Character> d = new ArrayDeque<>();

        for (int index = 0; index < line.length(); index++)
        {
            char c = line.charAt(index);
            if (c == '[' || c == '(' || c == '{')
            {
                d.push(c);
            }
            else if (c == ']' || c == ')' || c == '}')
            {
                if (d.size() != 0)
                {
                    char p = d.pop();

                    if ((c == ']' && p != '[') || (c == '}' && p != '{') || (c == ')' && p != '('))
                    {
                        System.out.println("Unbalanced");
                        exit(1);
                    }
                }
                else
                {
                    System.out.println("Unbalanced");
                    exit(1);
                }
            }
        }

        if (d.size() != 0)
        {
            System.out.println("Unbalanced: " + d.toString() + " remaining on stack");
        }
        else
        {
            System.out.println("BALANCED!");
        }
    }
}