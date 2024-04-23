# IPv4 and IPv6 Coexistence #
1. **Dual stack** allows IPv4 and IPv6 to coexist on the same network segment. (only dual stack) use native IPv6 connectivity.

2. **Tunneling** is a method of transporting an IPv6 packet over an IPv4 network. IPv6数据包封装在IPv4数据包中。 

3. **Network Address Translation 64 (NAT64)** allows IPv6-enabled devices to communicate with IPv4-enabled devices using a translation technique similar to NAT for IPv4.  IPv6数据包 $\Leftrightarrow$ IPv4数据包。

4. Tunneling and translation are for transitioning to native IPv6 and should only be used where needed. The goal should be native IPv6 communications from source to destination.

# IPv6 Address Representation #
## IPv6 Addressing Formats ##
1. 首选格式：x:x:x:x:x:x:x:x，每个“x”均包括四个十六进制值。
2. 规则1：省略前导0
3. 规则2：双冒号(::)替换任何由一个或多个全由 0 组成的16 位十六进制数组成的连续字符串，仅可在每个地址中使用一次。

# IPv6 Address Types #
## Unicast, Multicast, Anycast ##
1. Unicast - An IPv6 unicast address uniquely identifies an interface on an IPv6-enabled device. 单播地址用于唯一标识IPv6启用设备上的一个接口。

2. Multicast - An IPv6 multicast address is used to send a single IPv6 packet to multiple destinations. 多播地址用于将单个IPv6数据包发送到多个目的地。

3. Anycast - An IPv6 anycast address is any IPv6 unicast address that can be assigned to multiple devices. A packet sent to an anycast address is routed to the nearest device having that address.

## IPv6 Prefix Length ##
1. 前缀长度：/0 - /128
2. 一般前缀为 /64， 接口ID为后64位。

## Types of IPv6 Unicast Addresses ##
1. Global Unicast Address (GUA) 全局单播地址：
    - 地址具有全局唯一性,可在 IPv6互联网上路由
    - 互联网可路由地址
    - 可静态配置or动态分配
    - GUA有三个部分：
        - Global Routing Prefix：全局路由前缀为提供商（如 ISP）分配给客户或站点的地址的前缀或网络部分。
        - Subnet ID：子网ID字段是全局路由前缀和接口ID之间的区域。【用于子网划分】
        - Interface ID：IPv6 的主机部分（单个主机可能有多个接口）。

2. Link-local Address (LLA) 链路本地地址：
    - 每个启用 IPv6 的网络接口必备
    - 用于与同一链路（子网）中的其他设备通信
    - 仅限于单个链路
    - 唯一性仅在该链路上得到保证（不具有可路由性）
    - 用途：路由使用LLS向相邻路由器发送更新；主机使用本地路由LLA作为默认网关
    - LLA可通过静态获取（手动配置）or 动态获取（通过使用随机生成的值或使用扩展唯一标识符 (EUI) 方法创建自己的接口 ID，该方法使用客户端 MAC 地址和其他位）。
    - 以fe80开头。

3. 通常情况下，用作链路上其他设备的默认网关的是路由器的LLA而不是GUA。

# Dynamic Addressing for IPv6 GUAs #
- Router Solicitation (RS) 请求寻址信息的主机 => 所有IPv6路由器。
- Router Advertisement (RA) 被发送到所有的IPv6节点，位于IPv6路由器以太网接口上。

## ICMPv6 RA message ##
1. 消息包括：
    - Network prefix and prefix length 网络前缀和前缀长度: 告知设备其所属的网络。
    - Default gateway address 默认网关:IPv6 LLA，RA 消息的源 IPv6 地址。
    - DNS addresses and domain name DNS 地址和域名: DNS 服务器的地址和域名。

2. 三种方法：
    - SLAAC：
        - 允许设备在没有DHCPv6服务（非必需项）的情况下创建GUA：前缀（RA告知）+接口ID（PC通过EUI-64或随机生成创建）
        - 设备根据本地路由器的 ICMPv6 路由器通告 (RA) 消息获取必要信息
        - 没有中央服务器 => stateless
    
    - SLAAC and Stateless DHCPv6：
        - SLAAC创建自己的IPv6 GUA
        - 路由器LLA是RA源IPv6地址，作为默认网关地址
        - 使用无状态 DHCPv6 服务器获取其他信息

    - Stateful DHCPv6：
        - 路由器LLA即RA源IPv6地址，作为默认网关地址。
        - 有状态 DHCPv6 服务器获取GUA、DNS 服务器地址、域名和其他必要信息。

# IPv6 Multicast Addresses #
1. 两种常见的 IPv6 分配组播组
    - ff02::1 All-nodes multicast group 全节点组播组：
        - 包含所有支持 IPv6 的设备
        - IPv6 路由器将ICMPv6 RA 消息发送给全节点组播组。
    - ff02::2 All-routers multicast group 全路由器组播组：
        - 所有IPv6路由器加入
        - 发送到该组的数据包由该链路或网络上的所有 IPv6 路由器接收和处理。

2. 请求节点组播地址:
    - 类似于全节点组播地址
    - 优势在于它被映射到特殊的以太网组播地址 => 使以太网网卡可以通过检查目的 MAC 地址过滤该帧
