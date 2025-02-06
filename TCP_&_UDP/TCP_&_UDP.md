# 🔥🧱🛡️ Cisco CCNA: `TCP & UDP`

![My Video](https://user-images.githubusercontent.com/94720207/165892585-b830998d-d7c5-43b4-a3ad-f71a07b9077e.gif)

### 🐦 Twitter  : [@fz3r0_OPs](https://twitter.com/Fz3r0_OPs)
### 🐱 Github  : [Fz3r0](https://github.com/fz3r0) 

---
 
#### Keywords: `TCP & UDP` `TCP` `UDP`

---

# 📦 TCP & UDP

Transmission Control Protocol (TCP) and User Datagram Protocol (UDP) are both protocols that transfer data over the internet. TCP is more reliable, while UDP is faster but less reliable. 

TCP and UDP are both part of the Transport Layer, which ensures reliable data transfer between systems. A hybrid approach that uses both TCP and UDP can be used to address the challenges of data transfer. 

## ⚡ TCP vs UDP

![image](https://github.com/user-attachments/assets/6467263f-3f04-4fa2-b953-915df99af28f)

- **📦 TCP**: **Reliable, slower, connection-oriented.** :: Guarantees reliable delivery with error checking, but slower due to the overhead.
- **⚡ UDP**: **Unreliable, faster, connectionless.** :: Provides faster delivery without error checking, suitable for real-time applications where slight data loss is acceptable.

| **Feature**               | **📦 TCP**                                               | **⚡ UDP**                                           |
|---------------------------|---------------------------------------------------------|-----------------------------------------------------|
| **Reliability**            | Reliable <br> (error correction, retransmissions) 📋         | Unreliable<br>  (no error correction) ❌                 |
| **Speed**                  | Slower<br>  (due to error handling and overhead) 🐢          | Faster<br>  (no error correction) 🚀                    |
| **Connection Type**        | Connection-oriented<br>  (establishes and terminates a connection) 🔗 | Connectionless<br>  (no setup needed) 🌐               |
| **Overhead**               | High<br>  (more control bits for tracking and acknowledgment) 📊 | Low<br>  (minimal overhead) 📉                           |
| **Use Cases**              | Web, email, file transfers (e.g., FTP, HTTP, SMTP) 🌍  | Real-time applications (e.g., VoIP, video streaming) 📞 🎥 |
| **Segmentation**           | Segments are larger due to error checking 🔍           | Smaller segments<br>  (fewer checks) 🧩                  |
| **Flow Control**           | Yes<br>  (TCP can adjust speed based on congestion) ⚖️       | No<br>  (no flow control) 🚫                            |
| **Retransmission**         | Yes<br>  (on error) 🔄                                      | No retransmission 🚫                               |
| **Sequence Numbers**       | Yes<br>  🧮                                                 | No                                                  |
| **Acknowledgments**        | Yes<br>  ✅                                                 | No                                                  |
| **Handshakes**             | 3-way handshake (Start) + 4-way termination (End) ✋🤚  | None                                                |
| **Error Recovery**         | Yes<br>  🔧                                                | No                                                  |
| **Error Detection**        | Yes<br>  ✅                                                | Yes <br>  (but checksum only!!!) 🧮                              |

### 🔑 Three-Way Handshake (Connection Setup)

1. **SYN**: Host A sends SYN to Host B with a sequence number (SEQ=x).
2. **SYN-ACK**: Host B replies with SYN-ACK, using sequence number (y) and ACK number (x+1).
3. **ACK**: Host A sends ACK with number (y+1), confirming the connection.

### ⚰️ Four-Way Termination (Connection Teardown)

1. **FIN**: Host A sends FIN to terminate the connection.
2. **ACK**: Host B acknowledges the FIN.
3. **FIN**: Host B sends its own FIN.
4. **ACK**: Host A acknowledges Host B’s FIN, ending the connection.

### 🔢 Sequence & Acknowledgment Numbers

- TCP uses **sequence numbers** (SEQ) to track data order.
- **Acknowledgment numbers** (ACK) confirm receipt of data.

## 💡 When to Use TCP or UDP

- **📦 TCP**: When data reliability and accuracy are crucial (e.g., file transfer, web browsing). 
- **⚡ UDP**: When speed is more critical than reliability (e.g., VoIP, video streaming).


# 📦 TCP Features 

This cheatsheet covers key features of TCP, including multiplexing using port numbers, flow control, and reliability (error detection and recovery).

## 1. **🔢 Multiplexing using Port Numbers**

Multiplexing allows multiple applications to use the same network interface simultaneously by distinguishing them using **port numbers**. When you run multiple applications (e.g., web browsing, email, FTP), each will use a unique port number to identify which data belongs to which application.

### 📌 Port Number Ranges:

| **Port Range**                       | **Number Range**    | **Description**                                      |
|--------------------------------------|---------------------|------------------------------------------------------|
| **Total TCP/UDP ports**              | 65536               | All TCP/UDP Ports available                         |
| **Well-known port numbers**          | 0–1023              | Assigned to key core services.                      |
| **Registered port numbers**          | 1024–49151          | Assigned to industry applications.                  |
| **Dynamic port numbers**             | 49152–65535         | Temporary ports used for communication.             |


### 🌍 Common Well-Known Ports:

| **TCP Service** | **Description**                    | **Port** |
|-----------------|------------------------------------|----------|
| FTP             | File Transfer Protocol             | 20, 21   |
| SSH             | Secure Shell                        | 22      |
| Telnet          | Terminal Network                    | 23      |
| SMTP            | Simple Mail Transfer Protocol       | 25      |
| DNS             | Domain Name Server                  | 53      |
| HTTP            | Hyper Text Transfer Protocol        | 80      |
| HTTPS           | Hyper Text Transfer Protocol Secure | 443     |

### 💡 HINT: What is a Socket?

A **socket** consists of three components:

- **IP address**
- **Transport protocol** (e.g., TCP)
- **Port number**

Example: A socket on your laptop for web browsing might look like:

- `(123.1.1.1:50000)` for your laptop.
- `(200.1.1.1:80)` for the web server.

This combination uniquely identifies a connection.

## 2. **⚙️ Flow Control Using Windowing**

Flow control manages the rate at which data is sent to ensure that the receiver is not overwhelmed.

### 🪟 Windowing Concept:

- **Window size**: Indicates how much data can be sent before an acknowledgment is required.
- **Sliding window**: The window size can vary during the connection's lifetime.

#### 📊 Example:

- A **window size of 1** means the sender must wait for an acknowledgment after each byte.
- A **window size of 3** means the sender can send 3 bytes before waiting for an acknowledgment.

When congestion occurs or ACKs are delayed, the window size is reduced to slow down transmission.

### 🚦 Window Size in Action:

- If **Host A** sends segments 1, 2, and 3, and **Segment 2** is lost, **Host B** sends an **ACK 2** back to **Host A**, indicating it is expecting **Segment 2** next.
- **Host A** resends **Segment 2**, and **Host B** can then proceed to ACK **Segment 4**.

## 3. **🔧 Reliability (Error Detection and Error Recovery)**

- **Error detection**: Identifies corrupted data using checksums.
- **Error recovery**: Ensures lost or corrupted data is resent using **Sequence Numbers** and **Acknowledgments**.

### 🔄 How it Works:

1. **Error Detection**: Each segment includes a checksum. The sender calculates it and the receiver checks if it matches.
2. **Error Recovery**: If a segment is lost or corrupted, the receiver will not send an ACK. The sender then retransmits the segment.

If the **ACK** for a segment is lost, the sender waits for a **retransmission timer** to expire before retransmitting all segments.



## 4. **📝 TCP and UDP Headers**

![image](https://github.com/user-attachments/assets/541cb782-7b56-44f6-b6a0-dfdcf1014572)

## 📜 TCP Header

The **TCP header** is typically 20 bytes and contains various fields like the source and destination port numbers, sequence number, acknowledgment number, flags, and more.

| **Field**                | **Size (bits)** | **Description**                                                                                             |
|--------------------------|-----------------|-------------------------------------------------------------------------------------------------------------|
| **Source Port**           | 16              | Identifies the sending port.                                                                                |
| **Destination Port**      | 16              | Identifies the receiving port.                                                                              |
| **Sequence Number**       | 32              | Identifies the sequence number of the first byte of data in this segment.                                   |
| **Acknowledgment Number** | 32              | If ACK flag is set, it indicates the next sequence number the sender expects to receive.                    |
| **Data Offset**           | 4               | Specifies the size of the TCP header in 32-bit words.                                                        |
| **Reserved**              | 3               | Reserved for future use; should be set to zero.                                                              |
| **Flags**                 | 9               | Contains control flags: CWR, ECE, URG, ACK, PSH, RST, SYN, FIN.                                             |
| **Window Size**           | 16              | Specifies the number of bytes the sender is willing to accept from the receiver.                            |
| **Checksum**              | 16              | Provides error-checking for the header, payload, and an IP pseudo-header.                                   |
| **Urgent Pointer**        | 16              | If the URG flag is set, it points to the last urgent data byte.                                              |
| **Options**               | Variable        | Allows for various extensions or options (e.g., Maximum Segment Size, Time Stamp).                           |
| **Data**                  | Variable        | The payload data being transmitted.                                                                          |


## UDP Header

The **UDP header** is much simpler, consisting of only four fields (+ Data), Unlike TCP, UDP does not provide reliability or flow control:

| **Field**            | **Size (bits)** | **Description**                                                                                 |
|----------------------|-----------------|-------------------------------------------------------------------------------------------------|
| **Source Port**       | 16              | Identifies the sender's port.                                                                   |
| **Destination Port**  | 16              | Identifies the receiver's port.                                                                 |
| **Length**            | 16              | Specifies the length of the UDP datagram, including both header and data.                        |
| **Checksum**          | 16              | Optional in IPv4 for error-checking of the header and data. Required in most cases in IPv6.       |
| **Data**              | Variable        | The payload data being transmitted.                                                              |

## Differences Between TCP and UDP Headers

| **Field**            | **TCP**                                          | **UDP**                                          |
|----------------------|-------------------------------------------------|-------------------------------------------------|
| **Header Length**    | 20–60 bytes (with options)                      | 8 bytes                                         |
| **Reliability**      | Provides reliable delivery (acknowledgments, retransmissions, flow control) | Unreliable (no acknowledgment, no retransmission) |
| **Connection**       | Connection-oriented (establishes and terminates connections) | Connectionless (no setup or teardown)          |
| **Flow Control**     | Yes, uses window size for flow control          | No flow control                                |
| **Error Checking**   | Checks header and data (checksum)               | Checks header and data (checksum, optional in IPv4) |
| **Segmentation**     | Segments data into smaller pieces if needed     | Does not segment; the application must handle it |
| **Speed**           | Slower (due to reliability and connection management) | Faster (less overhead)                         |































# https://www.9tut.com/tcp-and-udp-tutorial





# 📚🗂️🎥 Resources

- https://www.9tut.com/osi-model-tutorial
- https://www.google.com/search?q=tcp+and+udp&rlz=1C1VDKB_esMX1103MX1103&oq=tcp+and+udp&gs_lcrp=EgZjaHJvbWUyDggAEEUYORhDGIAEGIoFMgwIARAAGEMYgAQYigUyDAgCEAAYQxiABBiKBTIMCAMQABhDGIAEGIoFMgcIBBAAGIAEMgYIBRBFGDwyBggGEEUYPDIGCAcQRRhB0gEIMTM0M2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8
- https://digilent.com/blog/udp-vs-tcp/
- https://en.wikipedia.org/wiki/User_Datagram_Protocol
- https://en.wikipedia.org/wiki/Transmission_Control_Protocol
  
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





