# **1. Digital Communications and High-Rate Transmission**  
(数字通信与高速传输)

## 1.1 Overview (概述)
- **Communication Chain (通信链):**  
  - Source Coding (源编码): Digitalizing and compressing the signal.  
    源编码：对信号进行数字化和压缩。
  - Channel Coding (信道编码): Adding redundancy to counter noise.  
    信道编码：通过添加冗余对抗噪声。
  - Modulation (调制): Mapping the signal to a carrier wave.  
    调制：将信号映射到载波。
  - Filtering Noise (噪声过滤): Reducing interference in the channel.  
    噪声过滤：减少信道中的干扰。
  - Decoding and Correction (解码与纠错): Restoring the original signal.  
    解码与纠错：恢复原始信号。

---

## 1.2 Analog Modulations (模拟调制)
### Principle (原理)
- **Carrier Signal (载波信号):**  
  \( s(t) = \cos(2\pi f_c t) \)  
  Signal information is transmitted by varying:  
  信号信息通过改变以下特性传输：
  - Amplitude (振幅)
  - Phase (相位)
  - Frequency (频率)

### Modulation Types (调制类型)
1. **Amplitude Modulation (AM, 幅度调制):**  
   \( s_A(t) = u(t) \cdot \cos(2\pi f_c t) \)  
   \( u(t) \): Modulating signal; \( f_c \): Carrier frequency.  
   \( u(t) \): 调制信号；\( f_c \): 载波频率。

2. **Phase Modulation (PM, 相位调制):**  
   \( s_\phi(t) = \cos(2\pi f_c t + u(t)) \)  
   Phase of the carrier changes with \( u(t) \).  
   载波的相位随 \( u(t) \) 变化。

3. **Frequency Modulation (FM, 频率调制):**  
   \( s_f(t) = \cos\left[2\pi f_c t + k_f \int u(t) dt\right] \)  
   \( k_f \): Frequency modulation index.  
   \( k_f \): 调频指数。

---

## 1.3 Digital Modulations (数字调制)
### Principles (原理)
- **Bit Rate (位速率):**  
  \( R_b = R_s \cdot \log_2(M) \)  
  \( R_s \): Symbol rate; \( M \): Number of constellation points.  
  \( R_s \): 符号率；\( M \): 星座点数。

- **Spectral Efficiency (频谱效率):**  
  \( \eta = \frac{R_b}{B} \)  
  \( B \): Bandwidth.  
  \( B \): 带宽。

### Examples (示例)
- **ASK (Amplitude Shift Keying, 幅移键控):**  
  Varies the amplitude to encode data.  
  通过改变振幅来编码数据。

- **PSK (Phase Shift Keying, 相移键控):**  
  Uses phase changes to encode data.  
  通过相位变化来编码数据。

- **QAM (Quadrature Amplitude Modulation, 正交幅度调制):**  
  Combines amplitude and phase changes to maximize efficiency.  
  综合振幅和相位变化以提高效率。

---

# **2. Satellite Telecommunication Overview**  
(卫星通信概述)

## 2.1 History (历史)
- 1957: Sputnik-1, the first artificial satellite, was launched.  
  1957年：Sputnik-1，人类第一颗人造卫星发射。
- 1965: Intelsat-1, the first commercial geostationary satellite.  
  1965年：Intelsat-1，第一颗商业地球同步卫星。

---

## 2.2 Satellite Orbits (卫星轨道)
- **LEO (Low Earth Orbit, 低地轨道):**  
  500-2000km altitude; global coverage and low latency.  
  轨道高度500-2000公里；覆盖全球且延迟低。
  
- **MEO (Medium Earth Orbit, 中地轨道):**  
  6000-23000km altitude; used for navigation.  
  轨道高度6000-23000公里；用于导航。

- **GEO (Geostationary Orbit, 地球同步轨道):**  
  35786km altitude; fixed coverage area.  
  轨道高度35786公里；覆盖固定区域。

### Kepler’s Laws (开普勒定律)
1. **Elliptical Orbits (椭圆轨道):** Earth is at one focus.  
   轨道为椭圆，地球位于一个焦点。
2. **Equal Areas (相等面积):** Equal time sweeps equal areas.  
   相等时间内扫过相等面积。
3. **Orbital Period (轨道周期):**  
   \( T^2 \propto a^3 \)  
   \( a \): Semi-major axis.  
   \( a \): 轨道半长轴。

---

# **3. Satellite Payloads for Telecommunications**  
(卫星通信有效载荷)

## 3.1 Payload Components (有效载荷组成)
- **Antennas (天线):** Convert electrical signals to electromagnetic waves.  
  转换电信号为电磁波。
