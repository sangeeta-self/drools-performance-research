package com.research.custom;

import com.research.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class CustomPricingEngine {

    private final List<Rule> rules = new ArrayList<>();

    public CustomPricingEngine(int ruleCount) {
        generateRules(ruleCount);
    }

    public void evaluate(Policy p) {
        p.reset();
        for (Rule rule : rules) {
            rule.apply(p);
        }
        // Risk escalation
        if (p.getFinalPremium() > 30000) {
            p.setRiskCategory("HIGH");
        }
        if (p.getFinalPremium() > 50000) {
            p.setRiskCategory("CRITICAL");
        }
    }

    private void generateRules(int ruleCount) {
        for (int i = 0; i < ruleCount; i++) {
            int type = i % 8;
            switch (type) {
                case 0 -> rules.add(p -> {
                    if (p.getAge() > 60)
                        p.setFinalPremium(p.getFinalPremium() + 200);
                });
                case 1 -> rules.add(p -> {
                    if (p.isSmoker())
                        p.setFinalPremium(p.getFinalPremium() + 300);
                });
                case 2 -> rules.add(p -> {
                    if (p.isDiabetic())
                        p.setFinalPremium(p.getFinalPremium() + 250);
                });
                case 3 -> rules.add(p -> {
                    if (p.getCreditScore() < 600)
                        p.setFinalPremium(p.getFinalPremium() + 400);
                });
                case 4 -> rules.add(p -> {
                    if (p.isFloodZone())
                        p.setFinalPremium(p.getFinalPremium() + 500);
                });
                case 5 -> rules.add(p -> {
                    if (p.getCoverageAmount() > 10_000_000)
                        p.setFinalPremium(p.getFinalPremium() + 600);
                });
                case 6 -> rules.add(p -> {
                    if (p.getAccidentHistory() > 2)
                        p.setFinalPremium(p.getFinalPremium() + 350);
                });
                case 7 -> rules.add(p -> {
                    if (p.isSmoker() && p.isDiabetic() && p.getAge() > 55)
                        p.setFinalPremium(p.getFinalPremium() + 800);
                });
            }
        }
    }
}
