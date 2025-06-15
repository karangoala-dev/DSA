package Algorithms.IntervalQns;

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {
    private static class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        for(Interval i: intervals){
            pq.add(i);
        }
        int prevEndsAt = -1;
        while (!pq.isEmpty()){
            Interval curr = pq.poll();
            if(curr.start < prevEndsAt){
                return false;
            }
            prevEndsAt = curr.end;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
