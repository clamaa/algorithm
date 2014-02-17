package algorithm.application;

/**
 * User: clamaa
 * Date: 4/20/13
 */
public class RecursiveAlgorithm {

    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    public static int triangle(int n) {
        return n == 1 ? 1 : n + triangle(n - 1);
    }

    public static void doAnalyseGram() {

    }

    public static class AnalyseGram {
        public void doAnalyse(int newSize) {
            if (newSize == 1) {
                return;
            }
            for (int i = 0; i < newSize; i++) {
                doAnalyse(newSize - 1);
                if(newSize == 2){
                    displayWord();
                }
            }
        }

        public void displayWord(){

        }
    }

}
