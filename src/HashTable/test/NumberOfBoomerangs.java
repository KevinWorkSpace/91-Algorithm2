package HashTable.test;

import java.util.HashMap;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = null;
        for (int i=0; i<points.length; i++) {
            int[] point = points[i];
            map = new HashMap<>();
            for (int j=0; j<points.length; j++) {
                if (j != i) {
                    int[] tmp = points[j];
                    int dis = (point[0] - tmp[0]) * (point[0] - tmp[0]) + (point[1] - tmp[1]) * (point[1] - tmp[1]);
                    if (map.containsKey(dis)) {
                        map.put(dis, map.get(dis) + 1);
                    }
                    else map.put(dis, 1);
                }
            }
            for (Integer key : map.keySet()) {
                int num = map.get(key);
                if (num >= 2) res = res + num * (num-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        NumberOfBoomerangs boomerangs = new NumberOfBoomerangs();
        int res = boomerangs.numberOfBoomerangs(points);
    }
}
