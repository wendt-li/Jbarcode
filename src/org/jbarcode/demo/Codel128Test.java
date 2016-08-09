package org.jbarcode.demo;
import java.awt.image.BufferedImage;  
import java.io.FileOutputStream;  

import org.jbarcode.JBarcode;  
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.encode.Code39Encoder;  
import org.jbarcode.encode.EAN13Encoder;  
import org.jbarcode.paint.BaseLineTextPainter;  
import org.jbarcode.paint.EAN13TextPainter;  
import org.jbarcode.paint.WideRatioCodedPainter;  
import org.jbarcode.paint.WidthCodedPainter;  
import org.jbarcode.util.ImageUtil;  
  
/** 
 * 2008-10-4 
 * @author 刘庆 
 */  
public class Codel128Test {  
  
    public static void main(String[] paramArrayOfString)  
  {  
    try  
    {  
      JBarcode localJBarcode = new JBarcode(Code128Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());  
    // 设置打印编码
    localJBarcode.setEncoder(Code128Encoder.getInstance());  
    // 设置宽比 
    localJBarcode.setPainter(WideRatioCodedPainter.getInstance());  
    // 基线样式
    localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());  
    //显示字符串内容中是否显示检查码内容
    localJBarcode.setShowCheckDigit(true);
    // 设置高度 10.0 = 1cm 默认1.5cm
    localJBarcode.setBarHeight(15.0);
    //不生成检查码
    localJBarcode.setCheckDigit(false);
    // 是否显示文本 默认true
    localJBarcode.setShowText(true);
    // 设置自条码宽度
//    localJBarcode.setWideRatio(1);
    // 设置宽度比例
//    localJBarcode.setXDimension(0.5);
      
      
      //这里我们用作图书条码  
      String str = "788515004012";  
      BufferedImage localBufferedImage = localJBarcode.createBarcode(str);  
      saveToJPEG(localBufferedImage, "codel128.jpg");  
 
  
    }  
    catch (Exception localException)  
    {  
      localException.printStackTrace();  
    }  
  }  
  
  static void saveToJPEG(BufferedImage paramBufferedImage, String paramString)  
  {  
    saveToFile(paramBufferedImage, paramString, "jpeg");  
  }  
  
  static void saveToPNG(BufferedImage paramBufferedImage, String paramString)  
  {  
    saveToFile(paramBufferedImage, paramString, "png");  
  }  
  
  static void saveToGIF(BufferedImage paramBufferedImage, String paramString)  
  {  
    saveToFile(paramBufferedImage, paramString, "gif");  
  }  
  
  static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2)  
  {  
    try  
    {  
      FileOutputStream localFileOutputStream = new FileOutputStream("d:/images/" + paramString1);  
      ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);  
      localFileOutputStream.close();  
    }  
    catch (Exception localException)  
    {  
      localException.printStackTrace();  
    }  
  }  
  
}  