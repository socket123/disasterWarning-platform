package com.yoxnet.common.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;  
/**
 */
public class ExcelExtUtils extends ExcelUtils{
	
	
	public HSSFWorkbook writeExcel(String sheetName,String[][] columnNames,List<?> excelContent,String titleName,String[] columnNamesEN,int rowIndex,int cellIndex,int coulum) throws IOException{
    	HSSFWorkbook wb = getHSSFWorkbook(sheetName);
    	getMerge(columnNames[0], cellIndex);

 	    getTitlecell(titleName);

 	    getTwoTitlecell(columnNames,rowIndex,cellIndex,coulum);
 	    getDateSoure(excelContent,columnNamesEN);
	    return wb;
    }
	/**
	 * 合并单元格Excel导出
	 * @param columnNames
	 * @param rowIndex
	 * @param cellIndex
	 * @param coulum
	 */
	@SuppressWarnings("deprecation")
	public void getTwoTitlecell(String[][] columnNames,int rowIndex,int cellIndex,int coulum) {
		for (int i = 0; i < columnNames.length; ++i) {
			HSSFRow headRow = this.sheet.createRow(i + 1);
			headRow.setHeightInPoints(20.120001F);
			String[] columnName = columnNames[0];
			if (rowIndex == i) {
				for (int j = 0, k = 0; j < columnName.length; ++j, ++k) {
					if (cellIndex < j) {
						getMerge(i + 1, k, coulum);
						HSSFCell cell = headRow.createCell((short) k);
						cell.setCellStyle(this.style);
						cell.setCellValue(columnName[j]);
						k++;
					} else {
						getMerge(i + 1, j, 0);
						HSSFCell cell = headRow.createCell((short) k);
						cell.setCellStyle(this.style);
						cell.setCellValue(columnName[j]);
					}

				}
			} else {
				for (int j = 0, k = 0; j < columnName.length; ++j, ++k) {
					if (j < cellIndex + 1) {
						HSSFCell cell = headRow.createCell((short) j);
						getMerge(i, j, 0);
						cell.setCellStyle(this.style);
						cell.setCellValue("");
					} else {
						HSSFCell cell = headRow.createCell((short) k);
						getMerge(i + 1, k, 0);
						cell.setCellStyle(this.style);
						cell.setCellValue(columnNames[1][0]);
						cell = headRow.createCell((short) k + 1);
						getMerge(i + 1, k + 1, 0);
						cell.setCellStyle(this.style);
						cell.setCellValue((columnNames[1][1]));
						k = k + 1;
					}

				}

			}}

		}
	public void getMerge(String[] columnNames, int cellIndex) {
		int edge=cellIndex+2*(columnNames.length-1-cellIndex);
		this.sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, edge));
		//this.sheet.addMergedRegion(new CellRangeAddress(excelContent.size() + 1, excelContent.size() + 1, 0, 1));
	}
	/**
	 * 标题合并单元 格列
	 * @param columnNames
	 * @param i
	 * @param j
	 * @param coulum
	 */
	public void getMerge(int i,int j,int coulum) {
		this.sheet.addMergedRegion(new CellRangeAddress(i, i, j, j+coulum));
	}
	@SuppressWarnings("all")
	public void getDateSoure(List<?> excelContent,String[] col) {
		for (int i = 0; i < excelContent.size(); ++i) {
			Object log = excelContent.get(i);
			Class clazz = log.getClass();
			Field[] fields = clazz.getDeclaredFields();

			HSSFRow row = this.sheet.createRow((short) i + 3);
			for (int j = 0; j < fields.length; ++j) {
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
	/**
     * excelToList
     * @param rowList
     * @param sheetName
     * @param entityClass
     * @param fieldMap
     * @param uniqueFields
     * @return
     * @throws Exception
     */
	public <T> List<T> excelToList(List<Row> rowList,Class<T> entityClass,
			LinkedHashMap<String, String> fieldMap, String[] uniqueFields) throws Exception {
		// 定义要返回的list
		List<T> resultList = new ArrayList<T>();
		Row first = null;
		try {
			// 获取工作表的有效行数
			int realRows = 0;
			int coulums = fieldMap.size();
			if (null != rowList && rowList.size() > 0) {
				first = rowList.get(0);
				for (int i = 0; i < rowList.size(); i++) {
					int nullCols = 0;
					for (int j = 0; j < coulums; j++) {
						Cell currentCell = rowList.get(i).getCell(j);
						if (currentCell == null || "".equals(currentCell.getStringCellValue().trim())) {
							nullCols++;
						}
					}
					if (nullCols == coulums) {
						rowList.remove(i);
						break;
					} else {
						realRows++;
					}
				}
			}

			// 如果Excel中没有数据则提示错误
			if (realRows <= 1) {
				throw new ExcelException("Excel文件中没有任何数据");
			}

			Cell[] firstRow = getCells(first);

			String[] excelFieldNames = new String[firstRow.length];

			// 获取Excel中的列名
			for (int i = 0; i < firstRow.length; i++) {
				excelFieldNames[i] = firstRow[i].getStringCellValue().trim();
			}

			// 判断需要的字段在Excel中是否都存在
			boolean isExist = true;
			List<String> excelFieldList = Arrays.asList(excelFieldNames);
			for (String cnName : fieldMap.keySet()) {
				if (!excelFieldList.contains(cnName)) {
					isExist = false;
					break;
				}
			}

			// 如果有列名不存在，则抛出异常，提示错误
			if (!isExist) {
				throw new ExcelException("Excel中缺少必要的字段，或字段名称有误");
			}

			// 将列名和列号放入Map中,这样通过列名就可以拿到列号
			LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
			for (int i = 0; i < excelFieldNames.length; i++) {
				colMap.put(excelFieldNames[i], firstRow[i].getColumnIndex());
			}

			// 判断是否有重复行
			// 1.获取uniqueFields指定的列
			/*
			 * Cell[][] uniqueCells = new Cell[uniqueFields.length][]; for (int
			 * i = 0; i < uniqueFields.length; i++) { int col =
			 * colMap.get(uniqueFields[i]); uniqueCells[i] =
			 * sheet.getColumn(col); }
			 */

			// 2.从指定列中寻找重复行
			/*
			 * for (int i = 1; i < realRows; i++) { int nullCols = 0; for (int j
			 * = 0; j < uniqueFields.length; j++) { String currentContent =
			 * uniqueCells[j][i].getContents(); Cell sameCell =
			 * sheet.findCell(currentContent, uniqueCells[j][i].getColumn(),
			 * uniqueCells[j][i].getRow() + 1, uniqueCells[j][i].getColumn(),
			 * uniqueCells[j][realRows - 1].getRow(), true); if (sameCell !=
			 * null) { nullCols++; } } if (nullCols == uniqueFields.length) {
			 * throw new ExcelException("Excel中有重复行，请检查"); } }
			 */
			// 将sheet转换为list
			for (int i = 1; i < realRows; i++) {
				// 新建要转换的对象
				T entity = entityClass.newInstance();

				// 给对象中的字段赋值
				for (Entry<String, String> entry : fieldMap.entrySet()) {
					// 获取中文字段名
					String cnNormalName = entry.getKey();
					// 获取英文字段名
					String enNormalName = entry.getValue();
					// 根据中文字段名获取列号
					int col = colMap.get(cnNormalName);

					// 获取当前单元格中的内容
					String content = rowList.get(i).getCell(col).getStringCellValue().trim();
					// 给对象赋值
					setFieldValueByName(enNormalName, content, entity);
				}

				resultList.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 如果是ExcelException，则直接抛出
			if (e instanceof ExcelException) {
				throw (ExcelException) e;

				// 否则将其它异常包装成ExcelException再抛出
			} else {
				e.printStackTrace();
				throw new ExcelException("导入Excel失败");
			}
		}
		return resultList;
	}
		
	/**
	 * @MethodName : setFieldValueByName
	 * @Description : 根据字段名给对象的字段赋值
	 * @param fieldName
	 *            字段名
	 * @param fieldValue
	 *            字段值
	 * @param o
	 *            对象
	 * @author  陈高阳
	 */
	private static void setFieldValueByName(String fieldName, Object fieldValue, Object o) throws Exception {

		Field field = getFieldByName(fieldName, o.getClass());
		if (field != null) {
			field.setAccessible(true);
			// 获取字段类型
			Class<?> fieldType = field.getType();
			// 根据字段类型给字段赋值
			if (String.class == fieldType) {
				field.set(o, String.valueOf(fieldValue));
			} else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
				field.set(o, Integer.parseInt(fieldValue.toString()));
			} else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
				field.set(o, Long.valueOf(fieldValue.toString()));
			} else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
				field.set(o, Float.valueOf(fieldValue.toString()));
			} else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
				field.set(o, Short.valueOf(fieldValue.toString()));
			} else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
				field.set(o, Double.valueOf(fieldValue.toString()));
			} else if (Character.TYPE == fieldType) {
				if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
					field.set(o, Character.valueOf(fieldValue.toString().charAt(0)));
				}
			} else if (Date.class == fieldType) {
				field.set(o, DateFormatUtil.getFormatDate(fieldValue.toString(),"yyyy-MM-dd HH:mm:ss"));
			}else if (BigDecimal.class == fieldType) {
				if (null == fieldValue || "".equals(fieldValue.toString())) {
					fieldValue = "0";
				}
				field.set(o, BigDecimal.valueOf(Double.parseDouble(fieldValue.toString())));
			}  else {
				field.set(o, fieldValue);
			}
		} else {
			throw new ExcelException(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
		}
	}
	
	  /** 
     * @MethodName  : getFieldByName 
     * @Description : 根据字段名获取字段 
     * @param fieldName 字段名 
     * @param clazz 包含该字段的类 
     * @return 字段 
     * @author 陈高阳
     */  
    private static Field getFieldByName(String fieldName, Class<?>  clazz){  
        //拿到本类的所有字段  
        Field[] selfFields=clazz.getDeclaredFields();  
          
        //如果本类中存在该字段，则返回  
        for(Field field : selfFields){  
            if(field.getName().equals(fieldName)){  
                return field;  
            }  
        }  
          
        //否则，查看父类中是否存在此字段，如果有则返回  
        Class<?> superClazz=clazz.getSuperclass();  
        if(superClazz!=null  &&  superClazz !=Object.class){  
            return getFieldByName(fieldName, superClazz);  
        }  
        //如果本类和父类都没有，则返回空  
        return null;  
    }  
    /**
     * 获取第一行的列数
     * @param row
     * @return Cell[]
     * 陈高阳
     */
	private static Cell[] getCells(Row firstRow) {
		Cell[] cells = null;
		if (null != firstRow) {
			int lastCell = firstRow.getLastCellNum();
			cells = new Cell[lastCell];
			for (int i = 0; i < lastCell; i++) {
				cells[i] = firstRow.getCell(i);
			}
		}
		return cells;
	}
	public ExcelExtUtils(String excelPath) {
		super(excelPath);
		// TODO Auto-generated constructor stub
	}
	public ExcelExtUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
