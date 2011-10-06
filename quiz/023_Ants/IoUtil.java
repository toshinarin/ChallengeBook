import java.io.*;

public class IoUtil {
	static final boolean DEBUG = true;
	static BufferedReader mBr = null;
	static PrintWriter mPw = null;

	public static void print(String s) {
		if (DEBUG == false)
			return;
		System.out.println(s);
	}

	public static int openInput(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			mBr = new BufferedReader(fr);
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public static void closeInput() {
		try {
			mBr.close();
		} catch (Exception e) {
		}
	}

	private static boolean canWrite(File file) {
		if (file.exists() == false || file.isFile() == false
				|| file.canWrite() == false) {
			return false;
		}
		return true;
	}

	public static int openOutput(String fileName) {
		File f = new File(fileName);
		try {
			f.createNewFile();
		} catch (IOException e) {
			print("failed to prepare out file.");
			return -1;
		}

		if (canWrite(f) == false) {
			print("failed to prepare out file.");
			return -1;
		}

		try {
			mPw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	public static void closeOutput() {
		try {
			mPw.close();
			mPw = null;
		} catch (Exception e) {
		}
	}

	public static String readLine() {
		String ret = null;
		try {
			ret = mBr.readLine();
		} catch (Exception e) {
		}
		return ret;
	}

	public static int writeLine(String str) {
		try {
			mPw.println(str);
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
	
	public static int open(String inFile, String outFile) {
		if (openInput(inFile) != 0) {
			print("failed to open input.");
			return -1;
		}
		if (openOutput(outFile) != 0) {
			print("failed to open output.");
			closeInput();
			return -1;
		}

		return 0;
	}
	
	public static int close() {
		closeInput();
		closeOutput();
		return 0;
	}
}