import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        
        String randWord=randomWord();
        char[] word=new char[randWord.length()];
        for(int i=0;i<randWord.length();i++){
            word[i]='_';
        }
        int mistake=0;
        String miss="";
        
        
        while(mistake!=6){
            
            System.out.println(gallows[mistake]);
            System.out.print("\nWord: ");
            printWord(word);
            
            System.out.println("\nMisses: "+miss);
            System.out.print("Guess: ");
            char guess=scan.next().charAt(0);
            int c=0;
            for(int j=0;j<randWord.length();j++){
                if (guess==randWord.charAt(j)){
                    word[j]=guess;
                    c++;
                }
            }
            if(c==0){
                miss+=guess;
                mistake+=1;
            }
            checkWin(mistake, randWord, word);
        }
        
    


        scan.close();

    }

    public static String randomWord(){
        int index=(int)(Math.random()*words.length);
        return words[index];
    }

    public static void checkWin(int mistake,String randWord,char[] word){
        int p=0;
        for(int i=0;i<word.length;i++){
            if(word[i]!='_'){
                p++;
            }
        }
        if (p==word.length){
            System.out.println("GOOD WORK!");
        }
        else{
            if (mistake==6){
                System.out.println("\nRIP!\n\nThe word was: "+randWord);
            }
            

        }
    }

    public static void printWord(char[] word){
        for(int i=0;i<word.length;i++){
            System.out.print(word[i]+" ");
        }
    }
}







