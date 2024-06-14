package mips;

import java.util.Arrays;
import java.util.HashMap;

import basicsupport.HelpMethods;

public class ProgramMemoryHashMapSample {
    private HashMap<ArrayKey, String> addressToInstruction;

    public ProgramMemoryHashMapSample() {
        addressToInstruction = new HashMap<>();
        initializeHashMap();
    }

    public void initializeHashMap() {
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(0)), 
            "00100000001000000000000000000100"); // addi $r0, $r1, 0x0004
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(4)),
            "00100000001000001111111111111000"); // addi $r0, $r1, 0xFFF8
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(8)), 
            "00100000010000010000000000001000"); // addi $r1, $r2, 0x0008
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(12)), 
            "00100000010000010000000000001000"); // add  $r2, $r0, $r1
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(16)), 
            "00100000010000010000000000001000"); // addi $r1, $r2, 0x0008
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(20)), 
            "00100000000000100000000000000010"); // addi $r2, $r0, 0x0002
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(24)), 
            "00000000010000010001100000100010"); // sub  $r3, $r2, $r1
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(28)), 
            "00101000011001001111111111111011"); // slti $r4, $r3, 0xFFFB
        addressToInstruction.put(
            new ArrayKey(HelpMethods.decToBin(32)), 
            "00000000000001000010100000101010"); // slt  $r5, $r0, $r4
    }

    public String getInstruction(int[] address) {
        return addressToInstruction.getOrDefault(new ArrayKey(address), "Instruction not found");
    }

    private class ArrayKey {
        private final int[] key;

        public ArrayKey(int[] key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) obj;
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }

        @Override
        public String toString() {
            return Arrays.toString(key);
        }
    }
}