- **Low Noise Amplifier (LNA, 低噪声放大器):** Reduce receiver noise.  
  降低接收噪声。
- **High Power Amplifier (HPA, 高功率放大器):** Boost transmission power.  
  提高发射功率。

---

# **4. Satellite Link Budgets**  
(卫星链路预算)

## 4.1 Key Parameters (关键参数)
1. **Free Space Loss (自由空间损耗):**  
   \( L_f = \left(\frac{4\pi d f}{c}\right)^2 \)  
   \( d \): Distance; \( f \): Frequency; \( c \): Speed of light.  
   \( d \): 距离；\( f \): 频率；\( c \): 光速。
   
2. **Signal-to-Noise Ratio (信噪比):**  
   \( \text{SNR (dB)} = 10\log_{10}\left(\frac{P_{\text{signal}}}{P_{\text{noise}}}\right) \)  
   Measures signal quality against noise.  
   衡量信号相对于噪声的质量。

why starlink 被叫做 LEO-HTS


---

# **5. Optical Fibre Networks**  
(光纤网络)

## 5.1 Principles (原理)
- **Speed in Fibre (光纤传播速度):**  
  \( c = \frac{c_0}{n} \)  
  \( c_0 \): Speed of light in vacuum; \( n \): Refractive index.  
  \( c_0 \): 真空光速；\( n \): 折射率。

- **Attenuation (衰减):**  
  \( P = P_0 e^{-\alpha L} \)  
  \( \alpha \): Attenuation coefficient; \( L \): Fibre length.  
  \( \alpha \): 衰减系数；\( L \): 光纤长度。

---

# **6. Satellite Broadcasting**  
(卫星广播)

## 6.1 Standards (标准)
- MPEG-2/MPEG-4 for video compression.  
  MPEG-2/MPEG-4 用于视频压缩。
- DVB-S2 supports efficient modulations like QPSK, 8PSK.  
  DVB-S2 支持高效调制，如 QPSK 和 8PSK。

---


# Optical Fibre Networks 1/4  
(光纤网络 1/4)

## 1. General Objective (总体目标)
- **Objective:** Provide an overview of optical fibre networks, characteristics, technologies, and their applications.  
  **目标：** 提供光纤网络的全貌，包括其特性、技术及应用。
- **Understand:**  
  - The physics of optical fibre (光纤的物理特性)  
  - Network design and deployment (网络设计与部署)  
  - High-rate network trends (高速网络发展趋势)

---

## 2. Historical Background (历史背景)
- **19th Century:** Mirrors used to direct light, leading to the idea of fibre optics.  
  **19世纪：** 使用镜子引导光线，为光纤技术提供了灵感。
- **1961:** Elias Snitzer developed the single-mode fibre theory.  
  **1961年：** Elias Snitzer 开发了单模光纤理论。
- **1973:** Bell Labs created the first practical fibre.  
  **1973年：** 贝尔实验室创造了第一根实用光纤。
- **1980:** Sprint built the first fibre-optic telecom network.  
  **1980年：** Sprint 建造了首个光纤通信网络。

---

## 3. Optical Fibre Basics (光纤基础)
### 3.1 Transmission Principles (传输原理)
- **Waveguide Principle:** Fibre acts as a waveguide using reflection and refraction to transmit light.  
  **波导原理：** 光纤作为波导，通过反射和折射传输光信号。
- **Key Components:**  
  - Reflections (反射)  
  - Refraction (折射)  
  - Attenuation (衰减)

### 3.2 Electromagnetic Spectrum (电磁波谱)
- **Infrared Wavelength:** Used range is typically 800nm–1600nm.  
  **红外波长：** 使用范围通常为800nm至1600nm。
- **Common Wavelengths:**  
  - 850nm and 1300nm for multi-mode fibres.  
    多模光纤：850nm和1300nm。
  - 1310nm and 1550nm for single-mode fibres.  
    单模光纤：1310nm和1550nm。

---

## 4. Fibre Characteristics (光纤特性)
### 4.1 Attenuation (衰减)
- **Cause:** Material absorption and Rayleigh scattering.  
  **原因：** 材料吸收和瑞利散射。
- **Compensation:** Amplifiers can offset attenuation.  
  **补偿：** 放大器可补偿信号衰减。

### 4.2 Chromatic Dispersion (色散)
- **Effect:** Signal broadening due to wavelength-dependent speed.  
  **影响：** 信号随波长传播速度不同而展宽。
- **Solution:** Use fibres with optimized refractive index profiles.  
  **解决方案：** 使用优化折射率的光纤。

---

# Optical Fibre Networks 2/4  
(光纤网络 2/4)

