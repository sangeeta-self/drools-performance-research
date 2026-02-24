package com.research.custom;

import com.research.model.Policy;

@FunctionalInterface
public interface Rule {
    void apply(Policy policy);
}