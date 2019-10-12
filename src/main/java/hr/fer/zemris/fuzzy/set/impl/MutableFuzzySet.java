package hr.fer.zemris.fuzzy.set.impl;

import hr.fer.zemris.fuzzy.domain.IDomain;
import hr.fer.zemris.fuzzy.domain.impl.DomainElement;
import hr.fer.zemris.fuzzy.set.IFuzzySet;

public class MutableFuzzySet implements IFuzzySet {
    private final double[] memberships;
    private final IDomain domain;

    public MutableFuzzySet(IDomain domain) {
        this.domain = domain;
        memberships = new double[domain.getCardinality()];
    }

    public MutableFuzzySet(double[] memberships, IDomain domain) {
        this.memberships = memberships;
        this.domain = domain;
    }

    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement element) {
        return memberships[domain.indexOfElement(element)];
    }

    public MutableFuzzySet set(DomainElement domainElement, double value) {
        memberships[domain.indexOfElement(domainElement)]=value;
        return this;
    }
}
