package Main;

public class DuplicateRemoval {

    public DuplicateRemoval() {

    }

    public int[][] removingDuplicate(int[][] arrayToModify) {
        int[][] result;
        for (int i = 0; i < arrayToModify.length; i++) {
            int start = 0;
            int end = arrayToModify[i].length - 1;
            while (start < arrayToModify[i].length - 2) {
                if (arrayToModify[i][start] == arrayToModify[i][end]) {
                    arrayToModify[i][end] = 0;

                }
                --end;
                if (end == start + 1) {
                    start++;
                    end = arrayToModify[i].length - 1;
                }

            }

        }

        return arrayToModify;
    }
}
