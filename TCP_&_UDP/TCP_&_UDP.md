# 🔥🧱🛡️ Cisco CCNA: `TCP & UDP`

![My Video](https://user-images.githubusercontent.com/94720207/165892585-b830998d-d7c5-43b4-a3ad-f71a07b9077e.gif)

### 🐦 Twitter  : [@fz3r0_OPs](https://twitter.com/Fz3r0_OPs)
### 🐱 Github  : [Fz3r0](https://github.com/fz3r0) 

---
 
#### Keywords: `TCP & UDP` `TCP` `UDP`

---

# TCP & UDP

## Overview

- **TCP**: Reliable, slower, connection-oriented.
- **UDP**: Unreliable, faster, connectionless.

## Key Differences

| Feature               | **TCP**                        | **UDP**                        |
|-----------------------|--------------------------------|--------------------------------|
| **Reliability**        | Reliable (error correction, retransmissions) | Unreliable (no error correction) |
| **Speed**              | Slower (due to error handling and overhead) | Faster (no error correction) |
| **Connection Type**    | Connection-oriented (establishes and terminates a connection) | Connectionless (no setup needed) |
| **Overhead**           | High (more control bits for tracking and acknowledgment) | Low (minimal overhead) |
| **Use Cases**          | Web, email, file transfers (e.g., FTP, HTTP, SMTP) | Real-time applications (e.g., VoIP, video streaming) |
| **Segmentation**       | Segments are larger due to error checking | Smaller segments (fewer checks) |
| **Flow Control**       | Yes (TCP can adjust speed based on congestion) | No (no flow control) |

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

## TCP vs UDP Headers

![image](https://github.com/user-attachments/assets/541cb782-7b56-44f6-b6a0-dfdcf1014572)
















# https://www.9tut.com/tcp-and-udp-tutorial





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





