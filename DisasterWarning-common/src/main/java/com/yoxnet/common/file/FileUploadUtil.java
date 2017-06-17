package com.yoxnet.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;


/**
 * 文件上传验证
 * @author jungang.qu
 *
 */
public class FileUploadUtil {
	/*//允许上传的文件名  例如图片
	public static final List<String> ALLOW_TYPES = Arrays.asList(
            "image/jpg","image/jpeg","image/png","image/gif",
    "image/jpg","image/jpeg","image/png","image/gif"
    );
	//文件重命名
	public static String rename(String fileName){
		int i = fileName.lastIndexOf(".");
		String str = fileName.substring(i);
		return new Date().getTime()+""+ new Random().nextInt(99999999) +str;
	}
	//校验文件类型是否是被允许的
	public static boolean allowUpload(String postfix){
		
		return ALLOW_TYPES.contains(postfix);
	}*/
	//上传文件保存路径
    public static String path = "/upload/";
    //定义可以上传文件的后缀数组,默认"*"，代表所有
    public static String[] filePostfixs = { "*" };
    public static String[] typeImages = { "gif", "jpeg", "png", "jpg", "tif", "bmp" };
    public static String[] typeOthers = { "html", "htm", "doc", "xls", "txt", "zip", "rar", "pdf", "cll" };
    
    //上传文件的最大长度
    public static long maxFileSize = 1024 * 1024 * 1024 * 2L;//2G
    //一次读取多少字节
    public static int bufferSize = 1024 * 8;
    
    private final static void init() {
        if (bufferSize > Integer.MAX_VALUE) {
            bufferSize = 1024 * 8;
        } else if (bufferSize < 8) {
            bufferSize = 8;
        }
        if (maxFileSize < 1) {
            maxFileSize = 1024 * 1024 * 1024 * 2L;
        } else if (maxFileSize > Long.MAX_VALUE) {
            maxFileSize = 1024 * 1024 * 1024 * 2L;
        }
    }
    
    /**
     * <b>function:</b>通过输入流参数上传文件
     * @param uploadFileName 文件名称
     * @param savePath 保存路径
     * @param InputStream 上传的文件的输入流
     * @return 是否上传成功
     * @throws Exception
     */
    public static UploadState upload4Stream(String fileName, String path, InputStream is) throws Exception {
        init();
        UploadState state = UploadState.UPLOAD_FAILURE;
        FileOutputStream fos = null;
       
        try {
            path = getDoPath(path);
            mkDir(path);
            fos = new FileOutputStream(path + fileName);   
              
            byte[] buffer = new byte[bufferSize];   
            int len = 0;   
            while ((len = is.read(buffer)) > 0) {   
                fos.write(buffer, 0, len);   
            }
            state = UploadState.UPLOAD_SUCCSSS;
        } catch (FileNotFoundException e) {   
            state = UploadState.UPLOAD_NOTFOUND;
               throw e;
        } catch (IOException e) {   
            state = UploadState.UPLOAD_FAILURE;
            throw e; 
        } finally {
            if (is != null) {
                is.close();
            }
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }
        return state;   
    }   
    
