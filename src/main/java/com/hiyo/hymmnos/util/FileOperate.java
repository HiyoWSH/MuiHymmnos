package com.hiyo.hymmnos.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 * @author wangsh
 * @e-mail wanghiyo@163.com
 * @date 2016年12月6日 上午10:58:39
 * @描述：文件操作类
 * @注意事项：
 */
// 我的文件操作库
public class FileOperate {

	private static final Logger logger = Logger.getLogger(FileOperate.class);
	
	private static void insert(String time, String msg, String sender,Connection conn) throws SQLException {
		if(StringUtils.isBlank(time) || StringUtils.isBlank(msg) || StringUtils.isBlank(sender))
		{
			//System.out.println("black" + time + " " + msg + " " + sender);
			return;
		}
		/******************/
		// PreparedStatement pstmt =
		// conn.prepareStatement("select * from mc$asset_database");

		try {
			PreparedStatement pstmt = conn
					.prepareStatement("insert into new_table(msg,sender,time) values(?,?,?)");
			pstmt.setString(1, msg);
			pstmt.setString(2, sender);
			pstmt.setString(3, time);
			pstmt.execute();
		} catch (Exception e) {

		}
		/******************/
	}

	/**
	 * 
	 * @param fileLocation 文件读取 路径
	 * @param coding 文件读取 编码
	 * @return List<String> 
	 */
	public static List<String> FileRead(String fileLocation, String coding) {
		List<String> list = new LinkedList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), coding));
			String strRead = null;
			while (br.ready()) {
				strRead = br.readLine();
				list.add(strRead);
			}
			br.close();
		} catch (Exception e) {
			logger.error("读取文件" + fileLocation + "失败" + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * @param fileLocation 文件读取 路径
	 * @param coding 文件读取 编码
	 * @return List<String> 
	 */
	public static StringBuilder FileReadToStringBuilder(String fileLocation, String coding) {
		StringBuilder bulider = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), coding));
			String strRead = null;
			while (br.ready()) {
				strRead = br.readLine();
				bulider.append(strRead);
				bulider.append("\n");
			}
			br.close();
		} catch (Exception e) {
			logger.error("读取文件" + fileLocation + "失败" + e.getMessage());
			e.printStackTrace();
		}
		return bulider;
	}

	/**
	 * 
	 * @param strList  写入内容，没文件会自动创建
	 * @param fileLocation 路径
	 * @param coding 编码
	 */
	public static void writeFile(List<String> strList, String fileLocation, String coding) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), coding));
			for (String s : strList) {
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("写入文件" + fileLocation + "失败，错误IO");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("写入文件" + fileLocation + "失败，未知错误");
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件是否存在
	 * @param s
	 * @return
	 */
	public static boolean fileExists(String s){
		File f = new File(s);
        return f.exists();
	}
	
	public static boolean createFile(String s){
		File f =new File(s);
		if(!f.exists()) {
			try {
				f.createNewFile();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 创建目录
	 * @param dirName 目录
	 */
	public static void createDir(String dirName){
		File f=new File(dirName);
		f.mkdirs();//创建一个文件夹与他所有父文件夹
	}
	
	public static void writeFile(String string, String fileLocation ,String coding) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), coding));
			bw.write(string);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("写入文件" + fileLocation + "失败，错误IO" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("写入文件" + fileLocation + "失败，未知错误" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static JSONArray readFile(File jsonarrayFile) {
		StringBuilder bulider = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsonarrayFile), "utf-8"));
			String strRead = null;
			while (br.ready()) {
				strRead = br.readLine();
				bulider.append(strRead);
				bulider.append("\n");
			}
			br.close();
		} catch (Exception e) {
			logger.error("读取文件失败" + e.getMessage());
			e.printStackTrace();
			bulider.append("[]");
		}
		return JSONArray.parseArray(bulider.toString());
	}
}
