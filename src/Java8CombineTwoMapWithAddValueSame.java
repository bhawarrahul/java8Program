import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Java8CombineTwoMapWithAddValueSame
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Map<String, Integer> map1 = new HashMap<>();
    	map1.put("Saturday",40);
        map1.put("Sunday",20);    
    
    	Map<String, Integer> map2 = new HashMap<>();
		map2.put("Saturday",40);
        map2.put("Monday",50);            
    	
    	HashMap<String, Integer> map4 = 
                Stream.of(map1, map2)
                      .flatMap(map -> map.entrySet().stream())
                      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) ->v1+v2, HashMap::new));
    	System.out.println(map4);
        
	}
}
