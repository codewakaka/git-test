package com.proof;

import java.util.Map;
import java.util.HashMap;

public class BdcProofInterface {
    private static BdcProofInterface bdcProofInterface;
    private BdcProofFactory proofFactory;
    private Map<String, BdcProofFactory> map = new HashMap<>();

    {
        map.put("广西", new BdcBxProof());
        map.put("山西", new BdcSxProof());
    }

    private BdcProofInterface(String type) {
        proofFactory = map.get(type);
    }

    public static BdcProofInterface getBdcProofInterface(String type) {
        if (bdcProofInterface == null) {
            synchronized (BdcProofInterface.class) {
                if (bdcProofInterface == null) {
                    bdcProofInterface = new BdcProofInterface(type);
                }
            }
        }
        return bdcProofInterface;
    }

    public String getProof() {
        return proofFactory.getProof();
    }

    public String printProofInfo() {
        return proofFactory.printProofInfo();
    }

}
