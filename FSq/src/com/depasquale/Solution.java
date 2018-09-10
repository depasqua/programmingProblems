package com.depasquale;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /**
     * My solution used a tree map. At one early design point I was thinking of breaking up the endpoint paths
     * by their component.  Now I see that I'm not really using the tree that well, and perhaps a simple Map<String, String>
     * might be substituted.
     */
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, String> tree = buildInput(scan);

        processRequestPaths(scan, tree);
    }

    /**
     * This method processes the second part of the file, the requests. It attempts to first match them 'as is'
     * against entries in the tree map, thereby giving preference to static paths. If the attempt fails, wildcard
     * processing will occur, which likely could be improved upon.
     * This method is O(n) for the second part of the input.
     */
    private static void processRequestPaths(Scanner scan, TreeMap<String, String> tree)
    {
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String methodName = findPathInMap(line, tree);

            if (methodName != null)
                System.out.println(methodName);
            else {
                // checking alternatives before we give up and 404... this needs a lot of work here to better
                // find the variants...
                List<String> alternatives = createVariants(line);
                for (String variant : alternatives)
                {
                    methodName = findPathInMap(variant, tree);
                    if (methodName != null) {
                        System.out.println(methodName);
                        break;
                    }
                }
                if (methodName == null)
                    System.out.println("404");
            }
        }
    }

    /**
     * Builds a list of path variants to check. There's like regex stuff that can be used here, rather than the
     * hacky way I did this. And I know it's not going to hit all permutations that I believe I need to hit...
     * Ran out of time....
     */
    private static List<String> createVariants(String basePath)
    {
        List<String> resultList = new ArrayList<>();
        basePath = basePath.substring(1);  // drop leading slash for split...
        String [] variants = basePath.split("/");

        for (int index = 0; index < variants.length; index++)
        {
            String temp = variants[index];
            variants[index] = "X";
            String newVariant = joinParts(variants);
            resultList.add(newVariant);
            variants[index] = temp;
        }
        return resultList;
    }

    /**
     * Builds the variant parts back into a request path
     */
    private static String joinParts(String[] variant)
    {
        StringBuilder result = new StringBuilder();
        for (String aVariant : variant)
            result.append("/").append(aVariant);
        return result.toString();
    }

    /**
     * Attempts to find the specified string as the key to a map entry
     */
    private static String findPathInMap(String path, TreeMap<String, String> tree)
    {
        if (tree.get(path) != null)
            return tree.get(path);
        else
            return null;
    }

    /**
     * This method processes the first part of the input, the config, up to the line starting with '#'
     * It builds a treeMap of the config/methodName pairs. It adds them 'as is', so wildcards are added as read.
     * This method is O(n), but does not process all 'n' lines of the file.
     */
    private static TreeMap<String, String> buildInput(Scanner scan)
    {
        TreeMap<String, String> endpointTree = new TreeMap<>();
        String line = "";
        do
        {
            line = scan.nextLine();
            if (line.charAt(0) != '#') // end config section
            {
                String[] lineData = line.split(" ");
                endpointTree.put(lineData[0], lineData[1]);
            }
        } while (line.charAt(0) != '#');

        return endpointTree;
    }
}