package hr.fer.zemris.fuzzy.domain.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DomainElement {

    private final int[] elements;

    public DomainElement(int... elements) {
        this.elements = elements;
    }

    public DomainElement(List<Integer> list) {
        elements = new int[list.size()];
        IntStream.range(0, list.size()).forEach(i -> elements[i] = list.get(i));
    }

    public static DomainElement of(int first, int second) {
        return new DomainElement(first, second);
    }

    public static DomainElement of(int i) {
        return new DomainElement(i);
    }

    public int getNumberOfComponents() {
        return elements.length;
    }

    public int getComponentValue(int index) {
        if (index < 0 || index >= elements.length) throw new IndexOutOfBoundsException("Index is out of bounds.");
        return elements[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainElement that = (DomainElement) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
