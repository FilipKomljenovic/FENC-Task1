package hr.fer.zemris.fuzzy.domain;

import hr.fer.zemris.fuzzy.domain.impl.DomainElement;

public interface IDomain extends Iterable<DomainElement> {

    int getCardinality();

    IDomain getComponent(int index);

    int getNumberOfComponents();

    int indexOfElement(DomainElement domainElement);

    DomainElement elementForIndex(int i);
}
