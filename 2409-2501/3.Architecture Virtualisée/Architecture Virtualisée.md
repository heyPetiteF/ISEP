# **5G and Telcos Softwarization**
1. Technology:
    - 1G: Analog
    - 2G: Digital(GSM,CDMA)
    - 3G: Digital(Universal Mobile Telecommunications System(UMTS)-欧洲及其他地区；CDMA2000-北美和亚洲)
    - 4G: LTE(Long-Term Evolution), LTE-A
    - 5G: NR(New Radio)
![1G-5G](./IMG/evolution-des-reseaux-mobiles-des-technologies-et-des-usages.jpg)

2. 下载时间（s）= 文件大小（bit）/ 网络速度（bps）
    $$
    1 \text{ GB} = 1024 \text{ MB} = 1024^2 \text{ KB} = 1024^3 \text{ Byte} = 1024^3 \times 8 \text{ bit}
    $$

3. Standardization Bodies:
    - Telecom standardization bodies are organizations that develop and promote technical standards for telecommunications.
    - These standards ensure interoperability, safety, and efficiency in communication systems.

        - **TM Forum (TeleManagement Forum)**: 全球电信行业的非营利性组织，致力于帮助通信服务提供商和数字服务提供商转型。它提供一套标准和框架，如 Frameworx，用于业务流程管理、系统集成和数字化转型。
        - **GSMA (Global System for Mobile Communications Association)**: 全球移动通信系统协会，是一个代表全球移动通信运营商和公司利益的行业组织。GSMA 负责制定 GSM、LTE 和 5G 等移动通信标准，并组织世界移动通信大会（MWC）等行业活动，促进移动通信产业的发展。
        - **3GPP (3rd Generation Partnership Project)**: 第三代合作伙伴计划，是一个由多个标准组织组成的合作项目，负责制定全球移动通信标准，包括3G（UMTS）、4G（LTE）和5G（NR）的技术规范。
        - **NGMN (Next Generation Mobile Networks Alliance)**: 下一代移动网络联盟，旨在确保移动通信网络的下一代技术满足用户需求。NGMN 联盟为运营商、制造商和研究机构提供一个平台，推动5G和未来移动通信网络的发展。
        - **CNCF (Cloud Native Computing Foundation)**: 云原生计算基金会，是一个致力于推广云原生技术的非营利性组织。CNCF 为电信行业提供了云原生架构、容器化和微服务等关键技术，以提高网络基础设施的灵活性和可扩展性。CNCF 支持并维护了一些关键项目，如 Kubernetes、Prometheus 和 Envoy，用于现代化电信网络的管理和运维。

4.  
- Enhanced Mobile Broadband

![Enhanced Mobile Broadband](./IMG/Enhanced%20Mobile%20Broadband.png)

- Enhanced Mobile eMBB

主要用于高带宽和高速数据传输的场景，如高清视频、VR/AR、流媒体和高速移动通信。

![Enhanced Mobile eMBB](./IMG/Enhanced%20Mobile%20eMBB.webp)

- Ultra Reliable Low Latency（URLLC）

用于需要超低延迟和高可靠性的场景，如触觉互联网、自动驾驶和远程医疗。

![Ultra Reliable Low Latency（URLLC）](./IMG/Ultra%20Reliable%20Low%20Latency.png)

- Massive Machine Type Communications (mMTC)

用于大量物联网设备的低功耗、低速率连接，如传感器网络和智能城市。

![Massive Machine Type Communications (mMTC)](./IMG/Massive%20Machine%20Type%20Communications%20(mMTC).png)

- NGMN use case groups
![5G use case families and related examples](./IMG/5G%20use%20case%20families%20and%20related%20examples.png)
    (1) Broadband access in dense areas（密集区域的宽带接入）
    - 应用场景：Pervasive Video 普遍视频。在城市中心、体育场馆等人流密集区域提供高质量的视频服务，满足高数据速率和带宽需求，如4K/8K视频直播、VR/AR体验等。
    - 关联5G特性：eMBB
    
    （2）Broadband access everywhere（随处可用的宽带接入）
    - 应用场景：50+ Mbps Everywhere（50Mbps以上的速率）。无论在城市、乡村还是高速公路上，5G都能提供稳定的宽带接入，确保用户在任何地方都能享受高速互联网连接。
    - 关联5G特性：eMBB

    （3）Higher user mobility（更高的用户移动性）
    - 应用场景：High Speed Train（高速列车）。在高速移动的环境中，如高铁，提供可靠的高速网络连接，确保用户在高速移动中仍然能够进行视频通话、流媒体等高带宽需求的活动。
    - 关联5G特性：eMBB

    （4）Massive Internet of Things（海量物联网）
    - 应用场景：Sensor Networks（传感器网络）。支持大量物联网设备的连接，如传感器网络，用于智能城市、环境监测、智能农业等场景。需要支持低功耗、低速率的大规模连接。
    - 关联5G特性：mMTC

    （5）Extreme real-time communications（极端实时通信）
    - 应用场景：Tactile Internet（触觉互联网）。需要超低延迟和高可靠性的通信场景，如触觉互联网、远程控制和自动驾驶等，要求毫秒级的延迟来保证实时响应。
    - 关联5G特性：URLLC

    （6）Lifeline communications（生命线通信）
    - 应用场景：Natural Disaster（自然灾害）。在自然灾害或紧急情况下提供可靠的通信服务，确保救援人员和灾区之间的通信畅通，支持紧急呼叫和定位等服务。
    - 关联5G特性：URLLC

    （7）Ultra-reliable communications（超可靠通信）
    - 应用场景：E-Health Services（电子健康服务）。需要极高可靠性和低延迟的通信服务，如远程医疗、手术机器人等场景，确保数据传输的准确性和及时性。
    - 关联5G特性：URLLC

    （8）Broadcast-like services（类似广播的服务）
    - 应用场景：Broadcast Services（广播服务）。提供类似广播的服务，如大型活动的实时流媒体广播，需要高带宽和广覆盖。
    - 关联5G特性：eMBB

