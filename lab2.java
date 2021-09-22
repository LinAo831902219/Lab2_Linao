package linao;
import java.io.*;
import java.util.Scanner;

public class lab2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("input FilePath:");
		String FilePath = sc.nextLine();
		System.out.print("input level:");
		int level = sc.nextInt();
		if(level == 1) {
			level1(FilePath);
		}
		else if(level == 2) {
			level1(FilePath);
			level2(FilePath);
		}
		else if(level == 3) {
			level1(FilePath);
			level2(FilePath);
			level3(FilePath);
		}
		else if(level == 4) {
			level1(FilePath);
			level2(FilePath);
			level3(FilePath);
			level4(FilePath);
		}
		else {}
	}
	public static void level1(String FilePath) throws IOException {
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
		System.out.println("total num: "+keywordNum);
	}
	public static void level2(String FilePath) throws IOException {
		/*
		 * switch case 
		 */
		BufferedReader textCode2 = new BufferedReader(new FileReader(FilePath));
		int switchNum = 0;
		String fileLine;
		while((fileLine = textCode2.readLine()) != null){
			if(fileLine.contains("switch")) {
				switchNum++;
			}
		}
		System.out.println("switch num: "+switchNum);
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
		System.out.print("case num:");
		for(int i = 0;i<switchNum;i++) {
			System.out.print(" "+caseNum[i]);
		}
		System.out.println();
	}
	public static void level3(String FilePath) throws IOException {
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
		System.out.println("if-else num: " + if_elseNum);
	}
	public static void level4(String FilePath) throws IOException {
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
		System.out.println("if-else num: " + if_elseNum);
		int if_else_ifNum = else_if_time;//discontinuous else if's count
		System.out.print("if-elseif-else num: "+if_else_ifNum);
		}
}
