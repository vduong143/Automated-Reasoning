package test;

import core.*;
import solver.*;

public class LiarsAndTruthTellersB extends KB {
	
	public LiarsAndTruthTellersB() {
		super();
		Symbol a = intern("Amy");
		Symbol b = intern("Bob");
		Symbol c = intern("Cal");
		
		//Amy says, “Cal is not honest.”
		add(new Biconditional(a, new Negation(b)));
		
		//Bob says, “Amy and Cal never lie.”
		add(new Biconditional(b, new Conjunction(a,c)));
		
		//Cal says, “Bob is correct.”
		add(new Biconditional(c,b));
		
		/**Alternate interpretation: “Bob is correct.” implies that Cal agrees with “Amy and Cal never lie.”, not necessarily that Bob is honest.
		/*add(new Biconditional(c, new Conjunction(a,c));
		 * 
		 */
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve Liars and Truth-tellers (b) with Model Checking:");
		
		//Amy
		System.out.println("Amy tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Amy")) + "\n");
		
		//Bob
		System.out.println("Bob tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Bob")) + "\n");
		
		//Cal
		System.out.println("Cal tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Cal")) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve Liars and Truth-tellers (b) with Resolution:");
		
		//Amy
		System.out.println("Amy tells the truth: " + Resolution.PLResolution(this, new Symbol("Amy")) + "\n");
		
		//Bob
		System.out.println("Bob tells the truth: " + Resolution.PLResolution(this, new Symbol("Bob")) + "\n");
		
		//Cal
		System.out.println("Cal tells the truth: " + Resolution.PLResolution(this, new Symbol("Cal")) + "\n");
	}
	
	public static void main(String[] args) {
		LiarsAndTruthTellersB truth = new LiarsAndTruthTellersB();
		truth.solveByModelChecking();
		truth.solveByResolution();
	}
}
