package BFS;

import java.util.*;

public class OpenTheLock {
    class Solution {
        public int openLock(String[] deadends, String target) {

return bfs(deadends, target);
        }
        class Edge{
            String node;
            int step;
            public Edge(String node, int step ) {
                this.node = node;
                this.step = step;
            }
        }

        int bfs(String[] deadends, String target) {
            List<String> stopsDeadEnds = Arrays.stream(deadends).toList();
            HashSet<String> visited = new HashSet<String>();
            visited.add("0000");
            Queue<Edge> pq = new PriorityQueue<>((a,b)->a.step-(b.step));
            pq.add(new Edge("0000",0));

            while (!pq.isEmpty()) {
                String curNode = pq.peek().node;
                int curStep = pq.peek().step;
                pq.poll();

                if (curNode.equals(target)) {
                    return curStep;
                }
                for (int i = 0;i < 4;i++){
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0;j < 4;j++){

                        if (i == j){

                            int digit = curNode.charAt(j)-'0';
                            digit++;
                            digit = digit % 10;
                            sb.append(digit);
                        }else
                            sb.append(curNode.charAt(j));

                    }
                    if (!visited.contains(sb.toString())&&!stopsDeadEnds.contains(sb.toString())){
                        visited.add(sb.toString());
                        pq.add(new Edge(sb.toString(),curStep+1));
                    }

                    sb = new StringBuilder();
                    for (int j = 0;j < 4;j++){

                        if (i == j){

                            int digit = curNode.charAt(j)-'0';
                            digit--;

                            if (digit<0)
                                digit = 9;
                            digit%=10;

                            sb.append(digit);
                        }else {

                            sb.append(curNode.charAt(j));
                        }
                    }
                    if (!visited.contains(sb.toString())&&!stopsDeadEnds.contains(sb.toString())){
                        visited.add(sb.toString());
                        pq.add(new Edge(sb.toString(),curStep+1));
                    }
                }
            }
            return -1;
        }

    }
}
