import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String[] selections = new String[5];

    // Constructor to initialize questions
    public QuestionService() {
        questions[0] = new Question(1, "What is the capital of India?", "Delhi", "Kolkata", "Chennai", "Mumbai", "Delhi");
        questions[1] = new Question(2, "What is the largest planet in the Solar System?", "Earth", "Mars", "Jupiter", "Saturn", "Jupiter");
        questions[2] = new Question(3, "Who wrote the Indian National Anthem?", "Rabindranath Tagore", "Bankim Chandra Chatterjee", "Mahatma Gandhi", "Subhash Chandra Bose", "Rabindranath Tagore");
        questions[3] = new Question(4, "Which is the smallest state in India by area?", "Goa", "Sikkim", "Tripura", "Nagaland", "Goa");
        questions[4] = new Question(5, "What is the chemical symbol for water?", "H2O", "O2", "H2", "HO", "H2O");
    }

    // Method to display all questions and collect user inputs
    public void playQuiz() {
        Scanner sc = new Scanner(System.in); // Create a single Scanner instance

        System.out.println("Welcome to the Quiz! Please enter your answers (1, 2, 3, or 4):");

        int i = 0;
        for (Question q : questions) {
            System.out.println("\nQuestion No. : " + q.getId());
            System.out.println("Question : " + q.getQuestion());
            System.out.println("1. " + q.getOpt1());
            System.out.println("2. " + q.getOpt2());
            System.out.println("3. " + q.getOpt3());
            System.out.println("4. " + q.getOpt4());

            System.out.print("Your Answer: ");
            selections[i] = sc.nextLine();
            i++;
        }

        // Displaying the user's selected answers
        System.out.println("\nYour Answers:");
        for (int j = 0; j < selections.length; j++) {
            System.out.println("Question " + (j + 1) + ": Selected Option " + selections[j]);
        }

        sc.close(); // Close the Scanner at the end
    }
    public void printScore() {
        int score = 0;
    
        for (int i = 0; i < 5; i++) {
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
    
            // Map the user's selected option number to the corresponding option text
            String userAnswer = selections[i];
            String selectedAnswer = "";
    
            switch (userAnswer) {
                case "1":
                    selectedAnswer = que.getOpt1();
                    break;
                case "2":
                    selectedAnswer = que.getOpt2();
                    break;
                case "3":
                    selectedAnswer = que.getOpt3();
                    break;
                case "4":
                    selectedAnswer = que.getOpt4();
                    break;
                default:
                    selectedAnswer = "Invalid"; // In case of invalid input
            }
    
            // Compare the selected answer text with the actual answer
            if (selectedAnswer.equals(actualAnswer)) {
                score++;
            }
        }
    
        System.out.println("Your Score: " + score);
    }
}
