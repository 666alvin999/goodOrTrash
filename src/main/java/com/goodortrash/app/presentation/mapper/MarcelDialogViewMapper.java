package com.goodortrash.app.presentation.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.presentation.dto.MarcelDialogView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcelDialogViewMapper {

    public MarcelDialogView mapToMarcelDialogView(MarcelDialog marcelDialog) {
        String cssClass = null;
        String associatedMarcel = null;

        if (marcelDialog.dialogType().contains("BAD")) {
            cssClass = "aggressive";
            associatedMarcel = "mad-marcel";
        }
        else if (marcelDialog.dialogType().contains("GOOD")) {
            cssClass = "kind";
            associatedMarcel = "kind-marcel";
        }
        else {
            cssClass = "neutral";
            if (marcelDialog.dialogType().contains("QUESTION")) {
                associatedMarcel = "question-marcel";
            }
            else {
                associatedMarcel = "neutral-marcel";
            }
        }

        return new MarcelDialogView(
                marcelDialog.text(),
                cssClass,
                associatedMarcel
        );
    }

    public List<MarcelDialogView> mapAllToMarcelDialogView(List<MarcelDialog> marcelDialogs) {
        return marcelDialogs.stream().map(this::mapToMarcelDialogView).toList();
    }
}
