package com.proof;

public class BdcSxProof implements BdcProofFactory {
    @Override
    public String getProof() {
        return "山西不动产登记中心";
    }

    @Override
    public String printProofInfo() {
        return "山西打印回传";
    }
}
