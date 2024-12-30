! - - - - - - - - - - - - - - - - - - - - START COPY - - - - - - - - - - - - - - - - - - - -
!############################################################################################
!                                                                                           #
!          @@@@@@@@@@@@@@@@@@             ((_.-'- Cisco Switch Generic Config -'-._))       #
!        @@@@@@@@@@@@@@@@@@@@@@@                                                            #
!      @@@@@@@@@@@@@@@@@@@@@@@@@@@            - Configuration for Cisco Switches -          #
!     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@                                                         #
!    @@@@@@@@@@@@@@@/      \@@@/   @      [+] Cyber-Weapon:............. Switch Config      #
!   @@@@@@@@@@@@@@@@\  O   @@  @ O @      [+] Version:.................. 2.0                #
!   @@@@@@@@@@@@@ @@@@@@@@@@  | \@@@@@    [+] Author:................... Fz3r0              #
!   @@@@@@@@@@@@@ @@@@@@@@@\__@_/@@@@@    [+] Github:................... github.com/Fz3r0   #
!    @@@@@@@@@@@@@@@/,/,/./´/_|.\`\,\     [+] Twitter:.................. @Fz3r0_OPs         #
!      @@@@@@@@@@@@@|  | | | | | | | |    [+] Youtube:.................. @Fz3r0_OPs         #
!                  \_|_|_|_|_|_|_|_|                                                        #
!                                                                                           #
!############################################################################################
!                                 !!! DISCLAIMER !!!                                        #
!############################################################################################
!                                                                                           #
!        THE AUTHOR ASSUMES NO RESPONSIBILITY OR LIABILITY FOR ANY DAMAGE OR ISSUES         #
!        THAT MAY ARISE FROM THE USE OR MISUSE OF THIS SCRIPT. USE AT YOUR OWN RISK.        #
!                                                                                           #
!############################################################################################
!    ((_.-`-+' Fz3r0 '+-´-._)) CISCO SWITCH GENERIC HIGH DENSITY NETWORK CONFIGURATION      #
!############################################################################################
! 
!   - THANK YOU FOR USING THIS CISCO SWITCH CONFIGURATION SCRIPT! 
!
!   - THIS SCRIPT IS INTENDED FOR HIGH DENSITY WIRED/WIRELESS NETWORKS
!    
!   - PLEASE READ THE INSTRUCTIONS CAREFULLY BEFORE PROCEEDING. 
!
!   - THIS SCRIPT INCLUDES SETUP FOR VLANS, IP ADDRESSING, DHCP, DNS, LLDP, 
!     AND VPN SETTINGS FOR OPTIMIZED NETWORK PERFORMANCE IN HIGH DENSITY ENVIRONMENTS.
!
!   - NOTE: MODIFY THE CONFIGURATIONS AS NEEDED FOR YOUR SPECIFIC SETUP. 
!           ALWAYS REVIEW EACH SECTION BEFORE APPLYING! 
!                                                                                          
!############################################################################################
!  + ENABLE & CONFIGURE
!############################################################################################
!
enable 
configure terminal
!
!############################################################################################
!  + MESSAGE OF THE DAY
!############################################################################################
!
banner motd #

=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

          -- Fz3r0 : JURASSIC PARK - SITE_A - NUBLAR ISLAND : LAS CINCO MUERTES --

+ DEVICE    =  SWITCH-001 (MDF)
+ TYPE      =  CORE SWITCH
+ SITE      =  SITE_A
+ LOCATION  =  MAINTANCE / UTILITY SHED
+ ADMIN 1   =  Fz3r0
+ ADMIN 2   =  Dennis Nedry

+ IP        =  10.1.0.10/16
+ GW        =  10.1.0.1 (FORTIGATE)

* Github : Fz3r0           
* Twitter: @fz3r0_OPs 
* Youtube: @fz3r0_OPs

=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

- PROPERTY OF In-Gen
- AUTORIZED PERSONAL ONLY! 
- VIOLATIONS WILL BE MONITORED, AND ACTION MAY BE TAKEN UNDER APPLICABLE CYBERSECURITY LAWS
- LOK TAR OGAR

=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

