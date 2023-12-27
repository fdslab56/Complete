
/**
 * ReverseWordWithStack is a Java program that reverses a word entered by the user
 * using a stack data structure. It reads a word from the user, pushes its characters
 * onto a stack, and then pops them off to build the reversed word.
 *
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordWithStack {
    /**
     * The main method of the program, responsible for reading a word, reversing it,
     * and printing the result.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();
        String reversedWord = reverseWord(input);
        System.out.println("Reversed word: " + reversedWord);

        scanner.close();
    }

    /**
     * Reverses a given word using a stack data structure.
     *
     * @param word The input word to be reversed.
     * @return The reversed word.
     */
    public static String reverseWord(String word) {
        Stack<Character> stack = new Stack<>();

        // Push each character of the word onto the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop characters from the stack to build the reversed word
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}