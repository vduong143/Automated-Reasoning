package core;

import java.util.*;

public class ModelImplemented implements Model{
	protected HashMap<Symbol,Boolean> assignment;

	//constructor
	public ModelImplemented() {
		assignment = new HashMap<Symbol,Boolean>();
	}
	
	@Override
	public void set(Symbol sym, boolean value) {
		if(assignment.containsKey(sym)) {
			assignment.remove(sym);
			assignment.put(sym, value);
		}
		else
			assignment.put(sym, value);
	}

	@Override
	public boolean get(Symbol sym) {
		if(assignment.containsKey(sym))
			return assignment.get(sym);
		else
			return false;
	}

	@Override
	public boolean satisfies(KB kb) {
		boolean temp = true;
		for(Sentence sentence : kb.sentences()) {
			temp = temp && sentence.isSatisfiedBy(this);
		}
		return temp;
	}

	@Override
	public boolean satisfies(Sentence sentence) {
		return sentence.isSatisfiedBy(this);
	}

	@Override
	public void dump() {
		Set<Symbol> set = assignment.keySet();
		for(Symbol sym : set) {
			System.out.println(sym + ": " + assignment.get(sym));
		}
	}
	
	public ModelImplemented clone() {	
		ModelImplemented m = new ModelImplemented();
		HashMap<Symbol, Boolean> map = new HashMap<Symbol, Boolean>();
		for(Symbol sym : this.getAssignment().keySet()) {
			map.put(sym, this.getAssignment().get(sym));
		}
		m.setAssignment(map);
		return m;
	}

	public HashMap<Symbol, Boolean> getAssignment() {
		return assignment;
	}

	public void setAssignment(HashMap<Symbol, Boolean> assignment) {
		this.assignment = assignment;
	}

}