5. IMT-2020(5G) vs. IMT-ADVANCED(4G)
![](./IMG/Enhancement-of-key-capabilities-from-IMT-Advanced-to-IMT-2020-71.png)
- **Peak Data Rate:** maximum rate per user underideal conditions. 10 Gbps for mobiles, 20 Gbpsunder certain conditions.
- **User experienced Data Rate:** 95% Rate across thecoverage area per user. 100 Mbps inurban/suburban areas.1 Gbps hotspot.
- **Spectrum Efficiency:** Throughput per Hz per cell
- **Mobility:** Max speed at which seamless handoverand QoS is quaranteed
- **Latency:** Radio contribution to latency betweensend and receive
- **Connection Density:** Devices per km2
- **Network Energy Efficiency:** Network bits per Joule.User bits per Joule
- **Area Traffic Capacity:** Throughput per m2

## Core Netword Evolution from 4G to 5G ###
1. UE(User Equipement): Smartphone，Tablet，Laptop，Wearable Devices，IoT Devices，In-Vehicle Systems，Fixed Wireless Access Devices，VR/AR Devices，USB Dongle，Mobile Hotspot
2. - User PLANE: 指网络中承载用户数据流的部分。它负责传输实际的用户数据，如网页浏览、视频流、语音通话等。这是网络中用于实际传输用户信息的路径。
        - 数据传输：在用户和互联网或其他通信方之间传递数据。
        - QoS（Quality of Service）：在传输过程中提供不同服务质量的保障，确保关键数据流的优先级。
        - 加密：为用户数据提供安全性，防止未经授权的访问。
    - Control PLANE: 指网络中负责控制信令和管理的部分。它负责控制和管理网络资源，包括用户的接入、移动性管理、建立和维护连接等。Control Plane 主要处理信令信息，决定如何传输用户数据。
        - 信令管理：管理信号传输，以便建立、维护和释放网络连接。
        - 会话管理：控制数据会话的建立、修改和终止，包括分配和管理 IP 地址。
        - 移动性管理：确保用户在移动过程中保持连接，提供漫游和切换等功能。
        - 资源分配：管理网络资源的分配和优化，以满足不同用户和服务的需求。

3. 4G vs 5G Functions - Gateways: 
    - SGW(Serving Gateway)
        - for 4G, handle mobility and session management
    
    - PGW
    
    - UPF(User Plane Function)
        - for 5G, replace SGW&PGW in 5G

![4G vs 5G Functions](./IMG/4G%20vs%205G%20Functions.PNG)

4. 5G system Service Based Architecture(SBA)

https://medium.com/5g-nr/5g-service-based-architecture-sba-47900b0ded0a

![5G system Service Based Architecture(SBA)](./IMG/5G%20System%20Architecture.webp)

    （1）AMF
    （2）UPF
    （3）PCF
    （4）AUSF
    （5）UDM-UDR
    （6）NRF
    （7）NEF
    （8）AF

![5G UE reaistration](./IMG/5G%20UE%20reaistration.png)

- UE Registration Steps:

    - **Step 1:**  
    The UE begins communication with the network, indicating its desire to register and access services (using UE Message).

    - **Step 2:**  
    The RAN chooses the AMF responsible for handling the UE’s registration. The RAN uses the UE’s location, requested NSSAI, and operator policies to determine the appropriate AMF.

    - **Step 3:**  
    - The RAN sends the UE’s registration request to the selected AMF over the N2 interface (UE message + cell ID + user location).

    - **Step 4 (optional):**  
    If the serving AMF has changed, this step ensures the new AMF gets all the necessary information about the UE from the old AMF.

    - **Step 5:**  
    The AMF chooses an AUSF (consulting the NRF) to perform authentication of the UE.  
    **Selection Criteria:** Based on the UE’s SUCI.

    - **Step 6:**  
    The AUSF uses the UE’s credentials and security information from the UDM (Unified Data Management) to authenticate the UE.

    - **Step 7:**  
    The AMF selects a Unified Data Management (UDM) (consulting the NRF) function to access subscriber-related information (SM, SDM, AM subscription).

    - **Step 8:**  
    AM policy control with PCF.

    - **Step 9:**  
    AMF sends a create SM context to SMF.

    - **Step 10:**  
    The SMF establishes the session with UPF.

    - **Step 11:**  
    UE access to data.

Purposes of Regustration:
    - Initial Access
    - Mobility 

## 5G NSA & 5G SA(Stand-Alone)

![](./IMG/5G%20NSA%20and%205G%20SA.png)

Only 5G core network (dependes form 4G)

# Virtuliztion Concepts
## 5G System Service Based Architecture (SBA)

**Service Based Architecture (SBA)** a.k.a. **Service Oriented Architecture (SOA)**

- **Standardized 标准化**:  
  Services within the same inventory (e.g., 5GC) are in compliance with the same contract design standards and have a standard communication agreement.

  服务在相同的目录中遵循相同的合约设计标准，并拥有统一的通信协议，保证不同服务之间的标准化通信。

- **Loosely coupled 松耦合**:  
  Inter-service contracts (e.g., NFs) dependency is minimized to the level that they are only aware of their existence. Interoperability between them is guaranteed.

   各服务之间的依赖性降到最低，服务间的互操作性得到了保证，减少了紧密依赖的复杂性。

- **Scalability 可扩展**:  
  Network functions are broken down into independent services, allowing for better scalability.

  网络功能被分解为独立的服务，使得网络具有更好的可扩展性，能够根据需要轻松扩展或缩减服务。

- **Reusable 可复用**:  
  Resources, logic, and functionalities are decomposed into multiple services to maximize code reusability.

  资源、逻辑和功能被分解为多个服务，以最大化代码和资源的可重用性。这样可以减少重复开发，提高效率。

- **Composable 可组合**:  
  Services can be composed to create new services (e.g., UPF chaining).

  不同的服务可以组合起来以创建新服务，通过不同服务的组合实现新的功能。