#
!
!############################################################################################
!  + HOSTNAME
!############################################################################################
!
hostname SW-01-MDF-SITE_A
!
!############################################################################################
!  + DOMAIN
!############################################################################################
!
no ip domain-lookup
ip domain-name Fz3r0.JP_SITE_A
!
!############################################################################################
!  + VLAN CONFIGURATION
!############################################################################################
!
vlan 1
name V1-DefaultVLAN=OFF
exit
!
vlan 10
name V10-MANAGEMENT
exit
!
vlan 50
name V50-ALFA_OPEN
exit
!
vlan 60
name V60-BRAVO_WPA2-PSK
exit
!
vlan 70
name V70-CHARLIE_802.1X-EAP
exit
!
vlan 80
name V80-DELTA_HOTSPOT-WISPr
exit
!
vlan 90
name V90-ECHO_HOTSPOT2.0-PASSPOINT
exit
!
vlan 66
name V66-HONEYPOT
exit
!
!############################################################################################
!  + VIRTUAL INTERFACE CONFIGURATION (MANAGEMENT VLAN & DEFAULT VLAN)
!############################################################################################
!
interface vlan 10
description MANAGEMENT-VIRTUAL-INTERFACE-V10
ip address 10.1.0.10 255.255.0.0
no shutdown
exit
!
interface vlan 1
shutdown
exit
!
!############################################################################################
!  + DEFAULT GATEWAY (FIREWALL/ROUTER MANAGEMENT IP)
!############################################################################################
!
ip default-gateway 10.1.0.1
!
!############################################################################################
!  + PHYSICAL INTERFACE CONFIGURATION
!############################################################################################
!
! ### WIRED ETHERNET LAN FOR PC's (ONLY 1 VLAN NEEDED)
!
interface range ethernet 0/0-3
switchport
description V50-ALFA_OPEN-WIRED_PC=ACCESS
switchport mode ACCESS
switchport ACCESS VLAN 50
switchport nonegotiate
lldp TRANSMIT
lldp RECEIVE
cdp ENABLE
spanning-tree PORTFAST
spanning-tree BPDUGUARD enable
ip DHCP SNOOPING limit rate 30
switchport port-security
switchport port-security MAXIMUM 2
switchport port-security mac-address F0:F0:F0:F0:F0:F0
switchport port-security mac-address sticky 
switchport port-security aging time 1440
switchport port-security violation shutdown
errdisable recovery cause psecure-violation
errdisable recovery interval 600
switchport port-security aging type inactivity
no shutdown
exit
!
! ### WIRED ETHERNET LAN FOR AP's (6 TAGGED/ALLOWED VLANS NEEDED & 1 TRUNK/MANAGEMENT)
!
interface range ethernet 1/0-3
switchport
description VLANS-50,60,70,80,90_WLAN-ACCESS-POINTS=TRUNK
switchport mode TRUNK
switchport TRUNK NATIVE vlan 10
switchport TRUNK ALLOWED vlan add 50,60,70,80,90
switchport nonegotiate
lldp TRANSMIT
lldp RECEIVE
cdp ENABLE
ip dhcp snooping TRUST
ip arp inspection TRUST
spanning-tree bpduguard DISABLE
spanning-tree portfast DISABLE
no shutdown
exit
!
! ### EMPTY INTERFACES (HONEYPOT + FULL SECURITY BLOCK EVERYTHING + OFF!!!)
!
interface range ethernet 2/0-1
switchport
description VLAN_66_HONEYPOT-EMPTY_INTERFACES=ACCESS(OFF)
switchport access vlan 69
switchport nonegotiate
NO lldp TRANSMIT
NO lldp RECEIVE
NO cdp ENABLE
spanning-tree PORTFAST
spanning-tree BPDUGUARD enable
ip DHCP SNOOPING limit rate 0
switchport port-security
switchport port-security MAXIMUM 1
switchport port-security mac-address F0:F0:F0:F0:F0:F0
switchport port-security aging time 1440
switchport port-security violation shutdown
errdisable recovery cause psecure-violation
errdisable recovery interval 600
switchport port-security aging type inactivity
shutdown
exit
!
! ### WIRED ETHERNET FOR SWITCH LINK CASCADE (6 TAGGED/ALLOWED VLANS NEEDED & 1 TRUNK/MANAGEMENT)
!
interface range ethernet 3/0-3
switchport
description VLANS-50,60,70,80,90-SWITCH-LINK-CASCADE=TRUNK
switchport mode TRUNK
switchport TRUNK NATIVE vlan 10
switchport TRUNK ALLOWED vlan add 50,60,70,80,90
switchport nonegotiate
lldp TRANSMIT
lldp RECEIVE
cdp ENABLE
no shutdown
exit
!
!############################################################################################
!  + USER CONFIGURATION
!############################################################################################
!
username Fz3r0-ROOT privilege 15 secret cisco12345
username User-ADMIN privilege 10 secret cisco12345
!
!############################################################################################
!  +  ENABLE PASSWORD + ADMINISTRATION LOGIN
!############################################################################################
!
enable secret fz3r012345
service password-encryption
security passwords min-length 10
login block-for 120 attempts 3 within 60
!          
!############################################################################################
!  + ADMINISTRATION + SSH CONFIGURATION + ENCRYPTION
!############################################################################################
!
! ### CONSOLE SERIAL INTERFACE (ALLOWED FOR ADMINISTRATION)
!
line console 0
password fz3r012345
login local
logging synchronous
exec-timeout 5 30
exit
!
! ### AUX INTERFACE (NON-ALLOWED FOR ADMINISTRATION / UNUSED)
!
line aux 0
privilege level 1
transport input none
transport output none
login local
no exec
exit
!
! ### VTY INTERFACE (Virtual Teletype for SSH/TELNET)
!
line vty 0 8
access-class 8 in
transport input ssh
login local
logging synchronous
exec-timeout 5 30
exit
!
! ### CRYPTOGRAPHIC RSA KEYS = 2048 BITS (256 BYTES) / SSH VERSION 2
!
crypto key generate rsa
2048
ip ssh version 2
exit
!
!############################################################################################
!  + CHECK CONFIGURATIONS
!############################################################################################
!
show vlan
show ip interface brief
show interface brief
show interface status
!
!############################################################################################
!  + CHECK PING TO GATEWAY AND CORE SWITCH
!############################################################################################
!
ping 10.1.0.1
ping 10.1.0.11
!
!############################################################################################
!  + SAVE CONFIGURATION
!############################################################################################
!
exit
end
write memory
!
!############################################################################################
!  + REBOOT SWITCH
!############################################################################################
!
reload
!
! - - - - - - - - - - - - - - - - - - - - - END COPY - - - - - - - - - - - - - - - - - - - -

