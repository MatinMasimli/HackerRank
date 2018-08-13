package HackerRank.SherlockAndAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        System.out.println(s);

        HashMap<String, Integer> subCharsMap = new HashMap<>();
        HashMap<String, Integer> leftOverMap = new HashMap<>();
        HashMap<String, Integer> leftOverInnerMap = new HashMap<>();
        HashMap<String, Integer> subCharsInnerMap = new HashMap<>();

        ArrayList<String> subCharsArr = new ArrayList<>();
        ArrayList<String> leftOverArr = new ArrayList<>();

        int count = 0;
        for(int j = 0; j < s.length(); j++){

            int subCharKey = 0;
            int leftOverKey = 0;
            int end = j+1;
            String subChars = "";
            String leftOverString = s;

            while(end <= leftOverString.length()){

                subChars = s.substring(j, end);
                subCharsMap.put(subChars, subCharKey);
                subCharsArr.add(subCharKey, subChars);
                subCharKey++;

                leftOverString = s.substring(j+1);
                leftOverMap.put(leftOverString, leftOverKey);
                leftOverArr.add(leftOverKey, leftOverString);
                System.out.println("subChars: " + subChars + " left: " + leftOverString + " end: " + end + " j: " + j);
                leftOverKey++;

                end++;

                int charCount = 0;
                int index = Integer.MIN_VALUE;


                for(int m = 0; m < subChars.length(); m++){
                    for(int n = 0; n < leftOverString.length(); n++){
                        if(leftOverString.charAt(n) == subChars.charAt(m)){

                            charCount++;
                            if(subChars.length() == 1){
                                if(charCount == subChars.length()){
                                    count++;
                                }
                            }
                            else{
                                if(m==0){
                                    index = n;
                                }
                                else{
                                    if(n == index - 1 || n == index + 1){
                                        if(charCount == subChars.length()){
                                            count++;
                                        }
                                    }
                                }

                            }

                        }
                    }
                }

            }

    /*        System.out.println("subCharMap" + subCharsMap);
            System.out.println("leftOverMap" + leftOverMap);

            System.out.println("subCharArr" + subCharsArr);
            System.out.println("leftOverArr" + leftOverArr);

            for(int i = 0; i < subCharsArr.size(); i++){

            }  */

        }




/*

        System.out.println(s);

        HashMap<String, Integer> subCharsMap = new HashMap<>();
        HashMap<String, Integer> leftOverMap = new HashMap<>();

        ArrayList<String> subCharsArr = new ArrayList<>();
        ArrayList<String> leftOverArr = new ArrayList<>();

        int count = 0;
        for(int j = 0; j < s.length(); j++){

            int subCharKey = 0;
            int leftOverKey = 0;
            int end = j+1;
            String subChars = "";
            String leftOverString = s;

            while(end <= leftOverString.length()){

                subChars = s.substring(j, end);
                subCharsMap.put(subChars, subCharKey);
                subCharsArr.add(subCharKey, subChars);
                subCharKey++;

                leftOverString = s.substring(j+1);
                leftOverMap.put(leftOverString, leftOverKey);
                leftOverArr.add(leftOverKey, leftOverString);
                System.out.println("subChars: " + subChars + " left: " + leftOverString + " end: " + end + " j: " + j);
                leftOverKey++;

                end++;


            }

            System.out.println("subCharMap" + subCharsMap);
            System.out.println("leftOverMap" + leftOverMap);

            System.out.println("subCharArr" + subCharsArr);
            System.out.println("leftOverArr" + leftOverArr);

            for(int i = 0; i < subCharsArr.size(); i++){

            }

*/






        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Anagram"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}