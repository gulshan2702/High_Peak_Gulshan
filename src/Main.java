import java.util.*;

public class Main {
    static class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    static int[] findMaxEarnings(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int endTime = 0;
        int totalEarnings = 0;
        int remainingTasks = jobs.length;
        for (Job job : jobs) {
            if (job.start >= endTime) {
                endTime = job.end;
                totalEarnings += job.profit;
                remainingTasks--;
            }
        }

        return new int[] { remainingTasks, totalEarnings };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Jobs");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter job start time, end time, and earnings");
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(start, end, profit);
        }

        int[] result = findMaxEarnings(jobs);
        System.out.println("The number of tasks and earnings available for others");
        System.out.println("Task: " + result[0]);
        System.out.println("Earnings: " + result[1]);
    }
}