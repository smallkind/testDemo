package com.smallkind.utils;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.org.apache.poi.util.IOUtils;

import java.io.File;
import java.io.OutputStream;

/**
 * @author smallkind
 * @description
 * @create 2017-07-06-16:19
 */
public class PdfUtil {


    /**
     * docx文档转换为PDF
     *
     * @param docxPath    docx文档
     * @param pdfPath PDF文档存储路径
     * @throws Exception 可能为Docx4JException, FileNotFoundException, IOException等
     */
    public static void convertDocxToPDF(String docxPath, String pdfPath) throws Exception {
        OutputStream os = null;
        try {
            WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(new File(docxPath));
            //Mapper fontMapper = new BestMatchingMapper();
            Mapper fontMapper = new IdentityPlusMapper();
            fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
            fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
            fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
            mlPackage.setFontMapper(fontMapper);

            os = new java.io.FileOutputStream(pdfPath);

            FOSettings foSettings = Docx4J.createFOSettings();
            foSettings.setWmlPackage(mlPackage);
            Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    public static void main(String[] args) {

    }
}


