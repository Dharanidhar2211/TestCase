package Nova.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class reTry implements IRetryAnalyzer
{
	int maxTry=1;
	int count=0;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxTry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
