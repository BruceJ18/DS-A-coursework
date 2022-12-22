package datastructures.hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFNRC (String string) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = string.toCharArray();
        for (char chr : chars) {
            var count = map.containsKey(chr) ? map.get(chr) : 0;
            map.put(chr, count + 1);
        }
        for (char chr : chars){
            if (map.get(chr) == 1)
                return chr;
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatedChar(String string){
        Set<Character> set = new HashSet<>();

        var chars = string.toCharArray();
        for (char chr : chars) {
            if (set.contains(chr))
                return chr;

            set.add(chr);
        }
        return Character.MIN_VALUE;
    }
}
