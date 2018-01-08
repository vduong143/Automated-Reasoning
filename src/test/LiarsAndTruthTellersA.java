package test;

import core.*;
import solver.*;

public class LiarsAndTruthTellersA extends KB {
	
	public LiarsAndTruthTellersA() {
		super();
		Symbol a = intern("Amy");
		Symbol b = intern("Bob");
		Symbol c = intern("Cal");
		
		//Amy says, “Cal and I are truthful.”
		add(new Biconditional(a, new Conjunction(a,b)));
		
		//Bob says, “Cal is a liar.”
		add(new Biconditional(b, new Negation(c)));
		
		//Cal says, “Bob speaks the truth or Amy lies.”
		add(new Biconditional(c, new Disjunction(b, new Negation(a))));
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve Liars and Truth-tellers (a) with Model Checking:");
		
		//Amy
		System.out.println("Amy tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Amy")) + "\n");
		
		//Bob
		System.out.println("Bob tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Bob")) + "\n");
		
		//Cal
		System.out.println("Cal tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Cal")) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve Liars and Truth-tellers (a) with Resolution:");
		
		//Amy
		System.out.println("Amy tells the truth: " + Resolution.PLResolution(this, new Symbol("Amy")) + "\n");
		
		//Bob
		System.out.println("Bob tells the truth: " + Resolution.PLResolution(this, new Symbol("Bob")) + "\n");
		
		//Cal
		System.out.println("Cal tells the truth: " + Resolution.PLResolution(this, new Symbol("Cal")) + "\n");
	}
	
	public static void main(String[] args) {
		LiarsAndTruthTellersA truth = new LiarsAndTruthTellersA();
		truth.solveByModelChecking();
		truth.solveByResolution();
	}
}
