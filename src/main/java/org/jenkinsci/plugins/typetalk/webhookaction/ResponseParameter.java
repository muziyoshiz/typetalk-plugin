package org.jenkinsci.plugins.typetalk.webhookaction;

import hudson.model.Job;
import org.jenkinsci.plugins.typetalk.support.Emoji;

import java.util.List;

public class ResponseParameter {

    private String description;

    public String getDescription() {
        return description != null ? description : message;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private final String message;

    public String getMessage() {
        return message;
    }

    private Emoji emoji;

    public Emoji getEmoji() {
        return emoji != null ? emoji : Emoji.SMILEY;
    }

    public void setEmoji(Emoji emoji) {
        this.emoji = emoji;
    }

    public boolean isEmojiSet() {
        return emoji != null;
    }

    // To be compatible, class and name are different
    private Job project;

    public Job getProject() {
        return project;
    }

    public void setProject(Job project) {
        this.project = project;
    }

    public ResponseParameter(String message) {
        this.message = message;
    }

    public static String flatMessages(List<String> messages) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < messages.size() - 1; i++) {
            builder.append(messages.get(i) + "\n");
        }
        builder.append(messages.get(messages.size() - 1));

        return builder.toString();
    }

}
