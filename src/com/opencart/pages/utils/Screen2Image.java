package com.opencart.pages.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screen2Image {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

    public void makeScreenshot(String partialName) throws Exception
    {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("C:\\Users\\ПК\\IdeaProjects\\java_demo1\\screenshots\\"+formatter.format(now.getTime())+ partialName + ".jpg"));
        System.out.println(formatter.format(now.getTime()) + " - screen of error was captured.");
    }
}

