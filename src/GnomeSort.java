public class GnomeSort implements SortAlgorithm {
    @Override
    public void sort(int[] a, SortMetrics m) {
        int i = 0;
        int n = a.length;

        while (i < n) {
            if (i == 0) {
                i++;
            } else {
                m.iterations++; // compara a[i] e a[i-1]
                if (a[i] >= a[i - 1]) {
                    i++;
                } else {
                    ArrayUtils.swap(a, i, i - 1, m);
                    i--;
                }
            }
        }
    }

    @Override
    public String name() { return "Gnome"; }
}
