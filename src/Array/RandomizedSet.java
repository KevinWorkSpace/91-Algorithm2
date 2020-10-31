package Array;

import java.util.*;

public class RandomizedSet {

    List<Integer> list;
    HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            list.set(index, list.get(list.size()-1));
            map.put(list.get(list.size()-1), index);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(-1);
        set.remove(-2);
        set.insert(-2);
        set.getRandom();
        set.remove(-1);
        set.insert(-2);
        set.getRandom();
    }
}
