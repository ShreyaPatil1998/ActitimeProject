package com.Actitime.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

	public class ListenerImplementation extends BaseClass implements ITestListener{ //(interface) Abstraction and Inheritance we used here

		@Override
		public void onTestStart(ITestResult result) {
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSuccess(result);
		}

		@Override
		public void onTestFailure(ITestResult result) {
			String name=result.getName();
			TakesScreenshot t=(TakesScreenshot) driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			//File dest=new File("./ScreenShorts/SS.png");
			File dest=new File("./ScreenShorts/"+name+".png");// Concandination
			try{
				Files.copy(src, dest);
			}catch (Exception e) {
				
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSkipped(result);
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onFinish(context);
		}

	}


