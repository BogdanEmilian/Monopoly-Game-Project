public class OutputDevice{
    public void writeMessage(String message){
        System.out.println(message);
    }

    public void writeMessage(int message){
        System.out.println(message);
    }

    public void arrayPrint(int[] num){
        for (int i = 0; i < num.length; i++ )
            System.out.print(num[i] + " ");
    }
}
