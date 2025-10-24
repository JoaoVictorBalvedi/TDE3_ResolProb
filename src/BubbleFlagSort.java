public class BubbleFlagSort implements SortAlgorithm {
    @Override
    public void sort(int[] a, SortMetrics m) {
        boolean changed;
        for (int i = 0; i < a.length - 1; i++) {
            changed = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                m.iterations++;
                if (a[j] > a[j + 1]) {
                    ArrayUtils.swap(a, j, j + 1, m);
                    changed = true;
                }
            }
            if (!changed) break;
        }
    }

    @Override
    public String name() { return "BubbleFlag"; }
}
