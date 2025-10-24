public class SortRunner {
    private final SortAlgorithm[] algos;

    public SortRunner(SortAlgorithm[] algos) {
        this.algos = algos;
    }

    public void runAll(String label, int[] base) {
        System.out.println("\n=== " + label + " ===");
        ArrayUtils.printArray("Original", base);

        SortMetrics m = new SortMetrics();

        for (SortAlgorithm algo : algos) {
            int[] a = ArrayUtils.copyOf(base);
            m.reset();
            algo.sort(a, m);
            ArrayUtils.printArray(algo.name(), a);
            System.out.println(algo.name() + " -> " + m.toString());
        }
    }
}
