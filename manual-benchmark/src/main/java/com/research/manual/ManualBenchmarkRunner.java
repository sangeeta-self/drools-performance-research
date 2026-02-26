package com.research.manual;

import com.research.custom.CustomPricingEngine;
import com.research.model.Policy;
import com.research.model.PolicyGenerator;

import java.util.ArrayList;
import java.util.List;

public class ManualBenchmarkRunner {

    /*public static void main(String[] args) {

        int ruleCount = 300;        // change: 50,150,300,500
        int policyCount = 100_000;  // number of policies

        System.out.println("Generating " + policyCount + " policies...");
        List<Policy> policies = generatePolicies(policyCount);


        CustomPricingEngine engine = new CustomPricingEngine(ruleCount);

        System.out.println("Starting Custom Engine benchmark...");
        long start = System.nanoTime();

        for (Policy policy : policies) {
            engine.evaluate(policy);
        }

        long end = System.nanoTime();

        long durationNs = end - start;
        double durationMs = durationNs / 1_000_000.0;

        System.out.println("Rules count: " + ruleCount);
        System.out.println("Policies processed: " + policyCount);
        System.out.println("Execution Time: " + durationMs + " ms");

        double throughput = policyCount / (durationMs / 1000);
        System.out.println("Throughput: " + throughput + " policies/sec");
    }*/

    public static void main(String[] args) {

        int[] ruleCounts = {50, 150, 300, 500};
        int policyCount = 100_000;

        for (int rules : ruleCounts) {

            double totalMs = 0;

            for (int run = 1; run <= 5; run++) {

                System.out.println("Run " + run + " for rules = " + rules);

                var policies = generatePolicies(policyCount);
                var engine = new CustomPricingEngine(rules);

                long start = System.nanoTime();

                for (Policy p : policies) {
                    engine.evaluate(p);
                }

                long end = System.nanoTime();
                double durationMs = (end - start) / 1_000_000.0;

                totalMs += durationMs;

                System.out.println("Time: " + durationMs + " ms");
            }

            double avg = totalMs / 5.0;
            System.out.println("=====================================");
            System.out.println("Rules: " + rules);
            System.out.println("Average Execution Time: " + avg + " ms");
            System.out.println("=====================================");
        }
    }

    private static List<Policy> generatePolicies(int count) {

        List<Policy> list = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            list.add(PolicyGenerator.generate());
        }

        return list;
    }
}
