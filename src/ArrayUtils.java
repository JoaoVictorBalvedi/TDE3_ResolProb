public class ArrayUtils {
    public static int[] copyOf(int[] src) {
        int[] c = new int[src.length];
        for (int i = 0; i < src.length; i++) c[i] = src[i];
        return c;
    }

    public static void swap(int[] a, int i, int j, SortMetrics m) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        m.swaps++;
    }

    public static void printArray(String title, int[] a) {
        System.out.print(title + ": [");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.println("]");
    }
}
