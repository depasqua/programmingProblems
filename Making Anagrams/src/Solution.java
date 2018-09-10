import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> stringAMap = mapString(a);
        Map<Character, Integer> stringBMap = mapString(b);

        for (Character c : stringAMap.keySet())
        {
            if (stringBMap.containsKey(c))
            {
                int countA = stringAMap.get(c);
                int countB = stringBMap.get(c);
                if (countA == countB)
                {
                    stringAMap.remove(c);
                    stringBMap.remove(c);
                }
                else if (countA < countB)
                {
                    stringAMap.remove(c);
                    stringBMap.put(c, stringBMap.get(c)-countA);
                }
                else {
                    stringBMap.remove(c);
                    stringAMap.put(c, stringAMap.get(c)-countB);
                }
            }
        }
        int sum = 0;
        for (Integer i : stringAMap.values())
            sum += i;
        for (Integer i : stringBMap.values())
            sum += i;
        return sum;
    }

    private static Map<Character, Integer> mapString(String str)
    {
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            if (!stringMap.containsKey(str.charAt(i)))
                stringMap.put(str.charAt(i), 1);
            else
            {
                int oldCount = stringMap.get(str.charAt(i));
                stringMap.put(str.charAt(i), oldCount++);
            }
        return stringMap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
