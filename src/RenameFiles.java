import java.io.File;


public class RenameFiles {
	
	/** 对某个目录下的文件进行重命名，去掉多余的字符串
	 * @param path 文件路径
	 * @param mode 模式；1：替换文件名中replaceStr；2： 替换replaceStr之前的部分；3：替换replaceStr之后的部分
	 * @param replaceStr 需要替换的字符串
	 * @param expStr 不处理的文件名包含的字符串
	 */
	public static boolean rename(String path, int mode, String replaceStr, String expStr) throws Exception {
		File f = new File(path);
		boolean succ = true;
		int count =0;
		for(File fi : f.listFiles()) {
			String fname = fi.getName();
			if(fname.indexOf(expStr)==-1 && fname.indexOf(replaceStr)>-1) {
				switch(mode){
				case 1:
					fname = fname.replace(replaceStr, "");
					break;
				case 2:
					fname = fname.substring(fname.indexOf(replaceStr)+replaceStr.length());
					break;
				case 3:
					fname = fname.substring(fname.indexOf(replaceStr));
				}
				
				succ = fi.renameTo(new File(path + File.separator + fname));// 重命名的目标要加路径
				if(!succ) {
					throw new Exception(fi.getName() + " --> " +fname+ " 文件重命名失败!");
				}else{
					System.out.println(fi.getName() + " --> " +fname+ " ...... success");
				}
				count ++;
			}
			
		}
		System.out.println(count + "个文件完成重命名操作！");
		return succ;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			rename("J:\\others",2,"]", ".td");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
