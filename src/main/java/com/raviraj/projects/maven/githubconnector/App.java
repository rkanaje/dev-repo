package com.raviraj.projects.maven.githubconnector;

import java.io.IOException;

import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

/**
 * Hello world!
 * 
 */
public class App {

	private static final String GITHUB_LOGIN = "rkanaje";
	private static final String GITHUB_PASSWORD = "rava6264742";
	private static final String GITHUB_API_TOKEN = "2c433426769f9938b43777c49959600fc577a000";

	public static void main(String[] args) throws IOException {
		GitHub github = GitHub.connect(GITHUB_LOGIN, GITHUB_API_TOKEN,
				GITHUB_PASSWORD);

		GHMyself mySelf = github.getMyself();
		String location = mySelf.getLocation();
		String url = mySelf.getHtmlUrl();
		System.out.println(String.format("%s, %s", location, url));

		// Events
		// List<GHEventInfo> events = github.getEvents();
		// for (GHEventInfo event : events) {
		//
		// System.out.println(event.getActor() + " : "
		// + event.getOrganization());
		// }

		// Repo

		GHRepository grepo = github.getRepository("rkanaje/dev-repo");
		GHUser owner = grepo.getOwner();

		System.out.println("\n*** End ***");
	}
}
