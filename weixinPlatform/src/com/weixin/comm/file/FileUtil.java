package com.weixin.comm.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;

public class FileUtil {

	public static void copy(File srcFile, File destFile) {
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copy(String srcFilePath, String destFilePath) {
		File srcFile = new File(srcFilePath);
		File destFile = new File(destFilePath);
		copy(srcFile, destFile);
	}

	public static String getFileExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public static int zipFiles(File[] files, File zipFile) {
		try {
			byte[] buf = new byte[1024];
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					zipFile));
			for (int i = 0; i < files.length; i++) {
				FileInputStream in = new FileInputStream(files[i]);
				out.putNextEntry(new ZipEntry(files[i].getName()));
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
			System.out.println("compress file finish");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/*
	* inputFileName 输入一个文件夹
    * zipFileName 输出一个压缩文件夹
    */
    public static void zip(String inputFileName,String zipFileName) throws Exception {
        System.out.println(zipFileName);
        zip(zipFileName, new File(inputFileName));
    }

    private static void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, inputFile, "");
        System.out.println("zip done");
        out.close();
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
           File[] fl = f.listFiles();
           out.putNextEntry(new ZipEntry(base + "/"));
           base = base.length() == 0 ? "" : base + "/";
           for (int i = 0; i < fl.length; i++) {
           zip(out, fl[i], base + fl[i].getName());
         }
        }else {
           out.putNextEntry(new ZipEntry(base));
           FileInputStream in = new FileInputStream(f);
           int b;
           System.out.println(base);
           while ( (b = in.read()) != -1) {
            out.write(b);
         }
         in.close();
       }
    }
	    
	public static <T> int writeFile(File file, List<T> list) {
		if (null != list && list.size() > 0) {
			// FileWriter writer=null;
			OutputStreamWriter writer = null;
			try {
				// writer=new FileWriter(file);
				writer = new OutputStreamWriter(
						new FileOutputStream(file, true), "UTF-8");
				for (T t : list) {
					writer.write(t.toString());
				}
				// writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	/**
	 * copy
	 * 
	 * @param filedir
	 * @param fileName
	 * @param list
	 * @return
	 */
	public static <T> int write(String filedir, String fileName, List<T> list) {
		File fileDirectory = new File(filedir);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
		}
		if (null != list && list.size() > 0) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(fileName, true), "UTF-8"));
				for (T t : list) {
					bw.write(t.toString());
				}
				// bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	/**
	 * 写文件
	 * 
	 * @param terminalDir
	 *            文件夹
	 * @param terminalSql
	 *            sql语句
	 * @param list
	 *            要写入的内容
	 * @return
	 */
	public static <T> int writeFile1(String terminalDir, String terminalSql,
			List<T> list) {
		File dirFile = new File(terminalDir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		if (null != list && list.size() > 0) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(terminalSql, true), "UTF-8"));
				for (T t : list) {
					bw.write(t.toString());
					bw.newLine();
				}
				// bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public static void deleteDirectory(String dir) {
		File zipFile = new File(dir);
		deleteFile(zipFile);
	}

	public static void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}

	}

	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		deleteFile(file);
	}

	/**
	 * 读取文件的每一行
	 * 
	 * @param file
	 *            要读取的文件
	 * @return
	 */
	public static List<String> fileReadLines(File file) {
		List<String> lines = null;
		try {
			if (file != null) {
				lines = FileUtils.readLines(file, "UTF-8");
			}
		} catch (Exception e) {
		}
		return lines;
	}

	/**
	 * 生成文件MD5摘要信息
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileMD5(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			if (in != null) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 生成发MD5摘要信息
	 * 
	 * @param file
	 * @param listChild
	 * @return
	 */
	public static Map<String, String> getDirMD5(File file, boolean listChild) {
		if (!file.isDirectory()) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		String md5;
		File files[] = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory() && listChild) {
				map.putAll(getDirMD5(f, listChild));
			} else {
				md5 = getFileMD5(f);
				if (md5 != null) {
					map.put(f.getPath(), md5);
				}
			}
		}
		return map;
	}

	/**
	 * 生成文件MD5摘要信息
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileMD5(FileInputStream in) {
		try {
			if (in == null) {
				throw new NullPointerException("file is null!");
			}
			MessageDigest digest = MessageDigest.getInstance("MD5");
			int n = 0;
			byte[] buffer = new byte[1024];
			while ((n = in.read(buffer)) != -1) {
				digest.update(buffer, 0, n);
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	/**
	 * 判断文件夹是否存在，不存在就报建一个
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createDir(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				return file.mkdirs();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 获取单位为MB的文件大小
	 * 
	 * @param file
	 *            文件
	 * @return
	 */
	public static String GetFileSize(File file) {
		DecimalFormat df = new DecimalFormat("###.##");
		try {
			long size = FileUtils.sizeOf(file);
			double mb = (double) size / (1024 * 1024);
			return df.format(mb);
		} catch (Exception e) {/*exception print console!*/}
		return "0";
	}

	public static void main(String args[]) throws FileNotFoundException {
		// File file = new File("F:/大Boss系统项目/数据库设计规范V1.0/数据库设计方法及命名规范.doc");
		// String md5 = getFileMD5(file);
		// System.out.println(md5.length());
		// System.out.println(md5);
		// System.out.println(getFileMD5(new
		// FileInputStream("F:/大Boss系统项目/数据库设计规范V1.0/数据库设计方法及命名规范.doc")));
		// e1223e2fa71b68a6b22ea4e6d7e8ce2f
		// 169.29102
		System.out.println(GetFileSize(new File(
				"/Users/JINLONE/Movies/Bootstrap.用户界面架构.完整版.iso")));
	}
}