- **Autonomic 自律性**:  
  Services have the control over their resources and functionalities. Minimal (or zero) external dependencies.

  服务能够自主控制其资源和功能，尽量减少或消除对外部依赖的需求，使得系统更加独立运行。

- **Stateless 无状态**:  
  Services do not store state for too long (or at all) of a transaction. Requests are treated independently.

  服务不会长时间存储事务状态（甚至不存储），请求之间是独立处理的。这使得服务更容易扩展和处理并发请求。

- **Abstract 抽象性**:  
  Inner logic is completely transparent to the consumer.

  内部逻辑对使用者完全透明，用户不需要了解服务的实现细节，只需调用即可。

- **Discoverable 可发现**:  
  Services can be found and identified.

  服务可以被发现和识别，方便其他服务或功能调用这些服务。

## Virtualization Definitions

- Virtualization is the abstraction of the true underlying hardware or software from VM Operating System (OS), application, storage, or network.

- Since we cannot run two operating systems on the same hardware at the same time (OSs like to have full control!), virtualization makes an OS believe it’s running on its own physical machine and has full control of it.

  - VM OS is called **Guest OS**.
  - Physical machine OS is called **Host OS**.

## VMM（Virtual Machine Monitor，虚拟机监控器）
虚拟化技术的核心组件之一，负责管理和协调虚拟机在物理硬件上的运行。

VMM也被称为Hypervisor（虚拟机管理程序），其主要任务是将底层硬件资源（如CPU、内存、存储等）分配给多个虚拟机，并确保虚拟机之间的隔离和安全。

### 主要功能和作用
1. **硬件抽象**： VMM将底层的物理硬件资源虚拟化，向每个虚拟机提供一个独立的虚拟硬件环境。这样，虚拟机可以像在独立的物理服务器上运行一样，使用分配给它们的虚拟资源。

2. 资源管理与分配： VMM负责管理物理主机的资源（如CPU时间、内存、存储、网络带宽等），并将它们动态地分配给虚拟机。当虚拟机需要更多资源时，VMM可以调整分配，确保资源的最佳利用。

3. 虚拟机隔离： VMM确保虚拟机之间的隔离，防止一个虚拟机对另一个虚拟机的影响。即使某个虚拟机出现故障或遭到攻击，也不会影响到其他虚拟机的运行，保障了系统的安全性和稳定性。

4. 调度与性能优化： VMM负责对虚拟机的执行进行调度，确保所有虚拟机都能公平地获得物理资源。同时，VMM还通过调优技术（如内存压缩、CPU调度等）来提高虚拟化环境的整体性能。

5. 安全性与访问控制： VMM可以通过访问控制机制，限制虚拟机对物理资源的访问权限。它还可以通过安全策略（如沙箱、加密等）保护虚拟机及其数据免受外部攻击。

6. 虚拟化类型支持： VMM支持多种虚拟化技术，包括全虚拟化（Full Virtualization）、半虚拟化（Paravirtualization）和硬件辅助虚拟化（Hardware-Assisted Virtualization）。VMM选择适当的虚拟化技术，依据硬件支持和性能要求进行调配。

7. VMM分为两种主要类型：
    - 裸机虚拟化，Bare Metal Hypervisor
    - 托管型虚拟化，Hosted Hypervisor

### virtualization landscape
![](./IMG/virtualization%20landscape.png)
1. **Full Virtualization 完全虚拟化**:
    
    The hypervisor (virtual machine monitor) provides a complete simulation of the underlying hardware, allowing unmodified guest operating systems to run. Examples include VMware and Microsoft Hyper-V.

    通过模拟硬件，让未经修改的操作系统运行。
    
    - **Hardware-Assisted Virtualization VT 硬件辅助虚拟化**:

    Modern CPUs (like Intel VT-x and AMD-V) include hardware support for virtualization, improving performance by allowing the hypervisor to manage resources more efficiently.

    利用CPU的虚拟化指令，提高虚拟化性能。

    - **Software-Assisted Virtualization 软件辅助虚拟化**:

    Using Binary Translation (BT) is a technique that allows unmodified guest operating systems to run on a hypervisor by translating their instructions into a format that the host CPU can execute.

    通过翻译指令让未经修改的操作系统运行。

2. **Paravirtualization 半虚拟化**:
    
    The guest OS is modified to be aware of the hypervisor, allowing for more efficient communication and resource management. Examples include Xen and some implementations of KVM.

    修改操作系统以更高效地与虚拟机管理程序通信。

3. **Hybrid Paravirtualization 混合虚拟化**:

    Hybrid paravirtualization is a virtualization technique that combines aspects of both paravirtualization and hardware-assisted virtualization.

    结合硬件辅助和半虚拟化的优点。

4. **Containerization (OS-level) 容器化**:

    While not traditional virtualization, containerization (e.g., Docker) allows multiple isolated applications to run on a single OS kernel, sharing resources while maintaining separation.

    在同一个操作系统上运行多个隔离的应用程序。

### X86 architecture levels of privileges 
![](./IMG/X86%20architecture%20levels.png)

1. **Ring 0** - 内核模式（Kernel Mode）

    - 最高权限, Guest OS
    - Ring 0是操作系统内核运行的地方，也是所有驱动程序、硬件控制程序等具有最高权限的代码运行的地方。它可以直接访问处理器的所有资源，包括内存、CPU指令、硬件设备等。
    - 典型用途：
        - 操作系统内核
        - 设备驱动程序
        - 直接与硬件交互的系统服务
    - Ring 0代码具有完全的控制权，可以执行任何指令，访问所有内存地址。
    - 若Ring 0中的代码出现错误，可能会导致整个系统崩溃，因为**没有限制或保护机制**。

2. **Ring 1** - 系统模式（System Mode）
    - Ring 1通常为操作系统的低级服务或某些虚拟化软件保留，理论上用于加载某些驱动程序或与硬件进行交互的代码。
    - 现代操作系统通常不会区分Ring 1和Ring 2，而是将大部分权限代码都放在Ring 0中。
    - 典型用途：
        - 操作系统的某些子模块（现代系统中很少使用）
    - 代码权限次于Ring 0，无法直接访问硬件，但可以通过调用Ring 0进行**间接访问**。

