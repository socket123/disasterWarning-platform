package com.yoxnet.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author duhuifan
 */
public class ExcelUtils {
	
	
	/** 
     * 默认的开始读取的行位置为第一行（索引值为0） 
     */  
    private final static int READ_START_POS = 0;  
      
    /** 
     * 默认结束读取的行位置为最后一行（索引值=0，用负数来表示倒数第n行） 
     */  
    private final static int READ_END_POS = 0;  
      
    /** 
     * 默认Excel内容的开始比较列位置为第一列（索引值为0） 
     */  
    private final static int COMPARE_POS = 0;  
      
    /** 
     * 默认多文件合并的时需要做内容比较（相同的内容不重复出现） 
     */  
    private final static boolean NEED_COMPARE = true;  
      
    /** 
     * 默认多文件合并的新文件遇到名称重复时，进行覆盖 
     */  
    private final static boolean NEED_OVERWRITE = true;  
      
    /** 
     * 默认只操作一个sheet 
     */  
    private final static boolean ONLY_ONE_SHEET = true;  
      
    /** 
     * 默认读取第一个sheet中（只有当ONLY_ONE_SHEET = true时有效） 
     */  
    private final static int SELECTED_SHEET = 0;  
      
    /** 
     * 默认从第一个sheet开始读取（索引值为0） 
     */  
    private final static int READ_START_SHEET= 0;  
      
    /** 
     * 默认在最后一个sheet结束读取（索引值=0，用负数来表示倒数第n行） 
     */  
    private final static int READ_END_SHEET = 0;  
      
    /** 
     * 默认打印各种信息 
     */  
    private final static boolean PRINT_MSG = true;  
      
      
  
    /** 
     * Excel文件路径 
     */  
    private String excelPath = "data.xlsx";  
  
    /** 
     * 设定开始读取的位置，默认为0 
     */  
    private int startReadPos = READ_START_POS;  
  
    /** 
     * 设定结束读取的位置，默认为0，用负数来表示倒数第n行 
     */  
    private int endReadPos = READ_END_POS;  
      
    /** 
     * 设定开始比较的列位置，默认为0 
     */  
    private int comparePos = COMPARE_POS;  
  
    /** 
     *  设定汇总的文件是否需要替换，默认为true 
     */  
    private boolean isOverWrite = NEED_OVERWRITE;  
      
    /** 
     *  设定是否需要比较，默认为true(仅当不覆写目标内容是有效，即isOverWrite=false时有效) 
     */  
    private boolean isNeedCompare = NEED_COMPARE;  
      
    /** 
     * 设定是否只操作第一个sheet 
     */  
    private boolean onlyReadOneSheet = ONLY_ONE_SHEET;  
      
    /** 
     * 设定操作的sheet在索引值 
     */  
    private int selectedSheetIdx =SELECTED_SHEET;  
      
    /** 
     * 设定操作的sheet的名称 
     */  
    private String selectedSheetName = "";  
      
    /** 
     * 设定开始读取的sheet，默认为0 
     */  
    private int startSheetIdx = READ_START_SHEET;  
  
    /** 
     * 设定结束读取的sheet，默认为0，用负数来表示倒数第n行     
     */  
    private int endSheetIdx = READ_END_SHEET;  
      
    /** 
     * 设定是否打印消息 
     */  
    private boolean printMsg = PRINT_MSG;  
      
    /**
     * Excel导入的工作空间  
     */
    HSSFWorkbook wb;
    /**
     * Excel导入的分页
     */
	HSSFSheet sheet;
	/**
	 * 标题字体
	 */
	public HSSFFont titleFont;
	/**
	 * 标题样式
	 */
	public HSSFCellStyle titlestyle;
	/**
	 * 头部字体
	 */
	public HSSFFont headerFont;
	/**
	 * 样式2(普通内容样式)
	 */
	public HSSFCellStyle style2;
	/**
	 * 样式1(标题样式)
	 */
	public HSSFCellStyle style;

      
    public ExcelUtils(){  
          
    }  
      
