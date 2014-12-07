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
public class Puzzle {
    String data;
	int posisiNol;

	public Puzzle(String data) {
		this.data = data;
	}

	public void setPosisiNol() {
		posisiNol = this.data.indexOf("0");
	}

	public String geserKeAtas() {
		return this.data.substring(0, posisiNol)
				+ this.data.substring(posisiNol + 3, posisiNol + 4)
				+ this.data.substring(posisiNol + 1, posisiNol + 3) + "0"
				+ this.data.substring(posisiNol + 4);
	}

	public String geserKeBawah() {
		return this.data.substring(0, posisiNol - 3) + "0"
				+ this.data.substring(posisiNol - 2, posisiNol)
				+ this.data.charAt(posisiNol - 3)
				+ this.data.substring(posisiNol + 1);
	}

	public String geserKeKanan() {
		return this.data.substring(0, posisiNol - 1) + "0"
				+ this.data.charAt(posisiNol - 1)
				+ this.data.substring(posisiNol + 1);
	}

	public String geserKeKiri() {
		return this.data.substring(0, posisiNol)
				+ this.data.charAt(posisiNol + 1) + "0"
				+ this.data.substring(posisiNol + 2);
	}

	public String getMatriks() {
		String matriks = "";
		for (int i = 0; i < 9; i++) {
			if (this.data.charAt(i) == '0') {
				matriks += "   ";
			} else {
				matriks += " " + String.valueOf(this.data.charAt(i)) + " ";
			}
			if ((i + 1) % 3 == 0) {
				matriks += "\n";
			}
		}
		return matriks;
	}

	public boolean isSolved() {
		if (this.data.equals("123456780")) {
			return true;
		}
		return false;
}
    
}