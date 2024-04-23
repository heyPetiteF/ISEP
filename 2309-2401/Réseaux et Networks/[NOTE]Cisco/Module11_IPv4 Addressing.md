# IPv4 Address Structure #
## IPv4 Address ##
1. An IPv4 address is a 32-bit hierarchical address:
    Network Portion + Host Portion.

2. All devices in the same network $\Leftrightarrow$ The bits within the network portion of the address identical.

3. The bit within the host portion of the address must be unique.

## The Subnet Mask ###
1. assigning an IPv4 address to a host requires the following:
    - IPv4 address: 主机唯一的IPv4地址
    - Subnet mask：标识网络部分/主机部分

2. A default gateway IPv4 address is required to reach remote networks. 

    默认网关作为访问外部网络的出口。在一个网络中，默认网关是一个网络节点，它允许与其他网络的通信。如果你的电脑或设备要发送数据到另一个不在本地网络的设备，数据首先会发送到这个默认网关。

3. DNS server IPv4 addresses are required to translate domain names to IPv4 addresses. 

    域名系统（DNS）是互联网上的一种服务，它将易于记忆的域名转换为机器可识别的IP地址。

4. the subnet mask is a consecutive sequence of 1 bits followed by a consecutive sequence of 0 bits.

    - 子网掩码的连续1序列表示IPv4的网络部分，亦称前缀（The Prefix）。表示为：
    ```
    /（网络部分位数）
    ```
    
    - 连续0序列表示IPv4的主机部分。

    - IP地址的网络部分 = （二进制）IP地址 AND （二进制）子网掩码

## IP addresses ##
Within each network are three types of IP addresses:
- Network address
- Host addresses
- Broadcast address

### Network address ###
1. 网络位+主机位全全为0
判断设备是否属于特定一网络：
    - same subnet mask 相同的子网掩码
    - same network bits  相同的网络位
    - on the same broadcast domain 位于同一广播域

### Host addresses ###
1. Host addresses are addresses that can be assigned to a device.

2. Host addresses can have any combination of bits in the host portion (除了全0位作为网络地址和全1位作为广播位)。
    - 首个主机地址：网络位.00...01
    - 末个主机地址：网络为.11...10

### Broadcast address ###
1. 网络位+主机位全全为1
2. A broadcast address is an address that is used when it is required to reach all devices on the IPv4 network. 

3. A broadcast address cannot be assigned to a device.

# IPv4 Unicast, Broadcast, and Multicast #
## Unicast ##
1. Unicast transmission refers to one device sending a message to one other device in one-to-one communications. 一对一通信。

2. A unicast packet：
    - A source IP address 源IP地址【单播】
    - A destination IP address 目的地IP地址【单播】

## Broadcast ##
1. Broadcast transmission refers to a device sending a message to all the devices on a network in one-to-all communications.一对多通信。

2. A broadcast packet：
    - A source IP address 源IP地址【单播】
    - destination IP address with all "1" in the host portion 目的地IP地址【主机位全为1】

3. 广播数据包仅限同一广播域内的设备处理，且会传输到同一广播域内的所有设备上。默认情况下路由不转发 => 限制在单个网络内/子网中。

4. - 定向广播：发送到特定网络上所有主机的广播，IP为 网络地址+主机位全为1

    - 限制性广播：发送到地址 255.255.255.255 的广播，向当前网络上所有设备发送信息。

5. 默认关闭定向广播功能指令：
    ```
    no ip directed-broadcast
    ```

## Multicast ##
1. Multicast transmission reduces traffic by allowing a host to send a single packet to a selected set of hosts that subscribe to a multicast group. 一个发送者向特定的多播组地址发送单个数据包，这个包被网络中订阅了该地址的所有成员接收。

2. A multicast packet：
    - A source IP address 源IP地址【单播】
    - destination IP address that is a multicast address 目的地IP地址（组播地址）【组播地址在IPv4中为224.0.0.0 - 239.255.255.255】

