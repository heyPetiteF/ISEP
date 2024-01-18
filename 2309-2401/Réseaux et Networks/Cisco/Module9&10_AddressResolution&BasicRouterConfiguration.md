# Address Resolution

## Destination on Same Network

two primary addresses assigned to a device on an Ethernet LAN:

* **Physical address** (the MAC address) 

    Used for NIC to NIC communications on the same Ethernet network.

* **Logical address** (the IP address) 

    Used to send the packet from the source device to the destination device. The destination IP address may be on the same IP network as the source or it may be on a remote network.

Layer 2 physical addresses (i.e., Ethernet MAC addresses) are used to deliver the data link frame with the encapsulated IP packet from one NIC to another NIC that is on the same network.

If the destination IP address is on the same network, the destination MAC address will be that of the destination device.

The Layer 2 Ethernet frame contains the following:

* Destination MAC address 
* Source MAC address

The Layer 3 IP packet contains the following:

* Source IPv4 address 
* Destination IPv4 address 

## Destination on Remote Network

When the destination IP address (IPv4 or IPv6) is on a remote network, the destination MAC address will be the address of the host default gateway (i.e., the router interface).

the IP addresses of the IP packets in a data flow associated with the MAC addresses on each link along the path to the destination:
* For IPv4 packets, this is done through a process called Address Resolution Protocol (ARP). 
* For IPv6 packets, the process is ICMPv6 Neighbor Discovery (ND).

## ARP Overview

Every IP device on an Ethernet network has a unique Ethernet MAC address. 

When a device sends an Ethernet Layer 2 frame, it contains these two addresses:

* **Destination MAC address** 

    The Ethernet MAC address of the destination device on the same local network segment. 

    If the destination host is on another network, then the destination address in the frame would be that of the default gateway (i.e., router).

* **Source MAC address** 

    The MAC address of the Ethernet NIC on the source host.

To send a packet to another host on the same local IPv4 network, a host must know the IPv4 address and the MAC address of the destination device, **MAC addresses must be discovered**.

A device uses **Address Resolution Protocol (ARP)** to determine the destination MAC address of a local device when it knows its IPv4 address.

ARP provides two basic functions:

* Resolving IPv4 addresses to MAC addresses
* Maintaining a table of IPv4 to MAC address mappings

## ARP Functions

When a packet is sent to the data link layer to be encapsulated into an Ethernet frame, the device refers to a table in its memory to find the MAC address that is mapped to the IPv4 address. This table is stored temporarily in RAM memory and called the ARP table or the ARP cache.

The sending device will **search its ARP table** for a destination IPv4 address and a corresponding MAC address.

* If the packet's destination IPv4 address is on the same network as the source IPv4 address, the device will search the ARP table for the destination IPv4 address.
* If the destination IPv4 address is on a different network than the source IPv4 address, the device will search the ARP table for the IPv4 address of the default gateway.

If the device locates the IPv4 address, its corresponding MAC address is used as the destination MAC address in the frame. 

If there is no entry is found, then the device sends an 
ARP request.

ARP messages are encapsulated directly within an Ethernet frame. There is no IPv4 header. The ARP request is encapsulated in an Ethernet frame using the following header information:

* **Destination MAC address** 

    This is a broadcast address **FF-FF-FF-FF-FF-FF** requiring all Ethernet NICs on the LAN to accept and process the ARP request.

* **Source MAC address** 

    This is MAC address of the sender of the ARP request.

* **Type** 

    ARP messages have a type field of **0x806**. This informs the receiving NIC that the data portion of the frame needs to be passed to the ARP process.

ARP requests are **broadcasts**, they are flooded out **all ports** by the switch, **except the receiving port**.

All Ethernet NICs on the LAN process broadcasts and must deliver the ARP request to its operating system for processing. 

**Every device must process the ARP request** to see if the target IPv4 address matches its own. A router will not forward broadcasts out other interfaces.

Only one device on the LAN will have an IPv4 address that matches the target IPv4 address in the ARP request. All other devices will not reply.

## ARP Operation - ARP Reply

Only the device with the target IPv4 address associated with the ARP request will respond with an ARP reply. 

The ARP reply is encapsulated in an Ethernet frame using the following header information:

* **Destination MAC address** 

This is the MAC address of the sender of the ARP request.

