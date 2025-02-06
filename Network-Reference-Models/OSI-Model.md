# 🔥🧱🛡️ Cisco CCNA: `OSI Model`

![My Video](https://user-images.githubusercontent.com/94720207/165892585-b830998d-d7c5-43b4-a3ad-f71a07b9077e.gif)

### 🐦 Twitter  : [@fz3r0_OPs](https://twitter.com/Fz3r0_OPs)
### 🐱 Github  : [Fz3r0](https://github.com/fz3r0) 

---
 
#### Keywords: `OSI Model` `Reference Models`

---

# 📡 OSI Model

The **OSI (Open Systems Interconnection) Model** is a 7-layer conceptual framework that describes how data travels through a network.

## 📊 OSI Layers Table

| Layer | Name              | Main Function                                   | PDU        | Common Protocols            | Devices       |
|-------|------------------|------------------------------------------------|------------|-----------------------------|--------------|
| 7️⃣   | **Application**  | User interface, network services               | Data       | HTTP, FTP, SMTP, DNS, SNMP  | _Logical_            |
| 6️⃣   | **Presentation** | Data translation, encryption, compression      | Data       | JPEG, MP3, MP4, TLS, SSL    | _Logical_            |
| 5️⃣   | **Session**      | Establish, maintain, terminate sessions        | Data       | NetBIOS, RPC, SQL, PPTP     | _Logical_            |
| 4️⃣   | **Transport**    | Flow control, reliability                      | Segment    | TCP (reliable), UDP (unreliable) | Firewall  |
| 3️⃣   | **Network**      | Logical addressing, routing                    | Packet     | IP, ICMP, ARP, IPX, AppleTalk | Router   |
| 2️⃣   | **Data Link**    | MAC addressing, error detection, frame delivery | Frame      | Ethernet, PPP, HDLC, VLANs, 802.11 MAC Frames  | Switch, Bridge |
| 1️⃣   | **Physical**     | Bit transmission, physical connections         | Bits (0,1) | Fiber, Coaxial, Ethernet, Radio Frequency (802.11 Spectrum)    | Hub, Repeater |


## 🔄 OSI Data Flow:

1. **Encapsulation**: Data is wrapped with headers as it moves **down** the layers (Application → Physical).
2. **Decapsulation**: Headers are removed as data moves **up** the layers (Physical → Application).

### 🔥 Key Concepts:

- **Encapsulation:** Adding headers at each layer before transmission.
- **Decapsulation:** Removing headers at each layer upon reception.
- **PDU (Protocol Data Unit):** The form data takes at each layer.
- **Logical Addressing (L3):** IP addresses for global identification.
- **Physical Addressing (L2):** MAC addresses for local identification.
- **Reliable (TCP) vs Unreliable (UDP) Transport:** TCP ensures delivery, UDP does not.

## 🧠 Memory Aids:

- **Top-to-bottom mnemonic** (Layer 7 → Layer 1):  
  **"All People Seem To Need Data Processing"**  

- **Bottom-to-top mnemonic** (Layer 1 → Layer 7):  
  **"Please Do Not Throw Sausage Pizza Away"**  

## 🏆 OSI vs TCP/IP Model:

- OSI is **theoretical**, TCP/IP is **practical**.
- TCP/IP combines **Application, Presentation, and Session** into a single **Application Layer**.
- TCP/IP only has **4 layers**: Application, Transport, Internet (Network), and Network Access (Data Link + Physical).





# 📚🗂️🎥 Resources

- https://www.9tut.com/osi-model-tutorial
  
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





