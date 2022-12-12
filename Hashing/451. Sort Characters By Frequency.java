package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sortByFrequency {

    public String frequencySort(String s) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            max = Math.max(max, map.get(s.charAt(i)));
            min = Math.min(min, map.get(s.charAt(i)));
        }
        if (max == 1 && min == 1)
            return s;
        StringBuffer sb = new StringBuffer();

        for (int i = max; i >= min; i--) {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                int n = e.getValue();
                if (n == i) {
                    while (n > 0) {
                        sb.append(e.getKey());
                        n--;
                    }
                }
            }
        }
        return sb.toString();
    }

    public String frequencySortOne(String s) {

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Make a list of the keys, sorted by frequency.
        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

        // Convert the counts into a string with a sb.
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String frequencySortTwo(String s) {

        if (s == null || s.isEmpty())
            return s;

        // Create a sorted Array of chars.
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Convert identical chars into single Strings.
        List<String> charStrings = new ArrayList<String>();
        StringBuilder currentString = new StringBuilder();
        currentString.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                charStrings.add(currentString.toString());
                currentString = new StringBuilder();
            }
            currentString.append(chars[i]);
        }
        charStrings.add(currentString.toString());

        // Our comparator is (a, b) -> b.length() - a.length().
        // If a is longer than b, then a negative number will be returned
        // telling the sort algorithm to place a first. Otherwise, a positive
        // number will be returned, telling it to place a second.
        // This results in a longest to shortest sorted list of the strings.
        Collections.sort(charStrings, (a, b) -> b.length() - a.length());

        // Use StringBuilder to build the String to return.
        StringBuilder sb = new StringBuilder();
        for (String str : charStrings)
            sb.append(str);
        return sb.toString();
    }
}
