package HackerRank.TwoStrings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // Complete the twoStrings function below.
    private static String twoStrings(String s1, String s2) {

        HashSet<String> characterSet1 = new HashSet<>();
        HashSet<String> characterSet2 = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++){
            characterSet1.add(String.valueOf(s1.charAt(i)));
        }

        for(int i = 0; i < s2.length(); i++){
            characterSet2.add(String.valueOf(s2.charAt(i)));
        }

        System.out.println("charS1: " + characterSet1);
        System.out.println("charS2: " + characterSet2);

        boolean resultBool = characterSet1.retainAll(characterSet2);
        System.out.println("Res1: " + characterSet1);
        System.out.println("Res2: " + characterSet2);


        if(!characterSet1.isEmpty()){
            result.add("YES");
        }
        else{
            result.add("NO");
        }

        for(String halfResult:result){
            System.out.println("halfRes: " + halfResult);
            return halfResult;
        }

        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("TwoStrings"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
