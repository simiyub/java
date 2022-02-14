import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class BalloonExample <T> {

    /**
     * A string S consisting of uppercase English letters is given.
     * In one move we can delete seven letters from S,
     * forming the word "BALLOON" (one 'B', one 'A', two 'L's, two 'O's and one 'N'),
     * and leave a shorter word in S.
     *
     * If the remaining letters in the shortened S are sufficient to allow another instance
     * of the word "BALLOON" to be removed, next move can be done.
     * What is the maximum number of such moves that we can apply to S?
     *
     * Write a function: class Solution public int solution(String s); }
     * that, given a string S of length N, returns the maximum number of moves that can be applied.
     *
     * Examples: 1. Given S="BAONXXOLL", the function should return 1. BAONXXOLL-XX
     * 2. Given S="BACOLLNNOLOLGBAX, the function should return BASTOLLA NOLASGHAR BOLGAXGX
     *
     * Given S="QAWABAWONL", the function should return 0. QAWABAWONL
     * Given S="ONLABLABLOON', the function should return 1. ONLABLABLOON OLABN
     * Write an efficient algorithm for the following assumptions: • N is an integer within the range 1.200,000): • string S consists only of uppercase letters (A-2).
     *
     * */



    private char[] quickSort(char[] array, int start, int end) {
        if(start>=end){
            return array;
        }
        int pivot = array[(start+end)/2];
        int index = partition(array,start,end,pivot);
        quickSort(array,start,index-1);
        quickSort(array,index,end);
        return array;

    }

    private int partition(char[] array, int left, int right, int pivot) {
        while(left<=right){
            while(array[left]<pivot){
                left++;
            }
            while (array[right]>pivot){
                right--;
            }
            if(left<=right){
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

//   private int charactersInAnArray(T[] array, Map characters){
//        char[] balloonChar = "BALLOON".toCharArray();
//        for(int i=0; i<balloonChar.length; i++){
//            Arrays.stream(array).filter(ch -> ch == balloonChar[i]).count();
////        }
////    }

    public static void main(String[] args){
                //String testString = "BAONXXOLL";
                String testString = "BAOOLLNNOLOLGBAX";
                BalloonExample balloonExample = new BalloonExample();
                String balloon = "BALLOON";
                char[] balloonArray = balloon.toCharArray();
                Map<Character, Integer> charCounts = new HashMap();
                for (int i = 0; i < balloonArray.length; i++) {
                    int count = 1;
                    if (charCounts.containsKey(balloonArray[i])) count += 1;
                    charCounts.put(balloonArray[i], count);
                }
                System.out.println(charCounts);
                char[] testChars = testString.toCharArray();
                Arrays.parallelSort(testChars);
                System.out.println(testChars);
                Map<Character, Long> testCharCount = new HashMap();
                charCounts.forEach((k,v) -> {
                    testCharCount.put(k, testString.chars().filter(ch -> ch == k).count());

                });
                testCharCount.forEach( (k,v)-> System.out.println(k+":"+v));

                for(Map.Entry<Character,Integer> e: charCounts){

                }
            }


//        array = balloonExample.quickSort(testString.toCharArray(),0,testString.length()-1);
//        String balloon = "BALLOON";
//        char[] array = testString.toCharArray();
//        Arrays.parallelSort(testString.toCharArray());
//        for(int i=0; i<array.length; i++){
//            balloon.chars().filter(ch -> ch == array[i]).count();
//        }

    }

