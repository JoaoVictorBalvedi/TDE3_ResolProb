public class CombSort implements SortAlgorithm {
    @Override
    public void sort(int[] a, SortMetrics m) {
        int n = a.length;
        int gap = n;
        boolean changed = true;
        final double SHRINK = 1.3;

        while (gap > 1 || changed) {
            gap = (int) (gap / SHRINK);
            if (gap < 1) gap = 1;
            changed = false;

            for (int i = 0; i + gap < n; i++) {
                m.iterations++;
                if (a[i] > a[i + gap]) {
                    ArrayUtils.swap(a, i, i + gap, m);
                    changed = true;
                }
            }
        }
    }

    @Override
    public String name() { return "Comb"; }
}
