package MAIN;

import javax.swing.JOptionPane;

public class test {

    /**
     * This method lets the user set up the amount of questions they want to answer. In the process of
     * answering the questions with user input, the program counts the amount of correct answers.
     * @param args
     */
    public static void main(String[] args) {
        // Variables for the two numbers and their answer
        int a; // first number
        int b; // second number
        int ans; // the answer for a and b

        // A boolean expression to see if we are going to add or not
        boolean add = false;

        // Input (from the user) variables
        int userAns = 0; // the user's answer
        int numOfCorrectAns = 0; // amount of correct answers
        int numOfProblems = 0; // the number of problems the user asked for

        String problem; // string for the question
        String userInput; // when the user inputs anything


        // the program opening/beginning box
        String input = JOptionPane.showInputDialog(
                null,
                "Hello! Welcome! \nHow many problems would you like to solve?",
                "Number of Problems" + " (To exit the program, type EXIT.)",
                JOptionPane.INFORMATION_MESSAGE);
        // EXIT option
        if(input.equalsIgnoreCase("exit")) {
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }
        else
            numOfProblems = Integer.parseInt(input);

        
        // the question
        for(int i = 1; i <= numOfProblems; i++) {
            a = (int)(Math.random() * 10); // random number from 0 thru 9
            b = (int)(Math.random() * 10);

            if(Math.random() < 0.5) // the 50% of probability of getting a problem with adding
                add = true;

            if(add) { // if the 50% probability is addition
                problem = a + " + " + b + " = ";
                ans = a + b;
            }
            else { // if the 50% probability is subtraction
                if(a > b) { // if a > b, then there will be no negatives in the subtraction.
                    problem = a + " - " + b + " = ";
                    ans = a - b;
                }
                else { // if a < b, then we swap b and a to avoid negatives.
                    problem = b + " - " + a + " = ";
                    ans = b - a;
                }
            }

            // the problem box
            userInput = JOptionPane.showInputDialog(
                    null,
                    problem,
                    "Problems " + i + " (To exit the program, type EXIT.)",
                    JOptionPane.INFORMATION_MESSAGE);
            // EXIT options
            if(userInput.equalsIgnoreCase("exit")) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            }
            else
                userAns = Integer.parseInt(userInput);

            // count the amount of questions the user got correct
            // let the user know if the answer was right or wrong
            if(userAns == ans) {
                numOfCorrectAns++;
                JOptionPane.showMessageDialog(null, "Correct answer! Great job! :)");
            }
            else
                JOptionPane.showMessageDialog(null, "Incorrect answer! Let's keep going! :(");
        }

        // This variable focuses on the number and the percentage of correct questions
        double stats = 100 * numOfCorrectAns/numOfProblems;

        // the program closing/ending box
        String results = "Number of Correct Answer(s): " + numOfCorrectAns + "/" + numOfProblems + "\n" + "Percent of Correct Answer(s): " + stats + " %" + "\n";
        JOptionPane.showMessageDialog(null, results);

    }
}