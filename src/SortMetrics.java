public class SortMetrics {
    public long iterations = 0; // contagem de comparações principais
    public long swaps = 0;      // contagem de trocas ou movimentos

    public void reset() {
        iterations = 0;
        swaps = 0;
    }

    @Override
    public String toString() {
        return "iterations=" + iterations + ", swaps=" + swaps;
    }
}
