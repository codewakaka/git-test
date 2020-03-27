package com.proof;

public class ProofTest {
    public static void main(String[] args) {
        BdcProofInterface proofInterface = BdcProofInterface.getBdcProofInterface("山西");
        System.out.println( proofInterface.getProof());
        System.out.println( proofInterface.printProofInfo());
    }
}
