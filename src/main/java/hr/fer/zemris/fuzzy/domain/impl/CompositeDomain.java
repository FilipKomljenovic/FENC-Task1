package hr.fer.zemris.fuzzy.domain.impl;

import hr.fer.zemris.fuzzy.domain.IDomain;
import one.util.streamex.StreamEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompositeDomain extends Domain {

    private final SimpleDomain[] simpleDomains;

    public CompositeDomain(SimpleDomain... domains) {
        this.simpleDomains = domains;
        domainElements = new ArrayList<>();
        List<List<Integer>> listOfDomains = new ArrayList<>();
        for (SimpleDomain domain : domains) {
            List<Integer> oneDomain = new ArrayList<>();
            int[] intNumbers = IntStream.range(domain.getFirst(), domain.getLast()).toArray();
            for (int number : intNumbers) {
                oneDomain.add(number);
            }
            listOfDomains.add(oneDomain);
        }
        super.domainElements = StreamEx.cartesianProduct(listOfDomains)
                .map(DomainElement::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getCardinality() {
        return StreamEx.of(simpleDomains)
                .mapToInt(SimpleDomain::getCardinality)
                .reduce(1, (first, second) -> first * second);
    }

    @Override
    public IDomain getComponent(int index) {
        if (index < 0 || index >= simpleDomains.length) throw new IndexOutOfBoundsException("Index is out of bounds.");
        return simpleDomains[index];
    }

    @Override
    public int getNumberOfComponents() {
        return simpleDomains.length;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new Iterator<DomainElement>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < domainElements.size();
            }

            @Override
            public DomainElement next() {
                if (!hasNext()) throw new ConcurrentModificationException("Next element does not exist.");
                return domainElements.get(index++);
            }
        };
    }

}