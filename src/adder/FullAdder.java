package adder;

public class FullAdder {
    private boolean a, b, cIn, cOut;
    private int     r;

    protected void prepareFullAdder(int a, int b, int cIn) {
        this.a   = trueOrFalse(a);
        this.b   = trueOrFalse(b);
        this.cIn = trueOrFalse(cIn);
        performCalculation();
    }

    protected int getResult() {
        return r;
    }

    protected boolean getCarryOut() {
        return cOut;
    }

    private boolean trueOrFalse(int var) {
        return var == 1 ? true : false;
    }

    private void performCalculation() {
        boolean AxorB, AandB;
        AxorB = xor(a, b) ? true : false;
        AandB = a && b    ? true : false;

        r    = xor(AxorB, cIn) ? 1 : 0;
        cOut = AandB || cIn;
    }

    private boolean xor(boolean var1, boolean var2) {
        return (var1 && !var2) || (!var1 && var2);
    }
}
