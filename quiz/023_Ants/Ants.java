public class Ants {

	public static String solve(int L, int n, int[] x) {
		int min = 0, max = 0;
		int dMax = 0;
		for (int i = 0; i < n; i++) {
			dMax = Math.max(dMax, Math.min(x[i], L - x[i]));
		}
		min = dMax;
		
		for (int j = 0; j < n; j++) {
			dMax = Math.max(dMax, Math.max(x[j], L - x[j]));
		}
		max = dMax;
		return "min = " + min + "\nmax = " + max;
	}
	
	public static void exec() {
		String tmpStr = null;
		String[] strArray = null;
		int L = 0, n = 0;
		int[] x = null;
		
		if ((tmpStr = IoUtil.readLine()) == null) return;
		L = Integer.parseInt(tmpStr);

		if ((tmpStr = IoUtil.readLine()) == null) return;
		n = Integer.parseInt(tmpStr);

		x = new int[n];
		if ((tmpStr = IoUtil.readLine()) == null) return;
		strArray = tmpStr.split(" ");
		if (strArray.length != n) return;
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(strArray[i]);
		}

		String ret = solve(L, n, x);
		IoUtil.print(ret);
		IoUtil.writeLine(ret);
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