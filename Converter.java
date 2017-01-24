import java.util.HashMap;

public class Converter {

	static HashMap<String, Integer> mp = new HashMap<String, Integer>();
	static HashMap<String, Integer> den = new HashMap<String, Integer>();
	static {
		mp.put("one", 1);
		mp.put("two", 2);
		mp.put("three",3);
		mp.put("four", 4);
		mp.put("five", 5);
		mp.put("six", 6);
		mp.put("seven", 7);
		mp.put("eight", 8);
		mp.put("nine", 9);
		mp.put("ten", 10);
		mp.put("eleven", 11);
		mp.put("twelve", 12);
		mp.put("therteen", 13);
		mp.put("fourteen", 14);
		mp.put("fifteen", 15);
		mp.put("sixteen", 16);
		mp.put("seventeen", 17);
		mp.put("eighteen", 18);
		mp.put("nineteen", 19);
		mp.put("twenty", 20);
		mp.put("thirty", 30);
		mp.put("fourty", 40);
		mp.put("fifty", 50);
		mp.put("sixty", 60);
		mp.put("seventy", 70);
		mp.put("eighty", 80);
		mp.put("nintey", 90);

		den.put("hundred", 100);
		den.put("thousand", 1000);
		den.put("lakh", 100000);
		den.put("crore", 10000000);

	}

	public static void main(String[] args) {
		String amount = "twenty two crore one lakh two hundred fifty two";
		String[] str = amount.split(" ");
		int sum = 0;
		int sum2 = 0;
		boolean flag = false;
		for (String s : str) {
			Integer amt = mp.get(s);
			if (amt == null) {
				amt = den.get(s);
				if (!flag) {
					flag = true;
					sum2 = sum2 * amt;
					sum=sum+sum2;
					sum2=0;
				}
			} else {
				flag=false;
				sum2 = sum2 + amt;
			}
		}
		sum=sum+sum2;
		System.out.println(sum);

	}

}
