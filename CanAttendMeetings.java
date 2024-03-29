
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, IntervalComparator);
        for (int i = 0; i < intervals.length - 1; ++i) {
        	if (intervals[i].end > intervals[i+1].start) {
        		return false;
        	}
        }
        return true;
    }

    private static Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
	    public int compare(Interval i1, Interval i2) {
	        return i1.start - i2.start;
	    }
	};
}

