import java.io.File;


public class RenameFiles {
	
	/** ��ĳ��Ŀ¼�µ��ļ�������������ȥ��������ַ���
	 * @param path �ļ�·��
	 * @param mode ģʽ��1���滻�ļ�����replaceStr��2�� �滻replaceStr֮ǰ�Ĳ��֣�3���滻replaceStr֮��Ĳ���
	 * @param replaceStr ��Ҫ�滻���ַ���
	 * @param expStr ��������ļ����������ַ���
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
				
				succ = fi.renameTo(new File(path + File.separator + fname));// ��������Ŀ��Ҫ��·��
				if(!succ) {
					throw new Exception(fi.getName() + " --> " +fname+ " �ļ�������ʧ��!");
				}else{
					System.out.println(fi.getName() + " --> " +fname+ " ...... success");
				}
				count ++;
			}
			
		}
		System.out.println(count + "���ļ����������������");
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
