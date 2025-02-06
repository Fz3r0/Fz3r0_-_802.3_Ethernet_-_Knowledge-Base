# 🔥🧱🛡️ Cisco CCNA: `WAN`

![My Video](https://user-images.githubusercontent.com/94720207/165892585-b830998d-d7c5-43b4-a3ad-f71a07b9077e.gif)

### 🐦 Twitter  : [@fz3r0_OPs](https://twitter.com/Fz3r0_OPs)
### 🐱 Github  : [Fz3r0](https://github.com/fz3r0) 

---
 
#### Keywords: `WAN`

---

# WAN 

Unlike LAN, which is used in relatively small geographic areas, WAN services help connect networks over broad distances, from a few to thousands of kilometers.  

While LANs are used inside buildings (homes, offices, ISPs), WANs connect them together. The Internet is the largest WAN today.  

### Why Use WAN?  

Due to the long-distance nature of WANs, individuals typically do not own them. Instead, they lease services from ISPs, cable, or telephone companies. This reduces costs significantly.  

**Note:** Although `serial` connections with copper cables were traditionally used in WANs, fiber **`optic cables`** are now common due to:  

- High bandwidth  
- Long distance coverage  
- Minimal signal loss  
- High speed and security  
- Thin and lightweight construction  


## WAN Devices & Terminologies

| **Term**                    | **Definition** |
|-----------------------------|---------------|
| **Router**                   | Connects LANs to WANs and provides internetworking. |
| **Data Terminal Equipment (DTE)** | Typically, the router at the customer side. |
| **Data Communications Equipment (DCE)** | Provides clocking signals for synchronization between DTE and DCE. |
| **Customer Premises Equipment (CPE)** | Devices at the customer side (owned or leased from provider). |
| **Demarcation Point**        | The physical point where the public network ends and the private network begins. |
| **Local Loop**               | A cable connecting the CPE to the nearest Central Office (CO) of the provider. |
| **CSU/DSU**                  | Converts digital signals and provides clocking for leased lines (T1, E1, etc.). |
| **Modem**                    | Converts digital data to analog for telephone lines and vice versa. |



# WAN Layer 2 Protocols

Wide Area Networks (WANs) use various protocols to facilitate long-distance communication between networks. These protocols define how data is transmitted, formatted, and managed across different types of WAN connections. 

- Some protocols, such as **HDLC** and **PPP**, are primarily used in **leased-line** connections, while others, like **Frame Relay**, **MPLS**, and **SD-WAN**, fall under **packet-switching** technologies, optimizing bandwidth usage and scalability.  

![image](https://github.com/user-attachments/assets/3b91d4fd-4521-4882-bebf-21bd537f67a7)


| **Protocol** | **Description** | **Example Use Case** | **Devices Used** | **Year Implemented** | **Current Status** | **Type (Packet-Switching or Leased-Line)** |
|--------------|---------------|------------------|------------------|------------------|------------------|--------------------------------|
| **HDLC (High-Level Data-Link Control)** | Default WAN protocol for Cisco routers. Although it is an open standard, each vendor adds proprietary fields, making it incompatible between different brands. | Point-to-point connections between routers in private networks. | Cisco routers, switches with WAN support. | 1979 (ISO 13239) | Obsolete in many modern networks, replaced by PPP or MPLS. | **Leased-Line** |
| **PPP (Point-to-Point Protocol)** | Open standard supporting both synchronous and asynchronous connections. Used in dial-up, xDSL, ISDN, and serial links. Provides authentication (PAP and CHAP). | Remote access connections in ISP networks and traditional VPNs. | DSL modems, access routers, RAS servers. | 1994 (RFC 1661) | Still used in some Internet access networks but largely replaced by Ethernet or MPLS. | **Leased-Line** |
| **Frame Relay** | Packet-switching protocol for efficient WAN connections without error control at layer 2. | Used for corporate WANs before MPLS became dominant. | Frame Relay switches, routers. | 1980s | Largely obsolete, replaced by MPLS and Ethernet-based WANs. | **Packet-Switching** |
| **ATM (Asynchronous Transfer Mode)** | High-speed, fixed-size cell-switching protocol designed for voice, video, and data. | Used in telecom networks and early broadband DSL infrastructure. | ATM switches, DSLAMs, backbone routers. | 1980s | Mostly obsolete, replaced by IP/MPLS and Ethernet. | **Packet-Switching** |
| **MPLS (Multiprotocol Label Switching)** | Modern WAN technology that forwards packets based on labels instead of IP addresses. Improves speed and QoS. | Enterprise WANs, carrier networks, and SD-WAN implementations. | Core routers, edge routers, MPLS switches. | Late 1990s | Still widely used, but SD-WAN is increasingly replacing traditional MPLS. | **Packet-Switching** |
| **Metro Ethernet** | Ethernet-based WAN service that provides high-speed connectivity between locations. | Used by businesses to connect multiple branches within a city. | Ethernet switches, carrier-grade routers. | 2000s | Increasingly popular due to cost-effectiveness and scalability. | **Packet-Switching** |
| **SD-WAN (Software-Defined WAN)** | Uses software-defined networking (SDN) to manage and optimize WAN traffic dynamically. | Cloud applications, enterprise WANs, hybrid networks. | SD-WAN appliances, cloud-based controllers. | 2010s | Rapidly growing, replacing traditional MPLS and VPN solutions. | **Packet-Switching** |


## Leased Line  

The two most common protocols used on `leased lines` are:  

| **Protocol**  | **Description** |
|--------------|---------------|
| **HDLC (High-Level Data-Link Control)** | Default WAN protocol for Cisco routers. Although standardized, each vendor adds proprietary fields, making it incompatible between different vendors. |
| **PPP (Point-to-Point Protocol)** | Open standard, supports both synchronous (analog phone lines) and asynchronous (ISDN, digital links). Used in dial-up, xDSL, ISDN, and serial applications. |

### PPP Subprotocols  

| **Subprotocol**  | **Function** |
|----------------|-------------|
| **LCP (Link Control Protocol)** | Sets up the link and handles authentication. |
| **NCP (Network Control Protocol)** | Negotiates configuration parameters for network layer protocols (e.g., IP). |

### PPP Authentication Methods  

| **Method** | **Security** |
|-----------|------------|
| **PAP (Password Authentication Protocol)** | Sends passwords in clear text. |
| **CHAP (Challenge Handshake Authentication Protocol)** | Uses encrypted password hashing with a three-way handshake. More secure than PAP. |



## Packet-Switching  

`Packet-switching` allows multiple routers to connect to a single WAN service using a single serial link. A key advantage over leased lines is that all connected routers can communicate with each other.  

### Common Packet-Switching Technologies  

| **Protocol**  | **Description** |
|--------------|---------------|
| **Frame Relay** | Digital packet-switched service operating over synchronous digital connections. Detects errors but does not correct them—higher-layer protocols (e.g., TCP) handle retransmissions. |
| **ATM (Asynchronous Transfer Mode)** | Out of CCNA scope, but another form of packet-switching. |

All three protocols (HDLC, PPP, Frame Relay) operate at **Layer 2 (Data Link Layer)** of the OSI Model.






# 📚🗂️🎥 Resources

- https://www.youtube.com/watch?v=BW3fQgdf4-w
- https://www.9tut.com/wan-tutorial
- https://www.youtube.com/watch?v=39pFGGPPS_4
  
---

<span align="center"> <p align="center"> ![giphy](https://user-images.githubusercontent.com/94720207/166587250-292d9a9f-e590-4c25-a678-d457e2268e85.gif) </p> </span> 



&nbsp;

<span align="center"> <p align="center"> _I hope this information was useful for someone_ </p> </span> 
<span align="center"> <p align="center"> _and please, don't forget to enjoy your days..._ </p> </span> 
<span align="center"> <p align="center"> _...It is getting dark... so dark..._ </p> </span> 

&nbsp;

<span align="center"> <p align="center"> _In the mist of the night you could see me come, where shadows move and Demons lie..._ </p> </span> 
<span align="center"> <p align="center"> _I am [Fz3r0 💀](https://github.com/Fz3r0/) and the Sun no longer rises..._ </p> </span> 

---






---

> ![hecho en mexico 5](https://user-images.githubusercontent.com/94720207/166068790-fa1f243d-2db9-4810-a6e4-eb3c4ad23700.png)
>
> _- Hecho en México - by [Fz3r0 💀](https://github.com/Fz3r0/)_  
>
> _"In the mist of the night you could see me come, where shadows move and Demons lie..."_ 





