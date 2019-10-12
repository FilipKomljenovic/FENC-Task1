package hr.fer.zemris.fuzzy.set.impl;

import hr.fer.zemris.fuzzy.domain.IDomain;
import hr.fer.zemris.fuzzy.domain.impl.DomainElement;
import hr.fer.zemris.fuzzy.set.IFuzzySet;
import hr.fer.zemris.fuzzy.set.IIntUnaryFunction;

public class CalculatedFuzzySet implements IFuzzySet {
    private final IDomain domain;
    private final IIntUnaryFunction function;


    public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
        this.domain = domain;
        this.function = function;
    }

    @Override
    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement element) {
        return function.valueAt(domain.indexOfElement(element));
    }
}
