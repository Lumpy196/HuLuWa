package com.hlw.Utils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class ScreenUtils {

    /**
     * This method can clean the console by simulate human's keyboard input.
     * It depends on the IDE's keymap
     *
     * @param delayTime set the delay time to show the terminal
     * @throws AWTException
     */
    public static void screenClear(int delayTime) throws AWTException {

        //The kepmap should be set as "CTRL + ALT + R" to make the method work correctly.
        Robot robot = new Robot();
        robot.delay(delayTime);
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(delayTime);
    }
}
