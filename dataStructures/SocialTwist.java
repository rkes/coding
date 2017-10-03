public class SocialTwist {

	public static void main(String[] args) {
		String[] s1="SOCIA*TWIST".split("\\*");
		String[] s2="SOCIALTWI*T".split("\\*");
		int maxO=Math.max(s1[0].length(), s2[0].length());
		int max1=Math.max(s1[1].length(), s2[1].length());
		String parent="";
		int start=0;
		int parentStart=0;
		if(maxO>max1){
			if(s1[0].length()>s2[0].length()){
				parent=s1[0];
				canContainStringUtil(s1[0],new StringBuilder(s2[0]));
			}
			else{
				parent=s2[0];
				canContainStringUtil(s2[0],new StringBuilder(s1[0]));
			}
			
		}
		else{
			start=1;
			parentStart=1;
			if(s1[1].length()>s2[1].length()){
				parent=s1[1];
			}
			else{
				parent=s2[1];
			}
		}
		
		
			
		

	}
	public static boolean canContainStringUtil(String s1,StringBuilder s2Builder){
		String s2=s2Builder.toString();
		if(s1.length()<s2.length()){
			String temp=s1;
			s1=s2;
			s2=temp;
		}
		char []s2ArrTemp=new char[s1.length()];
		int i=0;
		for(int j=0;i<s2.length();i++,j++){
			if(s1.charAt(i)==s2.charAt(j))
				s2ArrTemp[i]=s1.charAt(i);
			else
				return false;
		}
		while(i<s2.length()){
			s2ArrTemp[i]=s1.charAt(i++);
		}
		s2Builder.delete(0, s2Builder.length());
		s2Builder.append(new String(s2ArrTemp));
		return true;
	}

}
