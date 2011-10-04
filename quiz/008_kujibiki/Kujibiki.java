public class Kujibiki {

	public static void exec() {
		String tmpStr = null;
		String[] strArray = null;
		int n = 0, m = 0;
		int[] k = null;
		
		if ((tmpStr = IoUtil.readLine()) == null) return;
		n = Integer.parseInt(tmpStr);
		
		if ((tmpStr = IoUtil.readLine()) == null) return;
		m = Integer.parseInt(tmpStr);
		
		k = new int[n];
		if ((tmpStr = IoUtil.readLine()) == null) return;
		strArray = tmpStr.split(" ");
		if (strArray.length != n) return;
		for (int i = 0; i < n; i++) {
			k[i] = Integer.parseInt(strArray[i]);
		}
		
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					for (int d = 0; d < n; d++) {
						if ((k[a] + k[b] + k[c] + k[d]) == m) {
							IoUtil.writeLine("Yes");
							return;
						}
					}
				}
			}
		}
		IoUtil.writeLine("No");
	}

	public static void main(String[] args) {
		IoUtil.print("########### Start!! ############");
		String fileName = null;
		try {
			fileName = args[0];
			IoUtil.print("Open file: {" + fileName + "}");
			IoUtil.open(fileName, "out.txt");
			exec();
		} catch (Exception e) {
			IoUtil.print("failed to execute. error: {" + e + "}");
			e.printStackTrace();
		}
		if (fileName == null) {
			IoUtil.print("File name must be specified.");
			return;
		}
		IoUtil.close();
		IoUtil.print("########## Finished!! ##########");
	}
}