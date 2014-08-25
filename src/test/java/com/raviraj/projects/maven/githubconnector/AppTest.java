package com.raviraj.projects.maven.githubconnector;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String GITHUB_LOGIN = "rkanaje";
    private static final String GITHUB_PASSWORD = "rava6264742";
    private static final String GITHUB_API_TOKEN = "2c433426769f9938b43777c49959600fc577a000";
    
    @org.junit.Test
    public void runTest() throws IOException {
        GitHub github = GitHub.connect(GITHUB_LOGIN, GITHUB_API_TOKEN, GITHUB_PASSWORD);

        GHRepository grepo = github.getRepository("rkanaje/dev-repo");
        Map<String, GHBranch> branches = grepo.getBranches();

        for (Entry<String, GHBranch> entry : branches.entrySet()) {
            System.out.println("\n ================= \n" + entry.getKey());
            GHBranch branch = entry.getValue();

            System.out.println(branch.getName() + ", " + branch.getSHA1() + ", " + branch.getOwner());
        }

        System.out.println("\n*** End ***");
    }
}
