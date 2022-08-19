package uut;

public class BogoSort {

    private int[] i;

    public int[] sortWithRandom(int n) {
        if (n <= 0) {
            return new int[0];
        }
        i = new int[n];
        for (int j = 0; j<n; j++) {
            i[j] = ((int) (Math.random() * n));
        }

        int counter = 0;
        System.out.println("I'll sort " + i.length + " elements...");
        while(!isSorted()) {
            shuffle(i);
            counter++;
        }
        System.out.println("Solution found! (shuffled " + counter + " times)");
        return i;
    }

    private void shuffle(int[] i) {
        for(int x = 0; x < i.length; ++x) {
            int index1 = (int) (Math.random() * i.length),
                    index2 = (int) (Math.random() * i.length);
            int a = i[index1];
            i[index1] = i[index2];
            i[index2] = a;
        }
    }

    private boolean isSorted() {
        for(int x = 0; x < i.length - 1; ++x) {
            if(i[x] > i[x+1]) {
                return false;
            }
        }
        return true;
    }

}