package hr.fer.zemris.fuzzy.domain.impl;

import hr.fer.zemris.fuzzy.domain.IDomain;

import java.util.ArrayList;
import java.util.List;

public abstract class Domain implements IDomain {

    protected List<DomainElement> domainElements;

    public static IDomain intRange(int first, int last) {
        return new SimpleDomain(first, last);
    }

    public static IDomain combine(IDomain d1, IDomain d2) {
        List<SimpleDomain> domainsList = new ArrayList<>();
        domainsList.addAll(extractSimpleDomainsFromIDomain(d1));
        domainsList.addAll(extractSimpleDomainsFromIDomain(d2));
        SimpleDomain[] domains = new SimpleDomain[domainsList.size()];
        return new CompositeDomain(domainsList.toArray(domains));
    }

    private static List<SimpleDomain> extractSimpleDomainsFromIDomain(IDomain d1) {
        List<SimpleDomain> simpleDomains = new ArrayList<>();
        for (int i = 0; i < d1.getNumberOfComponents(); i++) {
            simpleDomains.add((SimpleDomain) d1.getComponent(i));
        }
        return simpleDomains;
    }

    @Override
    public int indexOfElement(DomainElement domainElement) {
        return domainElements.indexOf(domainElement);
    }

    @Override
    public DomainElement elementForIndex(int i) {
        return domainElements.get(i);
    }
}
