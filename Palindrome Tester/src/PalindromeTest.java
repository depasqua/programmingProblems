import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeTest {
    public static void main(String[] args) {
        String word = "radar";
        System.out.println("Palindrome test: " + word + ": " + palTest(word));

        word="word";
        System.out.println("Palindrome test: " + word + ": " + palTest(word));

        word="madam im adam";
        System.out.println("Palindrome test: " + word + ": " + palTest(word));
    }

    private static boolean palTest(String word)
    {
        Stack<Character> stackC = new Stack<>();
        ArrayDeque<Character> queueC = new ArrayDeque<>();

        for(Character letter :word.toCharArray())
        {
            if (!letter.equals(' ')) {
                stackC.push(letter);
                queueC.add(letter);
            }
        }

        while(!stackC.empty())
        {
            char sLetter = stackC.pop();
            char qLetter = queueC.removeFirst();

            if (sLetter != qLetter)
                return false;
        }
        return true;
    }
}
