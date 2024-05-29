package adder;

public class FullAdder {
    private int a, b, cIn, cOut, r;

    protected void prepareFullAdder(int a, int b, int cIn) {
        this.a   = a;
        this.b   = b;
        this.cIn = cIn;
        performCalculation();
    }

    protected int getResult() {
        return r;
    }

    protected int getCarryOut() {
        return cOut;
    }

    private void performCalculation() {
        int AxorB, AandB;
        AxorB = xor(a, b);
        r     = xor(AxorB, cIn);
        AandB = a     == 1 && b   == 1 ? 1 : 0;
        cOut  = AandB == 1 || cIn == 1 ? 1 : 0;
    }

    private int xor(int var1, int var2) {
        return (var1 == 1 && var2 == 0) || (var1 == 0 && var2 == 1) ? 1 : 0;
    }
}