3. 当IPv4主机加入组播组后，该主机需处理：
    - 源IP地址发送来的数据包（组内信息）
    - 发往其唯一单播地址的数据包（个人信息）

# Types of IPv4 Addresses #
## Public IPv4 Addresses ##
1. Public IPv4 addresses are addresses which are globally routed between internet service provider (ISP) routers. 
    公共IPv4地址是唯一的，并可用于互联网。

2. 并非所有可用的IPv4地址都可用于互联网。

## Private IPv4 Addresses ##
1. Private IPv4 addresses are not unique and can be used internally within any network. 

    私有IPv4地址非唯一，主要用于组织内部，不可全局路由，不消耗公共IPv4的地址空间。
2. 任何组织都可以使用私有IPv4地址。 

## Routing to the Internet ##
1. 私有地址 => 公共地址
    - 当内部网络中的设备需要与互联网上的设备通信时，其数据包的源地址（私有地址）需要被转换为公共地址。
    - Network Address Translation (NAT) 用于完成私转公，从而允许使用私有地址的设备访问互联网。

2. 私有地址连接互联网：The IETF does not consider private IPv4 addresses or NAT as effective security measures.

## Special Use IPv4 Addresses ##
特殊用途的IPv4地址不被认为是公有。
1. Loopback addresses 环回地址
   - Loopback addresses (127.0.0.0 /8 or 127.0.0.1 to 127.255.255.254)通常仅被标识为127.0.0.1
   - 主机使用这些特殊地址将流量指向其自身。

2. Link-Local addresses 本地链路地址
    - Link-local addresses (169.254.0.0 /16 or 169.254.0.1 to 169.254.255.254) 
    - 通常称为the Automatic Private IP Addressing (APIPA)或self-assigned addresses.
    - 当没有可用的DHCP服务器时，Windows DHCP客户端使用它们进行自我配置。

## Legacy Classful Addressing ##
1. A 类 (0.0.0.0/8 - 127.0.0.0/8) 用于超大规模网络
2. B 类 (128.0.0.0 /16 – 191.255.0.0 /16) 用于中大型网络
3. C 类 (192.0.0.0 /24 – 223.255.255.0 /24) 用于小型网络
4. D类(224.0.0.0 - 239.0.0.0) 组播块
5. E类(240.0.0.0 – 255.0.0.0 )实验地址块

## Assignment of IP Addresses ##
1. Internet Assigned Numbers Authority (IANA) manages and allocates blocks of IP addresses to the Regional Internet Registries (RIRs).

2. RIR 的职责是向 ISP 分配 IP 地址，而 ISP 将向组织和更小的 ISP 提供 IPv4 地址块。

3. 根据 RIR 的政策规定，组织也可直接从 RIR 获取地址。

## Determine public or private ##
以下是私有IPv4地址的主要范围：

1. 10.0.0.0 - 10.255.255.255：
    - 子网掩码：255.0.0.0
    - 这个范围包含了大约1600万个私有地址。
2. 172.16.0.0 - 172.31.255.255：
    - 子网掩码：255.240.0.0
    - 这个范围包含了大约100万个私有地址。
3. 192.168.0.0 - 192.168.255.255：
    - 子网掩码：255.255.0.0
    - 这个范围包含了大约65000个私有地址。

# Network Segmentation #
## Broadcast Domains and Segmentation ##
1. In an Ethernet LAN：
    - devices use broadcasts and the Address Resolution Protocol (ARP) to locate other devices.
    - ARP 地址解析协议将第2层广播发送到本地网络上的已知 IPv4 地址，以发现相关 MAC 地址。
    - 主机通常使用DHCP来获取其IPv4地址配置，DHCP通过在本地网络上发送广播来定位DHCP服务器。

2. Switches & broadcasts：
    - 当交换机接收到广播时，它会将广播转发到除了接收广播的接口之外的所有接口 => 连接到该交换机的所有其他设备均会收到广播。