    public ExcelUtils(String excelPath){  
        this.excelPath = excelPath;  
    }  
      
    /** 
     * 还原设定（其实是重新new一个新的对象并返回） 
     */  
    public ExcelUtils RestoreSettings(){  
    	ExcelUtils instance = new  ExcelUtils(this.excelPath);  
        return instance;  
    }  
      
    /** 
     * 自动根据文件扩展名，调用对应的读取方法 
     */  
    public List<Row> readExcel() throws IOException{  
        return readExcel(this.excelPath,".xls");  
    }  
  
    /** 
     * 自动根据文件扩展名，调用对应的读取方法 
     */  
    public List<Row> readExcel(String xlsPath,String fileName) throws IOException{  
          
        //扩展名为空时，  
        if (fileName.equals("")){  
            throw new IOException("文件路径不能为空！");  
        }else{  
            File file = new File(xlsPath);  
            if(!file.exists()){  
                throw new IOException("文件不存在！");  
            }  
        }  
          
        //获取扩展名  
        String ext = fileName.substring(fileName.lastIndexOf(".")+1);  
          
        try {  
              
            if("xls".equals(ext)){              //使用xls方式读取  
                return readExcel_xls(xlsPath);  
            }else if("xlsx".equals(ext)){       //使用xlsx方式读取  
                return readExcel_xlsx(xlsPath);  
            }else{                                  //依次尝试xls、xlsx方式读取  
                try{  
                    return readExcel_xls(xlsPath);  
                } catch (IOException e1) {  
                    try{  
                        return readExcel_xlsx(xlsPath);  
                    } catch (IOException e2) {  
                        throw e2;  
                    }  
                }  
            }  
        } catch (IOException e) {  
            throw e;  
        }  
    }  
      


  
    /** 
     * 读取Excel 2007版，xlsx格式 
     */  
    public List<Row> readExcel_xlsx() throws IOException {  
        return readExcel_xlsx(excelPath);  
    }  
  
    /** 
     * 读取Excel 2007版，xlsx格式 
     */  
    public List<Row> readExcel_xlsx(String xlsPath) throws IOException {  
        // 判断文件是否存在  
        File file = new File(xlsPath);  
        if (!file.exists()) {  
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");  
        }  
  
        XSSFWorkbook wb = null;  
        List<Row> rowList = new ArrayList<Row>();  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            // 去读Excel  
            wb = new XSSFWorkbook(fis);  
  
            // 读取Excel 2007版，xlsx格式  
            rowList = readExcel(wb);  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return rowList;  
    }  
  
    /*** 
     * 读取Excel(97-03版，xls格式) 
     */  
    public List<Row> readExcel_xls() throws IOException {  
        return readExcel_xls(excelPath);  
    }  
  
    /*** 
     * 读取Excel(97-03版，xls格式) 
     */  
    public List<Row> readExcel_xls(String xlsPath) throws IOException {  
  
        // 判断文件是否存在  
        File file = new File(xlsPath);  
        if (!file.exists()) {  
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");  
        }  
  
        HSSFWorkbook wb = null;// 用于Workbook级的操作，创建、删除Excel  
        List<Row> rowList = new ArrayList<Row>();  
  
        try {  
            // 读取Excel  
            wb = new HSSFWorkbook(new FileInputStream(file));  
  
            // 读取Excel 97-03版，xls格式  
            rowList = readExcel(wb);  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return rowList;  
    }  
  
    /*** 
     * 读取单元格的值 
     */  
    public String getCellValue(Cell cell) {  
        Object result = "";  
        if (cell != null) {  
            switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_STRING:  
                result = cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_NUMERIC:  
                result = cell.getNumericCellValue();  
                break;  
            case Cell.CELL_TYPE_BOOLEAN:  
                result = cell.getBooleanCellValue();  
                break;  
            case Cell.CELL_TYPE_FORMULA:  
                result = cell.getCellFormula();  
                break;  
            case Cell.CELL_TYPE_ERROR:  
                result = cell.getErrorCellValue();  
                break;  
            case Cell.CELL_TYPE_BLANK:  
                break;  
            default:  
                break;  
            }  
        }  
        return result.toString();  
    }  
  
