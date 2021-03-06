package org.jtb.alogrec;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class LogFile {
	private static final SimpleDateFormat LOG_FILE_FORMAT = new SimpleDateFormat(
			"MMddHHmm_ss");
	public static final File DIR = new File(Environment.getExternalStorageDirectory(),
			"alogrec");

	private File file;

	LogFile() {
		file = new File(DIR, "alogrec_" + LOG_FILE_FORMAT.format(new Date())
				+ ".log");
	}

	void create() throws IOException {
		if (!DIR.exists() && !DIR.mkdirs()) {
			throw new IOException("could not establish log directory: " + DIR);
		}
		if (!file.createNewFile()) {
			throw new IOException("could not create log file: " + file);
		}
	}

	File getFile() {
		return file;
	}

	@Override
	public String toString() {
		return file.toString();
	}
}
