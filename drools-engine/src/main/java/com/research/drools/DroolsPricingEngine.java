package com.research.drools;
import com.research.model.Policy;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieSession;
import org.kie.api.io.ResourceType;
import org.kie.internal.utils.KieHelper;

import java.util.List;

public class DroolsPricingEngine {

    private final KieBase kieBase;

    public DroolsPricingEngine(int ruleCount) {
        String drl = DrlGenerator.generate(ruleCount);
        KieHelper helper = new KieHelper();
        helper.addContent(drl, ResourceType.DRL);
        Results results = helper.verify();
        if (results.hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException(results.getMessages().toString());
        }
        this.kieBase = helper.build();
    }

    // create fresh session per benchmark invocation
    public KieSession newSession() {
        return kieBase.newKieSession();
    }
    public void evaluateBatch(List<Policy> policies) {
        KieSession session = kieBase.newKieSession();
        for (Policy p : policies) {
            session.insert(p);
        }
        session.fireAllRules();
        session.dispose();
    }
}