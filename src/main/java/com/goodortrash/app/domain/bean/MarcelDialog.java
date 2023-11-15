package com.goodortrash.app.domain.bean;

import lombok.Builder;

@Builder
public record MarcelDialog(String text, String moral) {

    public static MarcelDialogBuilder marcelDialog() {
        return new MarcelDialogBuilder();
    }

}
