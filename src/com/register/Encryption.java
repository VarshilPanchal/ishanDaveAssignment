package com.register;
import java.security.MessageDigest;
	public class Encryption {
		public String encrypt(String password) {
			StringBuilder sb=new StringBuilder();
			String algorithm="SHA";
			byte plaintext[]=password.getBytes();
			try {
				MessageDigest md=MessageDigest.getInstance(algorithm);
				md.reset();
				md.update(plaintext);
				byte encodedPassword[]=md.digest();
				
				for(int i=0;i<encodedPassword.length;i++) {
					if((encodedPassword[i] & 0xff)< 0x10) {
						sb.append("a");
					}
					sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
					
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return sb.toString();
			
		
		}
	}

