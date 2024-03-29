package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.domain.impl.Domain;
import hr.fer.zemris.fuzzy.domain.impl.DomainElement;
import hr.fer.zemris.fuzzy.set.IFuzzySet;
import hr.fer.zemris.fuzzy.set.impl.CalculatedFuzzySet;
import hr.fer.zemris.fuzzy.set.impl.MutableFuzzySet;
import hr.fer.zemris.fuzzy.set.impl.StandardFuzzySets;
import hr.fer.zemris.fuzzy.util.Debug;

public class Primjer1 {
    public static <IDomain> void main(String[] args) {
        hr.fer.zemris.fuzzy.domain.IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
        IFuzzySet set1 = new MutableFuzzySet(d)
                .set(DomainElement.of(0), 1.0)
                .set(DomainElement.of(1), 0.8)
                .set(DomainElement.of(2), 0.6)
                .set(DomainElement.of(3), 0.4)
                .set(DomainElement.of(4), 0.2);
        Debug.print(set1, "Set1:");
        hr.fer.zemris.fuzzy.domain.IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
        IFuzzySet set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.lambdaFunction(
                        d2.indexOfElement(DomainElement.of(-4)),
                        d2.indexOfElement(DomainElement.of(0)),
                        d2.indexOfElement(DomainElement.of(4))
                )
        );
        Debug.print(set2, "Set2:");
    }
}