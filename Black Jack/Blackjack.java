import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        //Wait for the user to press enter.
        scan.nextLine();

        //Get two random cards.
        //Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        int rand1=drawRandomCard();
        int rand2=drawRandomCard();
        String card1=cardString(rand1);
        String card2=cardString(rand2);
        System.out.println("\n You get a \n" + card1 + "\n and a \n" + card2);
        
        // Print the sum of your hand value.
        // print: your total is: <hand value>
        int handValue=Math.min(rand1,10)+Math.min(rand2,10);//face cards will have 10 as values
        System.out.println("Your total is: "+handValue+"\n");
        
        //– Get two random cards for the dealer.
        //– Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //– Print: \nThe dealer's total is hidden
        
        int randDealer1=drawRandomCard();
        int randDealer2=drawRandomCard();
        String cardDealer1=cardString(randDealer1);
        String cardDealer2=cardString(randDealer2);
        int handValueDealer=Math.min(randDealer1,10)+ Math.min(randDealer2,10);
        System.out.println("The dealer shows \n" + cardDealer1 + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

        //   – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 

        while(true){
            String choice=hitOrStay();
            if (choice.equals("hit")){
                int cardNo=drawRandomCard();
                String card=cardString(cardNo);
                handValue+=Math.min(cardNo,10);
                System.out.println("\nYou get a\n "+card);
                System.out.println("Your new total is "+handValue);
                if (handValue>21){
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
            }
            else if (choice.equals("stay")){
                break;
            }
            else{
                continue;
            }
        }

        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n "+cardDealer1+" \n and a \n "+cardDealer2+"\n");
        System.out.println("Dealer's total is " + handValueDealer);
        while (handValueDealer<17){
            int cardNoD=drawRandomCard();
            String cardD=cardString(cardNoD);
            handValueDealer+=Math.min(cardNoD,10);
            System.out.println("Dealer gets a \n"+cardD);
            System.out.println("\nDealer's total is "+handValueDealer);
            if(handValueDealer>21){
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }
        
        if (handValue>handValueDealer){
            System.out.println("Player wins!");
        }
        else{
            System.out.println("Dealer wins!");
        }
        
    
         scan.close();

    }

    /** A function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */
    public static int drawRandomCard(){
        int cardNumber=(int)((Math.random()*13)+1);
         return cardNumber;
    }
    /** A function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */
    public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1:
             
            return "   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n";

            case 2:

            return "   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";

            case 3:
            return "   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            
            case 4:
            return "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";

            case 5:
            return "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";

            case 6:
            return "   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n";

            case 7:
              
            return "   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n";

            case 8:
            
            return "   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";

            case 9:
            return "   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n";

            case 10:
            return "   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n";

            case 11:

            return "   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";

            case 12:

            return "   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            
            case 13: 
            return "   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n";

            default: return "";

        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** A function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */

    public static String hitOrStay(){
        System.out.println("\nWould you like to hit or stay?");
        String choice= scan.nextLine();
        if (choice.equals("hit") || choice.equals("stay")){
            return choice;
            
        }
        else{
            System.out.println("Please write 'hit' or 'stay'");
            return "";
        }
    }
    }

