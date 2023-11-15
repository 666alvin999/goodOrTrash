package com.goodortrash.app.domain.bean;

import lombok.Builder;

@Builder
public record MarcelDialog(String text, String dialogType) {

    public static MarcelDialogBuilder marcelDialog() {
        return new MarcelDialogBuilder();
    }

}
