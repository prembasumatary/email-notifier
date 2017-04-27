package com.tw.go.plugin;


import org.junit.Assert;
import org.junit.Test;

public class FilterTest {

    @Test
    public void testSimpleFilterIsMatched() {
        Filter testFilter = new Filter("SmokeTestBaseInf", "cloudformation", "building");

        Assert.assertFalse(testFilter.matches("SmokeTestBaseInf", "cloudformation", BuildState.FAILED));
        Assert.assertFalse(testFilter.matches("SmokeTestBaseInf", "cloudformation", BuildState.FAILING));
        Assert.assertFalse(testFilter.matches("SmokeTestBaseInf", "cloudformation", BuildState.UNKNOWN));
    }

    @Test
    public void testFilterWithNullBuildStateMatchesAllStates() {
        Filter testFilter = new Filter("SmokeTestBaseInf", "cloudformation", null);

        for(BuildState currentState : BuildState.values()) {
            Assert.assertTrue(testFilter.matches("SmokeTestBaseInf", "cloudformation", currentState));
            Assert.assertTrue(testFilter.matches("SmokeTestBaseInf", "ClOuDfOrMaTiOn", currentState));

        }
    }

    @Test
    public void testFilterWithNullStageNameAndBuildStateMatchesAllStates() {
        Filter testFilter = new Filter("SmokeTestBaseInf", null, null);

        for(BuildState currentState : BuildState.values()) {
            Assert.assertTrue(testFilter.matches("SmokeTestBaseInf", null, currentState));
        }
    }
}