import java.util.Scanner;

public class Application {
    InputDevice inputDevice;
    OutputDevice outputDevice;
    
    String[] board = new String[40];
    
    public String scan(String displayMessage)
    {   
        outputDevice.writeMessage(displayMessage+"\n");
        Scanner scanner = new Scanner(System.in);
        String input="";
        if(scanner.hasNextLine())
            input = scanner.nextLine();
        if(input.contentEquals("")){
            input="0";
            scanner.close();            //Should close only when it's not used anymore, otherwise it goes crazy #tested
        }
        return input;
    }



    class Square{
        public String type;
        public String name;
        public int price;
        public int propNumber;

        public Square(String type, String name, int propNumber, int price){
            this.type = type;
            this.name = name;
            this.propNumber = propNumber;
            this.price = price;
        }

        public void action(Player player, Bank bank){
            if(this.type.equals("tax") || this.type.equals("start")){
                player.balance-=this.price;
                bank.totalBalance+=this.price;
                bank.playersBalance-=this.price;
            }
        }


    }
    class Player{
        String name;
        String shape;
        int position;
        int balance;

        public Player(String name, String shape, int position, int balance){
            this.name = name;
            this.shape = shape;
            this.position = position;
            this.balance = balance;
        }



    }

    class Bank{
        public int totalBalance;
        public int playersBalance;

        public Bank(){
            this.totalBalance=20580;
            this.playersBalance=0;
        }

        public void transfer(Player player, Square[] square, int ammount){
            player.balance-=ammount;
            totalBalance+=ammount;
        }
    }

    Square[] square;

    
    public void initialization(int playerNumber){
        square = new Square[40];
        
        square[0] = new Square("start", "Start", 0, -200);
        square[1] = new Square("prop", "Mediteranean Avenue", 0, 60);
        square[2] = new Square("chest", "Community Chest", 0, 0);
        square[3] = new Square("prop", "Baltic Avenue",0 , 60);
        square[4] = new Square("tax", "Income Tax",0 , 200);
        square[5] = new Square("railroad", "Reading Railroad",0 , 200);
        square[6] = new Square("prop", "Oriental Avenue",0 , 100);
        square[7] = new Square("chance", "Chance",0 , 0);
        square[8] = new Square("prop", "Vermont Avenue",0 , 100);
        square[9] = new Square("prop", "Connecticut Avenue",0 , 100);

        square[10] = new Square("jail", "In Jail/Just Visiting",0 , 0);
        square[11] = new Square("prop", "St. Charles Place",0 , 140);
        square[12] = new Square("company", "Elcectric Company",0 , 150);
        square[13] = new Square("prop", "States Avenue",0 , 140);
        square[14] = new Square("prop", "Virginia Avenue",0 , 140);
        square[15] = new Square("railroad", "Pennsilvania Railroad",0 , 200);
        square[16] = new Square("prop", "St. James Place",0 , 180);
        square[17] = new Square("chest", "Community Chest",0 , 0);
        square[18] = new Square("prop", "Tennessee Avenue",0 , 180);
        square[19] = new Square("prop", "New York Avenue",0 , 180);

        square[20] = new Square("parking", "Free Parking",0 , 0);
        square[21] = new Square("prop", "Kentucky Avenue",0 , 220);
        square[22] = new Square("chance", "Chance",0 , 0);
        square[23] = new Square("prop", "Indiana Avenue",0 , 220);
        square[24] = new Square("prop", "Illinois Avenue",0 , 240);
        square[25] = new Square("railroad", "B. & O. Railroad",0 , 200);
        square[26] = new Square("prop", "Atlantic Avenue",0 , 260);
        square[27] = new Square("prop", "Ventnor Avenue",0 , 260);
        square[28] = new Square("company", "Water Works",0 , 150);
        square[29] = new Square("prop", "Marvin Gardens",0 , 280);

        square[30] = new Square("go to jail", "GO TO JAIL",0 , 0);
        square[31] = new Square("prop", "Pacific Avenue",0 , 300);
        square[32] = new Square("prop", "North Carolina Avenue",0 , 300);
        square[33] = new Square("chest", "Community Chest",0 , 0);
        square[34] = new Square("prop", "Pennsylvania Avenue",0 , 320);
        square[35] = new Square("railroad", "Short Line",0 , 200);
        square[36] = new Square("chance", "Chance",0 , 0);
        square[37] = new Square("prop", "Park Place",0 , 350);
        square[38] = new Square("tax", "Luxury Tax",0 , 100);
        square[39] = new Square("prop", "Boardwalk",0 , 400);

        Bank bank = new Bank();
        Player[] player =new Player[playerNumber];
        
        
        
        for(int i=0; i<playerNumber; i++){
            player[i] = new Player(scan("Please enter the name of player " + i+1), scan("Please enter the shape of player " + i+1), 0, 0);
        }

        

    }


    public Application(InputDevice in, OutputDevice out){
        inputDevice = in;
        outputDevice = out;
    }

    public void run(){
        outputDevice.writeMessage("Application Started!");
        int playerNumber = Integer.parseInt(scan("Please enter the number of players:"));
        initialization(playerNumber);
        outputDevice.writeMessage("The game has begun!");

    }
}
    