    /** 
     * 通用读取Excel 
     */  
    private List<Row> readExcel(Workbook wb) {  
        List<Row> rowList = new ArrayList<Row>();  
          
        int sheetCount = 1;//需要操作的sheet数量  
          
        Sheet sheet = null;  
        if(onlyReadOneSheet){   //只操作一个sheet  
            // 获取设定操作的sheet(如果设定了名称，按名称查，否则按索引值查)  
            sheet =selectedSheetName.equals("")? wb.getSheetAt(selectedSheetIdx):wb.getSheet(selectedSheetName);  
        }else{                          //操作多个sheet  
            sheetCount = wb.getNumberOfSheets();//获取可以操作的总数量  
        }  
          
        // 获取sheet数目  
        for(int t=startSheetIdx; t<sheetCount+endSheetIdx;t++){  
            // 获取设定操作的sheet  
            if(!onlyReadOneSheet) {  
                sheet =wb.getSheetAt(t);  
            }  
             
            //获取最后行号  
            int lastRowNum = sheet.getLastRowNum();  

            
              
            Row row = null;  
            // 循环读取  
            for (int i = startReadPos; i <= lastRowNum + endReadPos; i++) {  
                row = sheet.getRow(i);  
                if (row != null) {  
                    rowList.add(row);  
                }  
            }  
        }  
        return rowList;  
    }  
    
  

  

      
    
    public static void main(String[] args) throws IOException {
   /* 	try {  
	        ExcelUtils eu = new ExcelUtils();  
	        eu.setExcelPath("C:\\Users\\Administrator\\Desktop\\test.xls");  
	        eu = eu.RestoreSettings();//还原设定  
	        eu.setStartReadPos(2);  
	        //eu.setEndReadPos(-1);  
	        List<Row> rowList=eu.readExcel();
	        //eu.excelToList
	        String sheetName="test";
	        LinkedHashMap<String, String> fieldMap=new LinkedHashMap<String, String>();
	        fieldMap.put("服务商编号", "");
	        fieldMap.put("服务商名称", "");
	        fieldMap.put("服务商属性", "");
	        fieldMap.put("收款账户名称", "");
	        fieldMap.put("开户行", "");
	        fieldMap.put("账号", "");
	        fieldMap.put("本次待结算金额", "");
	        FinanceClearImpVo vo=new FinanceClearImpVo();
	        String[] uniqueFields=new String[]{"服务商编号","服务商名称"};
	        eu.excelToList(rowList, sheetName, vo, fieldMap, uniqueFields);
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    } */ 
    }  
    
    public HSSFWorkbook writeExcel(String sheetName,String[] columnNames,List<?> excelContent,String titleName,String[] columnNamesEN ) throws IOException{
    	HSSFWorkbook wb = getHSSFWorkbook(sheetName);
    	getMerge(columnNames, excelContent);

 	    getTitlecell(titleName);

 	    getTwoTitlecell(columnNames);
 	    getDateSoure(excelContent,columnNamesEN);
	    return wb;
    }
    
    public HSSFWorkbook getHSSFWorkbook() {
		this.wb = new HSSFWorkbook();
		this.sheet = this.wb.createSheet("sheet1");
		styles();
		return this.wb;
	}
	
	public HSSFWorkbook getHSSFWorkbook(String cellName) {
		this.wb = new HSSFWorkbook();
		this.sheet = this.wb.createSheet(cellName);
		styles();
		return this.wb;
	}

