package com.weixin.comm.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.lang3.StringUtils;
import com.weixin.comm.logs.LogUtil;

/**
 * zip文件生成及解压
 * 
 * @author wang.g.z
 * 
 */
public class ZipUtils {

	private static final int buffer = 2048; // 字节缓存大小

	/**
	 * Zip压缩包生成
	 * 
	 * @param inFile
	 *            打包文件或文件目录
	 * @param zos
	 *            压缩包文件流
	 * @param desDir
	 *            生成压缩包保存路径
	 * @throws IOException
	 */
	public static void zipFile(File inFile, ZipOutputStream zos, String dir)
			throws IOException {
		if (inFile.isDirectory()) {
			File[] files = inFile.listFiles();
			for (File file : files) {
				zipFile(file, zos, dir + File.separator + inFile.getName());
			}
		} else {
			String entryName = null;
			if (StringUtils.isNotEmpty(dir)) {
				entryName = dir + File.separator + inFile.getName();
			} else {
				entryName = inFile.getName();
			}
			ZipEntry entry = new ZipEntry(entryName);
			zos.putNextEntry(entry);
			InputStream is = new FileInputStream(inFile);
			int len = 0;
			byte[] byteBuffer = new byte[buffer];
			while ((len = is.read(byteBuffer)) != -1) {
				zos.write(byteBuffer, 0, len);
			}
			is.close();
		}
	}

	/**
	 * 解压到指定目录
	 * 
	 * @param zipPath
	 * @param descDir
	 * @author isea533
	 */
	public static void unZipFiles(String zipPath, String descDir) throws IOException {
		unZipFiles(new File(zipPath), descDir);
	}

	/**
	 * 压缩文件-File
	 * 
	 * @param zipFile
	 *            zip文件
	 * @param srcFiles
	 *            被压缩源文件
	 * @author isea533
	 */
	public static void ZipFiles(ZipOutputStream out, String path, File[] srcFiles) {
		path = path.replaceAll("\\*", "/");
		if (!path.endsWith("/")) {
			path += "/";
		}
		byte[] buf = new byte[1024];
		try {
			for (int i = 0; i < srcFiles.length; i++) {
				if (srcFiles[i].isDirectory()) {
					File[] files = srcFiles[i].listFiles();
					String srcPath = srcFiles[i].getName();
					srcPath = srcPath.replaceAll("\\*", "/");
					if (!srcPath.endsWith("/")) {
						srcPath += "/";
					}
					out.putNextEntry(new ZipEntry(path + srcPath));
					ZipFiles(out, path + srcPath, files);
				} else {
					FileInputStream in = new FileInputStream(srcFiles[i]);
					System.out.println(path + srcFiles[i].getName());
					out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					out.closeEntry();
					in.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解压文件到指定目录
	 * 
	 * @param zipFile
	 * @param descDir
	 */
	@SuppressWarnings("rawtypes")
	public static void unZipFiles(File zipFile, String descDir) throws IOException {
		LogUtil.info("******************解压开始********************");
		File pathFile = new File(descDir);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		InputStream in = null;
		OutputStream out = null;
		org.apache.tools.zip.ZipFile zip = null;
		try{
			zip = new org.apache.tools.zip.ZipFile(zipFile);
			for (Enumeration entries = zip.getEntries(); entries.hasMoreElements();) {
				org.apache.tools.zip.ZipEntry entry = (org.apache.tools.zip.ZipEntry) entries.nextElement();
				String zipEntryName = entry.getName();
				in = zip.getInputStream(entry);
				String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\*", "/");
				//判断路径是否存在,不存在则创建文件路径
				File file = new File(descDir);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
				if (new File(outPath).isDirectory()) {
					continue;
				}
				// 输出文件路径信息
				out = new FileOutputStream(outPath);
				byte[] buf1 = new byte[1024];
				int len = 0;
				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();
				in = null;
				out.close();
				out = null;
				zip.close();
				zip = null;
			}
		} finally {
			if(zip != null) {
				zip.close();
				zip = null;
			}
			if(in != null) {
				in.close();
				in = null;
			}
			if(out != null) {
				out.close();
				out = null;
			}
		}
		LogUtil.info("******************解压完毕********************");
	}

	/**
	 * 判断是否为图片
	 * 
	 * @param filename
	 * @return
	 */
	public static boolean isPics(String filename) {
		boolean flag = false;
		if (filename.endsWith(".jpg") || filename.endsWith(".gif")
				|| filename.endsWith(".bmp") || filename.endsWith(".png")) {
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * //单个文件写入zip包 ZipOutputStream zos = new ZipOutputStream(new
		 * FileOutputStream("D:\\testZip.zip")); // 实例化一个名称为ab.txt的ZipEntry对象
		 * ZipEntry entry = new ZipEntry("ab.txt"); // 设置注释
		 * zos.setComment("zip测试for单个文件"); //
		 * 把生成的ZipEntry对象加入到压缩文件中，而之后往压缩文件中写入的内容都会放在这个ZipEntry对象里面
		 * zos.putNextEntry(entry); InputStream is = new
		 * FileInputStream("D:\\ab.txt"); int len = 0; while ((len = is.read())
		 * != -1) zos.write(len); is.close(); zos.close();
		 * 
		 * //多个文件写入zip包 File inFile = new File("D:\\test"); ZipOutputStream zost
		 * = new ZipOutputStream(new FileOutputStream("D:\\test.zip"));
		 * zos.setComment("多文件处理"); zipFile(inFile, zost, ""); zos.close();
		 */
		unZipFiles("D:\\icbcLocal\\download\\2013-12-31\\1007_623e9b4ba5d9cab868e27cd27b8472a6.zip",
				"D:\\icbcLocal\\download\\2013-12-31");
	}

}
