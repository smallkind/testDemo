package com.smallkind.utils;

import com.lowagie.text.pdf.BaseFont;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author smallkind
 * @description
 * @create 2017-07-12-15:51
 */
public class Html2Pdf {

//    public boolean convertHtmlToPdf(String inputFile, String outputFile)
//            throws Exception {
//
//        OutputStream os = new FileOutputStream(outputFile);
//        ITextRenderer renderer = new ITextRenderer();
//        String url = new File(inputFile).toURI().toURL().toString();
//        renderer.setDocument(url);
//        // 解决中文支持问题
//        ITextFontResolver fontResolver = renderer.getFontResolver();
//        fontResolver.addFont("C:/Windows/Fonts/simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        //解决图片的相对路径问题
//        renderer.getSharedContext().setBaseURL("file:/D:/test");
//        renderer.layout();
//        renderer.createPDF(os);
//        os.flush();
//        os.close();
//        return true;
//    }


//    public   static  void  main(String [] args){
//        Html2Pdf html2Pdf =new Html2Pdf();
//        try {
//            html2Pdf.convertHtmlToPdf("D:\\1.html","D:\\index.pdf");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
