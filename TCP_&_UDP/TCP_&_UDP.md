# 🔥🧱🛡️ Cisco CCNA: `TCP & UDP`

![My Video](https://user-images.githubusercontent.com/94720207/165892585-b830998d-d7c5-43b4-a3ad-f71a07b9077e.gif)

### 🐦 Twitter  : [@fz3r0_OPs](https://twitter.com/Fz3r0_OPs)
### 🐱 Github  : [Fz3r0](https://github.com/fz3r0) 

---
 
#### Keywords: `TCP & UDP` `TCP` `UDP`

---

# TCP & UDP

Transmission Control Protocol (TCP) and User Datagram Protocol (UDP) are both protocols that transfer data over the internet. TCP is more reliable, while UDP is faster but less reliable. 

TCP and UDP are both part of the Transport Layer, which ensures reliable data transfer between systems. A hybrid approach that uses both TCP and UDP can be used to address the challenges of data transfer. 

## Overview

- **TCP**: Reliable, slower, connection-oriented.
- **UDP**: Unreliable, faster, connectionless.

## TCP VS UDP

| **Feature**               | **TCP**                                                | **UDP**                                           |
|---------------------------|--------------------------------------------------------|---------------------------------------------------|
| **Reliability**            | Reliable (error correction, retransmissions)           | Unreliable (no error correction)                 |
| **Speed**                  | Slower (due to error handling and overhead)            | Faster (no error correction)                     |
| **Connection Type**        | Connection-oriented (establishes and terminates a connection) | Connectionless (no setup needed)                |
| **Overhead**               | High (more control bits for tracking and acknowledgment) | Low (minimal overhead)                          |
| **Use Cases**              | Web, email, file transfers (e.g., FTP, HTTP, SMTP)     | Real-time applications (e.g., VoIP, video streaming) |
| **Segmentation**           | Segments are larger due to error checking              | Smaller segments (fewer checks)                  |
| **Flow Control**           | Yes (TCP can adjust speed based on congestion)         | No (no flow control)                             |
| **Retransmission**         | Yes (on error)                                        | No retransmission                                 |
| **Sequence Numbers**       | Yes                                                   | No                                                |
| **Acknowledgments**        | Yes                                                   | No                                                |
| **Handshakes**             | 3-way handshake (Start) + 4-way termination (End)      | None                                              |
| **Error Recovery**         | Yes                                                   | No                                                |
| **Error Detection**        | Yes                                                   | Yes (checksum only)                               |


## TCP vs UDP

![image](https://github.com/user-attachments/assets/6467263f-3f04-4fa2-b953-915df99af28f)

- **TCP**: Guarantees reliable delivery with error checking, but slower due to the overhead.
- **UDP**: Provides faster delivery without error checking, suitable for real-time applications where slight data loss is acceptable.

### Three-Way Handshake (Connection Setup)

1. **SYN**: Host A sends SYN to Host B with a sequence number (SEQ=x).
2. **SYN-ACK**: Host B replies with SYN-ACK, using sequence number (y) and ACK number (x+1).
3. **ACK**: Host A sends ACK with number (y+1), confirming the connection.

### Four-Way Termination (Connection Teardown)

1. **FIN**: Host A sends FIN to terminate the connection.
2. **ACK**: Host B acknowledges the FIN.
3. **FIN**: Host B sends its own FIN.
4. **ACK**: Host A acknowledges Host B’s FIN, ending the connection.

### Sequence & Acknowledgment Numbers

- TCP uses **sequence numbers** (SEQ) to track data order.
- **Acknowledgment numbers** (ACK) confirm receipt of data.

## When to Use TCP or UDP

- **TCP**: When data reliability and accuracy are crucial (e.g., file transfer, web browsing).
- **UDP**: When speed is more critical than reliability (e.g., VoIP, video streaming).


# TCP Features 

This cheatsheet covers key features of TCP, including multiplexing using port numbers, flow control, and reliability (error detection and recovery).

## 1. **Multiplexing using Port Numbers**

Multiplexing allows multiple applications to use the same network interface simultaneously by distinguishing them using **port numbers**. When you run multiple applications (e.g., web browsing, email, FTP), each will use a unique port number to identify which data belongs to which application.

### Port Number Ranges:

### Port Number Ranges

| **Port Range**                       | **Number Range**    | **Description**                                      |
|--------------------------------------|---------------------|------------------------------------------------------|
| **Total TCP/UDP ports**              | 65536               | All TCP/UDP Ports available                         |
| **Well-known port numbers**          | 0–1023              | Assigned to key core services.                      |
| **Registered port numbers**          | 1024–49151          | Assigned to industry applications.                  |
| **Dynamic port numbers**             | 49152–65535         | Temporary ports used for communication.             |


### Common Well-Known Ports:

| **TCP Service** | **Description**                    | **Port** |
|-----------------|------------------------------------|----------|
| FTP             | File Transfer Protocol             | 20, 21   |
| SSH             | Secure Shell                        | 22      |
| Telnet          | Terminal Network                    | 23      |
| SMTP            | Simple Mail Transfer Protocol       | 25      |
| DNS             | Domain Name Server                  | 53      |
| HTTP            | Hyper Text Transfer Protocol        | 80      |
| HTTPS           | Hyper Text Transfer Protocol Secure | 443     |

### HINT: What is a Socket?

A **socket** consists of three components:

- **IP address**
- **Transport protocol** (e.g., TCP)
- **Port number**

Example: A socket on your laptop for web browsing might look like:

- `(123.1.1.1:50000)` for your laptop.
- `(200.1.1.1:80)` for the web server.

This combination uniquely identifies a connection.



## 2. **Flow Control Using Windowing**

Flow control manages the rate at which data is sent to ensure that the receiver is not overwhelmed.

### Windowing Concept:

- **Window size**: Indicates how much data can be sent before an acknowledgment is required.
- **Sliding window**: The window size can vary during the connection's lifetime.

#### Example:

- A **window size of 1** means the sender must wait for an acknowledgment after each byte.
- A **window size of 3** means the sender can send 3 bytes before waiting for an acknowledgment.

When a congestion occurs or ACKs are delayed, the window size is reduced to slow down transmission.

### Window Size in Action:

- If **Host A** sends segments 1, 2, and 3, and **Segment 2** is lost, **Host B** sends an **ACK 2** back to **Host A**, indicating it is expecting **Segment 2** next.
- **Host A** resends **Segment 2**, and **Host B** can then proceed to ACK **Segment 4**.


## 3. **Reliability (Error Detection and Error Recovery)**

- **Error detection**: Identifies corrupted data using checksums.
- **Error recovery**: Ensures lost or corrupted data is resent using **Sequence Numbers** and **Acknowledgments**.

### How it Works:

1. **Error Detection**: Each segment includes a checksum. The sender calculates it and the receiver checks if it matches.
2. **Error Recovery**: If a segment is lost or corrupted, the receiver will not send an ACK. The sender then retransmits the segment.

If the **ACK** for a segment is lost, the sender waits for a **retransmission timer** to expire before retransmitting all segments.



---

## 4. **TCP and UDP Headers**

### TCP Header:

The **TCP header** is typically 20 bytes and contains various fields like the source and destination port numbers, sequence number, acknowledgment number, flags, and more.

#### Key Fields:
- **Flags**: Used for controlling connection establishment and termination (e.g., SYN, ACK).
- **Sequence Number**: Used for sequencing segments.
- **Window Size**: Indicates how many bytes the receiver can accept.

---

### UDP Header:

The **UDP header** is much simpler, consisting of only four fields:
1. Source Port
2. Destination Port
3. Length
4. Checksum

Unlike TCP, UDP does not provide reliability or flow control.

---

By understanding these TCP features, you'll have a solid foundation for networking and troubleshooting TCP connections.













## TCP vs UDP Headers

![image](https://github.com/user-attachments/assets/541cb782-7b56-44f6-b6a0-dfdcf1014572)
















# https://www.9tut.com/tcp-and-udp-tutorial





# 📚🗂️🎥 Resources

- https://www.9tut.com/osi-model-tutorial
- https://www.google.com/search?q=tcp+and+udp&rlz=1C1VDKB_esMX1103MX1103&oq=tcp+and+udp&gs_lcrp=EgZjaHJvbWUyDggAEEUYORhDGIAEGIoFMgwIARAAGEMYgAQYigUyDAgCEAAYQxiABBiKBTIMCAMQABhDGIAEGIoFMgcIBBAAGIAEMgYIBRBFGDwyBggGEEUYPDIGCAcQRRhB0gEIMTM0M2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8
  
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





