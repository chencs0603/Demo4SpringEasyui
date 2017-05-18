package personal.chencs.learn.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "file")
public class FileController {
	
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//File.separator作为路径分隔符，兼容不同的操作系统
		String rootPath = request.getSession().getServletContext().getRealPath(File.separator);
		String fileName = rootPath + File.separator + "logs"  + File.separator + "log4j.log";
		File file = new File(fileName);
		//文件不存在
		if (!file.exists()) {
			return;
		}
		
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (StringUtils.isEmpty(mimeType)) {
			mimeType = "application/octet-stream";
		}
		
		response.setContentType(mimeType);
		//通过“内联”浏览器将尝试显示内容到浏览器中（图片，PDF，文本，...）。对于其他内容类型，文件将直接下载
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
		response.setContentLength((int)file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
}
