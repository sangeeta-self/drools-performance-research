package com.research.drools;

public class DrlGenerator {

    public static String generate(int ruleCount) {
        StringBuilder drl = new StringBuilder();
        drl.append("package rules;\n");
        drl.append("import com.research.model.Policy;\n\n");
        for (int i = 1; i <= ruleCount; i++) {
            drl.append("rule \"Rule_").append(i).append("\"\n");
            drl.append("when\n");
            drl.append("    $p : Policy(age > ").append(20 + (i % 50)).append(")\n");
            drl.append("then\n");
            drl.append("    $p.setFinalPremium($p.getFinalPremium() + ")
                    .append(10 + (i % 100))
                    .append(");\n");
            drl.append("end\n\n");
        }
        return drl.toString();
    }
}