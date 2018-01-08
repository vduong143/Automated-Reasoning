package test;

import core.*;
import solver.*;

public class ModusPonens extends KB{
	
	public ModusPonens() {
		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve Modus Ponens with Model Checking: ");
		Sentence q = new Symbol("Q");
		System.out.println("Q = " + ModelChecking.TTEntails(this, q) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve Modus Ponens with Resolution: ");
		Sentence q = new Symbol("Q");
		System.out.println("Q = " + Resolution.PLResolution(this, q) + "\n");
	}
	
	public static void main(String[] args) {
		ModusPonens mp = new ModusPonens();
		mp.solveByModelChecking();
		mp.solveByResolution();
	}
}
