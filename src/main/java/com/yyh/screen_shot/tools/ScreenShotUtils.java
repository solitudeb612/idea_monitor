package com.yyh.screen_shot.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class ScreenShotUtils {
    private static String defaultImageFormat = "png";
    public static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    public static void snapShot(String filePath, String fileName) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                // 如果目录不存在，创建目录
                boolean create = file.mkdirs();

            }

            // 拷贝屏幕到一个 BufferedImage 对象 screenshot
            BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle((int) d.getWidth(), (int) d.getHeight()));

            // 根据文件名前缀和默认图像格式，生成完整的文件名
            String name = fileName + "_" + getDateTimeString() + "." + defaultImageFormat;
            String imagePath = filePath + File.separator + name;
            File f = new File(imagePath);
            System.out.println("Save File " + imagePath);

            // 将 screenshot 对象写入图像文件
            boolean tof = ImageIO.write(screenshot, defaultImageFormat, f);
            if (tof) {
                System.out.println("图片生成成功：" + name);
                onImageSaved(imagePath); // 调用回调方法
            } else {
                System.out.println("图片生成失败");
            }
        } catch (Exception e) {
            System.out.println("截图失败" + e);
        }
    }

    public static void snapShot() {
        try {
            // 加载配置文件
            Properties properties = new Properties();
            String configFilePath = "src/main/resources/config.properties";
            FileInputStream fis = new FileInputStream(configFilePath);
            properties.load(fis);
            fis.close();

            // 获取文件路径
            String filePath = properties.getProperty("screenshot.path");

            // 拷贝屏幕到一个 BufferedImage 对象 screenshot
            BufferedImage screenshot = (new Robot()).createScreenCapture(new Rectangle((int) d.getWidth(), (int) d.getHeight()));

            // 根据文件名前缀和默认图像格式，生成完整的文件名
            String name = "screenshot_" + getDateTimeString() + "." + defaultImageFormat;
            String imagePath = filePath + File.separator + name;
            File f = new File(imagePath);

            // 将 screenshot 对象写入图像文件
            boolean tof = ImageIO.write(screenshot, defaultImageFormat, f);
            if (tof) {
                System.out.println("图片生成成功：" + name);
                onImageSaved(imagePath); // 调用回调方法
            } else {
                System.out.println("图片生成失败");
            }
        } catch (Exception e) {
            System.out.println("截图失败" + e);
        }
    }

    private static String getDateTimeString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    private static void onImageSaved(String imagePath) {
        // 在截图保存后执行自定义的操作
        System.out.println("图片保存成功：" + imagePath);
        // 这里可以添加您想要执行的逻辑
    }
}