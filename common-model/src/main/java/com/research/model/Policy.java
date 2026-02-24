package com.research.model;

public class Policy {

    // ---------------- Demographics ----------------
    private int age;
    private String gender;
    private String maritalStatus;
    private int dependents;

    // ---------------- Health ----------------
    private boolean smoker;
    private boolean diabetic;
    private boolean heartCondition;
    private boolean highBP;
    private double bmi;

    // ---------------- Financial ----------------
    private double annualIncome;
    private double creditScore;
    private boolean loanExisting;

    // ---------------- Coverage ----------------
    private double coverageAmount;
    private int policyTerm;
    private String policyType;

    // ---------------- Location ----------------
    private String cityTier;
    private String region;
    private boolean floodZone;

    // ---------------- Driving ----------------
    private int accidentHistory;
    private boolean duiHistory;

    // ---------------- Output ----------------
    private double basePremium = 5000;
    private double finalPremium;
    private String riskCategory;

    public Policy() {
    }

    // ---------------- Reset ----------------
    public void reset() {
        this.finalPremium = basePremium;
        this.riskCategory = "LOW";
    }

    // ---------------- Getters & Setters ----------------

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public int getDependents() { return dependents; }
    public void setDependents(int dependents) { this.dependents = dependents; }

    public boolean isSmoker() { return smoker; }
    public void setSmoker(boolean smoker) { this.smoker = smoker; }

    public boolean isDiabetic() { return diabetic; }
    public void setDiabetic(boolean diabetic) { this.diabetic = diabetic; }

    public boolean isHeartCondition() { return heartCondition; }
    public void setHeartCondition(boolean heartCondition) { this.heartCondition = heartCondition; }

    public boolean isHighBP() { return highBP; }
    public void setHighBP(boolean highBP) { this.highBP = highBP; }

    public double getBmi() { return bmi; }
    public void setBmi(double bmi) { this.bmi = bmi; }

    public double getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; }

    public double getCreditScore() { return creditScore; }
    public void setCreditScore(double creditScore) { this.creditScore = creditScore; }

    public boolean isLoanExisting() { return loanExisting; }
    public void setLoanExisting(boolean loanExisting) { this.loanExisting = loanExisting; }

    public double getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }

    public int getPolicyTerm() { return policyTerm; }
    public void setPolicyTerm(int policyTerm) { this.policyTerm = policyTerm; }

    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public String getCityTier() { return cityTier; }
    public void setCityTier(String cityTier) { this.cityTier = cityTier; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public boolean isFloodZone() { return floodZone; }
    public void setFloodZone(boolean floodZone) { this.floodZone = floodZone; }

    public int getAccidentHistory() { return accidentHistory; }
    public void setAccidentHistory(int accidentHistory) { this.accidentHistory = accidentHistory; }

    public boolean isDuiHistory() { return duiHistory; }
    public void setDuiHistory(boolean duiHistory) { this.duiHistory = duiHistory; }

    public double getBasePremium() { return basePremium; }
    public void setBasePremium(double basePremium) { this.basePremium = basePremium; }

    public double getFinalPremium() { return finalPremium; }
    public void setFinalPremium(double finalPremium) { this.finalPremium = finalPremium; }

    public String getRiskCategory() { return riskCategory; }
    public void setRiskCategory(String riskCategory) { this.riskCategory = riskCategory; }
}
