package com.research.model;

import java.util.Random;

public class PolicyGenerator {

    private static final Random RANDOM = new Random();

    private static final String[] GENDERS = {"Male", "Female"};
    private static final String[] MARITAL = {"Single", "Married"};
    private static final String[] POLICY_TYPES = {"TERM", "WHOLE", "ULIP"};
    private static final String[] CITY_TIERS = {"Tier1", "Tier2", "Tier3"};
    private static final String[] REGIONS = {"Coastal", "Inland", "Hill"};

    public static Policy generate() {

        Policy p = new Policy();

        // Demographics
        p.setAge(18 + RANDOM.nextInt(60));
        p.setGender(GENDERS[RANDOM.nextInt(GENDERS.length)]);
        p.setMaritalStatus(MARITAL[RANDOM.nextInt(MARITAL.length)]);
        p.setDependents(RANDOM.nextInt(4));

        // Health
        p.setSmoker(RANDOM.nextBoolean());
        p.setDiabetic(RANDOM.nextBoolean());
        p.setHeartCondition(RANDOM.nextBoolean());
        p.setHighBP(RANDOM.nextBoolean());
        p.setBmi(18 + RANDOM.nextDouble() * 20);

        // Financial
        p.setAnnualIncome(200_000 + RANDOM.nextInt(2_000_000));
        p.setCreditScore(300 + RANDOM.nextInt(600));
        p.setLoanExisting(RANDOM.nextBoolean());

        // Coverage
        p.setCoverageAmount(1_000_000 + RANDOM.nextInt(20_000_000));
        p.setPolicyTerm(5 + RANDOM.nextInt(25));
        p.setPolicyType(POLICY_TYPES[RANDOM.nextInt(POLICY_TYPES.length)]);

        // Location
        p.setCityTier(CITY_TIERS[RANDOM.nextInt(CITY_TIERS.length)]);
        p.setRegion(REGIONS[RANDOM.nextInt(REGIONS.length)]);
        p.setFloodZone(RANDOM.nextBoolean());

        // Driving
        p.setAccidentHistory(RANDOM.nextInt(5));
        p.setDuiHistory(RANDOM.nextBoolean());

        return p;
    }
}
