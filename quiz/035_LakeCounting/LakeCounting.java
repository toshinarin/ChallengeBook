public class LakeCounting {

	private static int N = 0, M = 0;
	private static char[][] map = null;

	public static void dfs(int x, int y) {
		if (map == null) return;

		map[y][x] = '.'; 

		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = x + dx, ny = y + dy;
				if (0 <= nx && 0 <= ny && nx < M && ny < N && map[ny][nx] == 'W') {
					dfs(nx, ny);
				}
			}
		}
		
		return;
	}
	
	public static String solve() {
		int res = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 'W') {
					dfs(i, j);
					res++;
				}
			}
		}
		return res + ""; 
	}
	
	public static void exec() {
		String tmpStr = null;

		if ((tmpStr = IoUtil.readLine()) == null) return;
		N = Integer.parseInt(tmpStr);

		if ((tmpStr = IoUtil.readLine()) == null) return;
		M = Integer.parseInt(tmpStr);

		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			if ((tmpStr = IoUtil.readLine()) == null) return;
			map[i] = tmpStr.toCharArray(); 
		}

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