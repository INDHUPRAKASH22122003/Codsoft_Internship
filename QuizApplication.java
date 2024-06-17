import java.util.Scanner;

public class QuizApplication {
    private final String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who wrote 'To Kill a Mockingbird'?"
    };

    private final String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Saturn"},
            {"Harper Lee", "Mark Twain", "Ernest Hemingway", "F. Scott Fitzgerald"}
    };

    private final int[] correctAnswers = {0, 2, 0}; // indices of the correct answers
    private int currentQuestion = 0;
    private int score = 0;

    public static void main(String[] args) {
        new QuizApplication().runQuiz();
    }

    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            System.out.print("Your answer (1-4): ");

            long startTime = System.currentTimeMillis();
            String input = scanner.nextLine();
            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;
            System.out.println("Answered in " + timeTaken + " seconds\n");

            // Check if the user answered within the time limit
            // seconds
            int timePerQuestion = 10;
            if (timeTaken > timePerQuestion) {
                System.out.println("Time's up! Moving to the next question.");
            } else {
                int answer = Integer.parseInt(input) - 1;
                if (answer == correctAnswers[i]) {
                    score++;
                }
            }
            currentQuestion++;
        }
        showResults();
        scanner.close();
    }

    private void showResults() {
        System.out.println("\nQuiz Over! Your score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q: " + questions[i]);
            System.out.println("Correct answer: " + options[i][correctAnswers[i]]);
        }
    }
}



