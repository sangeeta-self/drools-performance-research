package com.research.manual;

import com.research.custom.CustomPricingEngine;
import com.research.model.Policy;
import com.research.model.PolicyGenerator;

import java.util.ArrayList;
import java.util.List;

public class ManualBenchmarkRunner {
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
