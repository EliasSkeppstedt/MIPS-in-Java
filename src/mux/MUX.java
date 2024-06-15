package mux;

public abstract class MUX {
    private int[] 
        inputA,
        inputB,
        output;
    
    private int op;

    protected MUX(int[] arraySizeForMUX) {
        this.inputA = arraySizeForMUX;
        this.inputB = arraySizeForMUX;
        this.output = arraySizeForMUX;
    }

    public void setInputA(int[] inputA) {
        this.inputA = inputA;
    }

    public void setInputB(int[] inputB) {
        this.inputB = inputB;
    }

    public void setOP(int op) {
        this.op = op;
    }
    
    public int[] fetchOutput() {
        System.out.println("This ");
        return op == 0 ? inputA : inputB;
    }
}

