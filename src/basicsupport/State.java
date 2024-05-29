package basicsupport;

import mips.Operation;

public class State {
    private ControlUnit controlUnit;
    private Operation state;
    
    public State(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void setOperation(int[] opCode, int[] funct) {
        int opCodeDec = binToDec(opCode);
        int functDec = binToDec(funct);

        if (opCodeDec == 0) {
            if        (functDec == 32) {
                state = Operation.ADD;
            } else if (functDec == 34) {
                state = Operation.SUB;
            } else if (functDec == 36) {
                state = Operation.AND;
            } else if (functDec == 37) {
                state = Operation.OR;
            } else if (functDec == 42) {
                state = Operation.SLT;
            }
        } else if (opCodeDec == 35) {
            state = Operation.LW;
        } else if (opCodeDec == 43) {
            state = Operation.SW;
        } else if (opCodeDec == 4) {
            state = Operation.BEQ;
        } else if (opCodeDec == 2) {
            state = Operation.J;
        } else { 
            state = Operation.NOP; 
        }
        setControlUnitSignals();
    }

    private int binToDec(int[] bin) {
        int dec = 0;
        for (int i = 4, pow = 0; i >= 0; i--, pow++) {
            dec += bin[i] * Math.pow(2, pow);
        }   
        return dec;
    }

    public void setControlUnitSignals() {
        controlUnit.updateSignals(state);
    }
}
