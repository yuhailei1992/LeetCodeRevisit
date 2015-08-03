public class Solution {

    public static class EndHeightPair {
        public int end;
        public int height;
        public EndHeightPair(int end, int height) {
            this.end = end;
            this.height = height;
        }
    }

    public class HeightComparator implements Comparator<EndHeightPair> {
        @Override
        public int compare(EndHeightPair x, EndHeightPair y) {
            // Let the highest building be at top of PriorityQueue.
            return y.height - x.height;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }

        PriorityQueue<EndHeightPair> queue =
            new PriorityQueue<EndHeightPair>(buildings.length, new HeightComparator());
        for (int[] building : buildings) {
            if (queue.isEmpty()) {
                addToRes(res, building[0], building[2]);
            } else {
                // The case where current building doesn't overlap with previous highest building.
                if (building[0] > queue.peek().end) {
                    EndHeightPair prev = queue.poll();
                    // Discards those buildings completely hidden by previous highest building.
                    while (!queue.isEmpty() && queue.peek().end <= prev.end) {
                        queue.poll();
                    }
                    // Adds the silhouette point of previous tallest building.
                    addToRes(res, prev.end, queue.isEmpty() ? 0 : queue.peek().height);
                    // Adds the silhouette point of current building.
                    if (queue.isEmpty()
                        || (!queue.isEmpty() && queue.peek().height < building[2])) {
                        addToRes(res, building[0], building[2]);
                    }
                // The case where current building overlaps with previous highest building,
                // add silhouette point only if the current one is higher.
                } else if (building[0] < queue.peek().end) {
                    if (building[2] > queue.peek().height) {
                        addToRes(res, building[0], building[2]);
                    }
                // Edge case: current building is right beside previous highest building.
                // May need to update the height. Let addToRes to decide.
                } else {
                    addToRes(res, building[0], building[2]);
                }
            }
            // Adds the current building's end and height information into queue.
            queue.add(new EndHeightPair(building[1], building[2]));
        }
        // Final cleanup.
        while (!queue.isEmpty()) {
            EndHeightPair prev = queue.poll();
            // Discard those buildings that are completely hidden by previous highest one.
            while (!queue.isEmpty() && queue.peek().end <= prev.end) {
                queue.poll();
            }
            addToRes(res, prev.end, queue.isEmpty() ? 0 : queue.peek().height);
        }
        return res;
    }

    /**
     * Adds a new silhouette point into results.
     */
    private void addToRes(List<int[]> res, int position, int height) {
        if (res.size() == 0) {
            res.add(new int[]{position, height});
        } else {
            // Compares current silhouette point with previous one.
            int[] prev = res.get(res.size() - 1);
            // If they are of the same height, do nothing.
            if (prev[1] == height) {
                return;
            }
            // If they have same position, update the height of the highest building.
            if (prev[0] == position) {
                height = Math.max(height, prev[1]);
                // To update the height, we remove the previous silhouette point.
                res.remove(res.size() - 1);
            }
            res.add(new int[]{position, height});
        }
    }
}