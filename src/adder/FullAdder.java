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
        int AxorB, AandB, CINandAxorB;
        AxorB       = xor(a, b);
        r           = xor(AxorB, cIn);
        CINandAxorB = and(cIn, AxorB);
        AandB       = and(a, b);
        cOut        = or (CINandAxorB, AandB);
    }

    private int xor(int var1, int var2) {
        return (var1 == 1 && var2 == 0) || (var1 == 0 && var2 == 1) ? 1 : 0;
    }

    private int and(int var1, int var2) {
        return var1 == 1 && var2 == 1 ? 1 : 0;
    }

    private int or(int var1, int var2) {
        return var1 == 1 || var2 == 1 ? 1 : 0;
    }
}