3. **Ring 2** - 外围服务模式（Peripheral Mode）
    - Ring 2在理论上用于权限低于内核但高于用户模式的操作，如某些设备驱动程序或高级的虚拟化服务。
    - 现代操作系统也很少使用Ring 2，大多数操作系统将驱动程序放在Ring 0或Ring 3中。
    - 典型用途：
        - 驱动程序（现代系统通常在Ring 0中运行）
        - 特定服务程序（现代操作系统很少用）
    - 权限低于Ring 1，不能直接控制硬件，但仍具有比用户模式更高的访问权限。

4. Ring 3 - 用户模式（User Mode）
    - 最低权限
    - Ring 3是用户应用程序和普通进程运行的地方，权限最低，不能
    - 直接访问硬件或执行敏感的CPU指令。所有用户程序，包括浏览器、文档编辑器等，均在Ring 3中执行。
    - 典型用途：
        - 用户应用程序（如浏览器、文本编辑器）
        - 大部分系统进程
    - Ring 3中的程序不能直接与硬件交互，所有硬件访问必须通过系统调用（System Call）由Ring 0内核代理执行。
    - 若Ring 3程序出现错误，只会影响该程序的运行，不会导致整个系统崩溃。

### Bare metal vs hosted hypervisor 

1. **Bare metal** or **Type 1 hypervisor** 
    - runs directly on the host's hardware without an underlying operating system.
    - Type 1 generally offers better performance and efficiency since it has direct access to hardware resources.
    - Type 1 is ideal for data centers, enterprise environments, and scenarios requiring high performance and scalability.
    - 主要用于高性能需求的环境，直接控制硬件，性能较好。
    - 例子：VMware ESXi、Microsoft Hyper-V、Xen。

2. **Hosted hypervisor** or **Type 2 hypervisor** 
    - runs on top of an existing operating system.
    - Type 2 has slightly lower performance due to the overhead of the host operating system.
    - Suitable for desktop virtualization and development environments.
    - 常见于个人开发者和桌面虚拟化中，虽然使用起来方便，但性能相对较低。
    - 例：VMware Workstation、Oracle VirtualBox、KVM、arallels Desktop。

## Network Interface Virtualization
1. Normal Virtualization
2. VMDq
3. SR-IOV(Single Root I/O Virtualization)

## Cloud Computing Models: IaaS, PaaS, SaaS
![](./IMG/Cloud%20Computing%20Models.png)

### IaaS (Infrastructure as a Service)
1. **Definition**:
    - IaaS provides fundamental computing resources such as virtual machines, storage, networking, and other hardware resources. Users have full control over the management of operating systems, applications, and middleware.
    - IaaS offers users maximum control, allowing them to configure and manage resources similarly to a local data center.
2. **Examples**:
    - Amazon Web Services (AWS EC2)
    - Microsoft Azure
    - Google Compute Engine.
3. **Function**:
    - Provides virtualized computing resources, storage, and networking infrastructure.
    - Users can dynamically scale resources up or down as needed.
    - Users are responsible for managing the operating system, applications, and data, offering maximum flexibility.
4. **Use Cases**:
    - Businesses that want to control their IT infrastructure but do not want to invest in or maintain physical hardware.
    - Applications that need to scale on demand, such as large-scale computing or storage-intensive applications.

### PaaS (Platform as a Service)
1. **Definition**:
    - PaaS provides a platform and environment for developing, testing, deploying, and managing applications. Users don't need to manage the underlying infrastructure (such as servers, storage, networking) and can focus entirely on development and application management.
    - PaaS includes operating systems, databases, and middleware, offering a complete environment for application development.
2. **Examples**:
    - Google App Engine
    - Microsoft Azure App Services
    - Heroku.
3. **Function**:
    - Provides a complete environment for application development, testing, and deployment.
    - Developers can focus on building applications without managing the underlying hardware or software.
    - Automatically scales and manages resources for the applications.
4. **Use Cases**:
    - Developers who need to quickly build, test, and deploy applications without spending time on infrastructure management.
    - Suitable for continuous development and integration processes that require rapid iteration.

### SaaS (Software as a Service)**
1. Definition:
    - SaaS delivers ready-to-use applications over the internet. Users access these applications through a web browser or client, with all infrastructure and platform management handled by the service provider.
    - SaaS users don't manage or control the underlying infrastructure or platform. They only need to use the application as a service.
2. **Examples**:
    - Google Workspace (Gmail, Docs)
    - Microsoft 365
    - Salesforce
    - Dropbox.
3. **Function**:
    - Provides software applications as a service over the internet.
    - Users can access and use applications without worrying about installation, updates, or maintenance.
    - The service provider is responsible for managing the underlying infrastructure, updates, and security.
4. **Use Cases**:
    - Ideal for individuals and businesses who need easy access to software applications without dealing with maintenance or infrastructure.
    - Suitable for companies that require fast deployment of business applications like CRM, email services, or document collaboration tools.


## Containerization Benefit
- **Greater density**
    - Several GB in size for a VM vs. a few dozen MB for a Container
    - A maximum of 6000 containers can run theoretically on a host machine
- **Faster to launch and easy to scale up/down**
    - A container is just another process running on the Host OS
- **Uses far fewer resources than a VM**
    - Higher utilization of compute resources than traditional or hardware VMs
- **Well adapted for microservice architecture and design pattern**
- **Lower I/O latency and CPU overhead**
- **Increased portability**
    - Application container can run in a predictable/reproducible way on different OSs and environments
- **Operational simplicity**
    - Container engines provide a very simple yet powerful CLIs to life cycle manage containers 
      (create, start, stop, scale, destroy, attach, etc.)

---

## Quiz 

