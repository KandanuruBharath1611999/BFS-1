// Time Complexity: O(V + E) — where V is the number of courses (vertices) and E is the number of prerequisite pairs (edges).
// Space complexity: O(V + E) — for the adjacency list (map), the count array, and the queue st.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: -

// Approach :
// Build an adjacency list and an indegree array to represent prerequisites.
// Add all courses with 0 indegree to a queue and perform BFS (topological sort).
// If all courses are processed (no cycle), return true; otherwise, return false.

import java.util.*;
public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        Queue<Integer> st = new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            if(!map.containsKey(prerequisites[i][1]))
            {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],al);
            }
            else
            {
                ArrayList<Integer> al  = map.get(prerequisites[i][1]);
                al.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],al);
            }
            count[prerequisites[i][0]]++;
        }
        for(int i=0;i<count.length;i++)
        {
            if(count[i]==0)
            {
                st.add(i);
            }
        }
        if(st.isEmpty())
        {
            return false;
        }
        while(!st.isEmpty())
        {
            int x = st.poll();
            ArrayList<Integer> al =  map.get(x);
            if(al!=null)
            {
                for(int i=0;i<al.size();i++)
                {
                    int xy = al.get(i);
                    count[al.get(i)] =  count[al.get(i)] -1;
                    if(count[al.get(i)] == 0)
                    {
                        st.add(xy);
                    }
                }
            }
        }
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>0)
            {
                return false;
            }
        }
        return true;
    }
}