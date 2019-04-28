/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.util.file;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.moda.util.date.DateUtils;

/**
 *                       
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年10月15日</li>
 *
 */
public class LogFile {

    /**
     * 组日志文件名
     * @param bpath 基本目录
     * @param spath 子目录
     * @param now 日期
     * @return 完整的日志文件名 bpath/spath/yyyyMM/"us"+yyyyMMdd_hostName+".txt
     */
    public static String fileName(String bpath, String spath, Date now) {
        String basePath = bpath;
        //组目录 
        if (!basePath.endsWith("/")) {
            basePath += "/";
        }
        basePath += spath + "/";
        FileUtils.createDirectory(basePath);
        basePath += DateUtils.formatDate(now, "yyyyMM") + "/";
        FileUtils.createDirectory(basePath);
        String hostName = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostName = addr.getHostName().toString(); //获取本机计算机名称
        } catch (Exception e) {
        }

        basePath += "us" + DateUtils.formatDate(now, "yyyyMMdd") + "_" + hostName + ".txt";
        return basePath;
    }

    /**
     * 取目录下的某种类型的文件清单
     * @param path         路径
     * @param fileHeadStr  文件头
     * @param extName      文件扩展名
     * @param excludeFiles 排除的文件名
     * @return
     */
    public static List<String> getFiles(String path, String fileHeadStr, String extName,
                                        String excludeFiles) {
        File dir = new File(path);
        File[] children = dir.listFiles();
        List<String> list = new ArrayList<String>();
        if (children == null || children.length == 0) {
            return list;
        }
        for (int i = 0; i < children.length; i++) {
            File file = children[i];
            if (!file.isFile()) {
                continue;
            }
            String fileName = file.getName();
            if (fileName.equals(excludeFiles)) {
                continue;
            }
            if (!"*".equals(extName) && !fileName.toLowerCase().endsWith(extName.toLowerCase())) {
                continue;
            }
            if (!fileName.startsWith(fileHeadStr)) {
                continue;
            }
            list.add(fileName);
        }
        Collections.sort(list);
        return list;
    }
}
