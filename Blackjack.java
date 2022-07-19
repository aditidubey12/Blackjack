import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        //start of project
        P1Random randGen = new P1Random();
        int a = 0; //variable for menu
        int numGames = 1; //variable for games
        int card = 0; //variable for card
        int hand = 0; //variable for hand
        int numPlayers = 0; //variable for players
        int numDealer = 0; //variable for dealer wins
        int numTies = 0; //variable for ties
        int dealer = 0; //variable for dealer
        boolean gameisbeingplayed = false; //boolean for game
        Scanner scanner = new Scanner(System.in);
        //game starts w/ loop
        while (a != 4) {
            gameisbeingplayed=true;
            System.out.println("START GAME #" + numGames);
            System.out.print("Your card is a ");
            card = randGen.nextInt(13) + 1;
            if (card == 1) {
                System.out.println("ACE!");
                hand += 1;
            } else if (card >= 2 && card <= 10) {
                System.out.println(card + "!");
                hand += card;
            } else if (card == 11) {
                System.out.println("JACK!");
                hand += 10;
            } else if (card == 12) {
                System.out.println("QUEEN!");
                hand += 10;
            } else if (card == 13) {
                System.out.println("KING!");
                hand += 10;
            }
            System.out.println("Your hand is: " + hand);
            //menu starts and options are presented
            while (gameisbeingplayed == true) {
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("Choose an option: ");
                a = scanner.nextInt();
                //first option
                if (a == 1) {
                    card = randGen.nextInt(13) + 1;
                    System.out.print("Your card is a ");
                    if (card == 1) {
                        System.out.println("ACE!");
                        hand += 1;
                    } else if (card >= 2 && card <= 10) {
                        System.out.println(card + "!");
                        hand += card;
                    } else if (card == 11) {
                        System.out.println("JACK!");
                        hand += 10;
                    } else if (card == 12) {
                        System.out.println("QUEEN!");
                        hand += 10;
                    } else if (card == 13) {
                        System.out.println("KING!");
                        hand += 10;
                    }  System.out.println("Your hand is: " + hand);
                    if (hand>21) {
                        System.out.println("You exceeded 21! You lose.");
                        gameisbeingplayed=false;
                        numGames++;
                        numDealer++;
                    } if (hand==21){
                        gameisbeingplayed=false;
                        System.out.println("BLACKJACK! You win!");
                        numGames++;
                        numPlayers++;
                    }
                }
                //second option
                if (a == 2) {
                    gameisbeingplayed = false;
                    dealer = randGen.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealer);
                    System.out.println("Your hand is: " + hand);
                    numGames++;
                 if (dealer > 21) {
                    System.out.println("You win!");
                    numPlayers++;
                } else if (dealer == hand) {
                    System.out.println("It's a tie! No one wins!");
                    numTies++;
                } else if (dealer == 21 || dealer > hand && dealer <= 21) {
                    System.out.println("Dealer wins!");
                    numDealer++;
                } else if (hand > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    numDealer++;
                } else if (hand == 21) {
                    System.out.println("BLACKJACK! You win!");
                    numPlayers++;
                }
                 hand = 0;
            }
                //if user presses three
                if (a == 3) {
                        gameisbeingplayed = true;
                        System.out.println("Number of Player wins: " + numPlayers);
                        System.out.println("Number of Dealer wins: " + numDealer);
                        System.out.println("Number of tie games: " + numTies);
                        System.out.println("Total # of games played is: " + (numTies+numPlayers+numDealer));
                        System.out.println("Percentage of Player wins: " + (Math.round(((double) numPlayers / (numTies+numPlayers+numDealer)) * 10000.0)/100.0) + "%" + "\n");
                    }
                //if user presses four
                    if (a == 4) {
                        gameisbeingplayed=false;
                        numGames++;
                        break;
                    }
                    if (a < 1 || a > 4) {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                    }



            }
            hand=0;
        }
    }
}
