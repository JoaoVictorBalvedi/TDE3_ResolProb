public class CocktailSort implements SortAlgorithm {
    @Override
    public void sort(int[] a, SortMetrics m) {
        boolean changed = true;
        int left = 0, right = a.length - 1;

        while (changed) {
            changed = false;
            for (int i = left; i < right; i++) {
                m.iterations++;
                if (a[i] > a[i + 1]) {
                    ArrayUtils.swap(a, i, i + 1, m);
                    changed = true;
                }
            }
            if (!changed) break;
            changed = false;
            right--;
            for (int i = right; i > left; i--) {
                m.iterations++;
                if (a[i - 1] > a[i]) {
                    ArrayUtils.swap(a, i - 1, i, m);
                    changed = true;
                }
            }
            left++;
        }
    }

    @Override
    public String name() { return "Cocktail"; }
}
