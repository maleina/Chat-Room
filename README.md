# Chat Room
A very simple chatroom web app using WebSocket and STOMP with the Spring Boot MVC framework, implemented as part of Udacity's Java Developer Nanodegree program.

## Background
For those who may not know, WebSocket is a communication protocol that makes it possible to establish a two-way communication channel between a server and a client. In this project, starter code was provided for both the front and backends. See "Work Completed" below for more specifics as to what was implemented.

## Work Completed
### Implemented the message model
The message model is the message payload that is exchanged between the client and the server. Implemented the Message
class in the chat module.  Three basic actions are covered:
1. ENTER
2. CHAT
3. LEAVE

### Completed WebSocketChatServer
Made changes inside WebSocketChatServer in order to implement each method's description.

### Run the application with command
mvn build; mvn spring-boot:run

### Access the login page
http://localhost:8080

