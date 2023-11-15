package com.goodortrash.app.presentation.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.presentation.dto.MarcelDialogView;
import org.springframework.stereotype.Component;

@Component
public class MarcelDialogViewMapper {

    public MarcelDialogView mapToMarcelDialogView(MarcelDialog marcelDialog) {
        String cssClass = null;
        String associatedMarcel = null;

        if (marcelDialog.dialogType().contains("BAD")) {
            cssClass = "aggressive";
            associatedMarcel = "mad-marcel" + marcelDialog.dialogType().substring(marcelDialog.dialogType().indexOf('-'));
        }
        else if (marcelDialog.dialogType().contains("GOOD")) {
            cssClass = "kind";
            associatedMarcel = "kind-marcel" + marcelDialog.dialogType().substring(marcelDialog.dialogType().indexOf('-'));
        }
        else {
            cssClass = "neutral";
            if (marcelDialog.dialogType().contains("QUESTION")) {
                associatedMarcel = "question-marcel" + marcelDialog.dialogType().substring(marcelDialog.dialogType().indexOf('-'));
            }
            else {
                associatedMarcel = "neutral-marcel" + marcelDialog.dialogType().substring(marcelDialog.dialogType().indexOf('-'));
            }
        }

        return new MarcelDialogView(
                marcelDialog.text(),
                cssClass,
                associatedMarcel
        );
    }

}
