package org.xstefank.check;

import com.fasterxml.jackson.databind.JsonNode;
import org.jboss.logging.Logger;
import org.xstefank.check.additional.AdditionalChecks;
import org.xstefank.model.yaml.FormatConfig;
import org.xstefank.model.yaml.Format;

import java.util.ArrayList;
import java.util.List;

public class TemplateChecker {

    public static final String TEMPLATE_FORMAT_FILE = "template.format.file";
    private static final Logger log = Logger.getLogger(TemplateChecker.class);

    private List<Check> checks;
    private FormatConfig config;

    public TemplateChecker(FormatConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Argument config cannot be null");
        }
        this.config = config;
        checks = registerChecks(config.getFormat());
    }

    public String checkPR(JsonNode payload) {
        log.info("checking PR");
        String description = "";
        for (Check check : checks) {
            String message = check.check(payload);
            if (message != null) {
                description = message;
                break;
            }
        }

        return description;
    }

    private static List<Check> registerChecks(Format format) {
        List<Check> checks = new ArrayList<>();

        if (format.getTitle() != null) {
            checks.add(new TitleCheck(format.getTitle()));
        }

        if (format.getDescription() != null) {
            checks.add(new RequiredRowsCheck(format.getDescription().getRequiredRows()));
        }

        if (format.getCommit() != null) {
            checks.add(new LatestCommitCheck(format.getCommit()));
        }

        for (String additional : format.getAdditional()) {
            checks.add(AdditionalChecks.findCheck(additional));
        }

        return checks;
    }
}