1. What is the primary function of a hypervisor?
   - [ ] To provide a user interface
   - [ ] To compile software
   - [x] To manage hardware resources
   - [ ] To encrypt data

   **分析：** 虚拟机管理程序的主要功能是管理硬件资源，将其分配给虚拟机。

---

2. Which of the following is a type 1 hypervisor?
   - [ ] VMware Workstation
   - [x] Microsoft Hyper-V
   - [ ] Oracle VirtualBox
   - [ ] Oracle Solaris Zones

   **分析：** Type 1 虚拟机管理程序直接运行在硬件上，Microsoft Hyper-V 是其中之一。

---

3. What does "bare-metal" hypervisor mean?
   - [ ] Runs on top of an operating system
   - [x] Integrated directly on the hardware
   - [ ] Requires no hardware
   - [ ] Is only for testing purposes

   **分析：** 裸金属虚拟机管理程序直接运行在物理硬件上，不依赖操作系统。

---

4. What is the main advantage of paravirtualization?
   - [ ] Complete isolation of VMs
   - [x] Better performance through cooperation with the host OS
   - [ ] Simplicity of configuration
   - [ ] Compatibility with all guest OS types

   **分析：** 半虚拟化通过主机操作系统的协作，性能更好。

---

5. Which virtualization technology allows multiple operating systems to run concurrently on a single x86 machine?
   - [ ] Emulation
   - [ ] Paravirtualization
   - [x] Full virtualization
   - [ ] Containerization

   **分析：** 全虚拟化可以在单台机器上运行多个未修改的操作系统。

---

6. Which of the following is a common type 2 hypervisor?
   - [x] KVM
   - [ ] Xen
   - [ ] VMware ESXi
   - [ ] Citrix Hypervisor

   **分析：** KVM 是常见的 Type 2 虚拟机管理程序，依赖于操作系统。

---

7. Which virtualization method uses hardware-assisted virtualization features?
   - [ ] Software virtualization
   - [x] Full virtualization
   - [ ] Paravirtualization
   - [ ] None of the above

   **分析：** 全虚拟化使用硬件辅助虚拟化功能（如 Intel VT-x）。

---

8. What is the main disadvantage of type 2 hypervisors?
   - [ ] They are more complex
   - [ ] They require more hardware resources
   - [x] They run on top of a host OS, which can introduce overhead
   - [ ] They cannot run multiple VMs

   **分析：** Type 2 虚拟机管理程序依赖于操作系统，因此会有额外的性能开销。

---

9. Which hypervisor is known for its open-source nature?
   - [ ] Microsoft Hyper-V
   - [ ] Parallels Desktop
   - [x] KVM
   - [ ] Oracle VirtualBox

   **分析：** KVM 是集成在 Linux 内核中的开源虚拟机管理程序。

---

10. What is the purpose of the hypercall in paravirtualization?
   - [ ] To allocate memory
   - [x] To communicate between the guest OS and the hypervisor
   - [ ] To manage network traffic
   - [ ] To encrypt data

**分析：** 在半虚拟化中，hypercall 用于虚拟机和虚拟机管理程序之间的通信。

---

11. Which of the following is a feature of Intel VT-x?
   - [ ] Memory management
   - [x] Hardware-assisted virtualization
   - [ ] Network virtualization
   - [ ] Disk encryption

   **分析：** Intel VT-x 提供硬件辅助虚拟化功能，使虚拟机运行更加高效。

---

12. What does the term "snapshot" refer to in virtualization?
   - [ ] A backup of the entire system
   - [x] A point-in-time copy of a VM's state
   - [ ] A method of data encryption
   - [ ] A performance metric

   **分析：** 虚拟机快照是对虚拟机某一时刻状态的记录，便于恢复。

---

13. Which hypervisor is integrated into the Linux kernel?
   - [ ] VMware Workstation
   - [x] KVM
   - [ ] Microsoft Hyper-V
   - [ ] Oracle VirtualBox

   **分析：** KVM 是集成在 Linux 内核中的虚拟机管理程序。

---

14. Which virtualization technique allows for running unmodified guest operating systems?
   - [x] Full virtualization
   - [ ] Para Virtualization
   - [ ] Containerization
   - [ ] None of the above

   **分析：** 全虚拟化可以运行未修改的客操作系统，因为它完全模拟硬件环境。

---

15. Which of the following virtualization types is less portable?
   - [ ] Full virtualization
   - [ ] OS level
   - [x] Para virtualization
   - [ ] Hardware assisted

   **分析：** 半虚拟化需要对操作系统进行修改，降低了其在不同平台上的可移植性。

---

## Monolithic vs Microservice Architecture

## Container Runtimes

## **Docker**
```
# 使用 Python 3.9 作为基础镜像
FROM python:3.9-slim

# 设置工作目录
WORKDIR /app

# 复制当前目录的内容到工作目录
COPY . /app

# 安装 Python 依赖
RUN pip install -r requirements.txt

# 设置环境变量
ENV PYTHONUNBUFFERED=1

# 暴露容器的端口 5000
EXPOSE 5000

# 设置容器启动时的默认命令
CMD ["python", "app.py"]
```

- **构建镜像**： 在应用程序目录中运行以下命令构建 Docker 镜像：
```
docker build -t my-python-app .
```

- **运行容器**： 构建完成后，可以使用以下命令运行容器：
```
docker run -p 5000:5000 my-python-app
```


# 16102024
## GSM（Global System for Mobile Communications）
GSM，即全球移动通信系统，是一种广泛使用的蜂窝网络标准。它最早由欧洲电信标准协会（ETSI）在20世纪80年代开发，旨在为全球提供统一的移动通信标准。GSM 被认为是第二代（2G）移动通信技术的代表，其最大的特点是支持语音通信、短信（SMS）、以及低速数据传输。

### GSM 的主要特点：
- **数字信号处理**：

GSM 使用数字信号处理技术来传输语音和数据，相比早期的模拟通信系统（如 AMPS），数字系统更具保密性、可靠性和抗干扰性。
- **频率分配**：

