package com.raviraj.projects.connectors.github;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHEventPayload;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import org.kohsuke.github.GHEventPayload.IssueComment;

public class Head {
    private static final String GITHUB_LOGIN = "rkanaje";
    private static final String GITHUB_PASSWORD = "rava6264742";
    private static final String GITHUB_API_TOKEN = "2c433426769f9938b43777c49959600fc577a000";

    public static void main(String[] args) throws IOException {
        GitHub github = GitHub.connect(GITHUB_LOGIN, GITHUB_API_TOKEN, GITHUB_PASSWORD);

        // Repository & branch info
        GHRepository grepo = github.getRepository("rkanaje/dev-repo");
        Map<String, GHBranch> branches = grepo.getBranches();
        for (Entry<String, GHBranch> entry : branches.entrySet()) {
            GHBranch branch = entry.getValue();
            System.out.println(branch.getName() + ",\t" + branch.getSHA1() + ",\t" + branch.getOwner());
        }

        // Github events
        System.err.println("\n ************ Github events ********************** ");
        PagedIterable<GHEventInfo> eventInfo = grepo.listEvents();
        List<GHEventInfo> eventInfos = eventInfo.asList();

        for (GHEventInfo ghEventInfo : eventInfos) {
            displayEventInfo(ghEventInfo);
        }

        System.out.println("\n*** End ***");
    }

    private static void displayEventInfo(GHEventInfo eventinfo) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append(eventinfo.getActorLogin()).append("\t|").append(eventinfo.getActor()).append("\t|")
                .append(eventinfo.getOrganization()).append("\t|").append(eventinfo.getType().name()).append("\t|")
                .append(eventinfo.getCreatedAt());

        System.out.println(sb.toString());
    }
}
