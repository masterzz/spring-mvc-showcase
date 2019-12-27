import java.util.*;

public class TestString {


    public static Map<Character, Integer> handleStr(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int temp = countMap.get(chars[i]) == null ? 0 : countMap.get(chars[i]);
            countMap.put(chars[i], temp + 1);
        }
        sortMap(countMap);

        return countMap;
    }

    private static void sortMap(Map<Character, Integer> countMap) {
        Map<Integer, List<Character>> resultMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (!list.contains(entry.getValue()))
                list.add(entry.getValue());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1, temp; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            for (int i = 0; i < list.size(); i++) {
                if (entry.getValue() == list.get(i)) {
                    putMyMap(resultMap, list.get(i), entry.getKey());
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            List<Character> list1 = resultMap.get(list.get(i));
            for (int j = 0; j < list1.size(); j++) {
                System.out.print(list1.get(j) + ":" + list.get(i) + ";");
            }
        }

    }

    private static void putMyMap(Map<Integer, List<Character>> resultMap, Integer integer, Character key) {
        List<Character> list = resultMap.get(integer);
        if (null == resultMap.get(integer))
            list = new ArrayList<>();
        list.add(key);
        Collections.sort(list);
        resultMap.put(integer, list);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        handleStr(s);
    }
}