## 1. General Objective (总体目标)
- **Objective:** Provide in-depth knowledge of multiplexing, coupling, splitting, amplifying, and WDM.  
  **目标：** 提供关于复用、耦合、分光、放大及波分复用（WDM）的深入知识。

---

## 2. Coupling on Optical Fibre (光纤耦合)
### Principles (原理)
- **Coupling Functionality:**  
  - Combine multiple input signals into a single fibre.  
    将多个输入信号合并到一根光纤中。  
  - Reverse operation is splitting, used for signal distribution.  
    反向操作为分光，用于信号分发。

### Applications (应用)
1. **Broadcasting Signal (广播信号):**  
   Distribute the same signal to multiple devices (e.g., data centres).  
   将相同信号分发到多个设备（如数据中心）。  
2. **Securing Signal (信号保护):**  
   Ensure alternative paths in case of cable damage.  
   在光纤损坏时提供备用路径。  

---

## 3. Splitting Signal on Optical Fibre (光纤分光)
### Principles (原理)
- **Splitter Design:** Use prisms or mirrors to divide light signals.  
  **分光器设计：** 使用棱镜或镜面分离光信号。  
- **Energy Distribution:**  
  - Part of the light is transmitted, and part is reflected.  
    部分光信号透射，部分反射。  
  - Energy loss occurs, requiring amplification if necessary.  
    能量损耗时需要放大补偿。

---

## 4. Amplifying Signal (信号放大)
### Principles (原理)
- **Amplifier Types (放大器类型):**  
  - **EDFA (Erbium-Doped Fibre Amplifier):** Suitable for long-haul transmission.  
    **EDFA：** 适用于长距离传输。  
  - **Raman Amplifier:** Uses fibre as the gain medium.  
    **拉曼放大器：** 以光纤为增益介质。  
  - **Semiconductor Optical Amplifier (SOA):** Compact and cost-efficient.  
    **半导体光放大器（SOA）：** 紧凑且成本效益高。

### Key Features (关键特性)
- Amplification window and gain depend on dopant ions and matrix material.  
  增益窗口和增益取决于掺杂离子和基质材料。  

---

## 5. Wavelength Division Multiplexing (波分复用, WDM)
### Principles (原理)
- **Basic Concept:** Combine multiple wavelengths on a single fibre to maximize capacity.  
  **基本概念：** 在单根光纤上复用多种波长以最大化容量。  
- **Dense Wavelength Division Multiplexing (DWDM):** Space between wavelengths is less than 1nm, supporting up to 160 channels.  
  **密集波分复用（DWDM）：** 波长间距小于1nm，支持最多160个通道。

### Applications (应用)
- Long-haul transmission, especially submarine cables.  
  长途传输，尤其是海底光缆。

---

# Optical Fibre Networks 3/4  
(光纤网络 3/4)

## 1. Network Topologies (网络拓扑)
### Key Considerations (关键因素)
- **Requirements (需求):**  
  - High-rate transfers with minimal loss.  
    高速传输且损耗最小。  
  - Security and reliability.  
    安全性和可靠性。  
  - Traffic continuity in case of failures.  
    故障情况下的流量连续性。

### Solutions (解决方案)
- **Point-to-Point (P2P):** Dedicated fibre connections for high-capacity needs.  
  **点对点 (P2P)：** 用于高容量需求的专用光纤连接。  
- **Tree Topology:** Centralized structure, suitable for residential areas.  
  **树形拓扑：** 集中式结构，适用于住宅区域。  
- **Logical Loops:** Dual-path access to ensure redundancy.  
  **逻辑环形结构：** 提供双路径访问以确保冗余。

---

## 2. Submarine/Intercontinental Connections (海底/洲际连接)
### Challenges (挑战)
- Long distances require signal amplification and regeneration.  
  长距离需要信号放大和再生。  
- High latency due to physical distance.  
  因物理距离导致高延迟。

### Solutions (解决方案)
- Use of EDFA or Raman amplifiers for signal maintenance.  
  使用EDFA或拉曼放大器保持信号质量。  
- Deploy repeaters every 50–100km to mitigate attenuation.  
  每50–100公里部署中继器以减少衰减。

---

## 3. FTTH and GPON Architecture (FTTH与GPON架构)
### Passive Optical Network (PON) (无源光网络)
- **Components:**  
  - Optical Line Termination (OLT): Entry point to the optical network.  
    **光线路终端 (OLT)：** 光网络的入口点。  
  - Optical Network Termination (ONT): End-user connection point.  
    **光网络终端 (ONT)：** 用户连接点。

