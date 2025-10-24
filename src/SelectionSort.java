public class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] a, SortMetrics m) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                m.iterations++;
                if (a[j] < a[min]) min = j;
            }
            if (min != i) ArrayUtils.swap(a, i, min, m);
        }
    }

    @Override
    public String name() { return "Selection"; }
}
