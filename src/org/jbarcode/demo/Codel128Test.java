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
 * @author ���� 
 */  
public class Codel128Test {  
  
    public static void main(String[] paramArrayOfString)  
  {  
    try  
    {  
      JBarcode localJBarcode = new JBarcode(Code128Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());  
    // ���ô�ӡ����
    localJBarcode.setEncoder(Code128Encoder.getInstance());  
    // ���ÿ�� 
    localJBarcode.setPainter(WideRatioCodedPainter.getInstance());  
    // ������ʽ
    localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());  
    //��ʾ�ַ����������Ƿ���ʾ���������
    localJBarcode.setShowCheckDigit(true);
    // ���ø߶� 10.0 = 1cm Ĭ��1.5cm
    localJBarcode.setBarHeight(15.0);
    //�����ɼ����
    localJBarcode.setCheckDigit(false);
    // �Ƿ���ʾ�ı� Ĭ��true
    localJBarcode.setShowText(true);
    // ������������
//    localJBarcode.setWideRatio(1);
    // ���ÿ�ȱ���
//    localJBarcode.setXDimension(0.5);
      
      
      //������������ͼ������  
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