package cn.hdlmx.devops.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/4 16:05
 */
@ServerEndpoint("/webSocket/{sid}")
@Component
public class WebSocketServer {
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();
    private Session session;
    private String sid = "";

    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();
        this.sid = sid;
        try {
            sendMessage("连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        //群发消息
        for (WebSocketServer item : webSocketServers) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public void onClose() {
        webSocketServers.remove(this);
        subOnlineCount();

    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        for (WebSocketServer item : webSocketServers) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if (sid == null) {
                    item.sendMessage(message);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
