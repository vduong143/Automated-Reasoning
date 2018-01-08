package test;

import core.*;
import solver.*;

public class SimpleWumpusWorld extends KB {
	
	public SimpleWumpusWorld() {
		super();
		Symbol P11 = intern("P[1,1]");
		Symbol P12 = intern("P[1,2]");
		Symbol P21 = intern("P[2,1]");
		Symbol P22 = intern("P[2,2]");
		Symbol P31 = intern("P[3,1]");
		Symbol B11 = intern("B[1,1]");
		Symbol B21 = intern("B[2,1]");
		
		//~P[1,1]
		add(new Negation(P11));
		
		//B[1,1] <=> (P[1,2] || P[2,1])
		add(new Biconditional(B11, new Disjunction(P12,P21)));
		
		//B[2,1] <=> (P[1,1] || P[2,2] || P[3,1])
		add(new Biconditional(B21, new Disjunction(P11, new Disjunction(P22, P31))));
		
		//~B[1,1]
		add(new Negation(B11));
		
		//B[2,1]
		add(B21);
	}
	
	public void solveByModelChecking() {
		System.out.println("Solve Simple Wumpus World with Model Checking: ");
		Sentence P12 = new Symbol("P[1,2]");
		System.out.println("P[1,2] = " + ModelChecking.TTEntails(this, P12) + "\n");
	}
	
	public void solveByResolution() {
		System.out.println("Solve Simple Wumpus World with Resolution: ");
		Sentence P12 = new Symbol("P[1,2]");
		System.out.println("P[1,2] = " + Resolution.PLResolution(this, P12) + "\n");
	}
	
	public static void main(String[] args) {
		SimpleWumpusWorld wumpus = new SimpleWumpusWorld();
		wumpus.solveByModelChecking();
		wumpus.solveByResolution();
	}
}
