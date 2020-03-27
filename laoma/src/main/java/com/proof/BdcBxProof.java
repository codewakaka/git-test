package com.proof;

public class BdcBxProof implements BdcProofFactory {
    @Override
    public String getProof() {
        return "广西不动产登记中心";
    }

    @Override
    public String printProofInfo() {
        return "打印回传";
    }
}
