package solver;

import java.util.*;
import core.*;

public class ModelChecking {
	
	/**
	 * Recursive truth-table enumeration method
	 * From AIMA Figure 7.10
	 */
	
	public static boolean TTEntails(KB kb, Sentence alpha) {

		//get list of symbols from knowledge base
		ArrayList<Symbol> fromKB = new ArrayList<Symbol>(kb.symbols());

		//get list of symbols from sentence that needs to be proven
		ArrayList<Symbol> fromAlpha = alpha.getSymbols();

		//add symbols from alpha that is not in the knowledge base
		for(Symbol s : fromAlpha) {
			if(fromKB.contains(s) == false) {
				fromKB.add(s);
			}
		}
		ModelImplemented model = new ModelImplemented();
		return TTCheckAll(kb, alpha, fromKB, model);
	}

	public static boolean TTCheckAll(KB kb, Sentence alpha, ArrayList<Symbol> symbols, ModelImplemented model) {
		// if the list of symbols is empty
		if(symbols.isEmpty() == true) {
			
			// if the model satisfies the knowledge base
			// (i.e. every sentence in the KB is true given the values from the model)
			// then check if alpha is true given the values from the model
			if(model.satisfies(kb) == true)
				return model.satisfies(alpha);
			
			//when KB is false, always return true
			else
				return true;
		}
		else {
			//make a duplicate list of symbols to prevent issues with pointers in recursive call
			ArrayList<Symbol> symbols2 = new ArrayList<Symbol>(symbols);
			
			//remove the first symbol from the list
			Symbol p = symbols.remove(0);
			
			// make a copy of the model to prevent issues with pointers
			ModelImplemented m1 = model.clone();
			
			//set the removed symbol to true in one model
			m1.set(p, true);
			ModelImplemented m2 = model.clone();
			p = symbols2.remove(0);
			
			//set the removed symbol to false in the other model
			m2.set(p, false);
			
			//recursive call with the new models
			return TTCheckAll(kb, alpha, symbols, m1) && TTCheckAll(kb, alpha, symbols2, m2);
		}
	}
}
