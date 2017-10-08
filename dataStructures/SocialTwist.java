public class SocialTwist {


	public static void main(String[] args) {
		String str1="*C";
		String str2="B*";
		//SOCIALTTWQI  TWQIRT  OP :-SOCIALTTWQIRT 
		String []str1Arr=str1.split("\\*"); 
		String []str2Arr=str2.split("\\*");
		if((str1Arr.length==1||str2Arr.length==1)||(str1Arr.length==0||str2Arr.length==0)||(str1Arr[0].length()==0||str2Arr[0].length()==0)){
			if(str1.charAt(0)=='*'&&str2.charAt(str2.length()-1)=='*'){
				if(str1Arr.length==0)
					System.out.println(str2Arr[0]);
				else 
					if(str2Arr.length==1){
							int overLapp=getNonOverlappingSeq(str2Arr[0],str1Arr[1]);
							System.out.println(str2Arr[0]+str1Arr[1].substring(overLapp));
						}
					else 
						System.out.println(str1Arr[0]+str2Arr[1]);
				return ;
			}
			if(str2.charAt(0)=='*'&&str1.charAt(str1.length()-1)=='*'){
				if(str2Arr.length==0)
					System.out.println(str1Arr[0]);
				else 
					if(str1Arr.length==1){
							int overLapp=getNonOverlappingSeq(str1Arr[0],str2Arr[1]);
							System.out.println(str1Arr[0]+str2Arr[1].substring(overLapp));
						}
					else 
						System.out.println(str2Arr[0]+str1Arr[1]);
				return ;
			}
			if(str1.charAt(0)=='*'&&str2.charAt(0)=='*'){
				System.out.println("No Result");
				return ;
			}
			if(str1.charAt(str1.length()-1)=='*'&&str2.charAt(str2.length()-1)=='*'){
				System.out.println("No Result");
				return ;
			}
			if(str1.equals("*")){
				String s="";
				for(String st:str2Arr)
					s=s+st;
				System.out.println(s);
				return;
			}
			if(str2.equals("*")){
				String s="";
				for(String st:str1Arr)
					s=s+st;
				System.out.println(s);
				return;
			}
		}
		String begRes=null;
		String endRes=null;
		int nonoverlappingSegPos=0;
		if(str1Arr[0].length()>str2Arr[0].length()){
			begRes=getResultantString(str1Arr[0], str2Arr[0]);
		}
		else{
			begRes=getResultantString(str2Arr[0], str1Arr[0]);
		}
		if(str1Arr[1].length()>str2Arr[1].length())
			{
				nonoverlappingSegPos=getNonOverlappingSeq(begRes,str1Arr[1]);
				if(nonoverlappingSegPos!=0){
					str1Arr[1]=str1Arr[1].substring(nonoverlappingSegPos);
				}
			}
		else{
				nonoverlappingSegPos=getNonOverlappingSeq(begRes,str2Arr[1]);
				if(nonoverlappingSegPos!=0){
					str2Arr[1]=str2Arr[1].substring(nonoverlappingSegPos);
				}
			}
		if(begRes==null){
			System.out.println(" No Solution is Possible ");
			return ;
		}
		str1Arr[1]=(new StringBuilder(str1Arr[1])).reverse().toString();
		str2Arr[1]=(new StringBuilder(str2Arr[1])).reverse().toString();
		if(str1Arr[1].length()>str2Arr[1].length()){
			endRes=getResultantString(str1Arr[1], str2Arr[1]);
		}
		else{
			endRes=getResultantString(str2Arr[1], str1Arr[1]);
		}
		if(endRes==null){
			System.out.println(" No Solution is Possible ");
			return ;
		}
		endRes=new StringBuilder(endRes).reverse().toString();
		System.out.println(begRes+endRes);
			
	}
	private static int getNonOverlappingSeq(String begRes, String str) {
		int matchIndex=0;
		for(int i=0;i<begRes.length();i++){
			matchIndex=0;
			for(int j=0;j<str.length();j++){
				if(begRes.charAt(i)!=str.charAt(j))
					{if(matchIndex!=0)i--;break;}
				else
					{matchIndex++;i++;}
				if(i>=begRes.length()) break;
			}
		}
		return matchIndex;
	}
	public static String getResultantString(String first,String second){
		char []begArr=new char[first.length()];
		for(int i=0;i<second.length();i++){
			if(first.charAt(i)==second.charAt(i))
				begArr[i]=first.charAt(i);
			else{
				return null;
			}
		}
		for(int i=second.length()-1;i<first.length();i++){
			begArr[i]=first.charAt(i);
		}
		return new String(begArr);
	}


}
