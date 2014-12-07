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
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
public class PuzzleSolver {
    private static LinkedList<String> listPuzzle = new LinkedList<>();
	private static Map<String, String> rekamanParent = new TreeMap<>();
	private static Map<String, String> rekamanPergerakan = new TreeMap<>();

	private static String soal;

	public static void doSolve(String soal) {
		PuzzleSolver.soal = soal;
		add(soal, null, "");
		while (!listPuzzle.isEmpty()) {
			Puzzle currentPuzzle = new Puzzle(listPuzzle.removeFirst());
			
			if (currentPuzzle.isSolved()) 
				break;
			
			currentPuzzle.setPosisiNol();
			String nextPuzzle;

			if (currentPuzzle.posisiNol != 0 && currentPuzzle.posisiNol != 1 && currentPuzzle.posisiNol != 2) {
				nextPuzzle = currentPuzzle.geserKeBawah();
				add(nextPuzzle, currentPuzzle.data, nextPuzzle.charAt(currentPuzzle.posisiNol) + " pindah bawah");
			}
			if (currentPuzzle.posisiNol != 2 && currentPuzzle.posisiNol != 5 && currentPuzzle.posisiNol != 8) {
				nextPuzzle = currentPuzzle.geserKeKiri();
				add(nextPuzzle, currentPuzzle.data, nextPuzzle.charAt(currentPuzzle.posisiNol) + " pindah kiri");
			}
			if (currentPuzzle.posisiNol != 6 && currentPuzzle.posisiNol != 7 && currentPuzzle.posisiNol != 8) {
				nextPuzzle = currentPuzzle.geserKeAtas();
				add(nextPuzzle, currentPuzzle.data, nextPuzzle.charAt(currentPuzzle.posisiNol) + " pindah atas");
			}
			if (currentPuzzle.posisiNol != 0 && currentPuzzle.posisiNol != 3 && currentPuzzle.posisiNol != 6) {
				nextPuzzle = currentPuzzle.geserKeKanan();
				add(nextPuzzle, currentPuzzle.data, nextPuzzle.charAt(currentPuzzle.posisiNol) + " pindah kanan");
			}
		}
		printSolusi();
	}

	private static void add(String nextPuzzle, String parent, String pergerakan) {
		if (!rekamanParent.containsKey(nextPuzzle)) {
			listPuzzle.add(nextPuzzle);
			rekamanParent.put(nextPuzzle, parent);
			rekamanPergerakan.put(nextPuzzle, pergerakan);
		}
	}

	private static void printSolusi() {
		LinkedList<String> tempList = new LinkedList<>();
		String current = "123456780";
		
		while (current != soal) {
			tempList.addFirst(current);
			current = rekamanParent.get(current);
		}
		
		for (int i = 1; !tempList.isEmpty(); i++) {
                        System.out.println("-----------------------------------");	
                        Puzzle currentPuzzle = new Puzzle(tempList.removeFirst());
			System.out.print(" Langkah ke-" + i + "     : "
					+ rekamanPergerakan.get(currentPuzzle.data) + "\n");
                        System.out.println("-----------------------------------");
                        System.out.println(currentPuzzle.getMatriks());
          	}
		System.out.println("Solved.");

}
    
}