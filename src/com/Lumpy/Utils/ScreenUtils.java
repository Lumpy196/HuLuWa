package com.Lumpy.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This method can clean the console by simulate human's keyboard input.
 * It depends on the IDE's keymap
 */
public class ScreenUtils {
    public static void screenClear() throws AWTException {

        //The kepmap should be set as "CTRL + ALT +R" to make the method work correctly.
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(100);
    }
}
