package com.bbc.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import javax.imageio.ImageIO;
import java.io.File; 
import java.io.OutputStream; 
import java.io.IOException; 
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class QRUtil {
	
   private static final int BLACK = 0xFF000000; 
   private static final int WHITE = 0xFFFFFFFF; 
    
   private QRUtil() {} 
    
      
   public static BufferedImage toBufferedImage(BitMatrix matrix) { 
     int width = matrix.getWidth(); 
     int height = matrix.getHeight(); 
     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
     for (int x = 0; x < width; x++) { 
       for (int y = 0; y < height; y++) { 
         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE); 
       } 
     } 
     return image; 
   } 
    
      
   public static void writeToFile(BitMatrix matrix, String format, File file) 
       throws IOException { 
     BufferedImage image = toBufferedImage(matrix); 
     if (!ImageIO.write(image, format, file)) { 
       throw new IOException("Could not write an image of format " + format + " to " + file); 
     } 
   } 
    
      
   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) 
       throws IOException { 
     BufferedImage image = toBufferedImage(matrix); 
     if (!ImageIO.write(image, format, stream)) { 
       throw new IOException("Could not write an image of format " + format); 
     }
   }

    public static Map<String,String> createQR(String qrDesc,int width,int height,String path,String filename) throws WriterException, IOException {
        Map<String,String> map = new HashMap<String, String>();
        try {

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(qrDesc, BarcodeFormat.QR_CODE, width, height,hints);
            map.put("ml",DateUtils.getFormatDate(new Date(),"yyyyMMDD"));
            String newPath = path+map.get("ml");
            File file = new File(newPath);
            if (!file.exists()){
                file.mkdirs();
            }
            File file1 = new File(newPath,filename+".jpg");
            map.put("filename",filename+".jpg");
            MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            createQR("1233",100,100,"D:/work/mdtz/zbjr-zf/src/main/webapp/","123");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