- **Features:**  
  - Supports bi-directional communication on single-mode fibre.  
    **特性：** 支持单模光纤的双向通信。  
  - Resource sharing with splitters (e.g., 1:64 or 1:128).  
    **资源共享：** 使用分光器（如1:64或1:128）。  

---

# Optical Fibre Networks 4/4  
(光纤网络 4/4)

## 1. WDM Networks (波分复用网络)
### Principles (原理)
- Combine multiple wavelengths onto a single fibre, maximizing spectral efficiency.  
  将多个波长复用到单根光纤上，最大化光谱效率。

### Basic Architecture (基础架构)
1. **ROADM (Reconfigurable Optical Add-Drop Multiplexer):**  
   - Flexibly adds, drops, or routes wavelengths.  
     灵活地增加、移除或路由波长。  
   - Key components: WSS (Wavelength Selective Switch), transponders.  
     关键组件：波长选择开关 (WSS)，波长变换器。  
2. **Amplification Sites:**  
   - EDFA amplifiers are used between ROADMs to maintain signal quality.  
     在ROADM之间使用EDFA放大器保持信号质量。

---

## 2. Network Deployment (网络部署)
### Deployment Constraints (部署约束)
- **Urban Areas:** Limited duct space and high deployment costs.  
  **城市区域：** 管道空间有限且部署成本高。  
- **Countryside:** Long distances and private property issues.  
  **乡村区域：** 长距离传输及私人财产问题。

### Optimization (优化)
- Use GIS tools (e.g., ArcGIS, QGIS) for network design.  
  使用GIS工具（如ArcGIS、QGIS）进行网络设计。  
- Deploy logical loops to ensure redundancy and reliability.  
  部署逻辑环以确保冗余和可靠性。

---

# Optical Fibre Networks 5/4  
(光纤网络 5/4)

## 1. Passive and Active Components (无源和有源组件)
### Passive Components (无源组件)
- **Definition (定义):** Components that interact with light without requiring power.  
  **定义：** 不需要电源即可与光信号交互的组件。
- **Examples (示例):**  
  - Splitters (分光器)  
  - Couplers (耦合器)  
  - Polarization Splitters (偏振分光器)

### Active Components (有源组件)
- **Definition (定义):** Components that require power to function, such as emitting or amplifying light.  
  **定义：** 需要电源支持以发射或放大光信号的组件。
- **Examples (示例):**  
  - Amplifiers (放大器)  
  - Routers (路由器)  

---

## 2. Optical Amplification (光信号放大)
### Principles (原理)
- **Amplification Without Conversion (无转换放大):**  
  - Signal is amplified directly in the optical domain.  
    信号直接在光域内被放大。
  - EDFA (掺铒光纤放大器): Ideal for long-distance applications.  
    EDFA：适合长距离应用。

### Amplifier Types (放大器类型)
1. **EDFA:** Operates in 1550nm wavelength range with high efficiency.  
   **EDFA：** 工作在1550nm波长范围，效率高。  
2. **Raman Amplifier:** Utilizes nonlinear effects in the fibre itself.  
   **拉曼放大器：** 利用光纤本身的非线性效应。  
3. **SOA:** Compact and cost-effective but has higher noise levels.  
   **SOA：** 紧凑经济，但噪声水平较高。

---

## 3. Multiplexing Techniques (复用技术)
### Types of Multiplexing (复用类型)
1. **Wavelength Division Multiplexing (WDM, 波分复用):**  
   - Multiple wavelengths transmitted on a single fibre.  
     多个波长在单根光纤上传输。
   - Used for high-capacity and long-haul networks.  
     用于大容量和长距离网络。  
2. **Time Division Multiplexing (TDM, 时分复用):**  
   - Multiple signals transmitted in different time slots.  
     多个信号在不同时间段传输。  
   - Suitable for low-latency applications.  
     适用于低延迟应用。

---

## 4. Network Deployment Strategies (网络部署策略)
### Urban Areas (城市区域)
- **Challenges (挑战):**  
  - Limited duct space.  
    管道空间有限。  
  - High installation costs.  
    安装成本高。

- **Solutions (解决方案):**  
  - Utilize existing infrastructure (reuse ducts).  
    利用现有基础设施（重复利用管道）。  
  - Logical loops for redundancy.  
    使用逻辑环形结构提供冗余。

### Rural Areas (乡村区域)
- **Challenges (挑战):**  
  - Long distances and sparse population.  
    距离长且人口稀疏。  

- **Solutions (解决方案):**  
  - Optimize fibre layout with GIS tools.  
    使用GIS工具优化光纤布局。  
  - Deploy splitters at strategic locations.  
    在战略位置部署分光器。
