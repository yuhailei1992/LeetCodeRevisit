/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
        	return 0;
        }

        int maxNum = 0;
        int len = points.length;
        // For each of the points.
        for (int i = 0; i < len; ++i) {
            // Find the number of same points.
        	int samePoint = 0;
        	Map<Double, Integer> map = new HashMap<>();
        	// Cluster the points with slope.
        	for (int j = i + 1; j < len; ++j) {
        		Double key = null;
        		if (points[i].x == points[j].x && points[i].y == points[j].y) {
        			samePoint++;
        		} else if (points[i].x == points[j].x) {
        			key = (double)Integer.MAX_VALUE;
        		} else {
        		    if (points[i].y == points[j].y) {
        		        key = 0.0;
        		    } else {
        			    key = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
        		    }
        		}
        		// Puts into map.
        		if (key != null) {
            		if (!map.containsKey(key)) {
            			map.put(key, 1);
            		} else {
            			map.put(key, map.get(key) + 1);
            		}
        		}
        	}
        	// Finds the max.
        	int numPoints = samePoint;
        	for (Map.Entry<Double, Integer> entry : map.entrySet()) {
        		numPoints = Math.max(numPoints, samePoint + entry.getValue());
        	}
        	maxNum = Math.max(maxNum, numPoints);
        }
        return maxNum + 1;
    }
}