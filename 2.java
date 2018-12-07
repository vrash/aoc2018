import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class aoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("/Users/vrashabhirde/Desktop/aoc/input2.txt"));


        long sum = 0;
        int twocount = 0;
        int threecount = 0;

        ArrayList<String> temp = new ArrayList<>();
        int count = 0;
        int lowestDist = 0;
        String first="";
        String second="";
        while (reader.hasNextLine()) {
            String nextLiner = reader.nextLine();
            //input[count] = nextLiner;
            temp.add(nextLiner);
            //count++;
        }
        String[] input = new String[temp.size()];
        input = temp.toArray(input);
        for(int i=0; i<input.length; i++)
        {
            for(int j=i+1; j<input.length-1; j++)
            {
                //int dist = LevenshteinDistance.computeLevenshteinDistance(input[i],input[j]);
                int dist = distancCal(input[i], input[j]);
                if(i==0 && j==1)
                    lowestDist=dist;
                if(dist<lowestDist)
                {
                    lowestDist = dist;
                    first = input[i];
                    second = input[j];
                }

            }
        }
        System.out.println(first + " " + second);
        for(int i=0; i<first.length(); i++)
        {
            if(first.charAt(i)==second.charAt(i))
                System.out.print(first.charAt(i));
        }
    }

    public static int distancCal(String w1, String w2){
        int counter = 0;
        char[] first  = w1.toLowerCase().toCharArray();
        char[] second = w2.toLowerCase().toCharArray();

        int minLength = Math.min(first.length, second.length);

        for(int i = 0; i < minLength; i++)
        {
            if (first[i] != second[i])
            {
                counter++;
            }
        }
        return counter;
    }

}

class LevenshteinDistance {
    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(
            CharSequence str1,
            CharSequence str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= str1.length(); i++)
            for (int j = 1; j <= str2.length(); j++)
                distance[i][j] =
                        minimum(
                                distance[i - 1][j] + 1,
                                distance[i][j - 1] + 1,
                                distance[i - 1][j - 1] +
                                        ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));

        return distance[str1.length()][str2.length()];

    }
}


//   if(!reader.hasNextLine())
//     reader = new Scanner(new File("/Users/vrashabhirde/Desktop/aoc/input1.txt"));