GSM 使用频分多址（FDMA）和时分多址（TDMA）技术。在频分多址中，不同的用户使用不同的频率进行通信；在时分多址中，多个用户在相同的频率上以不同的时间段（时隙）进行通信。
- **国际漫游**：

GSM 提供了全球漫游能力，允许用户在不同国家使用相同的手机设备进行通信。通过标准化的协议，用户可以在支持 GSM 的任何地区自由切换网络。
- **支持多种服务**：

除了基本的语音通话，GSM 还支持短信（SMS）、低速数据传输、传真服务，以及呼叫转移、呼叫等待等功能。
- **SIM 卡**：

GSM 系统的另一个重要特点是使用 SIM 卡（Subscriber Identity Module）。SIM 卡存储用户的身份信息、电话号码、通讯录等，通过插入任意兼容 GSM 网络的手机，用户可以快速访问个人数据和服务。
### GSM 的架构
GSM 系统的架构复杂且模块化，主要由以下几大组件构成：

1.  **移动台（Mobile Station，MS）**：

    移动台即我们常说的手机，用户通过它访问 GSM 网络。移动台由用户设备（UE）和SIM 卡组成。SIM 卡包含用户的身份信息，并存储联系人、短信等数据。
2. **基站子系统（Base Station Subsystem，BSS）**：

    BSS 是 GSM 网络的接入部分，负责在手机与核心网络之间建立通信。它包括：
3. **基站控制器（Base Station Controller，BSC）**：

    管理多个基站并负责分配资源、移动性管理和切换等。
4. **基站收发台（Base Transceiver Station，BTS）**：
    负责无线信号的传输，连接手机与网络。
5. **网络与交换子系统（Network and Switching Subsystem，NSS）**：

    NSS 是 GSM 网络的核心部分，负责用户的身份管理、呼叫路由、计费等功能。它包括以下关键组件：
6. **移动交换中心（Mobile Switching Center，MSC）**：
    
    MSC 是 GSM 网络的核心，它负责呼叫建立、呼叫切换、短信传输、用户漫游和计费等任务。
7. **归属位置寄存器（Home Location Register，HLR）**：

    HLR 是一个数据库，存储用户的永久身份信息、服务状态等。
8. **访客位置寄存器（Visitor Location Register，VLR）**：

    VLR 是临时数据库，存储正在访问特定区域的用户的临时信息。
9. **鉴权中心（Authentication Center，AuC）**：
    
    负责用户的身份验证和网络接入授权。
10. **设备身份寄存器（Equipment Identity Register，EIR）**：

    存储设备的唯一标识号，用于防止被盗设备访问网络。
11. **运营支持子系统（Operation Support Subsystem，OSS）**：

    OSS 提供了网络的管理和维护功能，帮助运营商监控和优化网络性能，进行故障处理和资源管理。

### GSM 工作原理
GSM 网络的工作流程大致如下：

1. 接入网络：

    当手机开启时，移动台会搜索附近的基站，并通过最强信号的基站接入网络。
手机的 SIM 卡会向网络发送用户的身份信息（IMSI）和设备信息（IMEI），基站接收到信息后，通过 MSC 进行用户鉴权。
如果用户成功通过鉴权，网络将允许用户接入，并在 VLR 中注册用户的位置信息。
2. 呼叫建立：

    当用户发起呼叫时，手机将信号通过基站传递到 MSC。MSC 根据呼叫的目标，决定是否在本地网络处理，还是通过其他网络（如 PSTN 公共电话网络）进行呼叫路由。
MSC 会将呼叫请求传递到目标用户的 MSC，随后目标用户的手机振铃，双方通过基站建立通话。
3. 呼叫切换（Handover）：

    当用户在通话中移动时，手机可能会离开当前基站的覆盖范围。为了保持通话不中断，GSM 支持切换（Handover）功能，即在通话过程中将连接从一个基站转移到另一个基站。
切换可以在同一个 BSC 内进行，也可以跨多个 BSC 进行，由 MSC 管理和协调。
4. 短信服务（SMS）：

    短信在 GSM 网络中作为一种非常基础的消息传递服务，短信消息通过短消息服务中心（Short Message Service Center，SMSC）进行处理。
当用户发送短信时，消息通过 BSS 传递到 MSC，再由 MSC 传递给 SMSC。SMSC 负责将消息路由到接收方。
5. GSM 频率和技术细节
G   SM 系统使用的频率范围有所不同，具体取决于地区和运营商的规定。常见的频段包括：

- 900 MHz：主要用于欧洲和亚洲地区。
- 1800 MHz：也是在欧洲和亚洲使用，但提供更高的频谱容量。
- 850 MHz 和 1900 MHz：主要用于北美地区。
6. GSM 使用时分多址（TDMA）来将频率分成多个时隙，每个时隙为一个用户服务。这种方式有效提高了频谱利用率。通常，一个频率可以分为 8 个时隙（每秒钟 8 个用户可以共享同一个频率进行通信）。

### GSM 的演进
GSM 是 2G 通信技术的代表，但随着技术的发展，它逐步升级并支持了更高的通信速率：

- GPRS（General Packet Radio Service）：这是一种 2.5G 技术，通过分组交换技术为 GSM 增加了数据通信能力，允许用户进行持续的数据连接（如上网和收发邮件）。

- EDGE（Enhanced Data rates for GSM Evolution）：作为 GSM 网络的增强版本，EDGE 被称为 2.75G，它进一步提升了数据传输速率，接近 3G 的水平。

- 3G 和 LTE：随着 3G 和 4G LTE 技术的引入，GSM 网络逐步被更先进的技术取代。然而，GSM 网络由于其成熟和广泛的覆盖，仍然在一些地区被用于基础通信服务，特别是语音和短信业务。

### GSM 的优缺点
- 优点：
    - 全球标准化：GSM 是一种全球标准，用户可以在世界各地进行漫游。
    - 稳定的语音质量：由于采用了数字信号处理技术，GSM 的语音质量优于早期的模拟系统。
    - 安全性：GSM 通过加密和身份验证机制提高了通信的安全性。
