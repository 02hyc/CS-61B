package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> arrOne = new AListNoResizing<>();
      BuggyAList<Integer> arrTwo = new BuggyAList<>();

      arrOne.addLast(4);
      arrTwo.addLast(4);
      arrOne.addLast(5);
      arrTwo.addLast(5);
      arrOne.addLast(6);
      arrTwo.addLast(6);

      assertEquals(arrOne.size(), arrTwo.size());

      for (int i = 0; i < 3; i++) {
          assertEquals(arrOne.removeLast(), arrTwo.removeLast());
      }
  }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("size: " + size);
            } else {
                if (L.size() != 0) {
                    int num = L.getLast();
                    L.removeLast();
                //    System.out.println("removeLast(" + num + ")");
                }
            }
        }
    }

    @Test
    public void RandomizedComparison() {
      AListNoResizing<Integer> arrOne = new AListNoResizing<>();
      BuggyAList<Integer> arrTwo = new BuggyAList<>();

      int N = 500;
      for (int i = 0; i < N; i++) {
          int operationNumber = StdRandom.uniform(0, 5);
          if (operationNumber == 0) {
              int randVal = StdRandom.uniform(0, 100);
              arrOne.addLast(randVal);
              arrTwo.addLast(randVal);
              //System.out.println("addLast(" + randVal + ")");
              assertEquals(arrOne.size(), arrTwo.size());
          } else if (operationNumber == 1) {
              if (arrOne.size() != 0) {
                  assertEquals(arrOne.getLast(), arrTwo.getLast());
              }
          } else if (operationNumber == 2) {
              if (arrOne.size() != 0) {
                  int randIndex = StdRandom.uniform(0, arrOne.size());
                  assertEquals(arrOne.get(randIndex), arrTwo.get(randIndex));
              }
          } else if (operationNumber == 3) {
              int size = arrOne.size();
              //System.out.println("size: " + size);
              assertEquals(arrOne.size(), arrTwo.size());
          } else {
              if (arrOne.size() != 0) {
                  int num = arrOne.getLast();
              //    System.out.println("removeLast(" + num + ")");
                  assertEquals(arrOne.removeLast(), arrTwo.removeLast());
              }
          }
      }
    }
}
