package hr.fer.zemris.fuzzy.set.functions;

import hr.fer.zemris.fuzzy.domain.impl.DomainElement;
import hr.fer.zemris.fuzzy.set.IFuzzySet;
import hr.fer.zemris.fuzzy.set.impl.MutableFuzzySet;

public class Operations {

    public static IFuzzySet unaryOperation(IFuzzySet fuzzySet, IUnaryFunction unaryFunction) {
        MutableFuzzySet mutableFuzzySet = new MutableFuzzySet(fuzzySet.getDomain());
        for (DomainElement domainElement : mutableFuzzySet.getDomain()) {
            mutableFuzzySet.set(domainElement,
                    unaryFunction.valueAt(fuzzySet.getValueAt(domainElement))
            );
        }
        return mutableFuzzySet;
    }

    public static IFuzzySet binaryOperation(IFuzzySet fuzzySetFirst, IFuzzySet fuzzySetSecond, IBinaryFunction binaryFunction) {
        MutableFuzzySet mutableFuzzySet = new MutableFuzzySet(fuzzySetFirst.getDomain());
        for (DomainElement domainElement : mutableFuzzySet.getDomain()) {
            mutableFuzzySet.set(domainElement,
                    binaryFunction.valueAt(fuzzySetFirst.getValueAt(domainElement),
                            fuzzySetSecond.getValueAt(domainElement)
                    )
            );
        }
        return mutableFuzzySet;
    }

    public static IUnaryFunction zadehNot() {
        return l -> 1 - l;
    }

    public static IBinaryFunction zadehAnd() {
        return Double::min;
    }

    public static IBinaryFunction zadehOr() {
        return Double::max;
    }

    public static IBinaryFunction hamacherTNorm(double value) {
        return (a, b) -> (a * b) / (value + (1 - value) * (a + b - a * b));
    }

    public static IBinaryFunction hamacherSNorm(double value) {
        return (a, b) -> (a + b - (2 - value) * a * b) / (1 - (1 - value) * (a * b));
    }
}
