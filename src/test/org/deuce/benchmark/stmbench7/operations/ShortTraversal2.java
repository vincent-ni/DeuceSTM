package org.deuce.benchmark.stmbench7.operations;

import org.deuce.benchmark.stmbench7.OperationId;
import org.deuce.benchmark.stmbench7.Setup;
import org.deuce.benchmark.stmbench7.core.AtomicPart;
import org.deuce.benchmark.stmbench7.core.CompositePart;
import org.deuce.benchmark.stmbench7.core.Document;
import org.deuce.benchmark.stmbench7.core.RuntimeError;

/**
 * Short traversal ST2 (see the specification).
 * Read-only, short.
 */
public class ShortTraversal2 extends ShortTraversal1 {

	public ShortTraversal2(Setup oo7setup) {
		super(oo7setup);
	}

	@Override
	protected int traverse(CompositePart component) {
		Document documentation = component.getDocumentation();
		return traverse(documentation);
	}
	
	protected int traverse(Document documentation) {
		return documentation.searchText('I');
	}
	
	@Override
	protected int traverse(AtomicPart atomicPart) {
		throw new RuntimeError("ST2: unexpected call to traverse(AtomicPart)!");
	}
	
    @Override
    public OperationId getOperationId() {
    	return OperationId.ST2;
    }
}
