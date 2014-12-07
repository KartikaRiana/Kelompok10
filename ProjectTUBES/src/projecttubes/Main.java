/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecttubes;

/**
 *
 * @author KartikaRianafirin
 */
import java.util.Scanner;
public class Main {
    private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		String puzzle = PuzzleGenerator.doGenerate();
		scanner.nextLine();
		PuzzleSolver.doSolve(puzzle);

	}
}