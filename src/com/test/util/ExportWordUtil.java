package com.test.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Another
 * @info 将试卷内容导出为Word文档
 * 
 *       1.接收需要生成Word文档的数据
 * 
 *       2.根据Word模板，使用freemarker进行插值替换
 * 
 *       3.将Word文档输出到指定目录
 */
public class ExportWordUtil {
	private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
	static {
		configuration.setClassForTemplateLoading(ExportWordUtil.class, "/source");
		configuration.setDefaultEncoding("UTF-8");
	}

	/**
	 * @param dataMap    数据源
	 * @param targetPath 生成Word文档的路径
	 * @return 生成Word文档成功返回true，失败返回false
	 */
	public static Boolean createWord(Map<String, Object> dataMap, String targetPath) {
		return createWord(dataMap, "wordTemplate.ftl", targetPath);
	}

	public static Boolean createWord(Map<String, Object> dataMap, String templatePosition, String targetPath) {
		Template template = null;
		try {
			template = configuration.getTemplate(templatePosition);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File outFile = new File(targetPath);
		if (!outFile.exists()) {
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Writer out = null;
		try {
			try {
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			template.process(dataMap, out);
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
