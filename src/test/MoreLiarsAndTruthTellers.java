package test;

import core.*;
import solver.*;

public class MoreLiarsAndTruthTellers extends KB{

	public MoreLiarsAndTruthTellers() {
		super();
	    Symbol a = intern("Amy");
	    Symbol b = intern("Bob");
	    Symbol c = intern("Cal");
	    Symbol d = intern("Dee");
	    Symbol e = intern("Eli");
	    Symbol f = intern("Fay");
	    Symbol g = intern("Gil");
	    Symbol h = intern("Hal");
	    Symbol i = intern("Ida");
	    Symbol j = intern("Jay");
	    Symbol k = intern("Kay");
	    Symbol l = intern("Lee");
	    
	    //truth-teller claims
	    add(new Biconditional(a, new Conjunction(h, i)));
	    add(new Biconditional(b, new Conjunction(a, l)));
	    add(new Biconditional(c, new Conjunction(b, g)));
	    add(new Biconditional(d, new Conjunction(e, l)));
	    add(new Biconditional(e, new Conjunction(c, h)));
	    add(new Biconditional(f, new Conjunction(d, i)));
	    
	    //liar claims
	    add(new Biconditional(g, new Conjunction(new Negation(e), new Negation(j))));
	    add(new Biconditional(h, new Conjunction(new Negation(f), new Negation(k))));
	    add(new Biconditional(i, new Conjunction(new Negation(g), new Negation(k))));
	    add(new Biconditional(j, new Conjunction(new Negation(a), new Negation(c))));
	    add(new Biconditional(k, new Conjunction(new Negation(d), new Negation(f))));
	    add(new Biconditional(l, new Conjunction(new Negation(b), new Negation(j))));
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve More Liars and Truth-tellers with Model Checking:");
		System.out.println("Amy tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Amy")) + "\n");
		System.out.println("Bob tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Bob")) + "\n");
		System.out.println("Cal tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Cal")) + "\n");
		System.out.println("Dee tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Dee")) + "\n");
		System.out.println("Eli tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Eli")) + "\n");
		System.out.println("Fay tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Fay")) + "\n");
		System.out.println("Gil tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Gil")) + "\n");
		System.out.println("Hal tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Hal")) + "\n");
		System.out.println("Ida tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Ida")) + "\n");
		System.out.println("Jay tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Jay")) + "\n");
		System.out.println("Kay tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Kay")) + "\n");
		System.out.println("Lee tells the truth: " + ModelChecking.TTEntails(this, new Symbol("Lee")) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve More Liars and Truth-tellers with Resolution:");
		System.out.println("Amy tells the truth: " + Resolution.PLResolution(this, new Symbol("Amy")) + "\n");
		System.out.println("Bob tells the truth: " + Resolution.PLResolution(this, new Symbol("Bob")) + "\n");
		System.out.println("Cal tells the truth: " + Resolution.PLResolution(this, new Symbol("Cal")) + "\n");
		System.out.println("Dee tells the truth: " + Resolution.PLResolution(this, new Symbol("Dee")) + "\n");
		System.out.println("Eli tells the truth: " + Resolution.PLResolution(this, new Symbol("Eli")) + "\n");
		System.out.println("Fay tells the truth: " + Resolution.PLResolution(this, new Symbol("Fay")) + "\n");
		System.out.println("Gil tells the truth: " + Resolution.PLResolution(this, new Symbol("Gil")) + "\n");
		System.out.println("Hal tells the truth: " + Resolution.PLResolution(this, new Symbol("Hal")) + "\n");
		System.out.println("Ida tells the truth: " + Resolution.PLResolution(this, new Symbol("Ida")) + "\n");
		System.out.println("Jay tells the truth: " + Resolution.PLResolution(this, new Symbol("Jay")) + "\n");
		System.out.println("Kay tells the truth: " + Resolution.PLResolution(this, new Symbol("Kay")) + "\n");
		System.out.println("Lee tells the truth: " + Resolution.PLResolution(this, new Symbol("Lee")) + "\n");
	}
	
	public static void main(String[] args) {
		MoreLiarsAndTruthTellers truth = new MoreLiarsAndTruthTellers();
		truth.solveByModelChecking();
		truth.solveByResolution();
	}
}
