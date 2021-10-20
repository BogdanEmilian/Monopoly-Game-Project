import java.util.Random;

public class InputDevice {
     
    public String getType(){

        return "random";
    }

    public int nextInt(){

        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1,101);
    }
    
    public int throwDice(){

        Random randomGenerator = new Random();
        return randomGenerator.nextInt(2,13);
    }

    public int[] getNumbers(int N){

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = nextInt();
        }
        
            return num;
    }


}
