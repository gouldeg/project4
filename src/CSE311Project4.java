import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CSE311Project4 {

	static int numOfFiles = 0;
	static File[][] files = new File[100][100];
	public static void main(String[] args) {
		
		Scanner reader = new Scanner("System.in");
		System.out.println("Enter the file name");
		String fn1 = reader.nextLine();
		
		ArrayList<String> FileNames = getFileNames(fn1);
		for (int i = 0; i < FileNames.size(); i++)
		{
			checkClones(FileNames.get(i));
		}
		

	}
	public static boolean checkClones(String fileName)
	{
		File file = new File(fileName);
		if (numOfFiles == 0)
		{
			files[0][0] = file;
		} else
		{
			for (int i = 0; i < files.length; i++)
			{
				if (getFileContent(file).equals(getFileContent(files[i][0])))
				{
					files[i][files[i].length] = file;
				}
			}
		}
		
		return true;
	}
	
	public static String getFileContent(File f)
	{
		String content = "";
		try
		{
		Scanner fileReader = new Scanner(f);
		
		while (fileReader.hasNextLine())
		{
			content += fileReader.nextLine();
		}
		fileReader.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("e");
		}
		return content;
	}
	
	public static ArrayList<String> getFileNames(String s)
	{
		ArrayList<String> fileNames = new ArrayList<String>(50);
		File file1 = new File(s);
		try {
			Scanner fileReader = new Scanner(file1);
			while (fileReader.hasNext())
			{
				fileNames.add(fileReader.next());
			}
			fileReader.close();
		} catch (FileNotFoundException e)
		{
			System.out.println(e.toString());
		}
	
		return fileNames;
	}
}
