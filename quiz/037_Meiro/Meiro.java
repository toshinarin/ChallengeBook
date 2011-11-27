import java.util.LinkedList;

public class Meiro {

	private static int N = 0, M = 0;
	private static P sP = null;
	private static P gP = null;
	private static char[][] map = null;
	private static int[][] dMap = null;
	private static final int INF = 100000000;
	private static final int dx[] = {1, 0, -1, 0};
	private static final int dy[] = {0, 1, 0, -1};

	public static int bfs() {
		LinkedList<P> que = new LinkedList<P>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dMap[i][j] = INF;
			}
		}
		
		que.add(sP);
		dMap[sP.y][sP.x] = 0;
		
		while (que.isEmpty() == false) {
			P p = que.removeFirst();
			if (p.x == gP.x && p.y == gP.y) break;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0 <= nx && 0 <= ny && nx < M && ny < N && map[ny][nx] != '#' &&
						dMap[ny][nx] == INF) {
					que.add(new P(nx, ny));
					dMap[ny][nx] = dMap[p.y][p.x] + 1;
				}
			}
		}
		return dMap[gP.y][gP.x];
	}
	
	public static String solve() {
		int d = bfs();
		return d == INF ? "error: can't get goal!" : "shortest distance: " + d; 
	}
	
	public static void exec() {
		String tmpStr = null;

		if ((tmpStr = IoUtil.readLine()) == null) return;
		N = Integer.parseInt(tmpStr);

		if ((tmpStr = IoUtil.readLine()) == null) return;
		M = Integer.parseInt(tmpStr);

		map = new char[N][M];
		dMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			if ((tmpStr = IoUtil.readLine()) == null) return;
			map[i] = tmpStr.toCharArray();

			int sX = tmpStr.indexOf('S'); 
			if (sX != -1) sP = new P(sX, i);

			int gX = tmpStr.indexOf('G'); 
			if (gX != -1) gP = new P(gX, i);
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