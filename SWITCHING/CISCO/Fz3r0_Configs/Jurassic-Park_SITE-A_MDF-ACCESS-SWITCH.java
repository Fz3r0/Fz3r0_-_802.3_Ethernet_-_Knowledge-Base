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

+ DEVICE    =  SWITCH-002 (IDF_B) = ACCESS
+ SITE      =  SITE_A
+ LOCATION  =  RAPTOR PADDOK
+ ADMIN 1   =  Fz3r0
+ ADMIN 2   =  Dennis Nedry

+ IP        =  10.1.0.12/16
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
hostname SW2-IDF_B-SITE_A
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
name VLAN_1_default=OFF
exit
!
vlan 2
name VLAN_2_ALFA
exit
!
vlan 3
name VLAN_3_BRAVO
exit
!
vlan 4
name VLAN_4_CHARLY
exit
!
vlan 5
name VLAN_5_DELTA
exit
!
vlan 6
name VLAN_6_ECHO
exit
!
vlan 7
name VLAN_7_FOXTROT
exit
!
vlan 69
name VLAN_69_honeypot
exit
!
vlan 66
name VLAN_66_MANAGEMENT
exit
!
!############################################################################################
!  + VIRTUAL INTERFACE CONFIGURATION (MANAGEMENT VLAN & DEFAULT VLAN)
!############################################################################################
!
interface vlan 66
ip address 10.1.0.12 255.255.0.0
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
description VLAN_2_ALFA-WIRED_PC=ACCESS
switchport mode ACCESS
switchport ACCESS VLAN 2
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
description VLANS-3,4,5,6,7-ACCESS_POINTS=TRUNK
switchport mode TRUNK
switchport TRUNK NATIVE vlan 66
switchport TRUNK ALLOWED vlan add 3,4,5,6,7
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
description VLAN_69_honeypot-EMPTY_INTERFACES=ACCESS(OFF)
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
description VLANS-3,4,5,6,7-SWITCH-LINK-CASCADE=TRUNK
switchport mode TRUNK
switchport TRUNK NATIVE vlan 66
switchport TRUNK ALLOWED vlan add 3,4,5,6,7
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
!  + ENCRYPTION & SSH CONFIGURATION
!############################################################################################
!
! ### ENABLE PASSWORD
!
enable secret fz3r012345
service password-encryption
security passwords min-length 10
login block-for 120 attempts 3 within 60
!
! ### CONSOLE PORT (ALLOWED FOR ADMINISTRATION)
!
line console 0
password fz3r012345
login local
logging synchronous
exec-timeout 5 30
exit
!
line aux 0
privilege level 1
transport input none
transport output none
login local
no exec
exit
!
! ### SSH VTY CONFIGURATION
!
line vty 0 8
access-class 8 in
transport input ssh
login local
logging synchronous
exec-timeout 5 30
exit
!
! ### CRYPTO RSA FOR 2048 BITS VERSION 2
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