	public void styles() {
		this.titleFont = this.wb.createFont();
		this.titleFont.setColor((short) 10);
		this.titleFont.setBoldweight((short) 700);
		this.titleFont.setFontHeight((short) 300);

		this.titlestyle = this.wb.createCellStyle();
		this.titlestyle.setFont(this.titleFont);
		this.titlestyle.setAlignment((short) 2);
		this.titlestyle.setFillForegroundColor((short) 41);
		this.titlestyle.setFillPattern((short) 1);
		this.titlestyle.setWrapText(true);

		this.headerFont = this.wb.createFont();
		this.headerFont.setBoldweight((short) 700);
		this.headerFont.setColor((short) 400);
		HSSFPrintSetup printSetup = this.sheet.getPrintSetup();
		printSetup.setLandscape(true);
		this.sheet.setFitToPage(true);
		this.sheet.setHorizontallyCenter(true);
		this.sheet.setAutobreaks(true);
		this.sheet.setDefaultColumnWidth(20);
		printSetup.setFitHeight((short) 100);
		printSetup.setFitWidth((short) 180);

		this.style = this.wb.createCellStyle();
		this.style.setFont(this.headerFont);
		this.style.setBorderBottom((short) 1);
		this.style.setAlignment((short) 2);
		this.style.setFillForegroundColor((short) 41);
		this.style.setFillPattern((short) 1);
		this.style.setBorderBottom((short) 1);
		this.style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

		this.style.setBorderLeft((short) 1);
		this.style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		this.style.setBorderRight((short) 1);
		this.style.setRightBorderColor(IndexedColors.BLACK.getIndex());

		this.style.setBorderTop((short) 1);
		this.style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		this.style.setHidden(true);

		this.style2 = this.wb.createCellStyle();
		this.style2.setAlignment((short) 2);
		this.style2.setDataFormat(this.wb.createDataFormat().getFormat("0.00%"));
		this.style2.setVerticalAlignment((short) 1);
		this.style2.setBorderBottom((short) 1);
		this.style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());

