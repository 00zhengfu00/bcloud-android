package com.bcloud.core;

/**
 * �������������, ������������ĺ�̨����. <br>
 * ������UI���н����Ľӿ�. <br>
 * ���ᱣ���������������״̬. <br>
 * ����Ϊÿ�������̷߳�������.<br>
 * �����Զ���������ļ��ṹ, �ڱ�Ҫʱ�ᴴ����Ҫ��Ŀ¼. <br>
 * �����Զ���ȡ�ļ������µ���������(���������Чʱ����8Сʱ). <br>
 * ---------------------------------------------------------------------------- <br>
 * ÿ��task(pcs_file)������Щ��Ϣ: <br>
 * fs_id - �������ϵ��ļ�UID <br>
 * md5 - �ļ�MD5У��ֵ <br>
 * size - �ļ���С <br>
 * path - �ļ��ڷ������ϵľ���·�� <br>
 * name - �ļ��ڷ������ϵ����� <br>
 * savePath - ���浽�ľ���·�� <br>
 * saveName - ����ʱ���ļ��� <br>
 * currRange - ��ǰ���صĽ���, ���ֽ�Ϊ��λ, ��HTTP Header�п���. <br>
 * state - ����״̬ <br>
 * link - �ļ�����������URL, ��Ч�ڴ�Լ��8Сʱ, ��ʱ��Ҫ���»�ȡ. <br>
 */
public class DownloadPage {

}

/**
 ���ݿ����:
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
