import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------");
        System.out.println("Welcome to the game of Rock-Paper-Scissors");
        System.out.println("---------------------------------------------");

        System.out.println();
        System.out.print("Press 1 and then Enter to play the game: ");
        while (sc.nextInt()!=1) {
            System.out.println("Please press 1 and enter to enter game, and to exit the game press ctrl+c");
        }
        System.out.println();

        Game g = new Game();

        g.printRules();

        System.out.println("To exit playing game submit your choice of selection as 21 and hit enter");
        System.out.println("---------------------------------------------");
        System.out.println("enter your choice via\npressing 1 to select Rock\npressing 2 to select Paper\npressing 3 to select Scissors");
        int choice = sc.nextInt()-1;
        while (choice!=20) {
            if (choice>2 || choice<0) {
                System.out.print("Please enter a valid choice of input from given options: ");
                choice = sc.nextInt() - 1;
                continue;
            }

            int compChoice = g.makeCompMove();
            int winner = g.whoIsWinner(choice, compChoice);
            g.updateScores(winner);

            System.out.println("Your choice of selection: " + g.getChoiceOption(choice));
            System.out.println("Computer's choice of selection: " + g.getChoiceOption(compChoice));
            System.out.println(winner==0?"You won the round":winner==1?"Computer won the round":"The round was drawn");

            g.printScores();

            System.out.println("enter your choice via\npressing 1 to select Rock\npressing 2 to select Paper\npressing 3 to select Scissors\npress 21 to exit the match");
            choice = sc.nextInt() - 1;
        }

        System.out.println("Thank you for playing the game... hope you enjoyed your time here!!");
    }
}

class Game {
    // terminologies: 0-rock, 1-paper, 2 scissors; 0-user, 1-computer

    int userScore, compScore, roundCount;

    Game() {
        userScore = 0;
        compScore = 0;
        roundCount = 0;
    }

    public String getChoiceOption(int choice) {
        if (choice==0) return "Rock";
        else if (choice==1) return "Paper";
        else return "Scissors";
    }

    public int makeCompMove () {
        return (int)(Math.random()*3);
    }

    public void printRules () {
        System.out.println("---------------------------------------------");
        System.out.println("                   Rules");
        System.out.println("---------------------------------------------");
        System.out.println("You will be playing this game against computer who will randomly select any of rock paper or scissors without knowing your selection");
        System.out.println("You also will be asked to select your choice of option via\npressing 1 to select Rock\npressing 2 to select Paper\npressing 3 to select Scissors");
        System.out.println("Rock beats scissors, paper beats rock and scissors beats paper");
        System.out.println("Following the rules above the winner of the round will be decided based on your choice of decision");
        System.out.println("The overall score of all rounds played is kept as well so you will also be able to see who is winning based on all the rounds played overall");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    public void printScores () {
        System.out.println("---------------------------------------------");
        System.out.println("                 ScoreBoard");
        System.out.println("---------------------------------------------");
        System.out.println("You:" + userScore);
        System.out.println("Computer:" + compScore);
        System.out.println();
        System.out.println(whoIsWinning());
        System.out.println("---------------------------------------------");
    }

    public int whoIsWinner (int userChoice, int compChoice) {
        if (userChoice>compChoice) {
            if (userChoice-compChoice==1) return 0;
            else return 1;
        }
        else if (userChoice<compChoice) {
            if (compChoice-userChoice==1) return 1;
            else return 0;
        } else return 2;
    }

    public void updateScores (int winner) {
        if (winner==0) userScore++;
        else if (winner==1) compScore++;
        roundCount++;
    }

    public String whoIsWinning() {
        if (userScore>compScore) return "You are winning overall...";
        else if (userScore<compScore) return "Computer is winning overall...";
        else return "overall, Game is tied as of now";
    }
}
