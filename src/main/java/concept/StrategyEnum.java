package concept;

public enum StrategyEnum {

    ADD("+"){
        @Override
        public int apply(int a, int b){
            return a+b;
        }
    };
    private final String symbol;

    StrategyEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
    public abstract int apply(int a, int b);
}
