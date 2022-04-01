package ui.theme.offset

import org.jetbrains.compose.web.css.*
import ui.theme.AppCSSVariables
import ui.theme.EzLiveStylesheet

object WtOffsets : StyleSheet(EzLiveStylesheet) {
    val wtTopOffset96 by style {
        marginTop(96.px)
        property(
            "margin-top",
            "calc(4*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
    }

    val wtTopOffset24 by style {
        marginTop(24.px)
        property(
            "margin-top",
            "calc(1*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
    }

    val wtTopOffset48 by style {
        marginTop(48.px)
    }

    val wtTopOffset12 by style {
        self style {
            marginTop(12.px)
        }
    }

    val wtTopOffsetSm12 by style {
        media(mediaMaxWidth(640.px)) {
            self style {
                marginTop(12.px)
            }
        }
    }

    val wtTopOffsetSm24 by style {
        media(mediaMaxWidth(640.px)) {
            self style {
                marginTop(24.px)
            }
        }
    }
}