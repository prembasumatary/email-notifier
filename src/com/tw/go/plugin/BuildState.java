package com.tw.go.plugin;


public enum BuildState {

    FAILING,
    FAILED,
    UNKNOWN;

    public static BuildState fromRawString(String rawString) {
        if(rawString == null) {
            return null;
        }
        switch (rawString.toLowerCase()) {
            case "failing":
                return FAILING;
            case "failed":
                return FAILED;
            default:
                return UNKNOWN;
        }
    }
}
