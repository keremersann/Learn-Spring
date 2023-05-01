package junit;

public class MyMath {
    public int calculateSum(int[] numbers){
        int total = 0;
        for(int num : numbers){
            total += num;
        }
        return total;
    }
}
