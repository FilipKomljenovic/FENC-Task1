package hr.fer.zemris.fuzzy.set.impl;

import hr.fer.zemris.fuzzy.set.IIntUnaryFunction;

public class StandardFuzzySets {
    public IIntUnaryFunction lFunction(int alpha, int beta) {
        return x -> {
            if (x < alpha) return 1.0;
            if (x >= beta) return 0;
            return 1.0 * (beta - x) / (beta - alpha);
        };
    }

    public static IIntUnaryFunction lambdaFunction(int alpha, int beta, int gamma) {
        return x -> {
            if (x < alpha) return 0.0;
            if (x >= gamma) return 0.0;
            if (x < beta) return 1.0 * (x - alpha) / (beta - alpha);
            return 1.0 * (gamma - x) / (gamma - beta);
        };
    }

    public static IIntUnaryFunction gammaFunction(int alpha, int beta) {
        return x -> {
            if (x < alpha) return 0;
            if (x >= beta) return 1.0;
            return 1.0 * (x - alpha) / (beta - alpha);
        };
    }
}