- 缺点：
    - 数据速率较低：GSM 原生的数据传输速度非常有限，虽然通过 GPRS 和 EDGE 技术有所提升，但仍远不及现代的 3G 和 4G 网络。
    - 频率拥挤：由于 GSM 使用的频段较为固定，在人口密集的地区容易出现频率拥挤的问题。

## Interface in the UTRAN architecture

## Handover

## NAS 

## Location Area Update (LAU) 
Location Area Update (LAU) 是 GSM、UMTS 和 LTE 等移动网络中一种用于更新用户设备（UE）位置信息的过程。
当用户在网络的覆盖区域内移动时，手机需要定期向网络报告其当前位置，以便网络能够随时路由来电或短信给用户。
这个过程在电路交换（Circuit-Switched, CS）域和分组交换（Packet-Switched, PS）域都存在，但工作方式和涉及的组件略有不同。

### In CS domain
在 CS 域中，LAU 是用于更新用户设备在 Location Area（位置区） 内的移动性管理机制，主要涉及语音通话、短信等需要电路交换的服务。
LAU 的基本目的是确保用户在不同的位置区移动时，网络能够跟踪用户的位置，以便随时提供呼叫和消息路由。

在 CS 域中，LAU 的过程通常由以下几个步骤组成：

1. 移动台发起 LAU 请求：

    当用户设备检测到它已进入一个新的位置区（或达到定期更新的时间点），它会向网络发起 Location Area Update Request（LAU 请求）。这个请求通过无线链路发送到最近的基站（BTS），并传递给核心网络的 移动交换中心（Mobile Switching Center, MSC）。
2. MSC 和 VLR 处理请求：
    
    MSC 负责管理语音通话和短信的交换，是 CS 域的核心节点。MSC 接收到 LAU 请求后，会检查用户设备的身份信息（通过 SIM 卡的 IMSI 或 TMSI）并转发请求到 访客位置寄存器（Visitor Location Register, VLR）。
VLR 是一个数据库，存储着当前在该位置区内的所有用户的临时位置信息。当用户进入新位置区时，VLR 会更新用户的位置信息。
3. VLR 与 HLR 的交互：

    如果用户设备移动到了一个新的位置区且该位置区归属不同的 VLR 管理（即从一个 VLR 覆盖区域进入另一个 VLR 的覆盖区域），新的 VLR 需要与用户的 归属位置寄存器（Home Location Register, HLR） 交互。
HLR 是存储用户永久信息的中央数据库，记录了用户的服务配置、电话号码和当前所在的 VLR 等。当用户进入新的 VLR 覆盖区域时，新 VLR 会向 HLR 注册用户的位置信息，并要求 HLR 更新记录中的 VLR 信息。
同时，旧的 VLR 会从它的数据库中删除该用户的信息。
4. 响应用户设备：

    完成位置更新后，VLR 会将结果传递给 MSC，MSC 再通过基站将 LAU 接受（Location Area Update Accept） 消息发送回用户设备。
如果位置更新成功，用户设备会回复 LAU 完成（Location Area Update Complete） 消息，并且新的位置信息正式生效。
涉及的协议和信令
5. RRC（Radio Resource Control）：

    RRC 是在移动设备和基站之间运行的协议，负责控制和管理无线资源。在 LAU 过程中，RRC 负责建立无线连接以传输 LAU 信令。
6. MM（Mobility Management）：

    移动性管理协议负责控制用户设备的移动性，包括处理位置区更新、设备鉴权等。在 CS 域中，MM 协议直接管理 LAU 流程。
7. TMSI（Temporary Mobile Subscriber Identity）：

    为了保护用户隐私，移动网络使用 TMSI 作为用户设备的临时标识符。TMSI 通常由 VLR 分配，并且可以定期更换。用户设备通过 TMSI 与网络交互，而不是使用永久的 IMSI。

## MME（Mobility Management Entity）
MME（Mobility Management Entity） 是 LTE（长期演进，Long Term Evolution）网络的核心控制节点，主要用于管理用户设备（UE）的接入、移动性以及与核心网络的交互。
MME 是 LTE 网络中最为重要的控制节点，负责移动性管理、会话管理、用户鉴权和安全管理等任务。它不直接处理用户的数据流量，而是专注于控制信令，确保用户设备能够顺利接入网络，并在网络中无缝移动。
MME 的功能在 5G 中被 AMF 等新网络功能所继承和扩展，以应对更加复杂和高效的通信需求。
### MME 的主要功能
MME 作为 LTE 核心网的控制平面节点，承担了多个重要职责，主要包括以下几个方面：

1. 移动性管理（Mobility Management）
    - 空闲模式移动性管理：当用户设备处于空闲状态时（即没有活跃的数据会话），MME 负责追踪用户的位置。它管理 UE 所在的 追踪区（Tracking Area, TA），并处理 Tracking Area Update（TAU） 请求。当 UE 从一个 TA 移动到另一个 TA 时，MME 负责更新 UE 的位置信息。

    - 连接状态下的移动性管理：在活跃状态下，当用户跨越基站或小区时，MME 负责与基站（eNodeB）协同，完成用户会话的切换过程（Handover），确保移动过程中不丢失连接。

2. 会话管理（Session Management）

    - MME 负责管理用户会话的建立、维护和释放。它通过与 Serving Gateway（S-GW） 和 Packet Data Network Gateway（P-GW） 的交互，处理用户的会话请求。
    - 负责创建 默认承载（Default Bearer） 和 专用承载（Dedicated Bearer）。默认承载提供了用户设备和网络之间的基本 IP 连接，而专用承载则为特定应用（如视频通话）提供高优先级的数据传输通道。
3. 用户鉴权（Authentication）
    - 当用户设备接入 LTE 网络时，MME 通过与 归属用户服务器（Home Subscriber Server, HSS） 的交互，完成用户身份的鉴权。HSS 中存储了用户的永久订阅信息。
    - MME 使用 EPS-AKA（Evolved Packet System Authentication and Key Agreement） 协议进行鉴权，确保用户的合法性，并分配安全密钥用于后续的数据加密。
