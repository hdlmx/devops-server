package ftp;

import cn.hdlmx.devops.util.ftp.FtpClientBuilder;
import cn.hdlmx.devops.util.ftp.FtpUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/11/22 11:35
 */
public class FtpTest {
    @Test
    public void ftpConnect() {
        FTPClient ftpClient = FtpClientBuilder.connectFtpServer("192.168.18.150", 21, "devopsftp", "handong", "UTF-8");
       /* System.out.println("连接是否成功：" + ftpClient.isConnected());
        System.out.println("连接是否有效：" + ftpClient.isAvailable());
        FtpUtil.downloadSingleFile(ftpClient, "D:\\Java", "\\build\\anon.txt");
        File file = new File("D:" + File.separatorChar + "Java" + File.separatorChar + "jetbrains agent");
        FtpUtil.uploadFiles(ftpClient, file);*/

        //List<String> relativePathList = new ArrayList<>();
        //FtpUtil.downloadSingleFile(ftpClient, "D:\\Java", "\\fiddler\\Fiddler2\\西西软件园.txt");
        //FtpUtil.downloadFile(ftpClient, "helloworld-2.jar", "D:\\Java\\", "\\build-artifacts\\hellworld\\2019-12-11\\s");
        FtpUtil.uploadFiles(ftpClient,new File("D:"+File.separatorChar+"devops-server-0.0.1-SNAPSHOT.jar"),"\\build-artifacts\\helloworld\\springboot\\2019-12-11");

    }

}
