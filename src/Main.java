public class Main {
    public static void main(String[] args) {
        // algoritmos que vamos comparar
        SortAlgorithm[] algos = new SortAlgorithm[] {
                new CombSort(),
                new GnomeSort(),
                new BucketSort(),
                new BubbleFlagSort(),
                new SelectionSort(),
                new CocktailSort()
        };

        SortRunner runner = new SortRunner(algos);

        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        runner.runAll("Vetor 1 estilo aleatorio", vetor1);
        runner.runAll("Vetor 2 quase ordenado crescente", vetor2);
        runner.runAll("Vetor 3 decrescente", vetor3);
    }
}
