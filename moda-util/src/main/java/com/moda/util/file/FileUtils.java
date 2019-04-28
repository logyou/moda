package com.moda.util.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.moda.util.lang.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moda.entity.consts.Global;

/**
 * 文件操作工具类
 * 实现文件的创建、删除、复制、压缩、解压以及目录的创建、删除、复制、压缩解压等功能
 *
 * @author lyh
 * @version 1.1 2017-7-28
 */
public class FileUtils extends org.apache.commons.io.FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 复制单个文件，如果目标文件存在，则不覆盖
     *
     * @param srcFileName  待复制的文件名
     * @param descFileName 目标文件名
     * @return 如果复制成功，则返回true，否则返回false
     */
    public static boolean copyFile(String srcFileName, String descFileName) {
        return FileUtils.copyFileCover(srcFileName, descFileName, false);
    }

    /**
     * 复制单个文件
     *
     * @param srcFileName  待复制的文件名
     * @param descFileName 目标文件名
     * @param coverlay     如果目标文件已存在，是否覆盖
     * @return 如果复制成功，则返回true，否则返回false
     */
    public static boolean copyFileCover(String srcFileName, String descFileName, boolean coverlay) {
        File srcFile = new File(srcFileName);
        // 判断源文件是否存在
        if (!srcFile.exists()) {
            logger.debug("复制文件失败，源文件 " + srcFileName + " 不存在！");
            return false;
        }
        // 判断源文件是否是合法的文件
        else if (!srcFile.isFile()) {
            logger.debug("复制文件失败，" + srcFileName + " 不是一个文件！");
            return false;
        }
        File descFile = new File(descFileName);
        // 判断目标文件是否存在
        if (descFile.exists()) {
            // 如果目标文件存在，并且允许覆盖
            if (coverlay) {
                logger.debug("目标文件已存在，准备删除！");
                if (!FileUtils.delFile(descFileName)) {
                    logger.debug("删除目标文件 " + descFileName + " 失败！");
                    return false;
                }
            } else {
                logger.debug("复制文件失败，目标文件 " + descFileName + " 已存在！");
                return false;
            }
        } else {
            if (!descFile.getParentFile().exists()) {
                // 如果目标文件所在的目录不存在，则创建目录
                logger.debug("目标文件所在的目录不存在，创建目录！");
                // 创建目标文件所在的目录
                if (!descFile.getParentFile().mkdirs()) {
                    logger.debug("创建目标文件所在的目录失败！");
                    return false;
                }
            }
        }

        // 准备复制文件
        // 读取的位数
        int readByte = 0;
        InputStream ins = null;
        OutputStream outs = null;
        try {
            // 打开源文件
            ins = new FileInputStream(srcFile);
            // 打开目标文件的输出流
            outs = new FileOutputStream(descFile);
            byte[] buf = new byte[1024];
            // 一次读取1024个字节，当readByte为-1时表示文件已经读取完毕
            while ((readByte = ins.read(buf)) != -1) {
                // 将读取的字节流写入到输出流
                outs.write(buf, 0, readByte);
            }
            logger.debug("复制单个文件 " + srcFileName + " 到" + descFileName + "成功！");
            return true;
        } catch (Exception e) {
            logger.debug("复制文件失败：" + e.getMessage());
            return false;
        } finally {
            // 关闭输入输出流，首先关闭输出流，然后再关闭输入流
            if (outs != null) {
                try {
                    outs.close();
                } catch (IOException oute) {
                    oute.printStackTrace();
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException ine) {
                    ine.printStackTrace();
                }
            }
        }
    }

    /**
     * 复制整个目录的内容，如果目标目录存在，则不覆盖
     *
     * @param srcDirName  源目录名
     * @param descDirName 目标目录名
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyDirectory(String srcDirName, String descDirName) {
        return FileUtils.copyDirectoryCover(srcDirName, descDirName, false);
    }

    /**
     * 复制整个目录的内容
     *
     * @param srcDirName  源目录名
     * @param descDirName 目标目录名
     * @param coverlay    如果目标目录存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyDirectoryCover(String srcDirName, String descDirName,
                                             boolean coverlay) {
        File srcDir = new File(srcDirName);
        // 判断源目录是否存在
        if (!srcDir.exists()) {
            logger.debug("复制目录失败，源目录 " + srcDirName + " 不存在！");
            return false;
        }
        // 判断源目录是否是目录
        else if (!srcDir.isDirectory()) {
            logger.debug("复制目录失败，" + srcDirName + " 不是一个目录！");
            return false;
        }
        // 如果目标文件夹名不以文件分隔符结尾，自动添加文件分隔符
        String descDirNames = descDirName;
        if (!descDirNames.endsWith(File.separator)) {
            descDirNames = descDirNames + File.separator;
        }
        File descDir = new File(descDirNames);
        // 如果目标文件夹存在
        if (descDir.exists()) {
            if (coverlay) {
                // 允许覆盖目标目录
                logger.debug("目标目录已存在，准备删除！");
                if (!FileUtils.delFile(descDirNames)) {
                    logger.debug("删除目录 " + descDirNames + " 失败！");
                    return false;
                }
            } else {
                logger.debug("目标目录复制失败，目标目录 " + descDirNames + " 已存在！");
                return false;
            }
        } else {
            // 创建目标目录
            logger.debug("目标目录不存在，准备创建！");
            if (!descDir.mkdirs()) {
                logger.debug("创建目标目录失败！");
                return false;
            }

        }

        boolean flag = true;
        // 列出源目录下的所有文件名和子目录名
        File[] files = srcDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 如果是一个单个文件，则直接复制
            if (files[i].isFile()) {
                flag = FileUtils.copyFile(files[i].getAbsolutePath(),
                    descDirName + files[i].getName());
                // 如果拷贝文件失败，则退出循环
                if (!flag) {
                    break;
                }
            }
            // 如果是子目录，则继续复制目录
            if (files[i].isDirectory()) {
                flag = FileUtils.copyDirectory(files[i].getAbsolutePath(),
                    descDirName + files[i].getName());
                // 如果拷贝目录失败，则退出循环
                if (!flag) {
                    break;
                }
            }
        }

        if (!flag) {
            logger.debug("复制目录 " + srcDirName + " 到 " + descDirName + " 失败！");
            return false;
        }
        logger.debug("复制目录 " + srcDirName + " 到 " + descDirName + " 成功！");
        return true;

    }

    /**
     * 删除文件，可以删除单个文件或文件夹
     *
     * @param fileName 被删除的文件名
     * @return 如果删除成功，则返回true，否是返回false
     */
    public static boolean delFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            logger.debug(fileName + " 文件不存在！");
            return true;
        } else {
            if (file.isFile()) {
                return FileUtils.deleteFile(fileName);
            } else {
                return FileUtils.deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 被删除的文件名
     * @return 如果删除成功，则返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.debug("删除文件 " + fileName + " 成功！");
                return true;
            } else {
                logger.debug("删除文件 " + fileName + " 失败！");
                return false;
            }
        } else {
            logger.debug(fileName + " 文件不存在！");
            return true;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dirName 被删除的目录所在的文件路径
     * @return 如果目录删除成功，则返回true，否则返回false
     */
    public static boolean deleteDirectory(String dirName) {
        String dirNames = dirName;
        if (!dirNames.endsWith(File.separator)) {
            dirNames = dirNames + File.separator;
        }
        File dirFile = new File(dirNames);
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            logger.debug(dirNames + " 目录不存在！");
            return true;
        }
        boolean flag = true;
        // 列出全部文件及子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtils.deleteFile(files[i].getAbsolutePath());
                // 如果删除文件失败，则退出循环
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtils.deleteDirectory(files[i].getAbsolutePath());
                // 如果删除子目录失败，则退出循环
                if (!flag) {
                    break;
                }
            }
        }

        if (!flag) {
            logger.debug("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            logger.debug("删除目录 " + dirName + " 成功！");
            return true;
        } else {
            logger.debug("删除目录 " + dirName + " 失败！");
            return false;
        }

    }

    /**
     * 创建单个文件
     *
     * @param descFileName 文件名，包含路径
     * @return 如果创建成功，则返回true，否则返回false
     */
    public static boolean createFile(String descFileName) {
        File file = new File(descFileName);
        if (file.exists()) {
            logger.debug("文件 " + descFileName + " 已存在！");
            return false;
        }
        if (descFileName.endsWith(File.separator)) {
            logger.debug(descFileName + " 为目录，不能创建目录！");
            return false;
        }
        if (!file.getParentFile().exists()) {
            // 如果文件所在的目录不存在，则创建目录
            if (!file.getParentFile().mkdirs()) {
                logger.debug("创建文件所在的目录失败！");
                return false;
            }
        }

        // 创建文件
        try {
            if (file.createNewFile()) {
                logger.debug(descFileName + " 文件创建成功！");
                return true;
            } else {
                logger.debug(descFileName + " 文件创建失败！");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(descFileName + " 文件创建失败！");
            return false;
        }

    }

    /**
     * 创建目录
     *
     * @param descDirName 目录名,包含路径
     * @return 如果创建成功，则返回true，否则返回false
     */
    public static boolean createDirectory(String descDirName) {
        String descDirNames = descDirName;
        if (!descDirNames.endsWith(File.separator)) {
            descDirNames = descDirNames + File.separator;
        }
        File descDir = new File(descDirNames);
        if (descDir.exists()) {
            //            logger.debug("目录 " + descDirNames + " 已存在！");
            return false;
        }
        if (descDir.mkdirs()) {
            logger.debug("目录 " + descDirNames + " 创建成功！");
            return true;
        } else {
            logger.debug("目录 " + descDirNames + " 创建失败！");
            return false;
        }
    }

    /**
     * 写入文件
     *
     * @param fileName 要写入的文件
     */
    public static void writeToFile(String fileName, String content, boolean append) {
        try {
            FileUtils.write(new File(fileName), content, "utf-8", append);
            //            logger.debug("文件 " + fileName + " 写入成功！");
        } catch (IOException e) {
            logger.debug("文件 " + fileName + " 写入失败! " + e.getMessage());
        }
    }

    public static String readFileToString(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                return FileUtils.readFileToString(file, Global.UTF8);
            } catch (IOException e) {
                logger.debug("文件读取失败！{}", e.getMessage());
            }
        } else {
            logger.debug("文件{}不存在！", file.getAbsoluteFile());
        }
        return null;
    }

    /**
     * 写入文件
     *
     * @param fileName 要写入的文件
     */
    public static void writeToFile(String fileName, String content, String encoding,
                                   boolean append) {
        try {
            FileUtils.write(new File(fileName), content, encoding, append);
            logger.debug("文件 " + fileName + " 写入成功！");
        } catch (IOException e) {
            logger.debug("文件 " + fileName + " 写入失败! " + e.getMessage());
        }
    }

    /**
     * 压缩文件或目录
     *
     * @param srcDirName   压缩的根目录
     * @param fileName     根目录下的待压缩的文件名或文件夹名，其中*或""表示跟目录下的全部文件
     * @param descFileName 目标zip文件
     */
    public static void zipFiles(String srcDirName, String fileName, String descFileName) {
        // 判断目录是否存在
        if (srcDirName == null) {
            logger.debug("文件压缩失败，目录 " + srcDirName + " 不存在！");
            return;
        }
        File fileDir = new File(srcDirName);
        if (!fileDir.exists() || !fileDir.isDirectory()) {
            logger.debug("文件压缩失败，目录 " + srcDirName + " 不存在！");
            return;
        }
        String dirPath = fileDir.getAbsolutePath();
        File descFile = new File(descFileName);
        try {
            ZipOutputStream zouts = new ZipOutputStream(new FileOutputStream(descFile));
            if ("*".equals(fileName) || "".equals(fileName)) {
                FileUtils.zipDirectoryToZipFile(dirPath, fileDir, zouts);
            } else {
                File file = new File(fileDir, fileName);
                if (file.isFile()) {
                    FileUtils.zipFilesToZipFile(dirPath, file, zouts);
                } else {
                    FileUtils.zipDirectoryToZipFile(dirPath, file, zouts);
                }
            }
            zouts.close();
            logger.debug(descFileName + " 文件压缩成功！");
        } catch (Exception e) {
            logger.debug("文件压缩失败：" + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 解压缩ZIP文件，将ZIP文件里的内容解压到descFileName目录下
     *
     * @param zipFileName  需要解压的ZIP文件
     * @param descFileName 目标文件
     */
    public static boolean unZipFiles(String zipFileName, String descFileName) {
        String descFileNames = descFileName;
        if (!descFileNames.endsWith(File.separator)) {
            descFileNames = descFileNames + File.separator;
        }
        try {
            // 根据ZIP文件创建ZipFile对象
            ZipFile zipFile = new ZipFile(zipFileName);
            ZipEntry entry = null;
            String entryName = null;
            String descFileDir = null;
            byte[] buf = new byte[4096];
            int readByte = 0;
            // 获取ZIP文件里所有的entry
            @SuppressWarnings("rawtypes")
            Enumeration enums = zipFile.entries();
            // 遍历所有entry
            while (enums.hasMoreElements()) {
                entry = (ZipEntry) enums.nextElement();
                // 获得entry的名字
                entryName = entry.getName();
                descFileDir = descFileNames + entryName;
                if (entry.isDirectory()) {
                    // 如果entry是一个目录，则创建目录
                    new File(descFileDir).mkdirs();
                    continue;
                } else {
                    // 如果entry是一个文件，则创建父目录
                    new File(descFileDir).getParentFile().mkdirs();
                }
                File file = new File(descFileDir);
                // 打开文件输出流
                OutputStream os = new FileOutputStream(file);
                // 从ZipFile对象中打开entry的输入流
                InputStream is = zipFile.getInputStream(entry);
                while ((readByte = is.read(buf)) != -1) {
                    os.write(buf, 0, readByte);
                }
                os.close();
                is.close();
            }
            zipFile.close();
            logger.debug("文件解压成功！");
            return true;
        } catch (Exception e) {
            logger.debug("文件解压失败：" + e.getMessage());
            return false;
        }
    }

    /**
     * 将目录压缩到ZIP输出流
     *
     * @param dirPath 目录路径
     * @param fileDir 文件信息
     * @param zouts   输出流
     */
    public static void zipDirectoryToZipFile(String dirPath, File fileDir, ZipOutputStream zouts) {
        if (fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            // 空的文件夹
            if (files.length == 0) {
                // 目录信息
                ZipEntry entry = new ZipEntry(getEntryName(dirPath, fileDir));
                try {
                    zouts.putNextEntry(entry);
                    zouts.closeEntry();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    // 如果是文件，则调用文件压缩方法
                    FileUtils.zipFilesToZipFile(dirPath, files[i], zouts);
                } else {
                    // 如果是目录，则递归调用
                    FileUtils.zipDirectoryToZipFile(dirPath, files[i], zouts);
                }
            }

        }

    }

    /**
     * 将文件压缩到ZIP输出流
     *
     * @param dirPath 目录路径
     * @param file    文件
     * @param zouts   输出流
     */
    public static void zipFilesToZipFile(String dirPath, File file, ZipOutputStream zouts) {
        FileInputStream fin = null;
        ZipEntry entry = null;
        // 创建复制缓冲区
        byte[] buf = new byte[4096];
        int readByte = 0;
        if (file.isFile()) {
            try {
                // 创建一个文件输入流
                fin = new FileInputStream(file);
                // 创建一个ZipEntry
                entry = new ZipEntry(getEntryName(dirPath, file));
                // 存储信息到压缩文件
                zouts.putNextEntry(entry);
                // 复制字节到压缩文件
                while ((readByte = fin.read(buf)) != -1) {
                    zouts.write(buf, 0, readByte);
                }
                zouts.closeEntry();
                fin.close();
                System.out.println("添加文件 " + file.getAbsolutePath() + " 到zip文件中！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取待压缩文件在ZIP文件中entry的名字，即相对于跟目录的相对路径名
     *
     * @param dirPath 目录名
     * @param file    entry文件名
     * @return
     */
    private static String getEntryName(String dirPath, File file) {
        String dirPaths = dirPath;
        if (!dirPaths.endsWith(File.separator)) {
            dirPaths = dirPaths + File.separator;
        }
        String filePath = file.getAbsolutePath();
        // 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储
        if (file.isDirectory()) {
            filePath += "/";
        }
        int index = filePath.indexOf(dirPaths);

        return filePath.substring(index + dirPaths.length());
    }

    /**
     * 修复路径，将 \\ 或 / 等替换为 File.separator
     *
     * @param path
     * @return
     */
    public static String path(String path) {
        String p = StringUtils.replace(path, "\\", "/");
        p = StringUtils.join(StringUtils.split(p, "/"), "/");
        if (!StringUtils.startsWithAny(p, "/") && StringUtils.startsWithAny(path, "\\", "/")) {
            p += "/";
        }
        if (!StringUtils.endsWithAny(p, "/") && StringUtils.endsWithAny(path, "\\", "/")) {
            p = p + "/";
        }
        return p;
    }

    /**
     * 判断文件或文件夹是否存在
     *
     * @param fileName 文件或文件夹路径
     * @return true-存在;false-不存在
     */
    public static boolean exists(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        return new File(fileName).exists();
    }

    /**
     * 获取文件大小
     *
     * @param fileName 文件名
     * @return
     */
    public static long getFileSize(String fileName) {
        try {
            long fileSize = 0;
            File f = new File(fileName);
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                fileSize = fis.available();
                fis.close();
            }
            return fileSize;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 流转成文件
     *
     * @param in           输入流
     * @param fullFileName 完整文件名
     * @return boolean
     */
    public static boolean inputStreamToFile(InputStream in, String fullFileName) {
        try {
            File file = new File(fullFileName);
            if (!file.getParentFile().exists()) {
                if (!FileUtils.createDirectory(file.getParent())) {
                    return false;
                }
            }
            if (!file.createNewFile()) {
                logger.error("创建 {} 文件失败！", file.getAbsolutePath());
                return false;
            }
            org.apache.commons.io.FileUtils.copyInputStreamToFile(in, file);
            logger.debug("文件已保存到 {} ！", fullFileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     * 读取url存储到本地
     *
     * @param fileUrl      文件地址
     * @param fullFileName 保存路径
     * @return boolean
     */
    public static boolean downloadToLocal(String fileUrl, String fullFileName) {
        BufferedInputStream bis = null;
        OutputStream bos = null;
        try {
            File file = new File(fullFileName);
            if (!file.getParentFile().exists()) {
                if (!FileUtils.createDirectory(file.getParent())) {
                    return false;
                }
            }
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            bis = new BufferedInputStream(conn.getInputStream());
            byte[] bytes = new byte[100];
            bos = new FileOutputStream(new File(fullFileName));
            int len;
            while ((len = bis.read(bytes)) > 0) {
                bos.write(bytes, 0, len);
            }
            bis.close();
            bos.flush();
            bos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("下载文件失败！");
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return false;
    }

    /**
     * 保存上传的文件到磁盘
     *
     * @param uploadResult 上传参数
     * @return 成功参数
     */
    public static UploadResult saveFile(UploadResult uploadResult) {
        //计算文件MD5值
        String md5 = FileHash.getFileHash(uploadResult.getTempFullFileName(), FileHash.MD5);
        uploadResult.setSubPath("files/" + md5.substring(0, 3));
        uploadResult.setSrcFileName(md5 + "." + uploadResult.getExtName());
        //如果已经存在该文件就直接返回
        if (FileUtils.exists(uploadResult.getSrcFullFileName())) {
            logger.info("文件 {} 已存在！", uploadResult.getSrcFullFileName());
            FileUtils.deleteFile(uploadResult.getTempFullFileName());
            return uploadResult;
        }
        try {
            FileUtils.moveFile(new File(uploadResult.getTempFullFileName()),
                new File(uploadResult.getSrcFullFileName()));
            logger.info("文件已从 {} 移动到 {} ！", uploadResult.getTempFullFileName(),
                uploadResult.getSrcFullFileName());
        } catch (IOException e) {
            logger.error("把文件从 {} 移动到 {} 失败！", uploadResult.getTempFullFileName(),
                uploadResult.getSrcFullFileName());
            e.printStackTrace();
            return null;
        }

        return uploadResult;
    }

    /**
     * 返回不带扩展名的文件名称
     *
     * @param path 文件路径
     * @return 名称
     */
    public static String getNameWithoutExt(String path) {
        String name = FilenameUtils.getName(path);
        return name.substring(0, name.lastIndexOf('.'));
    }

}
