import java.util.ArrayList;
import java.util.List;

public class BucketSort implements SortAlgorithm {

    // insertion sort manual para usar dentro de cada bucket
    private void insertionSort(int[] arr, SortMetrics m) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                m.iterations++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j]; // movimento conta como swap para fins de comparação
                    m.swaps++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    @Override
    public void sort(int[] a, SortMetrics m) {
        if (a.length <= 1) return;

        int min = a[0], max = a[0];
        for (int v : a) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        int n = a.length;
        int bucketsCount = n; // escolha simples
        int range = Math.max(1, max - min + 1);
        double step = (double) range / bucketsCount;

        List<List<Integer>> buckets = new ArrayList<>(bucketsCount);
        for (int i = 0; i < bucketsCount; i++) buckets.add(new ArrayList<>());

        // distribuição
        for (int v : a) {
            int idx = (int) ((v - min) / step);
            if (idx >= bucketsCount) idx = bucketsCount - 1;
            buckets.get(idx).add(v);
        }

        // ordena cada bucket com insertion manual e recompõe
        int k = 0;
        for (List<Integer> b : buckets) {
            if (b.isEmpty()) continue;

            int[] temp = new int[b.size()];
            for (int i = 0; i < b.size(); i++) temp[i] = b.get(i);

            insertionSort(temp, m);

            for (int x : temp) a[k++] = x;
        }
    }

    @Override
    public String name() { return "Bucket"; }
}
