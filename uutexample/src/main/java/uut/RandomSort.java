package uut;

public class RandomSort {

    private int[] i;

    public RandomSort(int[] i) {
        this.i = i;
    }

    public int[] sort() {
        int counter = 0;
        System.out.println("I'll sort " + i.length + " elements...");
        while(!isSorted()) {
            shuffle(i);
            counter++;
        }
        System.out.println("Solution found! (shuffled " + counter + " times)");
        return i;
    }

    public void print() {
        for(int x : i) {
            System.out.print(x + ", ");
        }
        System.out.println();
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

    public boolean isSorted() {
        for(int x = 0; x < i.length - 1; ++x) {
            if(i[x] > i[x+1]) {
                return false;
            }
        }
        return true;
    }

}