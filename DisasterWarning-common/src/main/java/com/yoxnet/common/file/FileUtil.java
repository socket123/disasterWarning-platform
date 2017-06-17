package com.yoxnet.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 此类中封装一些常用的文件操作。
 * 
 */

public class FileUtil {

	/**
	 * 文件路径映射关系配置
	 */
	private static final String FNAME_PROPERITY = "storagefilepath";
	
	/**
	 * 文件存储路径映射
	 */
	private static Map<String, String> storageFilePath = null;
	
	
	
  private FileUtil() {

  }
  
  /**
   * 判断指定的文件是否存在。
   * @param fileName 要判断的文件的文件名
   * @return 存在时返回true，否则返回false。
   */
  public static boolean isFileExist(String fileName) {
    return new File(fileName).isFile();
  }

  /**
   * 创建指定的目录。
   * 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
   * <b>注意：可能会在返回false的时候创建部分父目录。</b>
   * @param file 要创建的目录
   * @return 完全创建成功时返回true，否则返回false。
   */
  public static boolean makeDirectory(File file) {
    File parent = file.getParentFile();
    if (parent != null) {
      return parent.mkdirs();
    }
    return false;
  }

  /**
   * 创建指定的目录。
   * 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。
   * @param fileName 要创建的目录的目录名
   * @return 完全创建成功时返回true，否则返回false。
   */
  public static boolean makeDirectory(String fileName) {
    File file = new File(fileName);
    return makeDirectory(file);
  }

  /**
   * 清空指定目录中的文件。
   * @param directory 要清空的目录
   * @return 目录下的所有文件都被成功删除时返回true，否则返回false.
   */
  public static boolean emptyDirectory(File directory) {
    boolean result = true;
    File[] entries = directory.listFiles();
    for (int i = 0; i < entries.length; i++) {
      if (!entries[i].delete()) {
        result = false;
      }
    }
    return result;
  }

  /**
   * 清空指定目录中的文件。
   * @param directoryName 要清空的目录的目录名
   * @return 目录下的所有文件都被成功删除时返回true，否则返回false。
   */
  public static boolean emptyDirectory(String directoryName) {
    File dir = new File(directoryName);
    return emptyDirectory(dir);
  }

  /**
   * 删除指定目录及其中的所有内容。
   * @param dirName 要删除的目录的目录名
   * @return 删除成功时返回true，否则返回false。
   */
  public static boolean deleteDirectory(String dirName) {
    return deleteDirectory(new File(dirName));
  }

  /**
   * 删除指定目录及其中的所有内容。
   * @param dir 要删除的目录
   * @return 删除成功时返回true，否则返回false。
   */
  public static boolean deleteDirectory(File dir) {
    if ( (dir == null) || !dir.isDirectory()) {
      throw new IllegalArgumentException("Argument " + dir +
                                         " is not a directory. ");
    }

    File[] entries = dir.listFiles();
    int sz = entries.length;

    for (int i = 0; i < sz; i++) {
      if (entries[i].isDirectory()) {
        if (!deleteDirectory(entries[i])) {
          return false;
        }
      }
      else {
        if (!entries[i].delete()) {
          return false;
        }
      }
    }

    if (!dir.delete()) {
      return false;
    }
    return true;
  }

  /**
   * 返回文件的URL地址。
   * @param file 文件
   * @return 文件对应的的URL地址
   * @throws MalformedURLException
   * @deprecated 在实现的时候没有注意到File类本身带一个toURL方法将文件路径转换为URL。
   *             请使用File.toURL方法。
   */
  public static URL getURL(File file) throws MalformedURLException {
    String fileURL = "file:/" + file.getAbsolutePath();
    URL url = new URL(fileURL);
    return url;
  }

  /**
   * 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。
   * @param filePath 转换前的路径
   * @return 转换后的路径
   */
  public static String toUNIXpath(String filePath) {
    return filePath.replace('\\', '/');
  }

