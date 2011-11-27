public class Bubunwa {

	private static int k = 0, n = 0;
	private static int[] a = null;

	public static boolean dfs(int i, int sum) {
		if (a == null) return false;

		//IoUtil.print("sum candidate: " + sum);
		if (i == n) return sum == k;

		if (dfs(i + 1, sum)) return true;

		if (dfs(i + 1, sum + a[i])) return true;
		
		return false;
	}
	
	public static String solve() {
		return dfs(0, 0) ? "Yes\n" : "No\n";
	}
	
	public static void exec() {
		String tmpStr = null;
		String[] strArray = null;

		if ((tmpStr = IoUtil.readLine()) == null) return;
		n = Integer.parseInt(tmpStr);
		
		a = new int[n];
		if ((tmpStr = IoUtil.readLine()) == null) return;
		strArray = tmpStr.split(" ");
		if (strArray.length != n) return;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strArray[i]);
		}

		if ((tmpStr = IoUtil.readLine()) == null) return;
		k = Integer.parseInt(tmpStr);

		String ret = solve();
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