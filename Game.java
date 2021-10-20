public class Game {

    public int multCheck(int H, int S){
        if ( H % S == 0 )
            return 1;
        else if ( S % H == 0 )
            return -1;
        else 
            return 0;
    }

    
}
