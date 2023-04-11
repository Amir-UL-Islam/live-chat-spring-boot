package com.example.livechat

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.io.IOException
import java.util.concurrent.CopyOnWriteArrayList


class ChatWebSocketHandler : TextWebSocketHandler() {
    private val sessions: MutableList<WebSocketSession> = CopyOnWriteArrayList()
    @Throws(IOException::class)
    public override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        for (s in sessions) {
            s.sendMessage(message)
        }
    }

    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessions.add(session)
    }

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session)
    }
}

