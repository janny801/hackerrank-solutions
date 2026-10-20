// ──────────────────────────────────────────────────
// Link        https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-elements-greater-than-previous-average/problem?isFullScreen=true
// Problem     Count Elements Greater Than Previous Average
// Difficulty  Easy
// Subdomain   Software Engineer Prep Kit
// Platform    HackerRank
// Language    java15
// Status      Accepted
// Submitted   2026-10-20, 02:11 p.m.
// ──────────────────────────────────────────────────

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */

public static int countResponseTimeRegressions(List<Integer> responseTimes) {
    // edge case; if there are fewer than 2 elements, we cannot compare to a prev average
    if (responseTimes==null|| responseTimes.size()<2)
    {
        return 0; 
    }
    int regressioncount = 0; //count of elements strictly greater then the running average of prev elements
    
    long runningsum= responseTimes.get(0); //.get(0) gets the first element 
    //running total that updates by adding a new number to a cumulative sum of prev numbers as we go thru the list 
    for(int i =1; i<responseTimes.size(); i++)
    {
        //start at index 1 since problem statement says to skip first element 
        //first element is the size of the array 
        long currentval = responseTimes.get(i); 
        
        //calculate average of all element seen prior to index i 
        double prevavg= (double)runningsum /i; 
        
        //check if current response time is strictly greater than prior avg 
        if(currentval>prevavg)
        {
            regressioncount ++; 
        }
        //add the current value to the running total for the next element 
        runningsum += currentval; 
    }
    return regressioncount; 
    
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countResponseTimeRegressions(responseTimes);

        System.out.println(result);

        bufferedReader.close();
    }
}
