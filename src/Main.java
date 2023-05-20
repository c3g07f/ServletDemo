import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ${description}
 *
 * @author C3g07f
 * @date ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        for(Integer key: map.keySet()){ // keySet()返回所有键的集合
//            System.out.println(key + " " + map.get(key));
//        }
//        for(String value: map.values()) { //values()返回所有值的集合
//            System.out.println(value);
//        }

//        for (Map.Entry<Integer, String> entry: map.entrySet()) { //entrySet()返回所有键值对的集合
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        map.forEach((key, value) -> System.out.println(key + " " + value));

    }
}