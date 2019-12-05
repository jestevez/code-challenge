package com.joseluisestevez.code.challenge.cucumber;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReportRunner extends Cucumber {

    private static final String PROJECT_NAME = "Cucumber & Spring Boot";
    private static final String BUILD_NUMBER = "1.0.0";
    private static final String BRANCH_NAME = "master";

    public CucumberReportRunner(Class clazz) throws InitializationError {
	super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
	super.run(notifier);
	generateReport();
    }

    public static void generateReport() {

	File reportOutputDirectory = new File("target/classes/static");
	List<String> jsonFiles = new ArrayList<>();
	jsonFiles.add("target/cucumber-report.json");

	Configuration configuration = new Configuration(reportOutputDirectory, PROJECT_NAME);
	configuration.setBuildNumber(BUILD_NUMBER);
	configuration.addClassifications("Build Number", configuration.getBuildNumber());
	configuration.addClassifications("Branch Name", BRANCH_NAME);

	ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	reportBuilder.generateReports();
    }
}
