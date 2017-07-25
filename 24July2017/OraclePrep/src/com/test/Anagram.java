package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagram {
	private static class AnaGram implements Comparable<AnaGram>{
		String str;
		int index;
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int compareTo(AnaGram s1){
			return this.str.compareTo(s1.str);
		}
	}
	public static void main(String[] args) {
		String [] str={"cat", "dog", "tac", "god", "act"};
		List<AnaGram> lst=new ArrayList<AnaGram>();
		int index=0;
		String stTest="";
		for(String s:str){
			char []chAr=s.toCharArray();
			AnaGram anGram=new AnaGram();
			Arrays.sort(chAr);
			String sTest=new String(chAr);
			anGram.setStr(new String(sTest));
			anGram.setIndex(index++);
			lst.add(anGram);
		}
		Collections.sort(lst);
		for(AnaGram an:lst){
			
		}
		System.out.println();
	}

}