4. 安全管理（Security Management）
    - MME 负责生成并分发加密密钥和完整性保护密钥，以确保用户与网络之间的通信是安全的，防止窃听和篡改。
    - 在用户接入时，MME 会与 eNodeB 协调，启用加密机制，确保在空中传输的数据被加密和保护。
5. IP 地址分配
    - 在用户连接到网络并建立会话时，MME 协调 P-GW 为用户分配 IP 地址。P-GW 负责实际的 IP 地址分配，但 MME 在会话建立和维护中起关键作用。
6. 追踪区域管理（Tracking Area Management）
    - MME 使用 追踪区（Tracking Area, TA） 来管理用户设备的位置信息。TA 是由多个 eNodeB（基站）组成的区域。当用户设备在空闲模式下移动到不同的 TA 时，需要向 MME 发起 TAU（Tracking Area Update） 请求，MME 更新用户的当前位置。
    - 这确保了即使用户不处于活跃状态，网络仍能及时找到用户，保证来电和通知的送达。
7. 网络间切换（Inter-RAT Handover）
    - MME 还负责管理不同无线接入技术（RAT）之间的切换。例如，当用户从 LTE 网络切换到 UMTS（3G）或 GSM（2G）网络时，MME 与 SGSN（Serving GPRS Support Node） 协作，确保切换过程的平滑进行。
8. 寻呼（Paging）
    - 当用户设备处于空闲模式时，如果有下行流量（如来电、短信等），MME 会通过 寻呼消息（Paging Message） 通知用户设备，要求其重新激活并建立数据连接。
    - MME 在 LTE 核心网（EPC）中的作用
    - MME 是 LTE 核心网 EPC（Evolved Packet Core） 的控制平面节点，它与 EPC 的其他组件紧密协作，主要包括以下核心网元素：

        - Serving Gateway（S-GW）：

            S-GW 是用户数据的中转站，负责在用户设备和外部网络之间传输数据包。MME 负责协调 S-GW 来建立和管理用户的会话和承载。
        - Packet Data Network Gateway（P-GW）：

            P-GW 是用户设备通向外部数据网络（如互联网）的网关。它管理用户的 IP 地址分配，并负责流量的路由。MME 通过 S-GW 与 P-GW 交互，完成用户会话的建立。
        - Home Subscriber Server（HSS）：

            HSS 是一个数据库，存储了用户的订阅信息、鉴权数据和服务配置。MME 通过 HSS 获取用户的鉴权密钥、接入权限以及位置信息。
        - eNodeB（基站）：

            eNodeB 是 LTE 的无线接入节点。MME 与 eNodeB 协作，负责管理用户设备与无线接入网络之间的连接。当用户设备在空闲模式和活跃模式之间切换时，MME 也负责协调 eNodeB 处理切换请求。
        - Serving GPRS Support Node（SGSN）：

            在跨代网络（如从 LTE 切换到 3G 或 2G 网络）时，MME 需要与 SGSN 协作，确保网络间切换的顺利进行。
### MME 的协议接口
MME 在 LTE 网络中使用多个标准化的协议接口，与其他核心网元素和基站进行通信。主要的接口包括：

1. S1-MME 接口：

    这是 MME 与 eNodeB 之间的接口，主要用于传输控制平面信令。S1-MME 接口使用 S1AP（S1 Application Protocol） 协议，负责处理控制信令，包括移动性管理、用户接入控制等。
2. S6a 接口：

    这是 MME 与 HSS 之间的接口，使用 Diameter 协议 进行通信。S6a 接口主要用于用户鉴权、授权和位置更新等功能。
3. S11 接口：

    S11 是 MME 与 S-GW 之间的接口，负责处理会话管理和承载控制。MME 通过 S11 接口与 S-GW 协同，管理用户数据的路由和转发。
4. S10 接口：

    这是 MME 之间的接口，用于在用户设备从一个 MME 管辖的区域移动到另一个 MME 管辖区域时，进行状态和上下文的传递，支持无缝的移动性管理。
5. SGs 接口：

    MME 通过 SGs 接口与 2G/3G 的 MSC 进行通信，以支持语音回落（CSFB，Circuit Switched FallBack）功能。当 LTE 网络中没有语音承载时，用户可以通过 CSFB 切换到 2G/3G 网络进行语音通话。
### MME 的重要性和作用
MME 在 LTE 网络中是不可或缺的核心控制节点，它主要负责以下几方面的关键功能：

1. 信令控制：

    MME 处理所有与用户接入、移动性和会话管理相关的控制信令，但不直接处理用户的数据流量。它是网络的控制中枢，决定了用户设备如何与网络进行交互。
2. 跨技术移动性：

    MME 通过支持跨 RAT（Radio Access Technology）的移动性管理，确保 LTE 与其他无线接入技术（如 2G/3G）之间的无缝切换，保证了用户在不同网络之间的平滑过渡。
3. 节能管理：

    MME 通过对用户设备的状态管理，优化了设备的电池使用时间。它可以控制 UE 进入低功耗的空闲模式，减少信令负载，同时还能保证网络的服务质量。
4. 网络负载管理：

    MME 在处理接入控制、会话管理时，能够合理分配网络资源，并根据网络负载情况进行优化管理，确保高效利用无线资源和核心网资源。
5. MME 在 5G 中的演进
    在 5G 网络中，MME 的功能被分离和演进为不同的网络功能（NF，Network Function）：

    - AMF（Access and Mobility Management Function）：AMF 是 5G 核心网中负责接入和移动性管理的网络功能，它继承并扩展了 MME 的大部分功能，主要负责接入控制、用户设备的鉴权和移动性管理。

    5G 网络采用了服务化架构（Service-Based Architecture, SBA），MME 的功能被拆分并与其他网络功能协作，以提供更灵活和高效的移动通信服务。