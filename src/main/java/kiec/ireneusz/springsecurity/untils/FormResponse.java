package kiec.ireneusz.springsecurity.untils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class FormResponse implements Serializable {

    private Map<String, Object> form;

    private Map<String, Object> validation;

    public FormResponse() {
        this.form = new HashMap<>();
        this.validation = new HashMap<>();
    }

    public void addForm(String key, Object value) {
        this.form.put(key, value);
    }

    public void addValidation(String key, Object value) {
        this.validation.put(key, value);
    }

}

