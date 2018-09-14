import java.util.*;
public class Solution{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        List<Character> openList = new ArrayList<>();
        openList.add('('); openList.add('['); openList.add('{');
        List<Character> closedList = new ArrayList<>();
        closedList.add('}'); closedList.add(')'); closedList.add(']');
        Deque<Character> stack = new ArrayDeque<>();

        while (sc.hasNext()) {
            String input=sc.next();
            boolean done = false;
            for (int i=0; i<input.length() && !done; i++)
            {
                if (openList.contains(input.charAt(i)))
                    stack.push(input.charAt(i));

                else if (closedList.contains(input.charAt(i)) && !stack.isEmpty())
                {
                    Character c = stack.pop();
                    if ((c == '(' && input.charAt(i) != ')') ||
                            (c == '{' && input.charAt(i) != '}') ||
                            (c == '[' && input.charAt(i) != ']'))
                    {
                        System.out.println("false");
                        done = true;
                    }
                }
                else
                {
                    System.out.println("false");
                    done = true;
                }
            }
            if (!done && stack.isEmpty())
                System.out.println("true");
            else if (!done)
            {
                System.out.println("false");
            }
        }
    }
}
