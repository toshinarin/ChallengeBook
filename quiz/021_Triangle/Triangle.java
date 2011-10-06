public class Triangle {

	public static void exec() {
		String tmpStr = null;
		String[] strArray = null;
		int n = 0;
		int[] a = null;
		
		if ((tmpStr = IoUtil.readLine()) == null) return;
		n = Integer.parseInt(tmpStr);
		
		a = new int[n];
		if ((tmpStr = IoUtil.readLine()) == null) return;
		strArray = tmpStr.split(" ");
		if (strArray.length != n) return;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strArray[i]);
		}
		int max = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (((a[i] * a[i]) + (a[j]) * a[j]) != (a[k]) * a[k]) {
						continue;
					}
					tmp = a[i] + a[j] + a[k];
					if (tmp > max) {
						max = tmp;
					}
				}
			}
		}
		IoUtil.print("max: {" + max + "}");
		IoUtil.writeLine(max + "");
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