package linao;
import java.io.*;
import java.util.Scanner;

public class lab2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("input FilePath: ");
		String FilePath = sc.nextLine();
		System.out.print("input level: ");
		int level = sc.nextInt();
		String s = perform(FilePath, level);
		System.out.print(s);
	}
	public static String level1(String FilePath) throws IOException {
		/*
		 * keywords
		 */
		String fileLine;
		String keywords;
		BufferedReader textCode = new BufferedReader(new FileReader(FilePath));
		int keywordNum = 0;
		while((fileLine = textCode.readLine()) != null){
			BufferedReader keywordList = new BufferedReader(new FileReader("C:\\test\\keyword_list.txt"));
			while((keywords = keywordList.readLine()) != null) {
				if(fileLine.contains(keywords)) {
					keywordNum++;
				}
			}
			if(fileLine.contains("do")||fileLine.contains("double")) {
				keywordNum--;
			}
		}
		return "total num: "+keywordNum+"\n";
	}
	public static String level2(String FilePath) throws IOException {
		/*
		 * switch case 
		 */
		String s = "";
		BufferedReader textCode2 = new BufferedReader(new FileReader(FilePath));
		int switchNum = 0;
		String fileLine;
		while((fileLine = textCode2.readLine()) != null){
			if(fileLine.contains("switch")) {
				switchNum++;
			}
		}
		s += "switch num: "+switchNum+"\n";
		int caseNum[]=new int[switchNum];
		int time = -1; //use to count switch
		BufferedReader textCode = new BufferedReader(new FileReader(FilePath));
		while((fileLine = textCode.readLine()) != null){
			if(fileLine.contains("switch")) {
				time++;
			}
			if(fileLine.contains("case")) {
				caseNum[time]++;
			}
		}
		s += "case num:";
		for(int i = 0;i<switchNum;i++) {
			s += " "+caseNum[i];
		}
		return s+"\n";
	}
	public static String level3(String FilePath) throws IOException {
		/*
		 * if-else: 
		 */
		BufferedReader textCode = new BufferedReader(new FileReader(FilePath));
		int if_elseNum = 0;
		int ifTime = 0;
		String fileLine;
		int else_if_time = 0; //discontinuous else if
		boolean boo = false; //Determine whether it is continuous of else if
		while((fileLine = textCode.readLine()) != null){
			if(fileLine.contains("if")&&!(fileLine.contains("else"))) {
				ifTime++;
			}
			if(fileLine.contains("if")&&(fileLine.contains("else"))&&!boo) {
				else_if_time++;
				boo = true;
			}else if(!(fileLine.contains("if")&&(fileLine.contains("else")))&&boo) {
				boo = false;
			}else {}
		}
		if_elseNum = ifTime-else_if_time;
		return "if-else num: " + if_elseNum+"\n";
	}
	public static String level4(String FilePath) throws IOException {
		/*
		 * if-else if -else: 
		 */
		BufferedReader textCode = new BufferedReader(new FileReader(FilePath));
		int if_elseNum = 0;
		int ifTime = 0;
		String fileLine;
		int else_if_time = 0; //discontinuous else if
		boolean boo = false; //Determine whether it is continuous of else if
		while((fileLine = textCode.readLine()) != null){
			if(fileLine.contains("if")&&!(fileLine.contains("else"))) {
				ifTime++;
			}
			if(fileLine.contains("if")&&(fileLine.contains("else"))&&!boo) {
				else_if_time++;
				boo = true;
			}else if(!(fileLine.contains("if")&&(fileLine.contains("else")))&&boo) {
				boo = false;
			}else {}
		}
		if_elseNum = ifTime-else_if_time;
		int if_else_ifNum = else_if_time;//discontinuous else if's count
		return "if-elseif-else num: "+if_else_ifNum+"\n";
		}
	public static String perform(String FilePath, int level) throws IOException {
		String s = "";
		if(level == 1) {
			s+=level1(FilePath);
		}
		else if(level == 2) {
			s+=level1(FilePath);
			s+=level2(FilePath);
		}
		else if(level == 3) {
			s+=level1(FilePath);
			s+=level2(FilePath);
			s+=level3(FilePath);
		}
		else if(level == 4) {
			s+=level1(FilePath);
			s+=level2(FilePath);
			s+=level3(FilePath);
			s+=level4(FilePath);
		}
		return s;
	}
}
