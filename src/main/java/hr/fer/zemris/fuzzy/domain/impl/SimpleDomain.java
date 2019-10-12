package hr.fer.zemris.fuzzy.domain.impl;

import hr.fer.zemris.fuzzy.domain.IDomain;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleDomain extends Domain {
    
    private final int first;
    private final int last;

    public SimpleDomain(int first, int last) {
        this.first = first;
        this.last = last;
        super.domainElements = IntStream.range(first, last)
                .mapToObj(DomainElement::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getCardinality() {
        return last - first;
    }

    @Override
    public IDomain getComponent(int index) {
        return this;
    }

    @Override
    public int getNumberOfComponents() {
        return 1;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new Iterator<DomainElement>() {
            private int index = first;

            @Override
            public boolean hasNext() {
                return index < last;
            }

            @Override
            public DomainElement next() {
                if (!hasNext()) throw new ConcurrentModificationException("Cannot access to next element.");
                return new DomainElement(index++);
            }
        };
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }
}
