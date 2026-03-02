package com.research.jmh;

import com.research.custom.CustomPricingEngine;
import com.research.drools.DroolsPricingEngine;
import com.research.model.Policy;
import com.research.model.PolicyGenerator;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class PricingBenchmark {

    @Param({"50", "150", "300", "500"})
    private int ruleCount;

    private CustomPricingEngine customEngine;
    private DroolsPricingEngine droolsEngine;
    private List<Policy> policies;

    @Setup(Level.Trial)
    public void setup() {

        customEngine = new CustomPricingEngine(ruleCount);
        droolsEngine = new DroolsPricingEngine(ruleCount);

        policies = new ArrayList<>(500_000);
        for (int i = 0; i < 500_000; i++) {
            policies.add(PolicyGenerator.generate());
        }
    }
    // Custom Engine Benchmark
    @Benchmark
    public void benchmarkCustomEngine(Blackhole bh) {

        for (Policy p : policies) {
            customEngine.evaluate(p);
        }

        // Consume something to avoid dead-code elimination
        bh.consume(policies.get(0).getFinalPremium());
    }

    // Drools Batch Benchmark
    @Benchmark
    public void benchmarkDroolsEngine(Blackhole bh) {
        droolsEngine.evaluateBatch(policies);
        bh.consume(policies.get(0).getFinalPremium());
    }

}