    /**
     * <b>function:</b>上传文件
     * @param uploadFileName 文件名称
     * @param savePath 保存路径
     * @param uploadFile 上传的文件
     * @return 是否上传成功
     * @throws Exception
     */
    public static UploadState upload4Stream(String fileName, String path, File file) throws Exception {
        init();
        UploadState state = UploadState.UPLOAD_FAILURE;
        FileInputStream fis = null;
        try {
            long size = file.length();
            if (size <= 0) {
                state = UploadState.UPLOAD_ZEROSIZE;
            } else {
                if (size <= maxFileSize) {
                    fis = new FileInputStream(file); 
                    state = upload4Stream(fileName, path, fis);
                } else {
                    state = UploadState.UPLOAD_OVERSIZE;
                }
            }
        } catch (FileNotFoundException e) {   
            state = UploadState.UPLOAD_NOTFOUND;
               throw e;
        } catch (IOException e) {   
            state = UploadState.UPLOAD_FAILURE;
            throw e; 
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return state;   
    }   
    
    /**
     * <b>function:</b>通过数组进行验证文件类型上传
     * @param fileName 文件名称
     * @param path 文件路径
     * @param file 文件
     * @param allowTypes 文件后缀、类型数组
     * @return 返回是否上传成功
     * @throws Exception
     */
    public static UploadState upload4Stream(String fileName, String path, File file, String[] allowTypes) throws Exception {
        UploadState state = UploadState.UPLOAD_FAILURE;
        if (validTypeByName(fileName, allowTypes)) {
            state = upload4Stream(fileName, path, file);
        } else {
            state = UploadState.UPLOAD_TYPE_ERROR;
        }
        return state; 
    }
    
    /**
     * <b>function:</b>通过数组进行验证文件类型上传
     * @param fileName 文件名称
     * @param path 文件路径
     * @param InputStream 文件输入流
     * @param allowTypes 文件后缀、类型数组
     * @return 返回是否上传成功
     * @throws Exception
     */
    public static UploadState upload4Stream(String fileName, String path, InputStream fs, String[] allowTypes) throws Exception {
        UploadState state = UploadState.UPLOAD_FAILURE;
        if (validTypeByName(fileName, allowTypes)) {
            state = upload4Stream(fileName, path, fs);
        } else {
            state = UploadState.UPLOAD_TYPE_ERROR;
        }
        return state; 
    }
    
    /**
     * <b>function:</b> 利用FileUtils上传文件；其中maxFileSize是限制上传文件的大小
     * @param fileName 文件名称
     * @param path 保存路径
     * @param file 文件
     * @return 是否上传成功
     * @throws Exception
     */
    public static boolean upload4CopyFile(String fileName, String path, File file) throws Exception {
        init();
        boolean success = false;
        if (file.length() <= maxFileSize) {
            path = getDoPath(path);
            mkDir(path);
            File destFile = new File(path, fileName);
			FileUtils.copyFile(file, destFile);
            success = true;
        } 
        return success;   
    }  
    
    /**
     * <b>function:</b>上传指定文件类型的文件
     * @param fileName 文件名
     * @param path 路径
     * @param file 文件
     * @param allowTypes 类型、后缀数组
     * @return 成功上传的文件名
     * @throws Exception
     */
    public static boolean upload4CopyFile(String fileName, String path, File file, String[] allowTypes) throws Exception {   
        boolean success = false;
        if (validTypeByName(fileName, allowTypes)) {
            success = upload4CopyFile(fileName, path, file);
        }
        return success;   
    }
    
    /**
     * <b>function:</b> 根据文件名和类型数组验证文件类型是否合法，flag是否忽略大小写
     * @param fileName 文件名
     * @param allowTypes 类型数组
     * @param flag 是否获得大小写
     * @return 是否验证通过
     */
    public static boolean validTypeByName(String fileName, String[] allowTypes, boolean flag) {
        String suffix = getType(fileName);
        boolean valid = false;
        if (allowTypes.length > 0 && "*".equals(allowTypes[0])) {
            valid = true;
        } else {
            for (String type : allowTypes) {
                if (flag) {//不区分大小写后缀
                    if (suffix != null && suffix.equalsIgnoreCase(type)) {
                        valid = true;
                        break;
                    }
                } else {//严格区分大小写
                    if (suffix != null && suffix.equals(type)) {
                        valid = true;
                        break;
                    }
                }
            }
        }
        return valid;
    }
    
    /**
     * <b>function:</b>根据文件名称和类型数组验证文件类型是否合法
     * @param fileName 文件名
     * @param allowTypes 文件类型数组
     * @return 是否合法
     */
    public static boolean validTypeByName(String fileName, String[] allowTypes) {
        return validTypeByName(fileName, allowTypes, true);
    }
    
    /**
     * <b>function:</b> 根据后缀和类型数组验证文件类型是否合法，flag是否区分后缀大小写，true严格大小写
     * @param suffix 后缀名
     * @param allowTypes 文件类型数组
     * @param flag 是否区分大小写
     * @return 是否合法
     */
    public static boolean validTypeByPostfix(String suffix, String[] allowTypes, boolean flag) {
        boolean valid = false;
        if (allowTypes.length > 0 && "*".equals(allowTypes[0])) {
            valid = true;
        } else {
            for (String type : allowTypes) {
                if (flag) {//不区分大小写后缀
                    if (suffix != null && suffix.equalsIgnoreCase(type)) {
                        valid = true;
                        break;
                    }
                } else {//严格区分大小写
                    if (suffix != null && suffix.equals(type)) {
                        valid = true;
                        break;
                    }
                }
            }
        }
        return valid;
    }
    /**
     * <b>function:</b>和文件后缀一样，不同的是没有“.”
     * @author hoojo
     * @createDate Oct 10, 2010 2:42:43 PM
     * @param fileName 文件名称
     * @return
     */
    public static String getType(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index != -1) {
            String suffix = fileName.substring(index + 1);//后缀
            return suffix; 
        } else {
            return null;
        }
   }
    /**
     * <b>function:</b>根据文件后缀名和类型数组，验证文件类型是否合法
     * @param suffix 后缀名
     * @param allowTypes 类型数组
     * @return 是否合法
     */
    public static boolean validTypeByPostfix(String suffix, String[] allowTypes) {
        return validTypeByPostfix(suffix, allowTypes, true);
    }
    
