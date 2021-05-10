package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;



public class StreamExample {
	
	//@Test
	public void regularData()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("nanda");
		al.add("badri");
		al.add("pokiri");
		al.add("mani");
		int count=0;
		for (int j = 0; j < al.size(); j++) 
		{
			String actual=al.get(j);
			if(actual.endsWith("i"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	//@Test
	public void streamfilter()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("nanda");
		al.add("badri");
		al.add("pokiri");
		al.add("mani");
		long l=al.stream().filter(s->s.startsWith("p")).count();
		System.out.println(l);
		
		long d=Stream.of("nanda","badri","pokiri","mani").filter(s->
		{
			s.startsWith("p");
			return true;
		}).count();
		System.out.println(d);
		
		al.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		al.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	}
   // @Test
    public void streammap()
    {
    	Stream.of("nanda","badri","pokiri","mani").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    	
    	//converting array to arraylist
    	List<String> names=Arrays.asList("nanda","badri","pokiri","mani");
    	names.stream().filter(s->s.endsWith("i")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    	
    	
    	List<String> names1=Arrays.asList("puri","ism","profanity","stoicism");
    	names1.stream().filter(s->s.endsWith("m")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    	//merging 2 different lists
    	Stream<String> newstring=Stream.concat(names.stream(),names1.stream());
    	//newstring.sorted().forEach(s->System.out.println(s));
    	
    	boolean flag=newstring.anyMatch(s->s.equalsIgnoreCase("profanity"));
    	Assert.assertTrue(flag);
    	System.out.println(flag);
    }
    @Test
    public void streamCollect()
    {
    	List<String> al=Stream.of("nanda","badri","pokiri","mani").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());
    	//System.out.println(al.get(0));
    	Assert.assertEquals(al.get(1),"POKIRI");
    	
    	//print unique number from this array
    	
    	List<Integer> values=Arrays.asList(4,5,6,4,5,6,9);
    	values.stream().distinct().forEach(s->System.out.println(s));
    
    	//print the third no using sorting.f
    	
    	//List<Integer> all=values.stream().distinct().sorted().collect(Collectors.toList());
    	//System.out.println(all.get(2));
    }
}