* **Source MAC address** 

This is the MAC address of the sender of the ARP reply.

* **Type** 

ARP messages have a type field of **0x806**. This informs the receiving NIC that the data portion of the frame needs to be passed to the ARP process.

* Only the device that originally sent the ARP request will receive the unicast ARP reply. After the ARP reply is received, the device will add the IPv4 address and the corresponding MAC address to its ARP table. Packets destined for that IPv4 address can now be encapsulated in frames using its corresponding MAC address.

* If no device responds to the ARP request, the packet is dropped because a frame cannot be created. The times differ depending on the operating system of the device.

* Entries in the ARP table are time stamped. If a device does not receive a frame from a particular device before the timestamp expires, the entry for this device is removed from the ARP table.*

## ARP Tables on Networking Devices
On a Cisco router used to display the ARP table, as shown in the figure: 

```
show ip arp
```

On a Windows 10 PC, the command is used to display the ARP table, as shown in the figure:
```
arp –a 
```

## ARP Broadcasts and ARP Spoofing

* As a broadcast frame, an ARP request is received and processed by every device on the local network, if **a large number** of devices were to be powered up and all start accessing network services at the same time, there could be some **reduction in performance for a short period of time**. After the devices send out the initial ARP broadcasts and have learned the necessary MAC addresses, any impact on the network will be minimized.

* In some cases, the use of ARP can lead to a potential security risk. A threat actor can use ARP spoofing to perform an ARP poisoning attack.

## IPv6 Neighbor Discovery Messages (ND or NDP)

ND provides address resolution, router discovery, and redirection services for IPv6 using ICMPv6. ICMPv6 ND uses five ICMPv6 messages to perform these services:

* Neighbor Solicitation messages
* Neighbor Advertisement messages
* Router Solicitation messages
* Router Advertisement messages
* Redirect Message

Neighbor Solicitation and Neighbor Advertisement messages are used for device-to-device messaging such as address resolution. Devices include both host computers and routers.

Router Solicitation and Router Advertisement messages are for messaging between devices and routers. Typically router discovery is used for dynamic address allocation and stateless address autoconfiguration (SLAAC).

## IPv6 Neighbor Discovery - Address Resolution

ICMPv6 Neighbor Solicitation and Neighbor Advertisement messages are used for MAC address resolution.

ICMPv6 Neighbor Solicitation messages are sent using special Ethernet and IPv6 multicast addresses. This allows the Ethernet NIC of the receiving device to determine whether the Neighbor Solicitation message is for itself without having to send it to the operating system for processing.

# Basic Router Configuration

1. If a router cannot locate the startup-config file in NVRAM it will enter setup mode to allow the configuration to be entered from the console device.

2. The command is used to encrypt all passwords in a router configuration file:
    ```
    Router_A(config)# service password-encryption
    ```

3. The privileged exec password is trustknow1. The command achieves the goal of providing the highest level of security:
    ```
    enable secret trustknow1
    ```

4.  the response from the router after the command is entered :
    ```
    > router(config)# hostname portsmouth
    > portmouth(config)#
    ```

5. set of commands will allow the required login using a password of cisco:
    ```
    Router(config)# line console 0
    Router(config-line)# password cisco
    Router(confg-line)# login
    ```

6. command can be used on a Cisco router to display all interfaces, the IPv4 address assigned, and the current status:
    ```
    show ip interface brief
    ```

7. The CLI mode allows users to access all device commands, such as those used for configuration, management, and troubleshooting: privileged EXEC mode

8. the purpose of the startup configuration file on a Cisco router: to contain the commands that are used to initially confgure a router on startup

9. The characteristic describes the default gateway of a host computer: the logical address of the router interface on the same network as the host computer.

10. ```
    banner motd //is used to display a message when a user attempts to log into the router.
    ```
    It provides a way to make announcements to those who log in to a router.

11. The command login is used to allow access to a router or switch through aux lines, console lines, and Telnet lines -> any line configuration mode.

12. The Cisco IOS is stored in flash.
    * The running configuration file is stored in RAM.
    * The bootup instructions are stored in ROM.
    * The startup configuration file is stored in NVRAM.

13. As soon as the command is entered, all currently set passwords formerly displayed in plain text are encrypted:
    ```
    service password-encryption
    ```