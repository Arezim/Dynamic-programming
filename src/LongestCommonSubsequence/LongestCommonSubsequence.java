package LongestCommonSubsequence;
public class LongestCommonSubsequence {
    public static void main(String[] args){
        System.out.println(getLCS("abcd", "acbd"));
    }

    private static int getLCS(String string1, String string2){
        int length1 = string1.length();
        int length2 = string2.length();

        int[][] arr = new int[length1+1][length2+1];
        for(int i=0; i<length1+1; i++){
            for(int j=0; j<length2+1; j++){
                if(i == 0 || j == 0){
                    arr[i][j] = 0;
                }
                else if(string1.charAt(i-1) == string2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[length1][length2];
    }
}
