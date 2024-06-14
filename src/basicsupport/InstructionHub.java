package basicsupport;

import java.util.Arrays;

public class InstructionHub {
    private State state;
    private RegisterFile registerFile;
    private SignExtend signExtend;
    private int[] instr = new int[32];

    // mux
    public InstructionHub(State state, RegisterFile registerFile, SignExtend signExtend) {
        this.state = state;
        this.registerFile = registerFile;
        this.signExtend = signExtend;
    }

    public void setInstruction(int[] instr) {

        String className = this.getClass().getSimpleName();
        HelpMethods.is32Bits(instr, className);
        
        HelpMethods.reverseArray(instr);
        this.instr = instr;
    }

    public void sendInstructionsFromInstructionHub() {
        toControlUnit();
        toRegisterFile();
        toSignExtend();
    }

    private void toControlUnit() {
        int[] opCode = Arrays.copyOfRange(instr, 0, 6);
        int[] funct = Arrays.copyOfRange(instr, 26, 32);

        state.setOperation(opCode, funct);
    }

    private void toRegisterFile() {
        int[] rs = Arrays.copyOfRange(instr, 6, 11);
        int[] rt = Arrays.copyOfRange(instr, 11, 16);
        int[] rd = Arrays.copyOfRange(instr, 16, 21);

        registerFile.setRegisters(rs, rt, rd);
    }

    private void toSignExtend() {
        int[] imm = Arrays.copyOfRange(instr, 16, 32);

        signExtend.setImmidiate(instr);
    }
}
