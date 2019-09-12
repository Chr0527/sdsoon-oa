package com.sdsoon.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

/**
 * file上传下载工具类
 * <p>
 * Created By Chr on 2019/6/24.
 */
@Slf4j
public class FileUtil {

    /**
     * 单个文件上传:原文件名上传
     *
     * @param file 前端的file
     * @param path 存储本地的path
     * @return
     */
    public static boolean upLoadFile(MultipartFile file, String path, String fileName) {
        if (file.isEmpty()) {
            return false;
        }
//        int size = (int) file.getSize();
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.info("上传失败--------");
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.info("上传失败--------");
            return false;
        }
    }

    /**
     * 下载
     *
     * @param path
     * @param fileNewName
     * @param fileOldName
     * @param res
     * @return
     * @throws UnsupportedEncodingException
     */
    public static boolean downloadFile(String path, String fileNewName, String fileOldName, HttpServletResponse res) throws UnsupportedEncodingException {
        if (fileNewName == null) {
            return false;
        }
        //通过文件名查找文件信息fileInfo=selectByFileName(fileName);
        //查看文件信息,存储路径
//        res.setContentType("application/force-download");// 设置强制下载不打开
        res.setContentType("application/x-download");
//        res.setContentType("application/multipart/form-data");
        res.addHeader("Content-Disposition", //
                "attachment;fileName=" +
                        new String(fileNewName.getBytes("utf-8"), "iso8859-1"));// 设置文件名
        res.setHeader("Context-Type", "application/xmsdownload");
        //判断文件是否存在
        File file = new File(Paths.get(path, fileNewName).toString());
        if (file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = res.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                log.debug("下载成功:{}", fileOldName);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    public static final String baseUrl = "http://oa.sdsoon.cn:8099/images/";

    public static boolean downloadNet(HttpServletResponse response, String newFileName, String oldFileName) throws IOException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

//        URL url = new URL("windine.blogdriver.com/logo.gif");
//        URL url = new URL("http://oa.sdsoon.cn:8099/images/1567392147878268.java");
        URL url = new URL(baseUrl + newFileName);
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        URLConnection conn = url.openConnection();
        System.out.println(com.getPath());
        //重命名下载的filename
        String[] split = oldFileName.split("\\.");
        File file = null;
        int i = 1;
        file = new File(com.getPath() + "/" + oldFileName);
        while (file.exists()) {
            String rename = "(" + i + ").";
            oldFileName = split[0] + rename + split[1];
//            System.out.println(oldFileName);
            file = new File(com.getPath() + "/" + oldFileName);
            i++;
        }
//        System.out.println(oldFileName);

        //
        try (
                InputStream inStream = conn.getInputStream();
                FileOutputStream fs = new FileOutputStream(com.getPath() + "/" + oldFileName)
        ) {
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
//                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }





    /*

    String fileName = "FileUploadTests.java";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;

     */

    /**
     * 删除文件
     *
     * @param f
     * @param fileName
     * @return
     */
    public static void delete(File f, String fileName) {
        //数组指向文件夹中的文件和文件夹
        File[] fi = f.listFiles();
        //遍历文件和文件夹
        for (File file : fi) {
            //如果是文件夹，递归查找
            if (file.isDirectory())
                delete(file, fileName);
            else if (file.isFile()) {
                //是文件的话，把文件名放到一个字符串中
                String filename = file.getName();
                //如果是“class”后缀文件，返回一个boolean型的值
                /*if (filename.endsWith("class")) {
                    System.out.println("成功删除：：" + file.getName());
                    //file.delete();
                }*/
                if (fileName.equals(filename)) {
                    System.out.println("成功删除：：" + file.getName());
                    file.delete();
                }
            }
        }

    }
    public static void main(String args[]) {
//        File file = new File("/Users");  //  /Users是路径名
        File file = new File("D:/upload");  //  "D:/upload"  Users是路径名
        delete(file,"java.txt");

    }
}
