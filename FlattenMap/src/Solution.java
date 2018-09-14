import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Object> topMap = new HashMap<>();
        topMap.put("One", "1");topMap.put("Two", "2");

        Map<String, Object> secondMap = new HashMap<>();
        secondMap.put("2.One", "2-1"); secondMap.put("2.Two", "2-2");

        Map<String, Object> thirdMap = new HashMap<>();
        thirdMap.put("3.One", "3-1"); thirdMap.put("3.Two", "3-2");

        topMap.put("Three", secondMap);
        topMap.put("Four", thirdMap);

        Map<String, Object> finalMap = new HashMap<>();

        flattenMap(topMap, finalMap);
        System.out.println(finalMap);
    }

    private static void flattenMap(Map<String, Object> src, Map<String, Object> dest)
    {
        List<String> keys = new ArrayList<>(src.keySet());

        for (String s : keys)
        {
            if (src.get(s) instanceof Map<?, ?>)
            {
                Map<String, Object> flatter = new HashMap<>();
                flattenMap((Map<String, Object>) src.get(s), flatter);
                dest.putAll(flatter);
            }
            else
                dest.put(s, src.get(s));
        }
    }
}
