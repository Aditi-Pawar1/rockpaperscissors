import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Random random = new Random();

        String[] rps = {"Rock", "Paper", "Scissors"};
        String computerMove, playerMove;
        boolean playAgain = true;

        try (Scanner scanner = new Scanner(System.in)) {
            while (playAgain) {
                System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
                playerMove = scanner.nextLine();

                if (playerMove.equalsIgnoreCase("exit")) {
                    playAgain = false;
                    continue;
                }

                if (!playerMove.equalsIgnoreCase("Rock") &&
                        !playerMove.equalsIgnoreCase("Paper") &&
                        !playerMove.equalsIgnoreCase("Scissors")) {
                    System.out.println("Invalid move, please try again.");
                    continue;
                }

                int randIndex = random.nextInt(3);
                computerMove = rps[randIndex];
                System.out.println("Computer move: " + computerMove);

                if (playerMove.equalsIgnoreCase(computerMove)) {
                    System.out.println("It's a tie!");
                } else if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                        (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
                        (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
