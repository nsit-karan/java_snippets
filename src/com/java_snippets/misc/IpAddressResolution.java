package com.java_snippets.misc;

import java.net.Inet6Address;
import java.net.InetAddress;

import org.bouncycastle.util.IPAddress;

import com.google.common.net.InetAddresses;

/*
 * Goal :
 * - figure out whether given ip is a valid ip or not
 * - only conclusive way possible is via regex.
 * 
 * Only java method which works for ipv6 with scope id is getByName which
 * does a lookup
 *         
 */
public class IpAddressResolution {
	
	
	public void formatIpAddress(String input) {
		boolean isIpAddress = InetAddresses.isInetAddress(input);
		if (isIpAddress) {
			System.out.println("IP address detected ");
		} else {
			System.out.println("Not an ip address");
		}
		
		try {
			InetAddress ipAddress = InetAddress.getByName(input);
			System.out.println("Able to parse the ip address");
			System.out.println(ipAddress.getHostAddress());
			
			if (ipAddress instanceof Inet6Address) {
				Inet6Address ipv6addr = (Inet6Address) ipAddress;
				System.out.println("Its an instance of ipv6 address");
				System.out.printf("sequnce id : %d", ipv6addr.getScopeId());
			} else {
				System.out.println("Its not an instance of ipv6 address");
			}
			
			
			System.out.println("Using bouncy castle library");
			boolean isValidIpv6 = IPAddress.isValidIPv6(input);
			if (isValidIpv6) {
				System.out.println("\nvalid ipv6");
			} else {
				System.out.println("\nNot a valid ipv6 address");
			}
			
			/*
			 * this throws exception : doesn't work for ipv6 with scopeid
			 * 
			 * - InetAddresses.forString(input);
			 * InetAddresses.forString(input);
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IpAddressResolution ip = new IpAddressResolution();
		ip.formatIpAddress("11.22.72.181");
		
		System.out.println("------------TRYING IPv6 adress with scope  --------------------");
		ip.formatIpAddress("fe80:0:0:0:768f:9950:4907:1134%12");

		System.out.println("------------TRYING normal IPv6 adress --------------------");
		ip.formatIpAddress("fe80:0:0:0:8765:1234:9874:2343");

		System.out.println("------------TRYING random address --------------------");
		ip.formatIpAddress("www.goooooogle.com");

		
	}

}
