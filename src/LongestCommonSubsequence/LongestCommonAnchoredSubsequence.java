package LongestCommonSubsequence;
public class LongestCommonAnchoredSubsequence {
    public static void main(String[] args){
        System.out.println("solution: " + getLCS("****", "a*b*cd*"));
    }

    private static int getLCS(String string1, String string2){
        int length1 = string1.length();
        int length2 = string2.length();
        int max=0;

        int[][] arr = new int[length1+1][length2+1];
        System.out.print("\t\t");
        for(int i=0; i<length2; i++){
            System.out.print(string2.charAt(i) + "\t");
        }
        System.out.println();
        for(int i=0; i<length1+1; i++){
            if(i>0 && i<length1+1)System.out.print(string1.charAt(i-1) + "\t");
            else if (i==0) {
                System.out.print("\t");
            }
            for(int j=0; j<length2+1; j++){
                if(i == 0 || j == 0){
                    arr[i][j] = 0;
                }
                else if((string1.charAt(i-1) == string2.charAt(j-1))){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else if(string2.charAt(j-1) == '*'){
                    arr[i][j] = arr[i-1][j];
                }
                else if(string1.charAt(i-1) == '*'){
                    arr[i][j] = arr[i][j-1];
                }
                else{
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                }
                if(arr[i][j] > max){
                    max = arr[i][j];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return max;
    }
}