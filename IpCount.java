/*  Q2. Find the count of ip's that visited have been visited from log file
*          i/p: "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234" 
*               "10.0.0.2 - pop [10/Dec/2000:12:44:16 -0500] \"GET /a.gif HTTP/1.0\" 200 234"
*               "10.0.0.1 - John [10/Dec/2000:13:07:26 -0500] \"GET /a.gif HTTP/1.0\" 200 234"
*               "10.0.0.3 - Peter [10/Dec/2000:22:54:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234"
*               "10.0.0.3 - Robert [10/Dec/2000:04:21:28 -0500] \"GET /a.gif HTTP/1.0\" 200 234"
*          
*          o/p: 10.0.0.1, 10.0.0.3
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class IpCount{
	public String freqIpCount(String[] lines){
		
		Map<String, Integer> hm = new HashMap<>();
		
		for(String line : lines){
			String ip = line.split(" ")[0];
			hm.put(ip, hm.getOrDefault(ip, 0)+1);
		}
		
		int maxCount = Collections.max(hm.values());
		
		List<String> ipAddress = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : hm.entrySet()){
		    if(entry.getValue() == maxCount)
			    ipAddress.add(entry.getKey());
		}
		return String.join(",", ipAddress);
	}
  
    public static void main(String[] args){
        IpCount ipc = new IpCount();
		String[] lines = new String[]{"10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234", 
               "10.0.0.2 - pop [10/Dec/2000:12:44:16 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
               "10.0.0.1 - John [10/Dec/2000:13:07:26 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
               "10.0.0.3 - Peter [10/Dec/2000:22:54:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
		"10.0.0.3 - Robert [10/Dec/2000:04:21:28 -0500] \"GET /a.gif HTTP/1.0\" 200 234"};
		System.out.println("Repitative Ip : "+ ipc.freqIpCount(lines));
			   
    }		
	
}