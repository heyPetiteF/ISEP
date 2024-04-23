# Transportation of Data #
## Role of the Transport Layer ##
1. 传输层负责在不同主机上运行的应用程序之间进行的逻辑通信。

2. 传输层不了解: 目标主机类型、数据必须经过的介质类型、数据使用的路径，链路拥塞情况或网络大小。

3. The transport layer includes two protocols:
    - Transmission Control Protocol (TCP)
    - User Datagram Protocol (UDP)

## Transport Layer Responsibilities ##
1. The transport layer has many responsibilities 
    - Tracking Individual Conversations 跟踪会话
    - Segmenting Data and Reassembling Segments数据分段和重组
    - Add Header Information 添加头信息
    - Identifting the Applications 标识应用
    - Conversation Multiplexing 会话多路复用

## Transport Layer Protocols ##
- Transport layer protocols specify how to transfer messages between hosts, and are responsible for managing reliability requirements of a conversation.

- IP 只涉及数据包的结构、地址分配和路由且不指定数据包的传送或传输方式。

![](./IMG/Transport%20Layer%20Protocols.png)

1. Transmission Control Protocol (TCP)
    - **可靠性和完整性**：TCP是一个可靠的、功能全面的传输层协议，确保所有数据能够准确送达目的地。
    - **数据分段**：TCP将数据划分为多个段进行传输。
    - **数据跟踪和确认**：TCP包含用于确保应用数据送达的字段，这些字段要求发送和接收主机进行额外处理。
    - TCP 使用以下基本操作提供可靠性和流量控制：
        - 编号并跟踪从特定应用程序发送到特定主机的数据段。
        - 确认收到数据
        - 一定时间段后重新传输未确认的数据
        - 有顺序的数据可能以错误的顺序到达 以接收方可以接受的有效速率发送数据
    - TCP的连接导向特性：
        - **建立连接**：为了维护会话的状态和跟踪信息，TCP首先在发送者和接收者之间建立连接。
        - **“包裹跟踪”**：TCP的传输类似于源自发送地到目的地的包裹跟踪。如果一个订单被分成多个包裹发送，客户可以在线检查递送顺序。

2. User Datagram Protocol (UDP)
    - **简单的传输层协议**：UDP比TCP更简单，不提供可靠性和流量控制，因此需要的头部字段更少。
    - **快速处理**：由于发送方和接收方的UDP进程不需要管理可靠性和流量控制，UDP数据报可以比TCP段更快地被处理。
    - **基本数据传输** ：UDP提供应用间传递数据报的基本功能，开销小，数据检查也很少。
    - **数据划分**：UDP将数据分割成称为数据报或段的单位。
    - **无连接协议**：UDP不提供可靠性或流量控制，因此不需要建立连接。
    - **无状态协议**：UDP不跟踪客户端和服务器之间发送或接收的信息，因此被称为无状态协议
    - **最佳努力递送**：UDP被称为最佳努力递送协议，因为它不保证数据在目的地被接收。
    - **无传输层确认**：使用UDP时，没有传输层过程通知发送方数据是否成功送达。
    - **“普通邮寄”**：使用UDP发送数据就像寄一封普通、无登记的信件。寄件人不知道收件人是否能收到信件，邮局也不负责追踪信件或通知寄件人信件是否送达目的地。

# Port Numbers #
1. TCP和UDP的端口使用
    - **多重会话管理**：TCP和UDP传输层协议使用端口号来管理多个同时发生的会话。
    - **头部字段**：TCP和UDP的头部字段中包含源端口号和目的端口号，每个端口号占2字节。
2. 端口号的作用
    - **源端口号**：与本地主机上发起应用程序相关联，用于唯一标识会话。例如**网络请求**：当主机发起网络页面请求时，源端口号由主机动态生成，用于唯一标识该会话。
    - **目的端口号**：与远程主机上的目的应用程序相关联。
    - **服务类型标识**：在请求中，目的端口号用于标识请求目的地服务器的服务类型。

# TCP Communication Process #
## TCP Server Processes ##
1. Clients Sending TCP Requests 客户端发送 TCP 请求
2. Request Destination Ports 请求的目的端口
3. Request Source Ports 请求源端口
4. Response Destination Ports 响应的目的端口
5. Response Source Ports 响应的源端口

## TCP Connection Establishment ##
1. **SYN** 源客户端请求与服务器进行客户端-服务器通信会话。
2. **ACK and SYN** 服务器确认客户端-服务器通信会话，并请求服务器-客户端通信会话。
3. **ACK** 源客户端确认服务器-客户端通信会话。

## Session Termination ##
1. **FIN** 当客户端的数据流中没有其他要发送的数据，将发送带 FIN 标志设置的分段。
2. **ACK** 服务器发送 ACK 信息，确认收到从客户端发出的请求终止会话的 FIN 信息。
3. **FIN** 服务器向客户端发送 FIN 信息，终止从服务器到客户端的会话。
4. **ACK** 客户端发送 ACK 响应信息，确认收到从服务器发出的 FIN 信息。
5. 当所有数据段得到确认后，会话关闭。
