package hr.fer.zemris.fuzzy.util;

import hr.fer.zemris.fuzzy.domain.IDomain;
import hr.fer.zemris.fuzzy.domain.impl.DomainElement;
import hr.fer.zemris.fuzzy.set.IFuzzySet;

import java.util.Iterator;

public class Debug {

    public static void print(IDomain domain, String headingText) {
        if (headingText != null) {
            System.out.println(headingText);
        }
        for (DomainElement e : domain) {
            System.out.println("Element domene: " + e);
        }
        System.out.println("Kardinalitet domene je: " + domain.getCardinality());
        System.out.println();
    }

    public static void print(IFuzzySet fuzzySet, String headingText) {
        if (headingText != null) {
            System.out.println(headingText);
        }
        for (DomainElement e : fuzzySet.getDomain()) {
            System.out.println("Element domene: " + e + " vrijednost: " + fuzzySet.getValueAt(e));
        }
        System.out.println("Kardinalitet domene je: " + fuzzySet.getDomain().getCardinality());
        System.out.println();
    }
}
