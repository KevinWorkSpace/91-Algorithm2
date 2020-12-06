package Basic.Tree.test;

import java.util.ArrayList;
import java.util.List;

public class VerticalTraversal {

    List<Location> locationList = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        locationList.sort(null);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(locationList.get(0).val);
        for (int i=1; i<locationList.size(); i++) {
            Location tmp = locationList.get(i);
            Location pre = locationList.get(i-1);
            if (tmp.x == pre.x) {
                tmpList.add(tmp.val);
            }
            else {
                list.add(new ArrayList<>(tmpList));
                tmpList.clear();
                tmpList.add(tmp.val);
            }
        }
        list.add(tmpList);
        return list;
    }

    public void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        Location location = new Location(root.val, x, y);
        locationList.add(location);
        dfs(root.left, x-1, y-1);
        dfs(root.right, x+1, y-1);
    }
}

class Location implements Comparable<Location>{
    int val;
    int x;
    int y;

    public Location(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Location o) {
        if (this.x > o.x) return 1;
        else if (this.x == o.x) {
            if (this.y < o.y) return 1;
            else if (this.y == o.y) {
                if (this.val > o.val) return 1;
                else if (this.val == o.val) return 0;
                else return -1;
            }
            else return -1;
        }
        else return -1;
    }
}
