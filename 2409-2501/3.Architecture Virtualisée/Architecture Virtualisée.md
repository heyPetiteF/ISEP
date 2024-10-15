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




