package com.tyh.code;

public class Compare_Version_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "01.0";
		String version2 = "1";
		System.out.println(new Compare_Version_Numbers().compareVersion(version1, version2));
	}

    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) return 0;
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        int low = version1s.length < version2s.length ? version1s.length : version2s.length;
        int index = 0;
        while(index < low){
            int version1cur = Integer.parseInt(version1s[index]);
            int version2cur = Integer.parseInt(version2s[index]);
            if(version1cur > version2cur){
                return 1;
            }
            else if(version1cur < version2cur){
                return -1;
            }
            else{
                index++;
            }
        }
        if(version1s.length == version2s.length) return 0;
        if(version1s.length > version2s.length){
        	while(index < version1s.length){
        		if(Integer.parseInt(version1s[index]) != 0){
        			return 1;
        		}
        		index++;
        	}
        }
        else{
        	while(index < version2s.length){
        		if(Integer.parseInt(version2s[index]) != 0){
        			return -1;
        		}  
        		index++;
        	}
        }
        return 0;
    }
}
