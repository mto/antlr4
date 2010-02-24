package org.antlr.v4.analysis;

import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.GrammarAST;

/** A tree of semantic predicates from the grammar AST if label==SEMPRED.
 *  In the NFA, labels will always be exactly one predicate, but the DFA
 *  may have to combine a bunch of them as it collects predicates from
 *  multiple NFA configurations into a single DFA state.
 */
public class PredicateLabel extends Label {
	protected SemanticContext semanticContext;

	public PredicateLabel(GrammarAST predicateASTNode) {
		this.semanticContext = new SemanticContext.Predicate(predicateASTNode);
	}

	public PredicateLabel(SemanticContext semCtx) {
		this.semanticContext = semCtx;
	}

	public int hashCode() {
		return semanticContext.hashCode();
	}

	public boolean equals(Object o) {
		if ( o==null ) {
			return false;
		}
		if ( this == o ) {
			return true; // equals if same object
		}
		if ( !(o instanceof PredicateLabel) ) {
			return false;
		}
		return semanticContext.equals(((PredicateLabel)o).semanticContext);
	}

	public String toString() {
		return "{"+semanticContext+"}?";
	}

	public String toString(Grammar g) {
		return toString();
	}	
}