  /**
   * 得到文件的类型。
   * @param fileName 文件名
   * @return 文件名中的类型部分
   */
  public static String getTypePart(String fileName) {
    int point = fileName.lastIndexOf('.');
    int length = fileName.length();
    if (point == -1 || point == length - 1) {
      return "";
    }
    else {
      return fileName.substring(point + 1, length);
    }
  }

  /**
   * 得到文件的类型。
   * @param file 文件
   * @return 文件名中的类型部分
   */
  public static String getFileType(File file) {
    return getTypePart(file.getName());
  }


  /**
   * 得到相对路径。
   * 文件名不是目录名的子节点时返回文件名。
   * @param pathName 目录名
   * @param fileName 文件名
   * @return 得到文件名相对于目录名的相对路径，目录下不存在该文件时返回文件名
   */
  public static String getSubpath(String pathName,String fileName) {
    int index = fileName.indexOf(pathName);
    if (index != -1) {
      return fileName.substring(index + pathName.length() + 1);
    }
    else {
      return fileName;
    }
  }

  /**
   * 检查给定目录的存在性
   * 保证指定的路径可用，如果指定的路径不存在，那么建立该路径，可以为多级路径
   * @param path
   * @return 真假值
   * @since  1.0
   */
   public static final boolean pathValidate(String path)
   {
     //String path="d:/web/www/sub";
     //System.out.println(path);
     //path = getUNIXfilePath(path);

     //path = ereg_replace("^\\/+", "", path);
     //path = ereg_replace("\\/+$", "", path);
     String[] arraypath = path.split("/");
     String tmppath = "";
     for (int i = 0; i < arraypath.length; i++)
     {
       tmppath += "/" + arraypath[i];
       File d = new File(tmppath.substring(1));
       if (!d.exists()) { //检查Sub目录是否存在
           System.out.println(tmppath.substring(1));
         if (!d.mkdir())
         {
           return false;
         }
       }
     }
     return true;
   }

   //拷贝文件
   public static final boolean CopyFile(File in, File out) throws Exception {
       try {
           FileInputStream fis = new FileInputStream(in);
           FileOutputStream fos = new FileOutputStream(out);
           byte[] buf = new byte[1024];
           int i = 0;
           while ((i = fis.read(buf)) != -1) {
               fos.write(buf, 0, i);
           }
           fis.close();
           fos.close();
           return true;
       } catch (IOException ie) {
           ie.printStackTrace();
           return false;
       }
   }
   //拷贝文件
   public static final boolean CopyFile(String infile, String outfile) throws Exception {
       try {
           File in = new File(infile);
           File out = new File(outfile);
           return CopyFile(in, out);
       } catch (IOException ie) {
           ie.printStackTrace();
           return false;
       }
   }
   
   /**
	 * getFileStorageMapping:<br/>
	 * 读取文件类型和文件存储路径映射配置<br/>
	 * 获取文件保存路径映射<br/>
	 *
	 * @author yi
	 * @return
	 */
   public static Map<String, String> getFileStorageMapping(){
	   
	   if(storageFilePath != null){
		   return storageFilePath;
	   }
	   
	   //初始化文件类型和存储路径映射关系
	   storageFilePath = new HashMap<String, String>();
	   
	   //读取配置文件，获取所有映射关系
	   ResourceBundle configReader = ResourceBundle.getBundle(FNAME_PROPERITY);
	   
	   Set<String> keys = configReader.keySet();
	   
	   if(keys != null){
		   for(String key : keys){
			   if(configReader.containsKey(key)){
				   String value =  configReader.getString(key);
				   storageFilePath.put(key, value);
			   }
		   }
	   }
	   
	   return storageFilePath;
   }
   
   
   /**
	 * getFileStoragePath:<br/>
	 * 获取当前文件类型的保存路径 <br/>
	 * 没有获取到的场合，返回默认保存路径<br/>
	 *
	 * @author yi
	 * @param fileType
	 * @return
	 */
   
   public static void main(String[] args) {
	   
	   System.out.println(getFileStorageMapping());
	   
	   
   }
   
}
