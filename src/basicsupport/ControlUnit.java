package basicsupport;

import mips.Operation;

public class ControlUnit {
    private int regWrite, regDst, ALUSrc, memWrite, memToReg, branch, jump;
    private int[] ALUControl = new int[3];
    
    public void updateSignals(Operation state) {
        switch (state) {
            case ADD:
                setForOperation
                    (1, 1, 0, 0, 0, 0, 0, new int[]{0, 1, 0});
                break;
            case SUB:
                setForOperation
                    (1, 1, 0, 0, 0, 0, 0, new int[]{1, 1, 0});
                break;
            case SLT:
                setForOperation
                    (1, 1, 0, 0, 0, 0, 0, new int[]{1, 1, 1});
                break;
            case AND:
                setForOperation
                    (1, 1, 0, 0, 0, 0, 0, new int[]{0, 0, 0});
                break;
            case OR:
                setForOperation
                    (1, 1, 0, 0, 0, 0, 0, new int[]{0, 0, 1});
                break;
            case ADDI:
                setForOperation
                    (1, 0, 1, 0, 0, 0, 0, new int[]{0, 1, 0});
                break;
            case SLTI:
                setForOperation
                    (1, 0, 1, 0, 0, 0, 0, new int[]{1, 1, 1});
                break;
            case NOP:
                setForOperation
                    (0, 0, 0, 0, 0, 0, 0, new int[]{0, 0, 0});
                break;
        }
    }

    public int getRegWrite() {
        return regWrite;
    }

    public int getRegDst() {
        return regDst;
    }

    public int getALUSrc() {
        return ALUSrc;
    }

    public int getMemWrite() {
        return memWrite;
    }

    public int getMemToReg() {
        return memToReg;
    }

    public int getBranch() {
        return branch;
    }

    public int getJump() {
        return jump;
    }

    public int[] getALUControl() {
        return ALUControl;
    }

    /**
     * @param regWrite
     * @param regDest
     * @param ALUSrc
     * @param memWrite
     * @param memToReg
     * @param branch
     * @param jump
     * @param ALUControl
     */
    private void setForOperation(int regWrite, int regDst, int ALUSrc, int memWrite, int memToReg, int branch, int jump, int[] ALUControl) {
        this.regWrite = regWrite;
        this.regDst = regDst;
        this.ALUSrc = ALUSrc;
        this.memWrite = memWrite;
        this.memToReg = memToReg;
        this.branch = branch;
        this.jump = jump;
        this.ALUControl = ALUControl;
    }
}
