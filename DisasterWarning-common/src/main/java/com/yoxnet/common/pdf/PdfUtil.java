package com.yoxnet.common.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {
	
	//模板路径
	private static String TEMPLATEPATH = C_PDF.TEMPLATEPATH;
	//生成的新文件路径
	private static String NEWPDFPATH = C_PDF.NEWPDFPATH;

	
	/**
	 * 利用模板生成pdf
	 * @param pdfFile pdf工具实体
	 * @return 
	 */
	public final static String createPDF(PdfFile pdfFile){
		FileOutputStream out = null;
		PdfReader reader = null ;
		ByteArrayOutputStream bos = null;
		PdfStamper stamper = null;
		Document doc = null;
		PdfCopy copy = null;
		try {
			out = new FileOutputStream(NEWPDFPATH+pdfFile.getPdfId()+pdfFile.getTemplateName());//输出流
			reader = new PdfReader(TEMPLATEPATH+pdfFile.getTemplateName());//读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
		    BaseFont baseFont = BaseFont.createFont("./SIMHEI.TTF",
		        BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
			java.util.Iterator<String> it = form.getFields().keySet().iterator();
			
			if(pdfFile.getImageList() != null){
				for(PdfImage image : pdfFile.getImageList()){
					setImage(image, stamper);
				}
			}
			
			if(pdfFile.getFields()!=null){
				while(it.hasNext()){
			    	String name = it.next().toString();
			    	//System.out.println(name);
			    	form.setField(name, pdfFile.getFields().get(name)==null?"":
			    		pdfFile.getFields().get(name).toString());
			    	form.addSubstitutionFont(baseFont);
			    }
			}
		    
		    stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
		    stamper.close();
		    doc = new Document();
		    copy = new PdfCopy(doc, out);
		    doc.open();
		    
		    for(int i=1;i<=reader.getNumberOfPages();i++){
		    	PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
		    	copy.addPage(importPage);
		    }
		    doc.close();
		    copy.close();
		} catch (IOException e) {
			return null;
		} catch (DocumentException e) {
			return null;
		}finally {
			try {
				stamper.close();
				bos.close();
				out.close();
			} catch (Exception e) {
				return null;
			}
		}
		return NEWPDFPATH+pdfFile.getPdfId()+pdfFile.getTemplateName();
	}  
	
	
	private static void setImage(PdfImage image,PdfStamper stamper) 
			throws MalformedURLException, IOException, DocumentException{
		if(!"".equals(image.getFilePath())){
            Image gif = Image.getInstance(image.getFilePath());
            gif.setAbsolutePosition(image.getAbsoluteX(), image.getAbsoluteY());
            gif.scalePercent(image.getScalePercent());
            PdfContentByte under = stamper.getUnderContent(image.getPageNum());
            under.addImage(gif);
        }
	}
	
	
	public static File Pdf(ArrayList<String> imageUrllist,String mOutputPdfFileName) {  
        Document doc = new Document(PageSize.A4, 20, 20, 20, 20);  
        try {  
            PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName));  
            doc.open();  
            for (int i = 0; i < imageUrllist.size(); i++) {  
                doc.newPage();  
//                doc.add(new Paragraph("简单使用iText"));  
                Image png1 = Image.getInstance(imageUrllist.get(i));  
                float heigth = png1.getHeight();  
                float width = png1.getWidth();  
                int percent = getPercent2(heigth, width);  
                png1.setAlignment(Image.MIDDLE);  
                png1.scalePercent(percent+3);// 表示是原来图像的比例;  
                doc.add(png1);  
            }  
            doc.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
        File mOutputPdfFile = new File(mOutputPdfFileName);  
        if (!mOutputPdfFile.exists()) {  
            mOutputPdfFile.deleteOnExit();  
            return null;  
        }  
        return mOutputPdfFile;  
    }  
  
    /** 
     * 第一种解决方案 在不改变图片形状的同时，判断，如果h>w，则按h压缩，否则在w>h或w=h的情况下，按宽度压缩 
     * 
     * @param h 
     * @param w 
     * @return 
     */  
  
    public static int getPercent(float h, float w) {  
        int p = 0;  
        float p2 = 0.0f;  
        if (h > w) {  
            p2 = 297 / h * 100;  
        } else {  
            p2 = 210 / w * 100;  
        }  
        p = Math.round(p2);  
        return p;  
    }  
  
    /** 
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的 
     * 
     * @param args 
     */  
    public static int getPercent2(float h, float w) {  
        int p = 0;  
        float p2 = 0.0f;  
        p2 = 530 / w * 100;  
        p = Math.round(p2);  
        return p;  
    }  
    
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
            ArrayList<String> imageUrllist = new ArrayList<String>();  
            imageUrllist.add("D:\\Documents\\Pictures\\" + "1" + ".jpg");
            imageUrllist.add("D:\\Documents\\Pictures\\" + "2" + ".jpg");
            String pdfUrl = "D:\\Foreverlove.pdf";  
            File file = Pdf(imageUrllist, pdfUrl);  
            try {  
                file.createNewFile();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
    }  
}