    /**
     * <b>function:</b>验证当前后缀、文件类型是否是图片类型
     * typeImages 可以设置图片类型
     * @param suffix 验证文件的后缀
     * @return 是否合法
     */
    public static boolean validTypeByPostfix4Images(String suffix) {
        return validTypeByPostfix(suffix, typeImages);
    }
    
    /**
     * <b>function:</b>验证当前后缀、文件类型是否是非图片类型（常用办公文件类型）
     * typeOthers 可以设置文件类型
     * @param suffix 验证文件的后缀
     * @return 是否合法
     */
    public static boolean validTypeByPostfix4Others(String suffix) {
        return validTypeByPostfix(suffix, typeOthers);
    }
    
    /**
     * <b>function:</b>验证当前文件名、文件类型是否是图片类型
     * typeImages 可以设置图片类型
     * @param fileName 验证文件的名称
     * @return 是否合法
     */
    public static boolean validTypeByName4Images(String fileName) {
        return validTypeByName(fileName, typeImages);
    }
    
    /**
     * <b>function:</b>验证当前文件名称、文件类型是否是非图片类型（常用办公文件类型）
     * typeOthers 可以设置文件类型
     * @param fileName 验证文件的名称
     * @return 是否合法
     */
    public static boolean validTypeByName4Others(String fileName) {
        return validTypeByName(fileName, typeOthers);
    }
    
    /**
     * <b>function:</b>传递一个路径和文件名称，删除该文件
     * @param fileName 文件名称
     * @param path 路径
     * @return 是否删除成功
     */
    public static boolean removeFile(String fileName, String path) {
        boolean flag = false;
        if (isFileExist(fileName, path)) {
            File file = new File(getDoPath(path) + fileName);
            flag = file.delete();
        }
        return flag;
    }
    
    /**
     * <b>function:</b>删除当前文件
     * @param file 要删除的文件
     * @return 是否删除成功
     */
    public static boolean removeFile(File file) {
        boolean flag = false;
        if (file != null && file.exists()) {
            flag = file.delete();
        }
        return flag;
    }
    
    /**
     * <b>function:</b>删除某个文件
     * @param path 传递该文件路径
     * @return 删除是否成功
     */
    public static boolean removeFile(String path) {
        return removeFile(new File(path));
    }
    /**
     * <b>function:</b> 传入一个文件名，得到这个文件名称的后缀
     * @param fileName 文件名
     * @return 后缀名
     */
    public static String getSuffix(String fileName) {
         int index = fileName.lastIndexOf(".");
         if (index != -1) {
             String suffix = fileName.substring(index);//后缀
             return suffix; 
         } else {
             return null;
         }
    }
    
    /**
     * <b>function:</b> 传递一个文件名称和一个新名称，组合成一个新的带后缀文件名
     * 当传递的文件名没有后缀，会添加默认的后缀
     * @param fileName 文件名称
     * @param newName 新文件名称
     * @param nullSuffix 为没有后缀的文件所添加的后缀;eg:txt
     * @return String 文件名称
     */
    public static String getNewFileName(String fileName, String newName, String nullSuffix) {
        String suffix = getSuffix(fileName);
        if (suffix != null) {
            newName += suffix; 
        } else {
            newName = newName.concat(".").concat(nullSuffix);
        }
        return newName;   
    } 
    
    /**
     * <b>function:</b> 利用uuid产生一个随机的name
     * @param fileName 带后缀的文件名称
     * @return String 随机生成的name
     */
    public static String getRandomName(String fileName) {
        String randomName = UUID.randomUUID().toString();
        return getNewFileName(fileName, randomName, "txt");
    } 
    
    
    /**
     * <b>function:</b>判断该文件是否存在
     * @param fileName 文件名称
     * @param path 目录
     * @return 是否存在
     */
    public static boolean isFileExist(String fileName, String path) {
        File file = new File(getDoPath(path) + fileName);
        return file.exists();
    }
    
    /**
     * <b>function:</b>处理后的系统文件路径
     * @param path 文件路径
     * @return 返回处理后的路径
     */
    public static String getDoPath(String path) {
        path = path.replace("\\", "/");
        String lastChar = path.substring(path.length() - 1);
        if (!"/".equals(lastChar)) {
            path += "/";
        }
        return path;
    }
    
    /**
     * <b>function:</b> 创建指定的path路径目录
     * @param path 目录、路径
     * @return 是否创建成功
     * @throws Exception
     */
    public static boolean mkDir(String path) throws Exception {   
        File file = null;   
        try {   
            file = new File(path);   
            if (!file.exists()) {   
                return file.mkdirs();   
            }   
        } catch (RuntimeException e) {   
            throw e;
        } finally {   
            file = null;   
        }   
        return false;   
    }   
    
}