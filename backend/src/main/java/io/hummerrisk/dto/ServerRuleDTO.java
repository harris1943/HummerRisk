package io.hummerrisk.dto;

import io.hummerrisk.base.domain.ServerRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harris
 */
public class ServerRuleDTO extends ServerRule {

    private String tagKey;

    private String tagName;

    private boolean isSaveParam;

    private List<String> tags = new ArrayList<>();

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        this.tagKey = tagKey;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean isSaveParam() {
        return isSaveParam;
    }

    public void setSaveParam(boolean saveParam) {
        isSaveParam = saveParam;
    }

}
