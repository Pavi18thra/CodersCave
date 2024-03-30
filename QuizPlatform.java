import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Class to represent a quiz question
class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

// Class to represent the Quiz
class Quiz {
    private List<Question> questions;
    private int score;
    private Random random;

    public Quiz() {
        questions = new ArrayList<>();
        random = new Random();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println(q.getQuestion());
            List<String> options = q.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (options.get(choice - 1).equalsIgnoreCase(q.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class QuizPlatform {
    public static void main(String[] args) {
        // Create Quiz object
        Quiz quiz = new Quiz();

        // Add some sample questions
        quiz.addQuestion(new Question("What is the capital of France?",
                List.of("London", "Paris", "Berlin", "Rome"), "Paris"));
        quiz.addQuestion(new Question("What is 2+2?", List.of("3", "4", "5", "6"), "4"));
        quiz.addQuestion(new Question("What is the tallest mammal?", 
                List.of("Elephant", "Giraffe", "Horse", "Lion"), "Giraffe"));

        // Start the quiz
        quiz.startQuiz();
    }
}
