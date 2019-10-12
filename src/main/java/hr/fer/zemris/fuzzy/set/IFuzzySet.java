package hr.fer.zemris.fuzzy.set;

import hr.fer.zemris.fuzzy.domain.IDomain;
import hr.fer.zemris.fuzzy.domain.impl.DomainElement;

public interface IFuzzySet {
    IDomain getDomain();
    double getValueAt(DomainElement element);
}
