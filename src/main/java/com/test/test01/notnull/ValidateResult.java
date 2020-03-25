package com.test.test01.notnull;

import lombok.Data;

/**
 * @ClassName: com.test.test01.notnull.ValidateResult
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/11/29 11:20
 * @Version: 1.0
 */
@Data
public class ValidateResult {
    private boolean isValid = true;
    private String message;

    public ValidateResult() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.isValid = false;
        this.message = message;
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public String toString() {
        return "ValidateResult{" +
            "isValid=" + isValid +
            ", message='" + message + '\'' +
            '}';
    }
}


