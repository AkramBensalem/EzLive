package ui.theme.display

import org.jetbrains.compose.web.css.*
import ui.theme.EzLiveStylesheet

object WtDisplay : StyleSheet(EzLiveStylesheet) {
    val wtDisplayNone by style {
        display(DisplayStyle.None)
    }

    val wtDisplayMdBlock by style {
        media(mediaMaxWidth(1000.px)) {
            self style {
                display(DisplayStyle.Block)
            }
        }
    }

    val wtDisplayMdNone by style {
        media(mediaMaxWidth(1000.px)) {
            self style {
                display(DisplayStyle.None)
            }
        }
    }
}