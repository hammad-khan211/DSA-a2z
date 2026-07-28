import java.util.*;

class Pair {
    double distance;
    int index;
    
    Pair(double distance , int index)
    {
        this.distance = distance;
        this.index = index;
    }
}

class MinDistBetweenGasStation
{
    static double brute(int[] stations , int k) //tc O(n * k)
    {
        if(stations.length == 1) return 0.0;
        int[] extraStations = new int[stations.length - 1];
        for(int gasStations = 1 ; gasStations <= k ; gasStations++)
        {
            double maxValue = 0;
            int maxIndex = -1;
            for(int i = 0 ; i < stations.length - 1 ; i++)
            {
                double difference = stations[i + 1] - stations[i];
                double sectionLength = difference / (extraStations[i] + 1);
                if(maxValue < sectionLength)
                {
                    maxValue = sectionLength;
                    maxIndex = i;
                }
            }
            extraStations[maxIndex]++;
        }
        double ans = 0;
        for(int i = 0 ; i < stations.length - 1 ; i++)
        {
            double diff = stations[i + 1] - stations[i];
            double maxL = diff / (extraStations[i] + 1);
            ans = Math.max(ans , maxL);
        }
        return ans;
    }

    static double optimal(int[] stations, int k) //tc 
    {
        if(stations.length == 1) return 0.0;
        int[] extraStations = new int[stations.length - 1];
        
        PriorityQueue < Pair > pq = new PriorityQueue<>((a , b) -> {
            int cmp = Double.compare(b.distance , a.distance);
            if(cmp != 0) return cmp;
            return Integer.compare(b.index , a.index);
            });
        
        for(int i = 0 ; i < stations.length - 1 ; i++)
        {
            pq.add(new Pair(stations[i + 1] - stations[i] , i));
        }
        
        for(int g = 1 ; g <= k ; g++)
        {
            Pair top = pq.poll();
            int idx = top.index;
            extraStations[idx]++;
            double totalDist = stations[idx + 1] - stations[idx];
            double newDist = totalDist / (extraStations[idx] + 1);
            pq.add(new Pair(newDist , idx));
        }
        return pq.peek().distance;
        
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of gas stations : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the distance of each gas station : ");
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of gas stations to be added : ");
        int g = sc.nextInt();
        double ans = optimal(arr, g);
        System.out.println("The maximum distance between " + g + " stations is minimum at : " + ans);
        sc.close();

    }


}