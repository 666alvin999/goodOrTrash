package com.goodortrash.app.presentation.dto;

import lombok.Builder;

@Builder
public record MarcelDialogView(String text, String dialogCssClass, String associatedMarcelDesignName) {

    public static MarcelDialogViewBuilder marcelDialogView() {
        return new MarcelDialogViewBuilder();
    }

}
