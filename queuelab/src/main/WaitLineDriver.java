/**
 * @author Collin Chiang
 * @date 9/19/2022
 */
package main;


public class WaitLineDriver {
    public static void main(String[] args) {
        WaitLine waitLine = new WaitLine();

        waitLine.simulate(10, 0.5, 3);
    }
}
