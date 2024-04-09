import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator;

class Solution {
    class Tuple implements Comparable<Tuple> {
        public int idx;
        public int val;

        public Tuple(int index, int val) {
            this.idx = index;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "(" + this.idx + ", " + this.val + ")";
        }
    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int k_ticket = tickets[k];
        System.out.println(k_ticket + " " + "k_ticket");
        ArrayList<Tuple> ticket_tup = new ArrayList<>();
        for (int m =0; m<n; m++) {
            ticket_tup.add(new Tuple(m, tickets[m]));
        }
        Collections.sort(ticket_tup);
        System.out.println(ticket_tup);
        int time = 0;
        int maxVal = k_ticket;

        for (int i = 0; i<n; i++) {
            if (ticket_tup.get(i).val<k_ticket ) {
                time += ticket_tup.get(i).val;
                System.out.println("time: " + time + " " + "previousVal: " + maxVal);
            } else {
                if (ticket_tup.get(i).idx<=k ) {
                    time += maxVal;
                } else {
                    time += maxVal -1;
                }
            }
        }
        return time;

          
      


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] tickets = {2,3,2};
        int k = 2;
        int time = sol.timeRequiredToBuy(tickets, k);

        System.out.println(time);
    }
}