package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateRemovalTest {

    @Test
    void removingDuplicate() {
        int [][] testValue = {{1,2,5,2,2},{8,7,2,3,4,5}};
        DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
        int [][]result=duplicateRemoval.removingDuplicate(testValue);
        int [][] answer = {{1, 2, 5, 0, 0}, {8, 7, 2, 3, 4, 5}};
        int x = result[0][3];
        int y = answer[0][3];
        assertEquals(y,x);
    }
}