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
import java.util.Random;
public class PuzzleGenerator {
    private static Puzzle currentPuzzle = new Puzzle("123456780");

	public static String doGenerate() {
		Random random = new Random();
		int level = 100;
		
		for (int i = 0; i < level; i++) {
			int a = random.nextInt(4);
			currentPuzzle.setPosisiNol();

			if (a == 0 && currentPuzzle.posisiNol != 0 && currentPuzzle.posisiNol != 1 && currentPuzzle.posisiNol != 2) {
				currentPuzzle.data = currentPuzzle.geserKeBawah();
			} else if (a == 1 && currentPuzzle.posisiNol != 2 && currentPuzzle.posisiNol != 5 && currentPuzzle.posisiNol != 8) {
				currentPuzzle.data = currentPuzzle.geserKeKiri();
			} else if (a == 2 && currentPuzzle.posisiNol != 6 && currentPuzzle.posisiNol != 7 && currentPuzzle.posisiNol != 8) {
				currentPuzzle.data = currentPuzzle.geserKeAtas();
			} else if (a == 3 && currentPuzzle.posisiNol != 0 && currentPuzzle.posisiNol != 3 && currentPuzzle.posisiNol != 6) {
				currentPuzzle.data = currentPuzzle.geserKeKanan();
			}
		}
		
		printHasil();
		return currentPuzzle.data;
	}

	private static void printHasil() {
		System.out.println("  SOAL : " );
                System.out.println("----------");
                System.out.println(currentPuzzle.getMatriks());
	}
}