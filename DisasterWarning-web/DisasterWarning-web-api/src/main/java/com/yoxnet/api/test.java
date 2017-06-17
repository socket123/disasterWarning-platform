package com.yoxnet.api;


public class test {
	public static void main(String[] args) {
			String a = "306省道521";
			String b = "306省道536";
			String c = "";
			
			char[] as = a.toCharArray();
			char[] bs = b.toCharArray();
			
			int leng = 0;
			
			if(as.length > bs.length){
				leng = bs.length;
			}else{
				leng = as.length;
			}
			
			for(int i=0;i<leng;i++){
				
				if(as[i] == bs[i]){
					c +=as[i]; 
				}else{
					break;
				}
				
			}
			
			System.out.println(c);
			
	}
}
