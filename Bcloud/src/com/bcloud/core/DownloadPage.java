package com.bcloud.core;

/**
 * 下载任务管理器, 处理下载任务的后台调度. <br>
 * 它是与UI进行交互的接口. <br>
 * 它会保存所有下载任务的状态. <br>
 * 它来为每个下载线程分配任务.<br>
 * 它会自动管理磁盘文件结构, 在必要时会创建必要的目录. <br>
 * 它会自动获取文件的最新的下载链接(这个链接有效时间是8小时). <br>
 * ---------------------------------------------------------------------------- <br>
 * 每个task(pcs_file)包含这些信息: <br>
 * fs_id - 服务器上的文件UID <br>
 * md5 - 文件MD5校验值 <br>
 * size - 文件大小 <br>
 * path - 文件在服务器上的绝对路径 <br>
 * name - 文件在服务器上的名称 <br>
 * savePath - 保存到的绝对路径 <br>
 * saveName - 保存时的文件名 <br>
 * currRange - 当前下载的进度, 以字节为单位, 在HTTP Header中可用. <br>
 * state - 任务状态 <br>
 * link - 文件的下载最终URL, 有效期大约是8小时, 超时后要重新获取. <br>
 */
public class DownloadPage {

}

/**
 数据库表名:
 '''CREATE TABLE IF NOT EXISTS tasks (
        name CHAR NOT NULL,
        path CHAR NOT NULL,
        fsid CHAR NOT NULL,
        size INTEGER NOT NULL,
        currsize INTEGER NOT NULL,
        link CHAR,
        isdir INTEGER,
        savename CHAR NOT NULL,
        savedir CHAR NOT NULL,
        state INT NOT NULL,
        statename CHAR NOT NULL,
        humansize CHAR NOT NULL,
        percent INT NOT NULL,
        tooltip CHAR
        )
        '''
 
 */
