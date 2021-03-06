package org.jenkinsci.plugins.typetalk;

import hudson.Extension;
import hudson.model.RootAction;
import org.jenkinsci.plugins.typetalk.webhookaction.WebhookExecutor;
import org.jenkinsci.plugins.typetalk.webhookaction.WebhookExecutorFactory;
import org.jenkinsci.plugins.typetalk.webhookaction.WebhookRequest;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.interceptor.RequirePOST;

import javax.servlet.ServletException;
import java.io.IOException;


@Extension
public class TypetalkWebhookAction implements RootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return "typetalk";
    }

    @RequirePOST
    public HttpResponse doNotify() {

        return new HttpResponse() {
            public void generateResponse(StaplerRequest req, StaplerResponse rsp, Object node)
                    throws IOException, ServletException {
                WebhookExecutor executor = WebhookExecutorFactory.create(req, rsp);
                executor.execute();
            }
        };

    }

}