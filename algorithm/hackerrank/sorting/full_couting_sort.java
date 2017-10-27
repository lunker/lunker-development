import java.io.*;
import java.util.*;

public class Solution {




    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        InputData[] inputArr;
        LinkedList<Integer>[] countingArr=new LinkedList[100]; // 0 <= x < 100
        InputData inputData=null;

        int n=0;
        int key;
        String value;

        Scanner in = new Scanner(System.in);

        n=in.nextInt();
        inputArr=new InputData[n];

        for(int x=0; x<100; x++)
            countingArr[x]=new LinkedList<Integer>();

        for(int idx=0; idx<n; idx++) {
            key=in.nextInt();
            value=in.nextLine();
            inputArr[idx]= new InputData(key, value.split(" ")[1]);

            inputData=inputArr[idx];
            countingArr[inputData.key].add(idx);
            //System.out.println(key+","+value);
        }

        // ------------- solve problem
        compute(inputArr, countingArr, n);
    }

    public static void compute(InputData[] inputArr, LinkedList<Integer>[] countingArr, int n){
        InputData inputData=null;

        int numOfValuesOnKey=0;
        int limit=n/2;

        for(int x=0; x<100; x++) {
            numOfValuesOnKey=countingArr[x].size();

            for(int idx=0; idx<numOfValuesOnKey; idx++){
                int idxOnInputArr=countingArr[x].pollFirst();
                if(idxOnInputArr < limit) {
                    System.out.print("-");
                }
                else{
                    System.out.print(inputArr[idxOnInputArr].value);
                }
                System.out.print(" ");
            }
        }
    }
}

class InputData{
    public int key;
    public String value;
    public InputData(int key, String value){
        this.key=key;
        this.value=value;
    }
}
