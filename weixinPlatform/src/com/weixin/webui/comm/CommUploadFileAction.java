package com.weixin.webui.comm;

import java.io.File;
import java.util.List;
import com.weixin.comm.Uuid;
import com.weixin.comm.file.FileUtil;
import com.weixin.webui.core.BaseAction;
import net.sf.json.JSONObject;

/**
 * 用于内容管理系统上传图片和文件上传
 * 
 * @author 	he.x.d
 * 			wang.g.z
 * @time 2013.12.12
 * 
 */
@SuppressWarnings("serial")
public class CommUploadFileAction extends BaseAction {

	private File uploadfile;
	private String uploadfileFileName;

	public String uploadPicShow() {
		return "picture";
	}

	public String uploadFileShow() {
		return "file";
	}

	/**
	 * 文件上传共用控件
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String uploadCommFile() {
		String reuslt = "ok";
		String tpFileName = "";
		JSONObject json = new JSONObject();
		StringBuffer filePath = new StringBuffer();
		String folder = this.getRequestParameter("folder");
		try{
			String uploadPath = this.getRequest().getRealPath("/");
			File file = null;
			if(folder.startsWith("/")) {
				file = new File(uploadPath + folder);
			} else {
				file = new File(uploadPath + File.separator +  folder);
			}
			if(file != null && !file.exists() && file.isDirectory()) {
				file.mkdirs();
			}
			if(Filedata != null && FiledataFileName != null) {
				for(int i=0; i<Filedata.size(); i++) {
					tpFileName = Uuid.getPrimaryKey() + FileUtil.getFileExtention(FiledataFileName.get(i));
					filePath.append(file.getAbsolutePath())
							.append(File.separator)
							.append(tpFileName);
					FileUtil.copy(Filedata.get(i), new File(filePath.toString()));
				}
			}
			
		} catch (Exception e) {
			reuslt = e.getMessage();
			e.printStackTrace();
		}
		json.put("result", reuslt);
		json.put("pic", folder + "/" + tpFileName);
		this.writeResult(json.toString());
		return null;
	}

	/** 文件对象 */
	private List<File> Filedata;

	/** 文件名 */
	private List<String> FiledataFileName;

	/** 文件内容类型 */
	private List<String> FiledataContentType;

	/**
	 * @return the filedata
	 */
	public List<File> getFiledata() {
		return Filedata;
	}

	/**
	 * @param filedata
	 *            the filedata to set
	 */
	public void setFiledata(List<File> filedata) {
		Filedata = filedata;
	}

	/**
	 * @return the filedataFileName
	 */
	public List<String> getFiledataFileName() {
		return FiledataFileName;
	}

	/**
	 * @param filedataFileName
	 *            the filedataFileName to set
	 */
	public void setFiledataFileName(List<String> filedataFileName) {
		FiledataFileName = filedataFileName;
	}

	/**
	 * @return the filedataContentType
	 */
	public List<String> getFiledataContentType() {
		return FiledataContentType;
	}

	/**
	 * @param filedataContentType
	 *            the filedataContentType to set
	 */
	public void setFiledataContentType(List<String> filedataContentType) {
		FiledataContentType = filedataContentType;
	}

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

}
