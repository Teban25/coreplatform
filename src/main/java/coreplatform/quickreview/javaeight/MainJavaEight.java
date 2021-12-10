package coreplatform.quickreview.javaeight;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class MainJavaEight {

	public static void main(String[] args) {
		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {

			@Override
			public boolean accept(File name) {
				// TODO Auto-generated method stub
				return name.isHidden();
			}
		});
		
		File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

		List<File> hiddenFiles3 = Arrays.asList(hiddenFiles2);
		hiddenFiles3.forEach(i -> System.out.println(i.getName()));
	}
}
