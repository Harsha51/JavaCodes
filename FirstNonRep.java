// WAP to find non-repitative character in a String. If no character has count =1 then return '$' else retrun character.

/* Inorder to find the non repitative character of string, first we need to count the each character repitation
*          It is better to use LinkedHashMap, as i can store count of each character along with character in K,V pair along with preserving insertion order.
*          Then i use for loop to iterate over the HashMap for each character and insert into HashMap object, with getOrDefault(,) where it works 
*           a way like checking the key in HashMap; if key is present, our described logic (+1 in our case) if not a deafult passed will be saved given in method args.
*
*  Later, we iterate the Map object using enhanced for loop with entrySet() method referencing from HashMap object. which give us [k,v] 
*  Now we check the value, if value is 1 then we return that character using getValue() -- return getKey() 
*/

import java.lang.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstNonRep{
    public Character nonRepitativeCharacter(String s){
        Map<Character, Integer> hm = new LinkedHashMap<>();
		s = s.toLowerCase();
		
		for(Character ch : s.toCharArray()){
		    hm.put(ch, hm.getOrDefault(ch, 0)+1);
		}
		for(Map.Entry<Character, Integer> entry : hm.entrySet()){
		    if(entry.getValue() == 1){
			   return entry.getKey();
		    }
		}
			return '$';   
   }
   public static void main(String[] args){
        FirstNonRep fnr = new FirstNonRep();
		System.out.println(fnr.nonRepitativeCharacter("JavaTech"));
   }

}