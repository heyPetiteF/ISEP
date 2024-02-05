# Application, Presentation, and Session #
## Application Layer ##
![](./IMG/Application%20Layer.png)
- Application layer protocols are used to exchange data between programs running on the source and destination hosts.
- Based on the TCP/IP model, the upper three layers of the OSI model (application, presentation, and session) define functions of the TCP/IP application layer.

## Presentation Layer ##
1. 表示层功能：
    - Formatting, or presenting, data at the source device into a compatible format for receipt by the destination device. 【格式化】
    - Compressing data in a way that can be decompressed by the destination device. 【压缩】
    - Encrypting data for transmission and decrypting data upon receipt. 【加密】

## Session Layer ##
1. Functions at the session layer create and maintain dialogs between source and destination applications. 
2. 用于处理信息交换、发起对话、重启会话

## TCP/IP Application Layer Protocols ##
TCP/IP协议栈中应用层的不同协议及其功能：
1. **Name System**
    1. DNS - 域名系统（或服务）
        - TCP, UDP 53 
        - Translates domain names into IP addresses.
    
2. **Host Config**
    1. BOOTP - Bootstrap Protocol
        - UDP client 68, server 67
        - Enables a diskless workstation to discover its own IP address, the IP address of a BOOTP server on the network, and a file to be loaded into memory to boot the machine
        - BOOTP is being superseded by DHCP

    2. DHCP - Dynamic Host Configuration Protocol
        - UDP client 68, server 67
        - Dynamically assigns IP addresses to be re-used when no longer needed

3. **Email**
    1. SMTP - Simple Mail Transfer Protocol
        - TCP 25
        - Enables clients to send email to a mail server
        - Enables servers to send email to other servers

    2. POP3 - Post Office Protocol
        - TCP 110
        - Enables clients to retrieve email from a mail server
        - Downloads the email to the local mail application of the client

    3. IMAP - Internet Message Access Protocol
        - TCP 143
        - Enables clients to access email stored on a mail server
        - Maintains email on the server

4. **File Transfer**
    1. FTP - File Transfer Protocol
        - TCP 20 to 21
        - Sets rules that enable a user on one host to access and transfer files to and from another host over a network
        - FTP is a reliable, connection-oriented, and acknowledged file delivery protocol
        - TFTP - Trivial File Transfer Protocol

    2. UDP client 69
        - A simple, connectionless file transfer protocol with best-effort, unacknowledged file delivery
        - It uses less overhead than FTP

5. **Web**
    1. HTTP - Hypertext Transfer Protocol
        - TCP 80, 8080
        - A set of rules for exchanging text, graphic images, sound, video, and other multimedia files on the World Wide Web

    2. HTTPS - HTTP Secure
        - TCP, UDP 443
        - The browser uses encryption to secure HTTP communications
        - Authenticates the website to which you are connecting your browser

# Peer-to-Peer #
## Client-Server Model ##

# Web and Email Protocols #

# IP Addressing Services #

# File Sharing Services #