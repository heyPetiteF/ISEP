# ICMP Messages #
Internet Control Message Protocols (ICMPs) 可同时用于 IPv4 和 IPv6。

ICMPv4（ IPv4 的消息协议）和 ICMPv6（IPv6 的消息协议）通用的 ICMP 消息包括：

1. **Host reachability**：ICMP Echo Message 可用于测试 IP 网络上主机的可达性

2. **Destination or Service Unreachable**：主机或网关收到无法传送的数据包时使用 ICMP 目的地不可达消息通知源主机。

    ICMPv4 的目的地不可达代码：
    - 0 - Net unreachable
    - 1 - Host unreachable
    - 2 - Protocol unreachable
    - 3 - Port unreachable

    ICMPv6 的目的地不可达代码：
    - 0 - No route to destination
    - 1 - Communication with the destination is administratively prohibited (e.g., firewall)
    - 2 – Beyond scope of the source address
    - 3 - Address unreachable
    - 4 - Port unreachable

3. **Time exceeded**
    - 路由器使用 ICMPv4 超时消息表明，因为数据包的生存时间 (TTL) 字段递减到 0 而不能转发该数据包。
    - ICMPv6使用IPv6跳数限制字段来确定数据包是否超时。

## ICMPv6 Messages ##
ICMPv6 includes four new protocols as part of the Neighbor Discovery Protocol (ND or NDP).

1. IPv6 路由器和 IPv6 设备之间的消息传递，包括动态地址分配：
    - Router Solicitation (RS) message
    - Router Advertisement (RA) message

2. IPv6 设备之间的消息传递，包括重复的地址检测和地址解析：
    - Neighbor Solicitation (NS) message
    - Neighbor Advertisement (NA) message

3. ICMPv6 ND also includes the redirect message


# Ping and Traceroute Testing #
使用ping进行的连通性测试的类型包括:
    - Pinging the local loopback
    - Pinging the default gateway
    - Pinging the remote host

