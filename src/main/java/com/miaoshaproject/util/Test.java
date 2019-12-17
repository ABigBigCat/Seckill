package com.miaoshaproject.util;

import java.io.*;

/**
 * @ClassName MpGenerator
 * @Author tu
 * @Date 2019/6/13 下午1:40
 * @Version 1.0
 **/
public class Test {

	/**
	 * 读入TXT文件
	 */
	public static void readFile() {
		String pathname = "D:\\0511数据导入\\insurancecid(1).txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
		//防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
		//不关闭文件会导致资源的泄露，读写文件都同理
		//Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
		try (FileReader reader = new FileReader(pathname);
			 BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
		) {
			String line;
			while ((line = br.readLine()) != null) {
				// 一次读入一行数据
				String result = format(line);
				fileWrite(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写入TXT文件
	 */
	public static void fileWrite(String str) {
		/**
		 * 将传入的一段内容写入文件
		 * content 需要写入的内容
		 * path 文件存放路径
		 * */
		FileWriter fw = null;
		try {
			//如果文件存在则追加写入，文件不存在则创建
			File f = new File("D:\\0511数据导入\\insurancecid.sql");
			fw = new FileWriter(f,true); //追加的方式
			//fw = new FileWriter(f,false); //覆盖的方式
		}catch(IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.write(str + "\r\n");//内容
		pw.flush();

		try {
			fw.flush();
			pw.close();
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}



	public static String format(String str){
		String[] strList = str.split(",");
		//String sql ="UPDATE me_company_bank SET dr = 1 where account_no ='@1' and update_time ='@2' ;";
		//String sql ="UPDATE pg_member_integral_record SET amount_61 = '@2' where card_code ='@2' and month = '201909' ;";
		//String sql ="INSERT INTO `bank_account_info`(`cust_id`, `member_card`, `source`, `status`, `is_account_type1`, `account_status1`, `is_account_type2`, `account_status2`, `is_account_type3`, `account_status3`, `creator`, `create_time`, `update_person`, `update_time`, `dr`) VALUES ('1000@1', '@1', 4, 0, 0, 0, 0, 0, 0, 0, 'system', '2019-11-12 00:00:00', NULL, NULL, 0);";
		//String sql ="UPDATE mm_member_pwd SET dr = 1 where card_code ='@1' and id > 2071 ;";
		//String sql = "update bank_base_info set bank_name = '@2',remark = '修改支行',update_time = now() where account_id =(select id from bank_account_info where member_card = '@1' and is_account_type2 = 1 and dr = 0) and  bank_account = '@3' and account_type = 2 and dr = 0";
		String sql ="UPDATE insurance_base_info SET cust_id = '@3' where card_code = '@1' and name = '@2';";
		String target = null;
		for(int i =0; i<strList.length; i++){
			target = sql.replace("@1",strList[0].trim()).
			 					replace("@2",strList[1].trim()).
								replace("@3",strList[2].trim());
//								replace("@4",strList[3].trim());
		}
		System.out.println(target);
		return target;
	}

	public static void main(String[] args) {
		readFile();
	}
}