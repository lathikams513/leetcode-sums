import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = i; 
            robots[i][3] = directions.charAt(i);
        }

        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[3] == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[3] == 'R') {
                    int[] top = stack.peek();

                    if (top[1] == robot[1]) {
                        stack.pop();
                        robot[1] = 0;
                        break;
                    } else if (top[1] > robot[1]) {
                        top[1]--;
                        robot[1] = 0;
                        break;
                    } else {
                        stack.pop();
                        robot[1]--;
                    }
                }

                if (robot[1] > 0) {
                    stack.push(robot);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            int[] r = stack.pop();
            map.put(r[2], r[1]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }
}