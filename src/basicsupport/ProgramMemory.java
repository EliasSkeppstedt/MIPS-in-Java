package basicsupport;

import mips.ProgramMemoryHashMap;
import mips.ProgramMemoryHashMapSample;

public class ProgramMemory {

    //private ProgramMemoryHashMap hashMap = new ProgramMemoryHashMap();
    private ProgramMemoryHashMapSample hashMap = new ProgramMemoryHashMapSample();

    private int[] instruction = new int[32];
    private int[] address = new int[32];

    private InstructionHub instructionHub;

    public ProgramMemory(InstructionHub instructionHub) {
        this.instructionHub = instructionHub;
    }

    public void setAddressToNextInstruction(int[] address) {

        String className = this.getClass().getSimpleName();
        HelpMethods.is32Bits(address, className);

        this.address = address;
        readNextInstruction();
    }

    private void readNextInstruction() {

        String instruction = hashMap.getInstruction(address);

        System.out.println("Instruction: " + instruction);

        String className = this.getClass().getSimpleName();
        HelpMethods.is32Bits(address, className);

        for (int i = 0; i < 32; i++) {
            this.instruction[i] = Character.getNumericValue(instruction.charAt(i));;
        }
        sendInstructionToInstructionHub();
    }

    private void sendInstructionToInstructionHub() {

        String className = this.getClass().getSimpleName();
        HelpMethods.is32Bits(instruction, className);

        instructionHub.setInstruction(instruction);
        instructionHub.sendInstructionsFromInstructionHub();
    }
}