		this.style2.setBorderLeft((short) 1);
		this.style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());

		this.style2.setBorderRight((short) 1);
		this.style2.setRightBorderColor(IndexedColors.BLACK.getIndex());

		this.style2.setBorderTop((short) 1);
		this.style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
		this.style2.setHidden(true);
	}

	public void getMerge(String[] columnNames, List<?> excelContent) {
		this.sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNames.length - 1));

		//this.sheet.addMergedRegion(new CellRangeAddress(excelContent.size() + 1, excelContent.size() + 1, 0, 1));
	}

	public void getTitlecell(String titleName) {
		HSSFRow titleRow = null;
		HSSFCell titlecell = null;
		if (!(titleName.equals(""))) {
			titleRow = this.sheet.createRow(0);
			titleRow.setHeightInPoints(30.120001F);
			titlecell = titleRow.createCell(0);
			titlecell.setCellStyle(this.titlestyle);
			titlecell.setCellValue(titleName);
		}
	}

	@SuppressWarnings("deprecation")
	public void getTwoTitlecell(String[] columnNames) {
		HSSFRow headRow = this.sheet.createRow(1);
		headRow.setHeightInPoints(20.120001F);

		for (int i = 0; i < columnNames.length; ++i) {
			HSSFCell cell = headRow.createCell((short) i);
			cell.setCellStyle(this.style);
			cell.setCellValue(columnNames[i]);
		}
	}

	@SuppressWarnings("all")
	public void getDateSoure(List<?> excelContent) {
		for (int i = 0; i < excelContent.size(); ++i) {
			Object log = excelContent.get(i);
			Class clazz = log.getClass();
			Field[] fields = clazz.getDeclaredFields();

			HSSFRow row = this.sheet.createRow((short) i + 2);
			//this.sheet.autoSizeColumn(i);
			for (int j = 0; j < fields.length; ++j) {
				HSSFCell cell = row.createCell((short) j);
				cell.setCellStyle(this.style2);
				try {
					Object resultObject = invokeMethod(log, fields[j].getName(), null);
					cell.setCellValue((String) resultObject);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			for(int j = 0; j < fields.length; ++j){
				this.sheet.autoSizeColumn(j);
			}
		}
	}
	
	@SuppressWarnings("all")
	public void getDateSoure(List<?> excelContent,String[] col) {
		for (int i = 0; i < excelContent.size(); ++i) {
			Object log = excelContent.get(i);
			Class clazz = log.getClass();
			Field[] fields = clazz.getDeclaredFields();

			HSSFRow row = this.sheet.createRow((short) i + 2);
			for (int j = 0; j < col.length; ++j) {
				HSSFCell cell = row.createCell((short) j);
				cell.setCellStyle(this.style2);
				try {
					Object resultObject = invokeMethod(log, col[j], null);
					cell.setCellValue((String) resultObject);
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("all")
	public Object invokeMethod(Object owner, String fieldname, Object[] args) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class ownerClass = owner.getClass();

		Method method = null;
		method = ownerClass.getMethod(toGetter(fieldname), new Class[0]);

		Object object = null;
		object = method.invoke(owner, new Object[0]);

		return object;
	}

	public String toGetter(String fieldname) {
		if ((fieldname == null) || (fieldname.length() == 0)) {
			return null;
		}

		if (fieldname.length() > 2) {
			String second = fieldname.substring(1, 2);
			if (second.equals(second.toUpperCase())) {
				return "get" + fieldname;
			}
		}

		fieldname = "get" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
		return fieldname;
	}
    public String getExcelPath() {  
        return this.excelPath;  
    }  
  
    public void setExcelPath(String excelPath) {  
        this.excelPath = excelPath;  
    }  
  
    public boolean isNeedCompare() {  
        return isNeedCompare;  
    }  
  
    public void setNeedCompare(boolean isNeedCompare) {  
        this.isNeedCompare = isNeedCompare;  
    }  
  
    public int getComparePos() {  
        return comparePos;  
    }  
  
    public void setComparePos(int comparePos) {  
        this.comparePos = comparePos;  
    }  
  
    public int getStartReadPos() {  
        return startReadPos;  
    }  
  
    public void setStartReadPos(int startReadPos) {  
        this.startReadPos = startReadPos;  
    }  
  
    public int getEndReadPos() {  
        return endReadPos;  
    }  
  
    public void setEndReadPos(int endReadPos) {  
        this.endReadPos = endReadPos;  
    }  
  
    public boolean isOverWrite() {  
        return isOverWrite;  
    }  
  
    public void setOverWrite(boolean isOverWrite) {  
        this.isOverWrite = isOverWrite;  
    }  
  
    public boolean isOnlyReadOneSheet() {  
        return onlyReadOneSheet;  
    }  
  
    public void setOnlyReadOneSheet(boolean onlyReadOneSheet) {  
        this.onlyReadOneSheet = onlyReadOneSheet;  
    }  
  
    public int getSelectedSheetIdx() {  
        return selectedSheetIdx;  
    }  
  
    public void setSelectedSheetIdx(int selectedSheetIdx) {  
        this.selectedSheetIdx = selectedSheetIdx;  
    }  
  
    public String getSelectedSheetName() {  
        return selectedSheetName;  
    }  
  
    public void setSelectedSheetName(String selectedSheetName) {  
        this.selectedSheetName = selectedSheetName;  
    }  
  
    public int getStartSheetIdx() {  
        return startSheetIdx;  
    }  
  
    public void setStartSheetIdx(int startSheetIdx) {  
        this.startSheetIdx = startSheetIdx;  
    }  
  
    public int getEndSheetIdx() {  
        return endSheetIdx;  
    }  
  
    public void setEndSheetIdx(int endSheetIdx) {  
        this.endSheetIdx = endSheetIdx;  
    }  
  
    public boolean isPrintMsg() {  
        return printMsg;  
    }  
  
    public void setPrintMsg(boolean printMsg) {  
        this.printMsg = printMsg;  
    }

	
    
}