3. Routers Segment Broadcast Domains：
    - 路由器不传播广播。
    - 每个路由器接口连接到一个广播域，广播只在该特定的广播域内传播。

## Problems with Large Broadcast Domains ##
1. 大型广播域的问题：
    - 大型广播域连接许多主机，可能会产生过多的广播流量。
    - 过多的广播流量会导致网络操作变慢。
    - 设备需要接收并处理每个广播数据包，这也可能导致设备操作变慢。

2. 解决方案【划分子网】。
   
# Subnet an IPv4 Network #
1. 划分目的：
    - 划分子网即将一个大型网络划分为更小、更易管理的广播域。
    - 划分后广播仅在更小的广播域内传播，从而减少了广播流量，提高网络效率，并可以提供更好的网络安全性。
    - 划分原理：通过改变前缀长度（如从/16到/24），使用主机位来创建额外的子网。

2. 划分方法：
    - 通过借用主机位作为网络位来扩展子网掩码，从而创建子网。
    - 网络最容易在八位字节（octet）边界上进行子网划分，即/8、/16和/24。
    - 子网掩码的不同前缀长度决定了子网中可用的主机数量。

3. 划分计算步骤：
    - 计算所需的主机位数n：$2^n - 2 \geq 所需主机数$。
    - 子网掩码：前$(32-n)$位为网络位（置1），后$n$位为主机位（置0）。
    - 将子网掩码转换为十进制。

# Variable Length Subnet Masking (VLSM) #
1. 传统子网划分的局限性：
    - 传统子网划分为每个子网分配相同数量的地址，可能导致地址浪费。
2. VLSM的优势：
    - 更灵活地划分子网，根据实际需要为每个子网分配不同数量的地址。
    - 避免传统子网划分中的地址浪费问题。
3. 子网划分原则：
    - 优先满足最大子网的主机需求。
    - 继续划分直到满足最小子网的需求。

## VLSM Topology Address Assignment ##
1. 有效的地址分配：通过VLSM，局域网（LAN）和路由器间网络的IPv4地址分配可以实现无不必要浪费。

2. VLSM拓扑的具体配置：
    - 确定网络需求: 分析所需子网数、每个子网中的主机数，以确定地址空间。
    - 进行子网划分：根据主机数量的需求，首先划分需求最大的子网；对需求较少的子网使用更长的子网掩码进行划分。
    - 计算子网掩码。
    - 分配IP地址。
    - 考虑路由和管理。

# Structured Design #
1. 网络需求研究
    - 全面审视网络：研究整个网络，包括内部网和DMZ，以确定每个区域的分割方式。
    - 地址规划：确定哪些区域需要严格的地址保留（如DMZ中的公有IPv4地址空间），哪些区域可以更灵活地使用地址（如内部网）。

2. 子网需求和VLSM应用
    - 确定子网数量和大小：基于每个子网的需求，确定需要多少个子网以及每个子网需要多少主机。
    - 使用VLSM：在需要地址保留的区域，如DMZ，采用可变长度子网掩码（VLSM）进行更有效的地址分配。

3. 主机地址分配
    - 静态与动态地址分配：决定哪些主机需要静态IPv4地址，哪些可以使用DHCP动态获取地址。
    - 管理地址分配：包括如何分配主机地址，防止地址重复，同时便于监控和管理地址以提高性能和安全性

4. 设备类型和地址分配
    - 最终用户设备：客户端、服务器和外部设备。
    - 互联网可访问服务器：需要特别考虑的设备，可能需要特定的地址分配。
    - 中间设备和网关：如路由器和交换机，可能需要特定范围的地址。

5. 固定模式的地址分配
    - 设备分类：使用固定模式为不同类型的设备分配地址。
    - 简化管理：这种方法有助于添加和删除设备、根据IP过滤流量，以及简化网络文档和管理。