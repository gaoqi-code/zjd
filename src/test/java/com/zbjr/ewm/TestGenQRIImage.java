//package com.zbjr.ewm;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//
//import java.io.File;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by gonglixun on 2017/1/14.
// */
//public class TestGenQRIImage {
//
//    public static String genQRImage(String folderName, String imageName, String content){
//        //String filePath = System.getProperty("twtwebapp.root");  
//        String fileName = imageName + ".png";
//        try{
//// 检查是否存在imageQR目录，不存在则先创建  
//            File file = new File(folderName);
//            if(!file.exists()&&!file.isDirectory()){
//                file.mkdir();
//            }
//            folderName = file.getAbsolutePath();
//            int width=200;// 图像宽度  
//            int height = 200;// 图像高度  
//            String format = "png";//图像类型  
//            Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType, Object>();
//            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
//            hints.put(EncodeHintType.MARGIN, 1);
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);// 生成矩阵  
//            Path path = FileSystems.getDefault().getPath(folderName,fileName);
//            MatrixToImageWriter.writeToPath(bitMatrix,format,path);// 输出图像  
//            log.info("二维码已经生成," + path);
//            fileName = path.toString();
//        }catch(Exception e){
//            log.error(e.getMessage(),e);
//            fileName = null;
//        }
//        return fileName;
//    }
//
//}
