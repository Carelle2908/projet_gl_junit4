package org.junit.internal.requests;

import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;

import java.util.Comparator;

public class SortingRequest extends Request {
    private final Request request;
    private final Comparator<Description> comparator;

    public SortingRequest(Request request, Comparator<Description> comparator) {
        this.request = request;
        this.comparator = comparator;
    }

    @Override
    public Runner getRunner() {
        Runner runner = request.getRunner();
        if (runner != null) {
            Sorter sorter = new Sorter(comparator);
            sorter.apply(runner);
        }
        return runner;
    }
}
