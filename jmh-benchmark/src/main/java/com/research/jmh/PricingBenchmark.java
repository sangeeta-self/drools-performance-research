package com.research.jmh;

import com.research.custom.CustomPricingEngine;
import com.research.model.Policy;
import com.research.model.PolicyGenerator;
import org.openjdk.jmh.annotations.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class PricingBenchmark {

   /* private CustomPricingEngine engine;
    private Policy policy;

    @Setup(Level.Trial)
    public void setup() {
        engine = new CustomPricingEngine(300); // try 50,150,300,500
        policy = PolicyGenerator.generate();
    }

    @Benchmark
    public void customEngineBenchmark() {
        engine.evaluate(policy);
    }*/

    @Param({"50", "150", "300", "500"})
    private int ruleCount;

    private CustomPricingEngine engine;
    private List<Policy> policies;

    @Setup(Level.Trial)
    public void setup() {
        engine = new CustomPricingEngine(ruleCount);
        policies = new ArrayList<>();

        for (int i = 0; i < 500_000; i++) {
            policies.add(PolicyGenerator.generate());
        }
    }

    @Benchmark
    public void benchmarkCustomEngine() {
        for (Policy p : policies) {
            engine.evaluate(p);
        }
    }
}
