import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public static void main(String[] arrivingOnTime) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);

        

        // your code goes here
        // no. of stops
        int n = fs.nextInt();
        // no of lines
        int m = fs.nextInt();
        // arrival time
        int s = fs.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int t0 = fs.nextInt();
            int p = fs.nextInt();
            int d = fs.nextInt();
            adj.get(v).add(new Edge(u, t0, p, d));
        }

        int[] latestArrival = new int[n];
        Arrays.fill(latestArrival, Integer.MIN_VALUE);
        latestArrival[n-1] = s;

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(State -> -State.latestTime));
        pq.add(new State(n-1, s));

        while(!pq.isEmpty()) {
            State currentState = pq.poll();
            int arrivalTime = currentState.latestTime;
            int currentStop = currentState.node;
            // if alr have later time at this node can skip
            if (arrivalTime<latestArrival[currentStop]) {
                continue;
            }
            // get adjacent
            for (Edge e : adj.get(currentStop)) {
                int prev = e.u;
                int t0 = e.t0;
                int p = e.p;
                int d = e.d;

                int latest_departure = arrivalTime - d;
                if (latest_departure < t0 ) continue;
                int waitingTime = (latest_departure - t0 ) % p == 0 ? 0 : (latest_departure - t0) % p;
                writer.println("waitingTime: " + waitingTime);
                // need to leave earlier if train hasn't reached
                latest_departure = latest_departure - waitingTime;
                // >= BECAUSE .. 
                if (latest_departure >= latestArrival[prev]) {
                    latestArrival[prev] = latest_departure;
                    pq.add(new State(prev, latest_departure));
                }
            }
        }

        if (latestArrival[0] == Integer.MIN_VALUE) {
            writer.println("impossible");
        } else {
            writer.println(latestArrival[0]);
        }




        writer.close(); // do not forget!
    }

    static class Edge {
        int u, t0, p, d;
        // u is departing node
        Edge(int u, int t0, int p, int d) {
            this.u = u;
            this.t0 = t0;
            this.p = p;
            this.d = d;
        }
    }

    static class State {
        int node;
        int latestTime;

        State(int node, int latestTime) {
            this.node = node;
            this.latestTime = latestTime;
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(
                            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}