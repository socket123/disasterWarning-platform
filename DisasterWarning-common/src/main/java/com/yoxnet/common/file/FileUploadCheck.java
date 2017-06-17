package com.yoxnet.common.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA. User: beyond Date: 13-4-13 Time: 下午6:32 To change
 * this template use File | Settings | File Templates.
 */
public class FileUploadCheck {

	/**
	 * 文件后缀 判断
	 *
	 * @param file
	 * @return
	 */
	public static int fileCheck(MultipartFile file) {
		int status = 0;
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			int num = file.getOriginalFilename().indexOf(".");
			if (num != -1) {
				String suffix = filename.substring(num + 1).toLowerCase();
				if (suffix != null && !suffix.equals("")) {
					if (suffix.equals("jpg") || suffix.equals("jpeg") || suffix.equals("gif") || suffix.equals("png")) {
						status = 1;
					}
				}
			}
		}
		return status;
	}

	/**
	 * 检查文件（大小）
	 *
	 * @param file
	 * @return
	 */
	public static int checkFileSize(MultipartFile file) {
		int status = 0;
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			int num = file.getOriginalFilename().lastIndexOf("."); // 最后一个点
			if (num != -1) {
				// 限制访问的后缀。
				String suffix = filename.substring(num + 1).toLowerCase();
				if (suffix != null && !suffix.equals("")) {
					if (suffix.equals("jpg") || suffix.equals("jpeg") || suffix.equals("gif") || suffix.equals("png")
							|| suffix.equals("pdf") || suffix.equals("pdfx") || suffix.equals("doc")
							|| suffix.equals("docx") || suffix.equals("zip") || suffix.equals("rar")) {
						status = 1;
					} else {
						status = -999;
					}
				} else {
					status = -1000;
				}

				if (status == 1) {

					if (file.getSize() >= 10 * 1024 * 1024) {
						status = -888;
						// TODO log
						// RunLog.logDao.info("文件大小超限...");
					}
				}

			} else {
				status = -1000;
				// TODO log
				// RunLog.logDao.info("名称非法:filename-->" + filename);
			}
		}
		return status;
	}

}
