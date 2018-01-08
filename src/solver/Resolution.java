package solver;

import java.util.*;
import core.*;
import cnf.*;

public class Resolution {
	
	/**
	 * Propositional Theorem Solving using Resolution
	 * From AIMA Figure 7.12
	 */
	
	public static boolean PLResolution(KB kb, Sentence alpha) {
		KB kbCopy = kb.copyKB();
		
		//add negation of alpha to KB
		kbCopy.add(new Negation(alpha)); 
		
		//convert all clauses to CNF using Professor Ferguson's CNFConvertor
		Set<Clause> clauses = CNFConverter.convert(kbCopy);
		Set<Clause> newClauses = new HashSet<>();

		//a set to hold the resulting clauses from resolving two clauses
		Set<Clause> resolvents;

		//while-do loop
		while(true) {
			//for each pair of C[i], C[j]
			for(Clause clause_i : clauses) {
				for(Clause clause_j : clauses) {
					//check if C[i], C[j] are different
					if(clause_i.equals(clause_j) == false) {
						
						//get the set of all possible clauses obtained by resolving C[i], C[j]
						resolvents = PLResolve(clause_i, clause_j);
						
						//iterate over the resolvents
						for(Clause currentClause : resolvents) {
							//if the resolvents contains the empty clause then return true
							if(currentClause.isEmpty())
								return true;
						}
						newClauses.addAll(resolvents);
					}
				}
			}
			
			//if clauses contains all of the clauses in newClauses return false
			if(clauses.containsAll(newClauses))
				return false;
			
			//add newClauses to clauses
			clauses.addAll(newClauses);
		}
	}

	/**
	 * Resolves two propositional clauses
	 * Returns the set of possible clauses from resolving the two clauses
	 */
	
	public static Set<Clause> PLResolve(Clause ci, Clause cj) {

		//copy the clauses to prevent pointer errors
		Clause clause_i = ci.copyClause();
		Clause clause_j = cj.copyClause();

		Set<Clause> resolvents = new HashSet<>();

		for(Literal literal_i : clause_i) {
			for(Literal literal_j : clause_j) {

				//if the two literals are the same symbol but different polarities
				//i.e. if one literal is negated and the other is not
				//then remove the literals and combing the remaining literals from the two clauses into one new clause
				if(literal_i.getContent().equals(literal_j.getContent()) && literal_i.getPolarity() != literal_j.getPolarity()) {
						
					//print out clauses C[i], C[j] for showing step-by-step proof by resolution
					//System.out.println("\nClauses: " + clause_i + "\t" + clause_j);

					//remove the literals
					clause_i.remove(literal_i);
					clause_j.remove(literal_j);

					//add resulting clause to the resolvents
					clause_i.addAll(clause_j);
					resolvents.add(clause_i);
					
					//print of the set of resolvents for showing step-by-step proof by resolution
					//System.out.println("Resolvents: " + resolvents);
						
					return resolvents;
				}
			}
		}
		
		//if the clauses cannot be resolved 
		//i.e. they do not have a matching literal of opposite polarity
		// then return the two clauses
		resolvents.add(clause_i);
		resolvents.add(clause_j);
		return resolvents;
	}
}
