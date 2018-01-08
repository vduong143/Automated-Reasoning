package test;

import core.*;
import solver.*;

public class HornClauses extends KB {

	public HornClauses() {
		super();
		Symbol myth = intern("mythical");
		Symbol immortal = intern("immortal");
		Symbol mammal = intern("mammal");
		Symbol horned = intern("horned");
		Symbol magical = intern("magical");
		
		//if the unicorn is mythical, then it is immortal
		add(new Implication(myth, immortal));
		
		//if it is not mythical, then it is a mortal mammal
		add(new Implication(new Negation(myth), new Conjunction(new Negation(immortal), mammal)));
		
		//if the unicorn is either immortal or a mammal, then it is horned
		add(new Implication(new Disjunction(immortal, mammal), horned));
		
		//the unicorn is magical if it is horned
		add(new Implication(horned, magical));
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve Horn Clauses with Model Checking: ");
		
		//mythical
		System.out.println("Can we prove that the unicorn is mythical?");
		System.out.println("mythical = " + ModelChecking.TTEntails(this, new Symbol("mythical")) + "\n");
		
		//magical
		System.out.println("Can we prove that the unicorn is magical?");
		System.out.println("magical = " + ModelChecking.TTEntails(this, new Symbol("magical")) + "\n");
		
		//horned
		System.out.println("Can we prove that the unicorn is horned?");
		System.out.println("horned = " + ModelChecking.TTEntails(this, new Symbol("horned")) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve Horn Clauses with Resolution: ");
		
		//mythical
		System.out.println("Can we prove that the unicorn is mythical?");
		System.out.println("mythical = " + Resolution.PLResolution(this, new Symbol("mythical")) + "\n");
		
		//magical
		System.out.println("Can we prove that the unicorn is magical?");
		System.out.println("magical = " + Resolution.PLResolution(this, new Symbol("magical")) + "\n");
		
		//horned
		System.out.println("Can we prove that the unicorn is horned?");
		System.out.println("horned = " + Resolution.PLResolution(this, new Symbol("horned")) + "\n");
	}
	
	public static void main(String[] args) {
		HornClauses horn = new HornClauses();
		horn.solveByModelChecking();
		horn.solveByResolution();
	}
}
